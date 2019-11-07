package cn.dk.reactive.stream;

import java.util.Random;
import java.util.stream.Stream;

/**
 * stream 中间操作
 * 所有的 Intermediate 操作都会返回一个 Stream 让操作继续
 */
public class StreamIntermediateDemo {
    public static void main(String[] args) {
        String str = "where to show class";

        // filter 中间操作，参数是一个 Predicate，过滤符合条件的元素
        // map 中间操作，参数是一个 Function，获取每个元素的 length()
        // 最终使用 forEach 终止操作把每个长度打印出来
        Stream.of(str.split(" ")).filter(s -> s.length() > 4).map(s -> s.length()).forEach(System.out::println);

        // flatMap 中间操作，A -> B(B属性是一个集合)，使之后的后续操作在所有 B 集合上进行
        // chars() 返回的是一个 IntStream，并不是Stream的子类，所以需要装箱操作 boxed()
        Stream.of(str.split(" ")).flatMap(s -> s.chars().boxed()).forEach(System.out::println);

        // peek 中间操作，一般用于debug流处理过程
        Stream.of(str.split(" ")).filter(s -> s.length() > 4).peek(System.out::println
        ).map(s -> s.length()).forEach(System.out::println);

        // limit 中间操作，一般用于限制无限流
        new Random().ints().filter(i -> i>1000 && i<9999).limit(10).forEach(System.out::println);
    }
}
