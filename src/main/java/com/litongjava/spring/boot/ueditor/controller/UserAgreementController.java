package com.litongjava.spring.boot.ueditor.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.litong.spring.boot.v158.mp.layui.v255.controller.MpCurdController;
import com.litongjava.spring.boot.ueditor.entity.UserAgreement;
import com.litongjava.spring.boot.ueditor.service.UserAgreementService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author litong
 * @since 2020-06-16
 */
@RestController
@RequestMapping("/userAgreement")
public class UserAgreementController extends MpCurdController<UserAgreementService, UserAgreement> {

}

