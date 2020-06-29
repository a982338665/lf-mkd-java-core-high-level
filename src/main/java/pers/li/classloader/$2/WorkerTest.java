package pers.li.classloader.$2;

/**
 * 使用BootstrapClassLoader加载此类，未添加启动参数时，则使用AppClassLoader加载
 * 	在启动参数中 添加：-Xbootclasspath/a:E:/java/source/PMOOC11-02/bin ，后面的路径为.class的路径
 */
public class WorkerTest {

	public static void main(String[] args) {
		new Worker().say();
	}
}
