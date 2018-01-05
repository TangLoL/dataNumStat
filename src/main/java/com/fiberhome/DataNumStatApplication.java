package com.fiberhome;

import com.fiberhome.listener.DataNumListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class DataNumStatApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataNumStatApplication.class, args);
	}

	/**
	 * 跨域访问
	 * @return
	 */

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("PUT", "DELETE","GET","POST")
						.allowedHeaders("*")
						.exposedHeaders("access-control-allow-headers",
								"access-control-allow-methods",
								"access-control-allow-origin",
								"access-control-max-age",
								"X-Frame-Options")
						.allowCredentials(false).maxAge(3600);
			}
		};

	}

	/**
	 *listener配置
	 * @return
	 */

//	@Bean
//	public ServletListenerRegistrationBean<DataNumListener> dataNumListenerRegistration(){
//		ServletListenerRegistrationBean<DataNumListener> registration = new ServletListenerRegistrationBean<DataNumListener>(new DataNumListener());
//		return registration;
//	}

	/**
	 * Servlet配置
	 * @return
	 */
//	@Bean
//	public ServletRegistrationBean testServletRegistration() {
//		ServletRegistrationBean registration = new ServletRegistrationBean(new DataNumServlet());
//		registration.addUrlMappings("/hello");
//		return registration;
//	}

	/**
	 * filter配置
	 * @return
	 */
//	@Bean
//	public FilterRegistrationBean testFilterRegistration() {
//		FilterRegistrationBean registration = new FilterRegistrationBean(new TestFilter());
//		registration.addUrlPatterns("/");
//		return registration;
//	}

}