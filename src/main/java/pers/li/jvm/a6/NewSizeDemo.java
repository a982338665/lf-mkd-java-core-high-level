package pers.li.jvm.a6;

/**
 * 来自于《实战Java虚拟机》
 *
 *  ·-Xmn 新生代大小：包含eden,from,to
 *             ·-XX:SurvivorRatio设置eden区/from(或者to)的比例
 *             ·-XX:NewRatio 设置老年代/新生代比例
 *             ·-XX:+PrintGC/-XX:+PrintGCDetails打印GC的过程信息：可以看出垃圾收集器在垃圾收集过程中内存变化情况
 *
 * -Xmx20m -Xms20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
 * 初始值，最大值为20M 新生代1M
 * eden + from + to = 1024Kb
 * eden/from = 2
 * from = to
 * 解方程：得到 eden = 512k ，from = to = 215K
 * 新生代1M，eden/s0=2, eden 512KB, s0=s1=256KB 
 * 新生代无法容纳1M，所以直接放老年代
 * 因为eden=512k 无法容纳1M ，所以会放在老年代，eden+s0= 768K 小于 1M
 * 所以程序发生一次GC，之后所有的都会直接放在老年代，所以其他小对象占用放在新生代，数组大对象全部放在老年代（10M）
 * 
 * -Xmx20m -Xms20m -Xmn7m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
 * 计算同上
 * 新生代7M，eden/s0=2, eden=3.5M, s0=s1=1.75M
 * eden+s0 = 5.25M ，大约可以在新生代放3个数组，因此会发生多次GC
 * 所以可以容纳几个数组，但是无法容纳所有，因此发生GC，但是实际上最后占用的内存大约为3M，因为存在于新生代中的数组用完就会被GC掉，然后继续放继续GC，所以老生代里并没有几个数组
 *
 * -Xmx20m -Xms20m -Xmn15m -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:+UseSerialGC
 * 新生代15M，eden/s0=8, eden=12M, s0=s1=1.5M
 * 方程:
 *  eden + from + to = 15
 *  from = to
 *  eden / from = 8
 *  解方程：
 *  eden + 2to = 15
 *  eden = 8to
 *  10to = 15
 *  to = from = 1.5
 *  eden = 12
 *  因为eden+s=13.5M > 10M,所以10M均可以在新生代存在，足够容纳，那么程序就不会启动GC
 *  如果eden够会全部放在eden中
 *
 * -Xmx20m -Xms20m -XX:NewRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
 * 新生代是6.6M，老年代13.3M
 * 也会发生多次GC
 * @author Tom
 *
 */
public class NewSizeDemo {

	public static void main(String[] args) {
		
		byte[] b = null;
		for(int i=0;i<10;i++)
		{
			b = new byte[1*1024*1024];
		}		
	}
}
