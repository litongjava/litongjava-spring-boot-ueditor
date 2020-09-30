package com.litongjava.spring.boot.ueditor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bill robot
 * @date 2020年6月12日_上午10:47:37 
 * @version 1.0 
 * @desc
 */
@RestController
@RequestMapping("/")
public class IndexController {

  @RequestMapping()
  public String index() {
    return "litongjava-spring-boot-ueditor";
  }
}
