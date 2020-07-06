package pers.li.jvm.$3;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆：Heap
 * -共享内存大户，存储所有对象和数组
 * - -Xms初始值堆，-Xmx最大值堆
 *
 * 在运行前，VM arguments中添加参数：
 * 		-Xmx20M
 */
public class HeapOOM {
	public static void main(String[] args) {
		
		List<HeapObject> list = new ArrayList<>();

		while (true) {
			list.add(new HeapObject());
			System.out.println(list.size());
		}
//		System.out.println(Runtime.getRuntime().maxMemory()/1024/1024 + "M");
	}
}

class HeapObject {
}
