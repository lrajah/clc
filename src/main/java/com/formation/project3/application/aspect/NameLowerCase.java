/**
 * 
 */
package com.formation.project3.application.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import com.formation.project3.application.dto.BenevoleLight;
import com.formation.project3.application.dto.BenevoleLightById;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author Dell
 *
 */
@Aspect
@Configuration
public class NameLowerCase {
	
	
//	    @Pointcut("execution(* com.formation.projet3.application.controller.*.*(..))")
//	    public void genericPointcut() {}

	    @Pointcut("execution(com.formation.project3.application.dto.BenevoleLightById com.formation.project3.application.service.*.*(..))")
	    public void interceptPointcut() {}
	    @Pointcut("execution(java.util.List<com.formation.project3.application.dto.BenevoleLight> com.formation.project3.application.service.*.*(..))")
	    public void interceptPointcutList() {}

//	    @Before("genericPointcut()") 
//	    public void before(JoinPoint joinPoint) throws Throwable {
//	        System.out.println(joinPoint.toShortString() + " is called");
//	    }

	    @AfterReturning(pointcut="interceptPointcut()", returning="result") 
	    public void after(JoinPoint joinPoint, Object result) throws Throwable {
	    	((BenevoleLightById)result).setNom(((BenevoleLightById) result).getNom().toLowerCase());
	    	((BenevoleLightById)result).setPrenom(((BenevoleLightById) result).getPrenom().toLowerCase());
	    }
	    @SuppressWarnings("unchecked")
		@AfterReturning(pointcut="interceptPointcutList()", returning="result") 
	    public void after2(JoinPoint joinPoint, Object result) throws Throwable {
	    	
	    	((List<BenevoleLight>)result).stream().forEach(c -> c.setNom(c.getNom().toLowerCase()));
	    }
	    
//	    @AfterReturning(pointcut = "genericPointcut()", returning="result") 
//	    public void after3(JoinPoint joinPoint, Object result) throws Throwable {
//	        if ((result instanceof List<?>)) {
//	        @SuppressWarnings("unchecked")
//			List<Object> list = (List<Object>) result;
//	        for (Object o : list) {
//
//	            adapt(o);
//	        }
//	        }else {
//	        	adapt(result);
//	        }
//	    }
//		private void adapt(Object o) throws IllegalAccessException {
//			for (Field f : o.getClass().getDeclaredFields()) {
//
//			    if (f.getType().equals(String.class)) {
//			        if (f.getName().equals("type")) continue;
//
//			        boolean access = f.isAccessible();
//			        f.setAccessible(true);
//			        String value = (String)(f.get(o));
//			        f.set(o, value.toLowerCase());
//			        f.setAccessible(access);
//			    }
//
//			}
//		}

//	    @Around("genericPointcut()")
//	    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//	        long startTime = System.currentTimeMillis();
//	        Object result = joinPoint.proceed();
//	        long timeTaken = System.currentTimeMillis() - startTime;
//	        System.out.println("Time Taken by " + joinPoint.toShortString() + " = " + timeTaken);
//	        return result;
//	    }
	
}
