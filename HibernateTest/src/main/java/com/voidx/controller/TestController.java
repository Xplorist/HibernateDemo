package com.voidx.controller;

import com.voidx.service.TestService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private TestService testService;

    @RequestMapping("/query")
    public String query(@RequestBody String parameter){
        String result = "Hello " + parameter + testService.query();

        try {
            result = URLEncoder.encode(result, "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result;
    }

}
