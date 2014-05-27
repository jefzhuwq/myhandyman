package com.mediabox.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mediabox.service.IHelloService;

@Controller
@RequestMapping("/test")
public class HelloControllor {
	private static final Log log = LogFactory.getLog(HelloControllor.class);

    private IHelloService helloService;

    public IHelloService getHelloService() {
        return helloService;
    }

    @Resource
    public void setHelloService(IHelloService helloService) {
    	this.helloService = helloService;
    }

    @RequestMapping("/hello.do")
    public @ResponseBody 
        String sayHello(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        log.info("userName=" + userName);
        int resultCode = helloService.addUser(userName);
        String rspInfo = "你好!" + userName + ",操作结果码=" + resultCode;
        response.setHeader("Content-type","text/html;charset=UTF-8"); 
        response.getOutputStream().write(rspInfo.getBytes("UTF-8"));
        return "";
    }
}
