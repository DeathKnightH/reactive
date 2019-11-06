package cn.dk.reactive.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreateDemo {
    public static void main(String[] args) {
        //集合
        List<String> list = new ArrayList<>();
        list.stream();

        //数组
        Arrays.stream(new int[]{1,2,3});

        //数字
        IntStream.of(3,4,5);

        //random，由于是无限的，需要有短路操作终止创建，如limit()
        new Random().ints().limit(1000);

        //自定义
        Stream.generate(() ->{
            return 200*100 + "demo";
        });
    }
}
