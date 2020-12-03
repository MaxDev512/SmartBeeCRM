package com.exam.crm.service.interfaces;

import com.exam.crm.model.Company;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public interface CompanyService {
  List<Company> get();
  void create(String name, String address, HttpSession session);
  boolean modify(int id, String name, String address, HttpSession session);
  void delete(int id);
}
