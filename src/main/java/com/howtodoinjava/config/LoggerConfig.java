package com.howtodoinjava.config;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
public class LoggerConfig {
	private static final String POINTCUT = "within(com.howtodoinjava.controller.*)";

	@Around(POINTCUT)
	public Object logAroundExec(ProceedingJoinPoint pjp) throws Throwable {
		log.info("before {}", constructLogMsg(pjp));
		var proceed = pjp.proceed();
		log.info("after {} wiht result: {}", constructLogMsg(pjp), proceed.toString());
		return proceed;
	}

	private String constructLogMsg(JoinPoint jp) {
		var args = Arrays.asList(jp.getArgs()).stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
		Method method = ((MethodSignature) jp.getSignature()).getMethod();
		var sb = new StringBuilder("@");
		sb.append(method.getName());
		sb.append(":");
		sb.append(args);
		return sb.toString();
	}
}
