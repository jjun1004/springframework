package com.mycompany.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.mycompany.webapp.dto.Ch08InputForm;

@Controller
@RequestMapping("/ch08")
@SessionAttributes({"inputForm"}) // 이 컨트롤러 안에서만 데이터 유지됨
public class Ch08Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch08Controller.class);
	
	@RequestMapping("/content")
	public String content(HttpSession session) {
		return "ch08/content";
	}
	
	@GetMapping(value = "/saveData", produces = "application/json; charset = UTF-8")
	@ResponseBody
	public String saveData(String name, HttpServletRequest request ,HttpSession session) {
		logger.info("실행");
		logger.info("name: " + name);
		
		// 매개변수가 HttpServletRequest request 일 때
		
		//HttpSession session = request.getSession();
		session.setAttribute("name", name);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		String json = jsonObject.toString(); // {"result": "success"}
		return json;
	}
	
	@GetMapping(value = "/readData", produces = "application/json; charset = UTF-8")
	@ResponseBody
	public String readData(HttpSession session, @SessionAttribute String name) {
		logger.info("실행");

		// 방법1 HttpSession session
//		String name = (String) session.getAttribute("name");
//		logger.info("name " + name);
		
		//방법 2 @SessionAttribute String name 
		// @SessionAttribute("name") String username
		logger.info("name" + name);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		String json = jsonObject.toString(); // {"name": "홍길동"}
		return json;
	}
	
	@GetMapping("/login")
	public String loginForm() {
		logger.info("실행");
		return "ch08/loginForm";
	}
	
	@PostMapping("/login")
	public String login(String mid, String mpassword, HttpSession session) {
		logger.info("실행");
		if(mid.equals("spring") && mpassword.equals("12345")) {
			session.setAttribute("sessionMid", mid);
		}
		return "redirect:/ch08/content";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		logger.info("실행");
		
		// 방법1
		session.removeAttribute("sessionMid");
		
		//방법2
//		session.invalidate();
		
		return "redirect:/ch08/content";
	}
	
	@PostMapping(value = "/loginAjax", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String loginAjax(String mid, String mpassword, HttpSession session) {
		logger.info("실행");
		String result = "";
		
		if(!mid.equals("spring")) {
			result = "wrongMid";
		} else if(!mpassword.equals("12345")) {
			result = "wrongMpassword";
		} else {
			result = "success";
			session.setAttribute("sessionMid", mid);
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", result);
		String json = jsonObject.toString(); 
		return json;
	}
	
		/*@GetMapping(value="/logoutAjax", produces="application/json; charset=UTF-8")
		@ResponseBody
		public String logoutAjax(HttpSession session) {
			logger.info("실행");
			
			//session.invalidate();
			session.removeAttribute("sessionMid");
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("result", "success");
			String json = jsonObject,toString();
			return json;
		}*/
	
	@GetMapping("/logoutAjax")
	public void logoutAjax(HttpSession session, HttpServletResponse response) throws IOException {
		logger.info("실행");

		session.invalidate();
		//session.removeAttribute("sessionMid");
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		String json = jsonObject.toString(); 
		
		pw.print(json);
		//pw.flush(); 메모리 비우고 전송. 이미 응답이 가서 응답헤더에 내용을 추가하지 못함
		//pw.close(); dispatcherServlet이 close 함. 자동으로 flush해서 메모리로 전송
	}
	
	@ModelAttribute("inputForm") // 앞에SessionAttributes를 붙히면 세션에 inputForm이름이 없을 때 딱 한번 실행 됨.
	public Ch08InputForm getInputForm() {
		logger.info("실행");
		Ch08InputForm inputForm = new Ch08InputForm();
		return inputForm;
	}
	
	
	@GetMapping("/inputStep1")
	public String inputStep1(@ModelAttribute("inputForm") Ch08InputForm inputForm) {
		// 세션에 있는 객체를 넣어줬기 때문에 같은 객체를 사용. 만약 ModelAttribute를 붙히지 않으면 매번 새로운 객체 생성
		logger.info("실행");
		return "ch08/inputStep1";
	}
	
	@PostMapping("/inputStep2")
	public String inputStep2(@ModelAttribute("inputForm") Ch08InputForm inputForm) {
		logger.info("실행");
		logger.info("data1: " + inputForm.getData1());
		logger.info("data2: " + inputForm.getData2());
		logger.info("data3: " + inputForm.getData3());
		logger.info("data4: " + inputForm.getData4());
		return "ch08/inputStep2";
	}
	
	@PostMapping("/inputDone")
	public String inputDone(@ModelAttribute("inputForm") Ch08InputForm inputForm, SessionStatus sessionStatus) {
		logger.info("실행");
		logger.info("data1: " + inputForm.getData1());
		logger.info("data2: " + inputForm.getData2());
		logger.info("data3: " + inputForm.getData3());
		logger.info("data4: " + inputForm.getData4());
		// 처리 내용 ~
		//세션에 저장되어 있는 inputForm을 제거
//		SessionAttributes(inputForm)이 모두 사라짐
		sessionStatus.setComplete();
		
//		session.removeAttribute("inputForm");  여기선 이방식으로 지우지 말기. 상황이 다름
		
		return "redirect:/ch08/content";
	}
}
