package com.eugene.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// set up logger

	private Logger logger = Logger.getLogger(getClass().getName());

	// set up pointcut declarations
	@Pointcut("execution(* com.eugene.springdemo.controller.*.*(..))")
	private void forControllerPackage() {

	}

	@Pointcut("execution(* com.eugene.springdemo.service.*.*(..))")
	private void forServicePackage() {

	}

	@Pointcut("execution(* com.eugene.springdemo.dao.*.*(..))")
	private void forDaoPackage() {

	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {

	}

	// add @Before
	@Before("forAppFlow()")
	public void before(JoinPoint jp) {
		logger.info("This is inside the before advice method");
		// display method name
		logger.info(jp.getSignature().toShortString());
		// display the arguments
		Object[] args = jp.getArgs();
		for (Object o : args) {
			logger.info(o.toString());
		}
	}

	@AfterReturning(pointcut = "forAppFlow()", returning = "result")
	public void afterReturning(JoinPoint jp, Object result) {
		logger.info("This is inside the after retuning method");
		if (result != null) {
			logger.info(result.toString());
		}
	}

	// add @After
}
