package pers.li.streams.$4;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author : Mr huangye
 * @URL : CSDN 皇夜_
 * @createTime : 2020/6/20 10:28
 * @Description :
 */
public class OptionalTest {

    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        System.err.println(integerStream.count());

        Stream<Integer> integerStream2 = Stream.of(1, 2, 3, 4, 5);
        System.err.println(integerStream2.filter(n->n>2).count());

        //取最大值，若没有则会报错 No value Present
        Stream<Integer> integerStream3 = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> max = integerStream3.max((n1, n2) -> n1 - n2);
        System.err.println(max.get());

        //包装盒子
        Optional<String> abd = Optional.of(new String("abd"));
        String s = abd.get();
        System.err.println(s);

        //空盒子
        Optional<String> empty = Optional.empty();
        String def = empty.orElse("def");
        System.err.println(def);

        //安全创建:x不为null则 x1 = x，若为null 则 x1 = Optional.empty()
        String x = null;
        Optional<String> x1 = Optional.ofNullable(x);

        //


    }
}
