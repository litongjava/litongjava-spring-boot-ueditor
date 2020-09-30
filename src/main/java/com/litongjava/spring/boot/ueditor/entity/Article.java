package com.litongjava.spring.boot.ueditor.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author litong
 * @since 2020-06-15
 */
@TableName("t_article")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  private String title;

  private String type;

  private String content;
}