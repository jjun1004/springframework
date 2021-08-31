package com.mycompany.webapp.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.controller.dto.Ch04Member;
import com.mycompany.webapp.validator.Ch04MemberEmailValidator;
import com.mycompany.webapp.validator.Ch04MemberIdValidator;
import com.mycompany.webapp.validator.Ch04MemberPasswordValidator;
import com.mycompany.webapp.validator.Ch04MemberTelValidator;

@Controller
@RequestMapping("/ch04")
public class Ch04Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch04Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		return "ch04/content";
	}
	
	@PostMapping("/method1")
	public String method1() {
		return "redirect:/ch04/content";
	}
	
	@InitBinder("joinForm")
	public void joinFormValidator(WebDataBinder binder) {
		logger.info("실행");
//		binder.setValidator(new Ch04MemberJoinFormValidator());
		
		binder.addValidators(
				new Ch04MemberIdValidator(),
				new Ch04MemberPasswordValidator(),
				new Ch04MemberEmailValidator(),
				new Ch04MemberTelValidator()
		);
	}
	
	@PostMapping("/join") // 메소드가 처리되기 전에 유효성 검사 수행해야 함.
	public String join(@ModelAttribute("joinForm") @Valid Ch04Member member, BindingResult bindingResult) { // 유효성 검사할 땐 @Valid를 붙히고 어떤 것으로 유효검사를 할건지 @Model~을 붙
		logger.info("실행");
		if(bindingResult.hasErrors()) {
			logger.info("다시 입력폼 제공 + 에러 메시지");
			//forward
			return "ch04/content";
		}	else {
			logger.info("정상 요청 처리 후 응답 제공");
			//redirect
			return "redirect:/ch04/content";
		}
	}
	
	@InitBinder("loginForm")
	public void loginFormValidator(WebDataBinder binder) {
		logger.info("실행");
//		binder.setValidator(new Ch04MemberJoinFormValidator());
		
		binder.addValidators(
				new Ch04MemberIdValidator(),
				new Ch04MemberPasswordValidator()
		);
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("loginForm") @Valid Ch04Member member, Errors errors) {
			logger.info("실행");
			if(errors.hasErrors()) {
				logger.info("다시 입력폼 제공 + 에러 메시지");
				//forward
				return "ch04/content";
			} else {
				logger.info("정상 요청 처리 후 응답 제공");
				//redirect
				return "redirect: /ch04/content";
			}
	}
	
	
}
