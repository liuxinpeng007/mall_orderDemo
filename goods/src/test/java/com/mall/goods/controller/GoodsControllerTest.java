package com.mall.goods.controller;

import com.mall.goods.GoodsServerApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GoodsServerApplication.class)
@WebAppConfiguration
@ContextConfiguration
public class GoodsControllerTest {

    @Autowired
    private WebApplicationContext context;


    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void testGetGoodsById() throws Exception {
        RequestBuilder request = null;
        //路径
        request = get("/goods/query/1ff2f913978e4897ac62d741d9e244b8")
                //接受的数据类型
                .accept(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                //状态吗是否相等
                .andExpect(status().isOk())
                //得到的信息是否与特定字段匹配
                //.andExpect(content().string("1wqeqweqweqweqweq"))
                //输出信息
                .andDo(print());
    }

    @Test
    public void getOrderByUserId() throws Exception {
        RequestBuilder request = null;
        //路径
        request = get("/order/query/user/edcae26418994a70a67ceb3d9fda6fa7")
                //接受的数据类型
                .accept(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                //状态吗是否相等
                .andExpect(status().isOk())
                //得到的信息是否与特定字段匹配
                //.andExpect(content().string("1wqeqweqweqweqweq"))
                //输出信息
                .andDo(print());
    }
}
