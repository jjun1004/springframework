package com.mycompany.webapp.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 자동적으로 클래스로부터 객체가 만들어짐
@RequestMapping("/ch06")
public class Ch06Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch06Controller.class);
	
	//	public Ch06Controller() { // 객체가 만들어졌다면 생성자 안에 로거가 실행됨. 확인용. @Controller 붙히지 않으면 불가
	//		logger.info("실행");
	//	}
	
	//com.mycompany.webapp.controller.Ch06Controller.<init>() - 실행
	// 생성자가 자동으로 실행되고 있다는 뜻
	
	@RequestMapping("/content")
	public String content() {
		return "ch06/content";
	}
	
	@RequestMapping("/forward")
	public String forward() {
		return "ch06/forward";
	}
	
	@RequestMapping("/redirect")
	public String redirect() {
		return "redirect:/";
	}
	
	
	@GetMapping("/getFragmentHtml")
	public String getFragmentHtml() {
		logger.info("실행");
		return "ch06/fragmentHtml";
	}
	
	@GetMapping("/getJson1")
	public void getJson1(HttpServletResponse response) throws Exception {
		logger.info("실행");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("fileName", "photo5.jpg");
		String json = jsonObject.toString();
		//응답 HTTP의 Body부분에 json을 포함
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println(json);
		pw.flush();
		pw.close();
	}
	
	@GetMapping(value="/getJson2", produces="application/json; charset=UTF-8") // 이 방식이 중요
	@ResponseBody
	public String getJson2() {
		logger.info("실행");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("fileName", "photo6.jpg");
		String json = jsonObject.toString();
		return json;
	}
	
	@GetMapping("/getJson3") // 이 방식이 중요
	public String getJson3() {
		logger.info("실행");
		return "redirect:/"; 
	} //	return "redirect:/ch06/getJson2"; 
	//위와 같이 하면 getJson2의 반환값이 json이기 때문에 결과 값은 나오나 ajax의 방향과 다름
}
