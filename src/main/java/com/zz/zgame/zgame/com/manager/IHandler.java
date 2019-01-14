package com.zz.zgame.zgame.com.manager;

import com.zz.zgame.net.message.MessagePacket;

public interface IHandler {

	void execute(MessagePacket packet);
}
