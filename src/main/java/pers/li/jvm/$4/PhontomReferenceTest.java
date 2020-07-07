package pers.li.jvm.$4;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 4.虚引用：
 * 虚对象本质上不是为程序员服务的，因为他随时会变成null，他只是用来跟踪对象的回收过程
 */
public class PhontomReferenceTest {

	public static void main(String[] args) {
		//reference队列类
		ReferenceQueue<StringBuilder> queue = new ReferenceQueue<StringBuilder>();
		//检查检测队列，不为空，移除
		Thread t = new CheckReferenceQueue(queue);
		t.setDaemon(true);
		t.start();

		//创建字符串
		StringBuilder s1 = new StringBuilder();
		for(int i=0;i<100000;i++)
		{
			s1.append("0000000000");
		}		

		//定义虚引用，s2 和 s1 指向同一个堆内存，同时s2 和 队列绑定在一起
		PhantomReference<StringBuilder> s2 = new PhantomReference<StringBuilder>(s1,queue);
		//s1 赋值为null
		s1 = null;
		//虚引用随时可能被回收,甚至没有被GC
		System.out.println(s2.get());
		
		System.gc();
		
		System.out.println(s2.get()); //null
		
		byte[] b = new byte[(int)(1024*1024*3.5)];	
		
	}

}

class CheckReferenceQueue extends Thread
{
	ReferenceQueue<StringBuilder> queue = null;
	
	public CheckReferenceQueue(ReferenceQueue<StringBuilder> queue)
	{
		this.queue = queue;
	}
	
	public void run()
	{
		while(true)
		{
			if(queue != null)
			{
				PhantomReference<StringBuilder> obj = null;
				try
				{
					obj = (PhantomReference<StringBuilder>) queue.remove();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				if(obj != null)
				{
					System.out.println("obj is deleted");
				}
			}
		}
	}
}
