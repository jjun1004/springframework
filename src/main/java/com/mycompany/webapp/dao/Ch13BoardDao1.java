package com.mycompany.webapp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//dao- 데이터 연동객체, 공유성 강함. root쪽 저장
public class Ch13BoardDao1 { 
	private static final Logger logger = LoggerFactory.getLogger(Ch13BoardDao1.class);
	
	public Ch13BoardDao1() {
		logger.info("실행"); // 생성자가 출력되고 객체가 만들어 졌는지 확인
	}
	
	public void update() {
		logger.info("실행");
	}
	
}
