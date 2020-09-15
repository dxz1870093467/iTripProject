package cn.ekgc.itrip.util;

import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

/**
 * <b>短信发送工具类</b>
 * @author Arthur
 * @version 1.0.0
 */
@Component("smsUtils")
public class SmsUtils {

	/**
	 * <b>使用容联云发送短信验证码</b>
	 * @param cellphone
	 * @param activationCode
	 * @throws Exception
	 */
	@Async
	public void sendActivationCodeByCloopen(String cellphone, String activationCode) throws Exception {
		String serverIp = ConstantUtils.CLOOPEN_SERVER_IP;
		//请求端口
		String serverPort = ConstantUtils.CLOOPEN_SERVER_PORT;
		//主账号,登陆云通讯网站后,可在控制台首页看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN
		String accountSId = ConstantUtils.CLOOPEN_ACCOUNT_SID;
		String accountToken = ConstantUtils.CLOOPEN_ACCOUNT_TOKEN;
		//请使用管理控制台中已创建应用的APPID
		String appId = ConstantUtils.CLOOPEN_APP_ID;
		CCPRestSmsSDK sdk = new CCPRestSmsSDK();
		sdk.init(serverIp, serverPort);
		sdk.setAccount(accountSId, accountToken);
		sdk.setAppId(appId);
		sdk.setBodyType(BodyType.Type_JSON);
		String to = cellphone;
		String templateId= ConstantUtils.CLOOPEN_TEMPLATE_ID;
		String[] datas = {activationCode, ConstantUtils.MAIL_EXPIRE, "变量3"};
		HashMap<String, Object> result = sdk.sendTemplateSMS(to, templateId, datas);
		if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet){
				Object object = data.get(key);
				System.out.println(key +" = "+object);
			}
		}else{
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
		}
	}
}
