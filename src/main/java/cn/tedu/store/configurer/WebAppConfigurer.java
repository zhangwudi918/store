package cn.tedu.store.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.tedu.store.interceptor.LoginInterceptor;

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// addPathPatterns方法：添加需要拦截的路径
		// excludePathPatterns方法：添加白名单,参数也是数组
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/**","/web/**","/address/**","/cart/**","/order/**").excludePathPatterns("/user/reg.do",
				"/user/login.do","/web/login.html","/web/register.html","/user/reg.do","/web/index.html","/web/product.html");

	}

}
