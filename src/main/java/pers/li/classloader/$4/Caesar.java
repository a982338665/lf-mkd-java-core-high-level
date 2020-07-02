package pers.li.classloader.$4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2020/7/1 13:54
 * @Description :
 */
public class Caesar {
    public static void main(String[] args) throws IOException {
        int key = 3;
        // 将Input类加密，输出到Output中
        String input = "D:\\go-20191030\\CoreHighLevel\\target\\classes\\pers\\li\\classloader\\$4\\Hello.class";
        String output = "D:\\go-20191030\\CoreHighLevel\\target\\classes\\pers\\li\\classloader\\$4\\Hello.caesar";

        try (FileInputStream in = new FileInputStream(input); FileOutputStream out = new FileOutputStream(output)) {
            int ch;
            while ((ch = in.read()) != -1) {
                // 每个字节码+key
                byte c = (byte) (ch + key);
                out.write(c);
            }
        }
        System.out.println("Caesar done");
    }
}
