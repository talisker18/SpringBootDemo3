package com.henz.SpringBootDemo3;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * this class will be instantiated manually instead by spring framework
 * it is used as bean in WiringConfiguration
 * 
 * class SimpleLogic is instantiated automatically by spring
 * 
 * */

public class PlainSimpleLogic implements InitializingBean{
	
	//DI of SimpleLogic instance via Autowire
	//see the logs: only 1 bean of SimpleLogic gets init at startup and this will be used
	//here
	@Autowired
	private SimpleLogic simpleLogic;
	
	//injection via constructor
	private SimpleLogic2 simpleLogic2;

	//or inject bean of SimpleLogic with constructor injection
	public PlainSimpleLogic(SimpleLogic2 simpleLogic2) {
		this.simpleLogic2 = simpleLogic2;
		System.out.println("class instance of PlainSimpleLogic created, bean scope prototype");
	}
	
	public void init() {
		System.out.println("class instance of PlainSimpleLogic initialized, bean scope prototype");
	}

	//alternative to @PostConstruct
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("class instance of PlainSimpleLogic initialized in afterPropertiesSet, bean scope prototype");
		
	}
	
	public void destroyed() {
		System.out.println("bean of PlainSimpleLogic is about to be destroyed, bean scope prototype");
	}
	
	public void doSomewhat() {
		simpleLogic.doSompleWork();
	}
	
	public void doSomewhat2() {
		simpleLogic2.doSompleWork();
	}
}
