package com.zz.zgame.net.netty.manager;

import com.zz.zgame.net.message.BasePacket;

/**
 * @author zhangzhou
 * @date 2018-01-04
 * 
 */
public interface MessageManager {

	void forward(BasePacket packet);
}
