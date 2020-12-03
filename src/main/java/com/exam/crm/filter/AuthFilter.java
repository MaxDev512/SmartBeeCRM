package com.exam.crm.filter;

import com.exam.crm.constant.ErrorCode;
import com.exam.crm.constant.SessionConsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class AuthFilter implements Filter {
  private static final Set<String> EXCLUDED_PATHS = Collections.unmodifiableSet(new HashSet<>(
    Arrays.asList("/", "/auth/login", "/auth/logout")));

  private HttpSession session;

  @Autowired
  private void setHttpSession(HttpSession session) {
    this.session = session;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest)request;
    HttpServletResponse resp = (HttpServletResponse)response;

    String path = req.getRequestURI().substring(req.getContextPath().length());
    boolean excludedPaths = EXCLUDED_PATHS.contains(path);

    if (!excludedPaths) {
      boolean isLogin = (session.getAttribute(SessionConsts.USER) != null);

      if (!isLogin) {
        req.setAttribute("errorCode", ErrorCode.NOT_LOGIN_YET);
        req.setAttribute("errorMessage", "未登入");
        req.getRequestDispatcher("error").forward(req, resp);

        return;
      }
    }

    chain.doFilter(request, response);
  }
}
