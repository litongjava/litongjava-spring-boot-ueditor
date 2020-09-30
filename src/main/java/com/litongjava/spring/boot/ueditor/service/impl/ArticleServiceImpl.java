package com.litongjava.spring.boot.ueditor.service.impl;

import com.litongjava.spring.boot.ueditor.entity.Article;
import com.litongjava.spring.boot.ueditor.dao.ArticleMapper;
import com.litongjava.spring.boot.ueditor.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author litong
 * @since 2020-06-15
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
