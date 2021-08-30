package com.mycompany.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/ch01")  // ~controller.java 랑 관련이 없음
public class Ch01Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Ch01Controller.class);
	

	@RequestMapping("/content") // http:localhost:8080/contextRoot - > /로 바꿨기 때문
	public String home() { // 메소드 이름은 어노테이션 @RequestMapping("/home") 이랑 관련 없음
		logger.info("실행2");
		return "ch01/content"; // if ) home2.jsp -> return "home2" / src/main/webapp/WEB-INF/views/ 아래의 content.jsp를 연결
	}
}
