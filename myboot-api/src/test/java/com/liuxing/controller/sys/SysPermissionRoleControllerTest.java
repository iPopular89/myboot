package com.liuxing.controller.sys;

import com.alibaba.fastjson.JSONObject;
import com.liuxing.controller.MybootApiApplication;
import com.liuxing.entity.SysPermissionRole;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybootApiApplication.class)
public class SysPermissionRoleControllerTest {

    /**
     * 模拟mvc测试对象
     */
    private MockMvc mockMvc;

    /**
     * web项目上下文
     */
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        //获取mockmvc对象实例
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getList() {
        try {
            MvcResult mvcResult = mockMvc
                    .perform(// 1
                            MockMvcRequestBuilders.get("/sysRole/getList") // 2
                            //.param("name","getList")        // 3
                    )
                    .andReturn();// 4

            int status = mvcResult.getResponse().getStatus(); // 5
            String responseString = mvcResult.getResponse().getContentAsString(); // 6

            Assert.assertEquals("请求错误", 200, status); // 7
            System.out.println("getList接口请求结果"+responseString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Rollback
    @Transactional
    public void addInfo() {
        try {
            SysPermissionRole sysRole=new SysPermissionRole();
            sysRole.setPermissionId("555");
            sysRole.setRoleId("555");
            String retString = JSONObject.toJSONString(sysRole);
            MvcResult mvcResult = mockMvc
                    .perform(// 1
                            MockMvcRequestBuilders.get("/sysRole/addInfo") // 2
                            .content(retString)
                    )
                    .andReturn();// 4

            int status = mvcResult.getResponse().getStatus(); // 5
            String responseString = mvcResult.getResponse().getContentAsString(); // 6

            Assert.assertEquals("请求错误", 200, status); // 7
            System.out.println("getList接口请求结果"+responseString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}