package com.fiberhome;

import com.fiberhome.config.MysqlProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@RestController
//@MapperScan("com.fiberhome.mapper")

@SpringBootApplication
//@ComponentScan(basePackages = {"com.fiberhome.mapper"})
//@EnableConfigurationProperties(MysqlProperties.class)
public class SpringbootApplication {
	@Value("${hello}")
	private String hello;

	@Resource
	MysqlProperties mysqlProperties;

	@RequestMapping("/s")
	String name(){
		return mysqlProperties.toString();
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//						.allowedOrigins("*")
//						.allowedMethods("PUT", "DELETE","GET","POST")
//						.allowedHeaders("*")
//						.exposedHeaders("access-control-allow-headers",
//								"access-control-allow-methods",
//								"access-control-allow-origin",
//								"access-control-max-age",
//								"X-Frame-Options")
//						.allowCredentials(false).maxAge(3600);
//			}
//		};
//
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
