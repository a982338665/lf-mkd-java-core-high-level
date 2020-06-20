package pers.li.streams.$1;

import java.util.Arrays;
import java.util.List;

public class SimpleStreamDemo {

    public static void main(String[] args) {
        String[] planets = new String[]{
                "Mercury", "Venus", "Earth",
                "Mars", "Jupiter", "Saturn",
                "Uranus", "Neptune"};

        //查找星球名字大于等于5个字母
        long count = 0;
        for (String p : planets) {
            if (p.length() > 5) {
                count++;
            }
        }


        //====================================================
        //使用流统计长度大于5的元素个数
        //====================================================
        List<String> pList = Arrays.asList(planets);
        //采用流方法
        long count2 = pList.stream()
                .filter(p -> p.length() > 5).count();
        //采用并行流方法:多个cpu共同操作：数据多的时候
        long count3 = pList.parallelStream()
                .filter(p -> p.length() > 5).count();
        System.err.println(count + "|" + count2 + "|" + count3);
    }

}
