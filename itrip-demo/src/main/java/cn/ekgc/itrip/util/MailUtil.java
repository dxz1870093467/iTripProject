package cn.ekgc.itrip.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

/**
 * <b>邮件发送工具类</b>
 * @author Arthur
 * @version 1.0.0
 */
@Component("mailUtil")
public class MailUtil {
	@Autowired
	private JavaMailSender mailSender;

	/**
	 * <b>邮件发送工具类</b>
	 * @param to
	 * @param name
	 * @param activationCode
	 * @throws Exception
	 */
	@Async
	public void sendMail(String to, String name, String activationCode) throws Exception {
		// 创建邮件信息对象
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		// 创建 MimeMessageHelper，当 Mulitipart 为 true 时，可以发送含有 HTML 代码的邮件
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
		// 设定收件人信息
		messageHelper.setTo("a244047273@163.com");
		// 设定发件人信息
		messageHelper.setFrom("15591339501@163.com");
		// 设置邮件主题
		messageHelper.setSubject("这是一封来自刘蛋蛋的信息");
		// 设置发送邮件的内容
		String context = "<div style='width: 600px; margin: 0 auto;'>" +
				"<h3>亲爱的：<strong>" + name + "</strong></h3>" +
				"<p>您已经成功的注册成为<strong>爱旅行</strong>会员！</p>" +
				"<p>只剩下最后一步，激活您的账号，您的激活码是：<strong style='color: red;'>" + activationCode + "</strong></p>" +
				"<p>请在<strong>" + expireTime + "</strong>分钟之内进行账号激活！</p></div>";
		// 进行邮件发送
		messageHelper.setText(context, true);
		mailSender.send(mimeMessage);
	}
}
