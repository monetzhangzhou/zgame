package zgame.zgame.aop;

/**
 * @author zhangzhou
 * @date 2018-03-17
 * 
 */
public class PerformanceMonitor {
	private static ThreadLocal<MethodPerformace> performanceRecord = new ThreadLocal<MethodPerformace>();

	public static void begin(String method) {
		System.err.println("begin monitor ...");
		performanceRecord.set(new MethodPerformace(method));
	}

	public static void end() {
		System.err.println("end monitor ...");
		performanceRecord.get().printPerformance();
	}
}
