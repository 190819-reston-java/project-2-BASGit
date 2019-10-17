/**
 * 
 */
package com.revature.controllers;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// see: training-code/week6/SpringAOPDemo/src/main/java/com/revature/aspects/
// Ideas: log IPs/time of visits, 404 requests, errors, How long things take, ...

@Aspect
@Component
public class Logging {
	
		private static final Logger storyControllerLog = Logger.getLogger(StoryController.class);
		
		//@Before("within(com.revature.controllers.StoryController)")
		@Before("execution(* *(..))")
		public static void logUserMethods(JoinPoint jp) {
			storyControllerLog.info(jp.getTarget() + " has invoked " + jp.getSignature());
			System.out.println("Hi?");
		}
			
//	public Logging() {
//	}

//	/**
//	 * @param args
//	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(StoryController.testingString());
		System.out.println(StoryController.class.toString());		
	}

}

