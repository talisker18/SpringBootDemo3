package com.henz.SpringBootDemo3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class SimpleLogic2 implements InitializingBean{

	public SimpleLogic2() {
		System.out.println("class instance of SimpleLogic2 created");
	}
	
	//use this to init instance vars if there are some
	@PostConstruct
	public void init() {
		System.out.println("class instance of SimpleLogic2 initialized, bean scope singleton");
	}

	//alternative to @PostConstruct
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("class instance of SimpleLogic2 initialized in afterPropertiesSet, bean scope singleton");
		
	}
	
	//this is called before the application terminates (?)
	@PreDestroy
	public void destroyed() {
		System.out.println("bean of SimpleLogi2c is about to be destroyed, bean scope singleton");
	}

	public void doSompleWork() {
		System.out.println("simple work method from SimpleLogic2");
		
	}
}
