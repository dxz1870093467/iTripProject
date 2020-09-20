package cn.ekgc.itrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>搜索功能 Provider 启动类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@EnableEurekaClient
@SpringBootApplication
public class SearchProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(SearchProviderStarter.class, args);
	}
}
