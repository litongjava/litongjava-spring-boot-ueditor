package com.litongjava.spring.boot.ueditor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Value("${project.user.name}")
  private String dbUsername;
  @Value("${project.user.password}")
  public String dbPassword;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.info("project.name:{},project.password:{}", dbUsername,dbPassword);
    log.info("用户的用户名: {}", username);
    // TODO 根据用户名，查找到对应的密码，与权限

    String password = passwordEncoder.encode(dbPassword);
    log.info("password: {}", password);

    // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
    User user = new User(dbUsername, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    return user;
  }
}