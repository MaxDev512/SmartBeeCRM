package com.exam.crm.controller;

import com.exam.crm.constant.ErrorCode;
import com.exam.crm.constant.SessionConsts;
import com.exam.crm.service.interfaces.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController {
  private AuthService authService;

  @Autowired
  private void setAuthService(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping("login")
  public ModelAndView login(String id, String password, HttpSession session) {
    ModelAndView mav = new ModelAndView();
    boolean isLogin = authService.login(id, password, session);

    if (isLogin) {
      mav.setViewName("redirect:/func/show");
    } else {
      super.setError(mav, ErrorCode.USER_NOT_FOUND, "無此使用者!");
    }

    return mav;
  }

  @PostMapping("logout")
  public ModelAndView logout(HttpSession session) {
    ModelAndView mav = new ModelAndView();

    mav.setViewName("redirect:/");

    session.removeAttribute(SessionConsts.USER);

    return mav;
  }
}
