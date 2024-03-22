package com.jyx.test.mq;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Manager
 * @Description: 事件调度
 * @Author: jyx
 * @Date: 2023-12-13 16:17
 * @Version: 1.0
 **/
public class Manager {

    static List<BaseListener> subs = new ArrayList<>();

    public static void addListener(BaseListener listener) {
        subs.add(listener);
    }

    public static void sendMsg(MsgEvent event) throws Exception {
        notifyListeners(event);
    }

    public static void notifyListeners(MsgEvent event) throws Exception {
        for (BaseListener listener : subs) {
            listener.handleMsg(event);
        }
    }

}
