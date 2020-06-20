package pers.li.streams.$3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2020/6/18 19:55
 * @Description : 流的转换
 */
public class StreamCHange {

    public static void main(String[] args) {

        //过滤大于2的所有数据
        Stream<Integer> s1 = Stream.of(1, 2, 3, 4, 5, 1, 2);
        Stream<Integer> s2 = s1.filter(n -> n > 2);
        s2.forEach(System.err::println);

        //基本类型去重
        Stream<Integer> s11 = Stream.of(1, 2, 3, 4, 5, 1, 2);
        Stream<Integer> s3 = s11.distinct();
        s3.forEach(System.err::println);


        //对象去重distinct
        //对象判定，先调用hashCode方法，后调用equals方法，如果两个都相等，则视为相同，排除一个,某些业务下需要重新这俩方法
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(new Transaction(1, 100, "batch"));
        transactions.add(new Transaction(1, 100, "batch"));
        transactions.add(new Transaction(1, 101, "batch"));
        transactions.add(new Transaction(3, 80, "grocery"));
        transactions.add(new Transaction(6, 120, "grocery"));
        transactions.stream().distinct().forEach(System.err::println);

        //排序：对流里的包装类进行排序，默认升序
        Stream<Integer> s111 = Stream.of(1, 2, 3, 4, 5, 1, 2);
        s111.sorted().forEach(System.err::println);

        //基本类型排序，加规则,按integer的值
        Stream<Integer> s112 = Stream.of(1, 2, 3, 4, 5, 1, 2);
        s112.sorted(Comparator.comparing(Integer::intValue)).forEach(System.err::println);

        //对象排序:默认调用Transaction中的compareTo方法
        Stream<Transaction> sorted = transactions.stream().sorted();
        sorted.forEach(System.err::println);

        //转换：利用方法引用对流的每个元素进行函数计算
        Stream<Double> stream = Stream.of(-0.1, -0.05, 23.01);
        Stream<Double> doubleStream = stream.map(Math::abs);
        doubleStream.forEach(System.err::println);

        //转换：利用lambda表达式计算
        Stream<Double> stream1 = Stream.of(-0.1, -0.05, 23.01);
        Stream<Double> doubleStream1 = stream1.map(n -> n * n);
        doubleStream1.forEach(System.err::println);

        //转化：
        String[] planets = new String[]{
                "Mercury", "Venus", "Earth",
                "Mars", "Jupiter", "Saturn",
                "Uranus", "Neptune"};
        Stream<List<String>> stream2 = Stream.of(planets).map(word -> letter(word));
        stream2.forEach(System.err::println);

        //转换： 将所有的结果合并
        String[] planets1 = new String[]{
                "Mercury", "Venus", "Earth",
                "Mars", "Jupiter", "Saturn",
                "Uranus", "Neptune"};
        Stream<String> stream3 = Stream.of(planets).flatMap(word -> letter2(word));
        stream3.forEach(System.err::println);

        //抽取limit
        Stream<Integer> s113 = Stream.of(1, 2, 3, 4, 5, 1, 2);
        Stream<Integer> limit = s113.limit(1);
        limit.forEach(System.err::println);

        //跳过skip
        Stream<Integer> s114 = Stream.of(1, 2, 3, 4, 5, 1, 2);
        Stream<Integer> sss = s114.skip(1);
        sss.forEach(System.err::println);

        //连接concat
        Stream<String> concat = Stream.concat(Stream.of("hello"), Stream.of("woeld"));
        concat.forEach(System.err::println);

        //调试peek，流不会动，只是在执行过程中执行某函数，用来调试
        Stream<Double> limit1 = Stream.iterate(1.0, n -> n * 2).peek(n -> System.err.println("number:" + n)).limit(5);
        limit1.forEach(System.err::println);

    }

    public static List<String> letter(String word) {
        List<String> strings = new ArrayList<>(word.length());
        for (int i = 0; i < word.length(); i++) {
            strings.add(word.substring(i,i+1));
        }
        return strings;
    }
    public static Stream<String> letter2(String word) {
        List<String> strings = new ArrayList<>(word.length());
        for (int i = 0; i < word.length(); i++) {
            strings.add(word.substring(i,i+1));
        }
        return strings.stream();
    }

}
