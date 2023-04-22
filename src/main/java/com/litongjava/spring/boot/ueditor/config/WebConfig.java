package com.litongjava.spring.boot.ueditor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

  // 静态资源配置
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    String[] strings = {"classpath:/litongjava-spring-boot-ueditor/", "classpath:/doc/", "classpath" +
      ":/ueditor-1.4/"};
    registry.addResourceHandler("/**")
      .addResourceLocations(strings);
  }

  @Bean
  public ResourceHttpRequestHandler resourceHttpRequestHandler() {
    return new ResourceHttpRequestHandler();
  }

}
