package com.exam.crm.controller;

import com.exam.crm.constant.SessionConsts;
import com.exam.crm.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/func")
public class FunctionController extends BaseController {
  @GetMapping("show")
  public ModelAndView show(HttpSession session) {
    ModelAndView mav = new ModelAndView();

    mav.setViewName("function");
    mav.addObject("permission", ((UserInfo)session.getAttribute(SessionConsts.USER)).getPermission());

    return mav;
  }
}
