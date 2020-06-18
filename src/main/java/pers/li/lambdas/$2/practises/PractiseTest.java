package pers.li.lambdas.$2.practises;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 系统自带函数式接口测试
 */
public class PractiseTest {

    public static void main(String[] args) {

        String apply = new test().getData.apply("2020-02-01 00:00:00");
        System.err.println(apply);

        Predicate<Integer> bool = s -> {
            if (s>10) {
                return true;
            }else{
                return false;
            }
        };
        System.err.println(bool.test(24));


        Consumer<String> stringConsumer = s -> {
            System.err.println("mmp "+s);
        };
        stringConsumer.accept("nnd");

        Function<String,Object> tt = s -> {
            return s;
        };
        System.err.println( tt.apply("pig"));

        //获取一个值
        Supplier<String> gg = () -> "hahah";
        System.err.println(gg.get());

    }

}
