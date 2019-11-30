package pers.li.lambdas.$4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("sss");
        list.add("sss1");
        list.add("sss2");

        list.forEach(System.out::println);
        System.err.println(list.toString());


        int[] x = new int[]{1, 2, 2};
        System.err.println(x.toString());
        List<int[]> ints = Arrays.asList(x);
    }
}
