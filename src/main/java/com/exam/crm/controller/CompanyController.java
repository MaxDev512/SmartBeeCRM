package com.exam.crm.controller;

import com.exam.crm.constant.ErrorCode;
import com.exam.crm.constant.FunctionId;
import com.exam.crm.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController {
  private CompanyService companyService;

  @Autowired
  private void setCompanyService(CompanyService companyService) {
    this.companyService = companyService;
  }

  @PostMapping("view")
  public ModelAndView view() {
    ModelAndView mav = new ModelAndView("show_data_company");

    mav.addObject("dataList", companyService.get());

    return mav;
  }

  @GetMapping("create")
  public String showCreatingView() {
    return "create_company";
  }

  @PostMapping("create")
  public ModelAndView create(String name, String address, HttpSession session) {
    ModelAndView mav = new ModelAndView();

    super.setSuccess(mav, "Company");
    mav.addObject("functionId", FunctionId.CREATE.ordinal());

    companyService.create(name, address, session);

    return mav;
  }

  @GetMapping("modify")
  public ModelAndView showModifyingView() {
    ModelAndView mav = new ModelAndView("modify_company");

    mav.addObject("dataList", companyService.get());

    return mav;
  }

  @PostMapping("modify")
  public ModelAndView modify(int id, String name, String address, HttpSession session) {
    ModelAndView mav = new ModelAndView();

    mav.addObject("functionId", FunctionId.MODIFY.ordinal());

    if (companyService.modify(id, name, address, session)) {
      super.setSuccess(mav, "Company");
    } else {
      super.setError(mav, ErrorCode.INVALID_ID, "Company 資料修改失敗, 無效的 Id!");
    }

    return mav;
  }

  @GetMapping("delete")
  public ModelAndView showDeletingView() {
    ModelAndView mav = new ModelAndView("delete_company");

    mav.addObject("dataList", companyService.get());

    return mav;
  }

  @PostMapping("delete")
  public ModelAndView delete(int id) {
    ModelAndView mav = new ModelAndView();

    super.setSuccess(mav, "Company");
    mav.addObject("functionId", FunctionId.DELETE.ordinal());

    companyService.delete(id);

    return mav;
  }
}
