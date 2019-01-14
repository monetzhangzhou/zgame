package com.zz.zgame.common.manager;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringProxy implements ApplicationContextAware {

	public static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringProxy.applicationContext = applicationContext;

	}

}
