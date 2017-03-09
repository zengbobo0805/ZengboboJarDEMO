package com.zengbobo.eventBus.demo.event;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by bobo on 2017/1/13.
 */

public class TestSubscriber2 extends BaseSubscriberEvent<TestSubscriber2.Test2EventLayoutParam> {

    public TestSubscriber2(IEventBusSubscriber<TestSubscriber2.Test2EventLayoutParam> eventBusSubscriber) {
        super(eventBusSubscriber);
    }


    public static class Test2EventLayoutParam extends BaseSubscriberEvent.BasePublisherParam {
        private int number;

        public int getNumber() {
            return number;
        }

        public Test2EventLayoutParam(int number) {
            this.number = number;
        }

        public static class Test2EventBuild extends BasePublisherBuilder {
            private int number;


            public Test2EventBuild setNumber(int number) {
                this.number = number;
                return this;
            }

            @Override
            public TestSubscriber2.Test2EventLayoutParam build() {
                return new TestSubscriber2.Test2EventLayoutParam(number);
            }
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    @Override
    public void onEventBust(TestSubscriber2.Test2EventLayoutParam param) {
        super.onEventBust(param);
        System.out.println("TestSubscriber2 println name:" + param.number);
    }
}
