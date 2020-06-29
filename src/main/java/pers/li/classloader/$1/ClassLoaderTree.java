package pers.li.classloader.$1;

/**
 * java类加载的层次关系
 * jdk.internal.loader.ClassLoaders$AppClassLoader
 * jdk.internal.loader.ClassLoaders$PlatformClassLoader [jdk11更名为Platform，以前为ExtClassLoader]
 * BootstrapLoader is implemented by C
 */
public class ClassLoaderTree {

	public static void main(String[] args) {
		ClassLoader c = ClassLoaderTree.class.getClassLoader();
		while(null != c)
		{
			System.out.println(c.getClass().getName());
			c = c.getParent();
		}
		if(null == c){
			System.out.println("BootstrapLoader is implemented by C ");
		}
	}
}


