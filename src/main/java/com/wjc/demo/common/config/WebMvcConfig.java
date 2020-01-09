package com.wjc.demo.common.config;

import com.wjc.demo.common.interceptor.DingTalkInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/**
 *
 * @ProjectName:    demo
 * @Package:        com.wjc.demo.common.config
 * @ClassName:      WebMvcConfig
 * @Description:    web配置信息
 * @Author:         wangjc
 * @CreateDate:     2020/1/9 0009 14:32
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/1/9 0009 14:32
 * @UpdateRemark:   更新内容
 * @Version:        1.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

	 /**
	  * @method  addInterceptors
	  * @description 增加拦截器
	  * @date: 2020/1/9 0009 14:32
	  * @author: wangjc
	  * @param :
	  * @return
	  */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 增加默认拦截器
		registry.addInterceptor(new DingTalkInterceptor()).addPathPatterns("/**");
	}
	
}
