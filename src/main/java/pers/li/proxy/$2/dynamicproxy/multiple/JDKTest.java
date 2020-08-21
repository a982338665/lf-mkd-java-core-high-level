package pers.li.proxy.$2.dynamicproxy.multiple;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2020/8/21 19:21
 * @Description : 打印生成的代理文件的 第二种方式，只适用于jdk代理
 */
public class JDKTest {

    public static void testProxyGenetate() {
//        byte[] newProxyClass = ProxyGenerator.generateProxyClass("$Proxy0", PersonServiceImpl.class.getInterfaces());
//        System.out.println(newProxyClass);
//        FileOutputStream fileOutputStream = null;
//        try {
//            fileOutputStream = new FileOutputStream(new File("/Users/shenjin/Desktop/$Proxy0.class"));
//            try {
//                fileOutputStream.write(newProxyClass);
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (fileOutputStream != null) {
//                    try {
//                        fileOutputStream.flush();
//                        fileOutputStream.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

}
