package com.exam.crm.controller;

import com.exam.crm.constant.ErrorCode;
import com.exam.crm.constant.FunctionId;
import com.exam.crm.service.interfaces.ClientService;
import com.exam.crm.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/client")
public class ClientController extends BaseController {
  private ClientService clientService;
  private CompanyService companyService;

  @Autowired
  private void setClientService(ClientService clientService) {
    this.clientService = clientService;
  }

  @Autowired
  private void setCompanyService(CompanyService companyService) {
    this.companyService = companyService;
  }

  @RequestMapping("view")
  public ModelAndView view() {
    ModelAndView mav = new ModelAndView("show_data_client");

    mav.addObject("dataList", clientService.get());

    return mav;
  }

  @GetMapping("create")
  public ModelAndView showCreatingView() {
    ModelAndView mav = new ModelAndView("create_client");

    mav.addObject("companyDataList", companyService.get());

    return mav;
  }

  @PostMapping("create")
  public ModelAndView create(int companyId, String name, String email, String phone, HttpSession session) {
    ModelAndView mav = new ModelAndView();

    mav.addObject("functionId", FunctionId.CREATE.ordinal());

    if (clientService.create(companyId, name, email, phone, session)) {
      super.setSuccess(mav, "Client");
    } else {
      super.setError(mav, ErrorCode.INVALID_COMPANY_ID, "Client 資料建立失敗, 無效的 Company Id!");
    }

    return mav;
  }

  @GetMapping("modify")
  public ModelAndView showModifyingView() {
    ModelAndView mav = new ModelAndView("modify_client");

    mav.addObject("dataList", clientService.get());

    return mav;
  }

  @PostMapping("modify")
  public ModelAndView modify(int id, int companyId, String name, String email, String phone, HttpSession session) {
    ModelAndView mav = new ModelAndView();

    super.setSuccess(mav, "Client");
    mav.addObject("functionId", FunctionId.MODIFY.ordinal());

    if (clientService.modify(id, companyId, name, email, phone, session)) {
      super.setSuccess(mav, "Client");
    } else {
      super.setError(mav, ErrorCode.INVALID_ID, "Client 資料修改失敗, 無效的 Id 或 Company Id!");
    }

    return mav;
  }

  @GetMapping("delete")
  public ModelAndView showDeletingView() {
    ModelAndView mav = new ModelAndView("delete_client");

    mav.addObject("dataList", clientService.get());

    return mav;
  }

  @PostMapping("delete")
  public ModelAndView delete(int id) {
    ModelAndView mav = new ModelAndView();

    mav.addObject("functionId", FunctionId.DELETE.ordinal());

    if (clientService.delete(id)) {
      super.setSuccess(mav, "Client");
    } else {
      super.setError(mav, ErrorCode.INVALID_ID, "Client 資料刪除失敗, 無效的 Id!");
    }

    return mav;
  }
}
