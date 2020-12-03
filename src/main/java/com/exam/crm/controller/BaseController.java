package com.exam.crm.controller;

import org.springframework.web.servlet.ModelAndView;

public abstract class BaseController {
  protected void setSuccess(ModelAndView mav, String title) {
    if (mav != null) {
      mav.setViewName("success");
      mav.addObject("title", title);
    }
  }

  protected void setError(ModelAndView mav, String errorCode, String errorMessage) {
    if (mav != null) {
      mav.setViewName("error");
      mav.addObject("errorCode", errorCode);
      mav.addObject("errorMessage", errorMessage);
    }
  }
}
