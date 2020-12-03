package com.exam.crm.service;

import com.exam.crm.constant.SessionConsts;
import com.exam.crm.dao.CompanyRepository;
import com.exam.crm.model.Company;
import com.exam.crm.model.UserInfo;
import com.exam.crm.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
  private CompanyRepository companyRepo;

  @Autowired
  private void setCompanyRepository(CompanyRepository companyRepo) {
    this.companyRepo = companyRepo;
  }

  public List<Company> get() {
    return companyRepo.findAll();
  }

  @Override
  public void create(String name, String address, HttpSession session) {
    UserInfo userInfo = (UserInfo) session.getAttribute(SessionConsts.USER);
    Date dateNow = new Date(System.currentTimeMillis());

    Company company = new Company();
    company.setName(name);
    company.setAddress(address);
    company.setCreated_by(userInfo.getId());
    company.setCreated_at(dateNow);
    company.setUpdated_by(userInfo.getId());
    company.setUpdated_at(dateNow);

    companyRepo.saveAndFlush(company);
  }

  @Override
  public boolean modify(int id, String name, String address, HttpSession session) {
    if (id > 0) {
      UserInfo userInfo = (UserInfo) session.getAttribute(SessionConsts.USER);

      Optional<Company> companyOpt = companyRepo.findById(id);
      if (companyOpt.isPresent()) {
        Company company = companyOpt.get();

        if (!name.isEmpty()) {
          company.setName(name);
        }
        if (!address.isEmpty()) {
          company.setAddress(address);
        }
        company.setUpdated_by(userInfo.getId());
        company.setUpdated_at(new Date(System.currentTimeMillis()));

        companyRepo.updateById(company);

        return true;
      }
    }

    return false;
  }

  @Override
  public void delete(int id) {
    companyRepo.deleteById(id);
  }
}
