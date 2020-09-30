package com.litongjava.spring.boot.ueditor.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.litong.spring.boot.v158.mp.layui.v255.controller.MpCurdController;
import com.litongjava.spring.boot.ueditor.entity.Article;
import com.litongjava.spring.boot.ueditor.service.ArticleService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author litong
 * @since 2020-06-15
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends MpCurdController<ArticleService, Article>{

}

