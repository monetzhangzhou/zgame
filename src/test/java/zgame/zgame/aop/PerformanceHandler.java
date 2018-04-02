package zgame.zgame.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangzhou
 * @date 2018-03-17
 * 
 */
public class PerformanceHandler implements InvocationHandler {

	private Object target;

	public PerformanceHandler(Object target) {
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
		Object object = method.invoke(target, args);
		PerformanceMonitor.end();
		return object;
	}

	public static void main(String[] args) {
		// ForumService serviceImpl = new ForumServiceImpl();
		// PerformanceHandler performanceHandler = new PerformanceHandler(serviceImpl);
		// ForumService proxy = (ForumService)
		// Proxy.newProxyInstance(serviceImpl.getClass().getClassLoader(),
		// serviceImpl.getClass().getInterfaces(), performanceHandler);
		// proxy.removeTopic(1);
		CProxy proxy = new CProxy();
		ForumServiceImpl serviceImpl = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
		serviceImpl.removeTopic(2);
	}

}
