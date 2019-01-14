package com.zz.zgame.common.manager;

import java.util.UUID;

/**
 * UUID生成器，保证时间和空间具有唯一性
 * Created by zhangzhou on 16/11/19.
 */
public class UUIDGenerator {

    /**
     * 获取一个UUID
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
