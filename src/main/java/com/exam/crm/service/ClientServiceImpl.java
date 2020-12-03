package com.exam.crm.service;

import com.exam.crm.constant.SessionConsts;
import com.exam.crm.dao.ClientRepository;
import com.exam.crm.dao.CompanyRepository;
import com.exam.crm.model.Client;
import com.exam.crm.model.UserInfo;
import com.exam.crm.service.interfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
  private ClientRepository clientRepo;
  private CompanyRepository companyRepo;

  @Autowired
  private void setClientRepository(ClientRepository clientRepo) {
    this.clientRepo = clientRepo;
  }

  @Autowired
  private void setCompanyRepository(CompanyRepository companyRepo) {
    this.companyRepo = companyRepo;
  }

  public List<Client> get() {
    return clientRepo.findAll();
  }

  @Override
  public boolean create(int companyId, String name, String email, String phone, HttpSession session) {
    if ((companyId > 0) && companyRepo.findById(companyId).isPresent()) {
      UserInfo userInfo = (UserInfo) session.getAttribute(SessionConsts.USER);
      Date dateNow = new Date(System.currentTimeMillis());

      Client client = new Client();
      client.setCompany_id(companyId);
      client.setName(name);
      client.setEmail(email);
      client.setPhone(phone);
      client.setCreated_by(userInfo.getId());
      client.setCreated_at(dateNow);
      client.setUpdated_by(userInfo.getId());
      client.setUpdated_at(dateNow);

      clientRepo.saveAndFlush(client);

      return true;
    }

    return false;
  }

  @Override
  public boolean modify(int id, int companyId, String name, String email, String phone, HttpSession session) {
    if (id > 0) {
      UserInfo userInfo = (UserInfo) session.getAttribute(SessionConsts.USER);

      Optional<Client> clientOpt = clientRepo.findById(id);
      if (clientOpt.isPresent()) {
        Client client = clientOpt.get();

        if ((companyId > 0) && (companyRepo.findById(companyId).isPresent())) {
          client.setCompany_id(companyId);
        }
        if (!name.isEmpty()) {
          client.setName(name);
        }
        if (!email.isEmpty()) {
          client.setEmail(email);
        }
        if (!phone.isEmpty()) {
          client.setPhone(phone);
        }
        client.setUpdated_by(userInfo.getId());
        client.setUpdated_at(new Date(System.currentTimeMillis()));

        clientRepo.updateById(client);

        return true;
      }
    }

    return false;
  }

  @Override
  public boolean delete(int id) {
    if ((id > 0) && clientRepo.findById(id).isPresent()) {
      clientRepo.deleteById(id);

      return true;
    }

    return false;
  }
}
