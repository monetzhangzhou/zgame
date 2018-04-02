package zgame.zgame.aop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author zhangzhou
 * @date 2018-03-17
 * 
 */
public class CProxy implements MethodInterceptor {
	private Enhancer enhancer = new Enhancer();

	public Object getProxy(Class class1) {
		enhancer.setSuperclass(class1);
		enhancer.setCallback(this);
		return enhancer.create();
	}

	public Object intercept(Object arg0, Method method, Object[] args, MethodProxy arg3) throws Throwable {
		PerformanceMonitor.begin(method.getName());
		Object result = arg3.invoke(arg0, args);
		PerformanceMonitor.end();
		return result;
	}

}
