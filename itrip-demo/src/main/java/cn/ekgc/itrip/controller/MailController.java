package cn.ekgc.itrip.controller;

import cn.ekgc.itrip.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("mailController")
@RequestMapping("/mail")
public class MailController {
	@Autowired
	private MailUtil mailUtil;

	@GetMapping("/send")
	public String sendMail() throws Exception {
		mailUtil.sendMail();
		return "邮件发送成功";
	}
}
