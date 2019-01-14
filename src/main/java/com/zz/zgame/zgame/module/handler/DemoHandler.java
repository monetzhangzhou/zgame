package com.zz.zgame.zgame.module.handler;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zz.zgame.net.message.MessagePacket;
import com.zz.zgame.zgame.com.manager.HandlerManager;
import com.zz.zgame.zgame.com.manager.IHandler;

@Component
public class DemoHandler {

	@Autowired
	private HandlerManager handlerManager;

	@PostConstruct
	public void init() {

		handlerManager.register(10001, new IHandler() {
			// 采用匿名内部类方式执行具体逻辑
			@Override
			public void execute(MessagePacket packet) {

			}
		});
	}
}
