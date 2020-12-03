package com.exam.crm.service.interfaces;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public interface AuthService {
  boolean login(String id, String password, HttpSession session);
}
