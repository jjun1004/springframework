package com.mycompany.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ch13Service1 {
	private static final Logger logger = LoggerFactory.getLogger(Ch13Service1.class);
	
	public Ch13Service1() {
		logger.info("실행"); // 생성자가 출력되고 객체가 만들어 졌는지 확인
	}
}
