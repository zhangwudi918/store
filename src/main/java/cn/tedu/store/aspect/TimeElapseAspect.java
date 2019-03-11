package cn.tedu.store.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 面向切面演示类
 * @author soft01
 *
 */
@Component//通用组件类注解，将该类交由spring管理
@Aspect //切面类注解
public class TimeElapseAspect {

@Around("execution(* cn.tedu.store.service.impl.*.*(..))")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		//业务前执行
		long start=System.currentTimeMillis();
		//执行业务代码
		Object obj=pjp.proceed();
		//业务后执行
		long end=System.currentTimeMillis();
		System.err.print("执行时间："+(end-start)+"ms");
		return obj;
	}
}

