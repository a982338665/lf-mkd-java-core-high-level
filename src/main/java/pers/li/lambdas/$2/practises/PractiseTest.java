package pers.li.lambdas.$2.practises;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 系统自带函数式接口测试
 */
public class PractiseTest {

    public static void main(String[] args) {
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
