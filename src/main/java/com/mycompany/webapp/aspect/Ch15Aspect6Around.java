package com.mycompany.webapp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.webapp.controller.Ch15Controller;

@Component
@Aspect
public class Ch15Aspect6Around {
	private static final Logger logger = LoggerFactory.getLogger(Ch15Controller.class);
	
	@Around("execution(public * com.mycompany.webapp.controller.Ch15Controller.around*(..))")
	public Object method(ProceedingJoinPoint joinPoint) {
		//------------------------------------------------
		logger.info("전처리 실행"); // 전 후 중 하나만 넣어도 됨
		//------------------------------------------------
		Object result = null;
		try {
			result = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//------------------------------------------------
		logger.info("후처리 실행");
		//------------------------------------------------
		return result;
	}
}
