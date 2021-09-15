package com.mycompany.webapp.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.webapp.controller.Ch15Controller;

@Component
@Aspect
public class Ch15Aspect4AfterReturning {
	private static final Logger logger = LoggerFactory.getLogger(Ch15Controller.class);
	
	@AfterReturning(
		pointcut="execution(public * com.mycompany.webapp.controller.Ch15Controller.afterReturning*(..))",
		returning="returnValue" // String returnValuev부분의 returnValue와 이름이 똑같아야 함.
		)
	public void method(String returnValue) {
		logger.info("실행");
		logger.info("리턴 값: "+ returnValue);
	}
}
