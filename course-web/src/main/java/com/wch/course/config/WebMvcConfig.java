package com.wch.course.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

   @Bean
   public FilterRegistrationBean loginFilterRegistrationBean() {
       FilterRegistrationBean loginFilterRegistrationBean = new FilterRegistrationBean();
       loginFilterRegistrationBean.setFilter(new LoginFilter());
       loginFilterRegistrationBean.addUrlPatterns("/*");
       return loginFilterRegistrationBean;
   }

   @Bean
   public LoginFilter loginFilter() {
       return new LoginFilter();
   }

   @Bean
   public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
       return new HiddenHttpMethodFilter();
   }
}
