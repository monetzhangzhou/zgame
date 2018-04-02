package zgame.zgame.aop;

/**
 * @author zhangzhou
 * @date 2018-03-17
 * 
 */
public class MethodPerformace {
	private long begin;
	private long end;
	private String serviceMethod;

	public MethodPerformace(String serviceMethod) {
		this.serviceMethod = serviceMethod;
		this.begin = System.currentTimeMillis();
	}

	public void printPerformance() {
		end = System.currentTimeMillis();
		System.err.println(serviceMethod + " serviceMethod time " + (this.end - this.begin));
	}
}
