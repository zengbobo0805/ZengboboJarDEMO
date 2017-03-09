package com.zengbobo.eventBus.demo.event;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by bobo on 2017/3/7.
 */

public class BaseSubscriberEvent<T extends
        BaseSubscriberEvent.BasePublisherParam> {


    protected IEventBusSubscriber<T> eventBusSubscriber;


    /**
     * 提供给订阅者构造函数；
     *
     * @param eventBusSubscriber 订阅事件回调；
     */
    public BaseSubscriberEvent(IEventBusSubscriber<T> eventBusSubscriber) {
        this.eventBusSubscriber = eventBusSubscriber;
    }


    /**
     * 订阅事件；
     *
     * @param register 是否订阅：true 订阅，false 不订阅；
     */
    public void register(boolean register) {
        if (register) {
            EventBus.getDefault().register(this);
        } else {
            EventBus.getDefault().unregister(this);
        }
    }

    /**
     * 发布事件
     *
     * @param param 发布事件；
     */
    public static <K extends BasePublisherParam> void post(K param) {
        EventBus.getDefault().post(param);
    }

    /**
     * 订阅者事件处理回调；
     */
    public interface IEventBusSubscriber<T> {
        public void onEventBus(T eventParam);
    }


    /**
     * 发布者参数构成；
     */
    public static class BasePublisherParam {

        public abstract static class BasePublisherBuilder {

            public abstract BasePublisherParam build();
        }

    }

    public void onEventBust(T param) {
        System.out.println("BaseSubscriberEvent param:" + param);
        if (eventBusSubscriber != null) {
            eventBusSubscriber.onEventBus(param);
        }
    }


}
