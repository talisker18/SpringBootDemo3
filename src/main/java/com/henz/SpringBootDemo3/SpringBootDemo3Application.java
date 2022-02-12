package com.henz.SpringBootDemo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootDemo3Application {

	//when starting this main method we will see that SimpleLogic instance
	//will be created in the spring context when spring is starting up the application
	//but we do not use this instance yet
	public static void main(String[] args) {
		//use following to demonstrate init of SimpleLogic beans, scope singleton
		//SpringApplication.run(SpringBootDemo3Application.class, args);
		
		//use this to demonstrate init of PlainSimpleLogic
		//since this class is injected as bean in WiringConfiguration, with scope 'prototype'
		//the initialization happens only when the class is referenced
		//we will do this in the next lines. first create a Context
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootDemo3Application.class, args);
		
		//...then do this. do 3x init of PlainSimpleLogic bean
		//System.out.println(context.getBean(PlainSimpleLogic.class));
		//System.out.println(context.getBean(PlainSimpleLogic.class));
		//System.out.println(context.getBean(PlainSimpleLogic.class));
		
		//autowired bean of SimpleLogic will be injected automatically
		//see the output: there will be created a bean of PlainSimpleLogic automatically when referenced
		context.getBean(PlainSimpleLogic.class).doSomewhat();
		
		//inject simpleLogic2 it via constructor
		//see the output: there will be created a bean of PlainSimpleLogic automatically when referenced
		context.getBean(PlainSimpleLogic.class).doSomewhat2();
	}

}
