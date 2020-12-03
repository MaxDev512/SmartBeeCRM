package com.exam.crm;

import com.exam.crm.model.UserInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
class CrmApplicationTests {
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testLogin() {
    try {
      MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
        .param("id", "max")
        .param("password", "1234"))
        .andExpect(MockMvcResultMatchers.redirectedUrl("/func/show"))
        .andReturn();

      UserInfo user = (UserInfo) mvcResult.getRequest().getSession().getAttribute("user");
      Assert.assertNotNull(user);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
