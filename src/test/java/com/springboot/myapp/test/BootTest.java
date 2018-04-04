package com.springboot.myapp.test;


import com.springboot.myapp.app.App;
import com.springboot.myapp.service.SpringBootService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * springBoot测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = App.class)
public class BootTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private SpringBootService springBootService;

    @Test
    public void test() throws Exception{
        springBootService.getAsyncname();
    }
}
