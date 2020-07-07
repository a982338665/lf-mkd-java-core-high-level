package pers.li.jvm.a6;

/**
 * 来自于《实战Java虚拟机》
 * -Xms5M -Xmx20M -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC
 * @author Tom
 *
 */
public class HeapAlloc {

	/**
	 * -XX:InitialHeapSize=5242880 -XX:MaxHeapSize=20971520 -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:ReservedCodeCacheSize=251658240 	【一些参数默认值：初始5M，最大20M】
	 * -XX:+SegmentedCodeCache -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseSerialGC 	【一些参数默认值】
	 * [0.019s][info   ][gc] Using Serial
	 * [0.019s][info   ][gc,heap,coops] Heap address: 0x00000000fec00000, size: 20 MB, Compressed Oops mode: 32-bit
	 * [0.227s][info   ][gc,start     ] GC(0) Pause Young (Allocation Failure)
	 * [0.229s][info   ][gc,heap      ] GC(0) DefNew: 1651K->191K(1856K)
	 * [0.229s][info   ][gc,heap      ] GC(0) Tenured: 0K->719K(4096K)
	 * [0.229s][info   ][gc,metaspace ] GC(0) Metaspace: 5619K->5619K(1056768K)
	 * [0.230s][info   ][gc           ] GC(0) Pause Young (Allocation Failure) 1M->0M(5M) 2.920ms
	 * [0.230s][info   ][gc,cpu       ] GC(0) User=0.00s Sys=0.00s Real=0.00s
	 * maxMemory=19.375 MB																		【占用的最大内存】
	 * freeMemory=3.978515625 MB																【空闲内存】
	 * totalMemory=5.8125 MB																	【总共内存】
	 * [0.283s][info   ][gc,start     ] GC(1) Pause Young (Allocation Failure)					【申请内存失败-触发GC回收】
	 * [0.285s][info   ][gc,heap      ] GC(1) DefNew: 1158K->192K(1856K)						【eden放不下1M内存，GC回收前剩下1158KB，回收后剩下192K  其中1856KB为整个新生代的大小】
	 * [0.285s][info   ][gc,heap      ] GC(1) Tenured: 719K->1198K(4096K)						【老生代：回收前剩下719K，回收后剩下1198KB，总大小 4M】
	 * [0.285s][info   ][gc,metaspace ] GC(1) Metaspace: 6876K->6876K(1056768K)					【永久代：未进行垃圾回收，剩下6876KB，总大小1056768KB】
	 * [0.285s][info   ][gc           ] GC(1) Pause Young (Allocation Failure) 1M->1M(5M) 1.667ms
	 * [0.285s][info   ][gc,cpu       ] GC(1) User=0.00s Sys=0.00s Real=0.00s
	 * 分配1MB空间
	 * [0.258s][info   ][gc,heap,exit ] Heap
	 * [0.258s][info   ][gc,heap,exit ]  def new generation   total 1856K, used 1264K [0x00000000fec00000, 0x00000000fee00000, 0x00000000ff2a0000)	【新生代】
	 * [0.258s][info   ][gc,heap,exit ]   eden space 1664K,  64% used [0x00000000fec00000, 0x00000000fed0c050, 0x00000000feda0000)
	 * [0.258s][info   ][gc,heap,exit ]   from space 192K,  99% used [0x00000000feda0000, 0x00000000fedcfff8, 0x00000000fedd0000)
	 * [0.258s][info   ][gc,heap,exit ]   to   space 192K,   0% used [0x00000000fedd0000, 0x00000000fedd0000, 0x00000000fee00000)
	 * [0.258s][info   ][gc,heap,exit ]  tenured generation   total 4096K, used 1198K [0x00000000ff2a0000, 0x00000000ff6a0000, 0x0000000100000000)	【老生代】
	 * [0.258s][info   ][gc,heap,exit ]    the space 4096K,  29% used [0x00000000ff2a0000, 0x00000000ff3cb9e8, 0x00000000ff3cba00, 0x00000000ff6a0000)
	 * [0.258s][info   ][gc,heap,exit ]  Metaspace       used 6895K, capacity 6995K, committed 7168K, reserved 1056768K								【永久代，元数据区，存储类结构信息等，使用了6M】
	 * [0.258s][info   ][gc,heap,exit ]   class space    used 613K, capacity 648K, committed 768K, reserved 1048576K
	 * @param args
	 */
	public static void main(String[] args) {
		
		printMemoryInfo();
		byte[] b = new byte[1*1024*1024];
		System.out.println("分配1MB空间");
		
//		printMemoryInfo();
//		b = new byte[4*1024*1024];
//		System.out.println("分配4MB空间");
//
//		printMemoryInfo();
//		b = new byte[16*1024*1024];
//		System.out.println("分配4MB空间");
	}
	
	public static void printMemoryInfo()
	{
		//当前线程能够使用的最大堆内存：maxMemory指理论上能使用的最大堆内存
		System.out.print("maxMemory=");
		System.out.println(Runtime.getRuntime().maxMemory()/1024.0/1024.0 + " MB");
		//当前堆内存的空闲内存有多少
		System.out.print("freeMemory=");
		System.out.println(Runtime.getRuntime().freeMemory()/1024.0/1024.0 + " MB");
		//当前堆占用的内存有多少
		System.out.print("totalMemory=");
		System.out.println(Runtime.getRuntime().totalMemory()/1024.0/1024.0 + " MB");
	}

}
