package com.mycompany.webapp.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.webapp.controller.Ch15Controller;

@Component
@Aspect
public class Ch15Aspect5AfterThrowing {
	private static final Logger logger = LoggerFactory.getLogger(Ch15Controller.class);
	
	@AfterThrowing(
		pointcut="execution(public * com.mycompany.webapp.controller.Ch15Controller.afterThrowing*(..))",
		throwing="e" // String returnValuev부분의 returnValue와 이름이 똑같아야 함.
		)
	public void method(Throwable e) {
		logger.info("실행");
		logger.info("예외 메시지: "+ e.getMessage());
	}
}
