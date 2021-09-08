package com.mycompany.webapp.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.Ch13BoardDao2;

//앞글자를 소문자로 한 객체가 만들어지기 때문에(기본 생성자로 객체생성됨) bean태그로 만들어 줄 필요 없음
@Service
public class Ch13Service2 {
	private static final Logger logger = LoggerFactory.getLogger(Ch13Service2.class);
	
	//@Autowired
	@Resource
	private Ch13BoardDao2 ch13BoardDao2;
	
	public Ch13Service2() {
		logger.info("실행"); // 생성자가 출력되고 객체가 만들어 졌는지 확인
	}

	/*
	//	@Autowired
	//setter위에 Autowired가 선언되면 setter를 자동으로 실행하고 setCh13BoardDao2에 자동적으로 의존성 객체가 주입됨.
	@Resource
	public void setCh13BoardDao2(Ch13BoardDao2 ch13BoardDao2) {
			logger.info("실행");
			this.ch13BoardDao2 = ch13BoardDao2;
	}
	 */

	public void method1() {
		logger.info("실행");
		ch13BoardDao2.update(); // private Ch13BoardDao1 ch13BoardDao1에 객체가 없기 때문 nullpointerException 발생. 따라서 위 처럼 매개값 넣을 필요있음.
	}
}
