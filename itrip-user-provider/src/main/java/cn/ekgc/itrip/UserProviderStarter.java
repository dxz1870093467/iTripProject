package cn.ekgc.itrip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * <b>爱旅行-用户模块 Provider 启动器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@EnableAsync
@MapperScan("cn.ekgc.itrip.dao")
@EnableEurekaClient
@SpringBootApplication
public class UserProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(UserProviderStarter.class, args);
	}
}
