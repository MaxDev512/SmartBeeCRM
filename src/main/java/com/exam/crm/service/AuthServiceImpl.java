package com.exam.crm.service;

import com.exam.crm.constant.SessionConsts;
import com.exam.crm.dao.UserRepository;
import com.exam.crm.model.User;
import com.exam.crm.model.UserInfo;
import com.exam.crm.service.interfaces.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service("auth")
public class AuthServiceImpl implements AuthService {
  private UserRepository userRepo;

  @Autowired
  private void setUserRepository(UserRepository userRepo) {
    this.userRepo = userRepo;
  }

  public boolean login(String id, String password, HttpSession session) {
    User user = userRepo.findById(id, password);
    boolean isLogin = (user != null);

    if (isLogin) {
      UserInfo userInfo = new UserInfo();
      userInfo.setId(user.getId());
      userInfo.setName(user.getName());
      userInfo.setPermission(user.getPermission());

      session.setAttribute(SessionConsts.USER, userInfo);
    }

    return isLogin;
  }
}
