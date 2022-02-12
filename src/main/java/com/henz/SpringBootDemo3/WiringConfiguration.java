package com.henz.SpringBootDemo3;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class WiringConfiguration {
	
	
	/*
	 * by default, spring makes scope of bean to singleton -> init the bean when app is started
	 * but we can define the scope, e.g. with prototype. with this, initialization only happens when
	 * the bean is actually used
	 * 
	 * */
	@Bean(initMethod = "init", destroyMethod = "destroyed")
	//now if we start the spring boot app, you will see that the bean initialization does not happen
	//at startup of the app
	//to init it we have to
	@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PlainSimpleLogic plainSimpleLogic(SimpleLogic2 simpleLogic2) {
		return new PlainSimpleLogic(simpleLogic2);
	}

}
