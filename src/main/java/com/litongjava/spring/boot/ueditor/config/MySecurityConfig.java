package com.litongjava.spring.boot.ueditor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    //开启登录.登录成功后调整的界面
    http.formLogin()
      .defaultSuccessUrl("/index.html", true) //设置默认重定向URL为/dashboard
      .and()
      .logout()
      .permitAll();
    //关闭frameOptions
    http.headers().frameOptions().disable();
    //设置不进行验证的接口
    String[] permitUrl ={"/html/**","/ueditor-1.4/**","/jquery/**","/js/**","/userAgreement/listColumn",
      "/article/listColumn"};

    http
      .authorizeRequests()
      .antMatchers(permitUrl).permitAll()
      .anyRequest().authenticated(); // 所有其他请求需要身份验证

    // 关闭csrf防护
    http.csrf().disable();
//    http.cors().disable();

  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}