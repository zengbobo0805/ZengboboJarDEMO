package com.zengbobo.eventBus.demo.event;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by bobo on 2017/1/13.
 */

public class TestSbuscriber1 extends BaseSubscriberEvent<TestSbuscriber1.Test1EventLayoutParam> {


    public TestSbuscriber1(IEventBusSubscriber<Test1EventLayoutParam> eventBusSubscriber) {
        super(eventBusSubscriber);
    }


    public static class Test1EventLayoutParam extends BaseSubscriberEvent.BasePublisherParam {
        private String name;

        public String getName() {
            return name;
        }

        public Test1EventLayoutParam(String name) {
            this.name = name;
        }

        public static class Test1EventBuild extends BasePublisherParam.BasePublisherBuilder {
            private String name;

            public Test1EventBuild setName(String name) {
                this.name = name;
                return this;
            }

            @Override
            public Test1EventLayoutParam build() {
                return new Test1EventLayoutParam(name);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    @Override
    public void onEventBust(Test1EventLayoutParam param) {
        super.onEventBust(param);
        System.out.println("TestSbuscriber1 println name:" + param.name);
    }
}
