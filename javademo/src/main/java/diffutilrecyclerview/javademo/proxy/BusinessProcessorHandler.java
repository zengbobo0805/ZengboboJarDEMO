package diffutilrecyclerview.javademo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by bobo on 2017/3/10.
 */

public class BusinessProcessorHandler implements InvocationHandler {
    private Object target = null;

    BusinessProcessorHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("BusinessProcessorHandler target:"+target);
        System.out.println("You can do something here before process your business");
        Object result = method.invoke(target, args);
        System.out.println("You can do something here after process your business");
        System.out.println("BusinessProcessorHandler result:"+result);
        return result;
//        return null;
    }

}
