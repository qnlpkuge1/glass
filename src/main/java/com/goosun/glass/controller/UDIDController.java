package com.goosun.glass.controller;


import com.goosun.glass.domain.res.UDIDRes;
import com.goosun.glass.utils.BeanToXml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.Map;

@Controller
public class UDIDController {

    private Logger log = LoggerFactory.getLogger(UDIDController.class);

    @PostMapping("/UDID/install")
    public String udid(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        //获取HTTP请求的输入流
        InputStream is = request.getInputStream();
        //已HTTP请求输入流建立一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        StringBuilder sb = new StringBuilder();

        //读取HTTP请求内容
        String buffer = null;
        while ((buffer = br.readLine()) != null) {
            sb.append(buffer);
        }
        String content = sb.toString().substring(sb.toString().indexOf("<?xml"), sb.toString().indexOf("</plist>")+8);

        Map udidMap = null;
        try {
            udidMap = BeanToXml.xmlToMap(content);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取udid失败");
        }
        if(udidMap!=null) {
            response.setHeader("Location", "http://192.168.3.6:9999/app?udid="+udidMap.get("UDID"));
            response.setStatus(301);
        }
        return "index";
    }



}
