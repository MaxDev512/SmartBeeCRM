package com.exam.crm.service.interfaces;

import com.exam.crm.model.Client;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public interface ClientService {
  List<Client> get();
  boolean create(int companyId, String name, String email, String phone, HttpSession session);
  boolean modify(int id, int companyId, String name, String email, String phone, HttpSession session);
  boolean delete(int id);
}
