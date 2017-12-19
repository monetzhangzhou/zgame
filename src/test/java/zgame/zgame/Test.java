package zgame.zgame;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Test {

	public static void main(String[] args) {
		ConcurrentNavigableMap<String, String> concurrentSkipListMap = new ConcurrentSkipListMap<String, String>();
		concurrentSkipListMap.put("3", "Wednesday");
		concurrentSkipListMap.put("2", "Tuesday");
		concurrentSkipListMap.put("1", "Monday");
		concurrentSkipListMap.put("5", "Friday");
		concurrentSkipListMap.put("4", "Thursday");
		for (Iterator<Entry<String, String>> iterator = concurrentSkipListMap.entrySet().iterator(); iterator.hasNext();) {
			Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey());
		}
	}
}
