package pers.li.reflection.$4.api;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class SimpleJavaCompiler {

	public static void main(String[] args) throws UnsupportedEncodingException {

		successCompile();
		failCompile();
	}

	public static void successCompile() {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		// 第一个参数：输入流，null表示默认使用system.in
		// 第二个参数：输出流，null表示默认使用system.out
		// 第三个参数：错误流，null表示默认使用system.err
		// 第四个参数：String... 需要编译的文件名
		// 返回值：0表示成功，其他错误
		int result = compiler.run(null, null, null, "F:/temp/Hello1.java", "F:/temp/Hello2.java");
		System.out.println(0 == result ? "Success" : "Fail");
	}

	public static void failCompile() throws UnsupportedEncodingException {
		ByteArrayOutputStream err = new ByteArrayOutputStream();
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		// 第一个参数：输入流，null表示默认使用system.in
		// 第二个参数：输出流，null表示默认使用system.out
		// 第三个参数：错误流，null表示默认使用system.err
		// 第四个参数：String... 需要编译的文件名
		// 返回值：0表示成功，其他错误
		int result = compiler.run(null, null, err, "F:/temp/Hello3.java");
		if (0 == result) {
			System.out.println("Success");
		} else {
			System.out.println("Fail");
			System.out.println(new String(err.toByteArray(), Charset.defaultCharset().toString()));
		}
	}
}
