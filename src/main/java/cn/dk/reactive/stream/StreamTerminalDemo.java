package cn.dk.reactive.stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream 的终止操作
 */
public class StreamTerminalDemo {
    public static void main(String[] args) {
        String str = "no mater how 123";

        // forEach 终止操作配合并行流
        str.chars().parallel().forEach(i -> System.out.print((char)i));
        System.out.println("");
        // forEachOrder 有序并行
        str.chars().parallel().forEachOrdered(i -> System.out.print((char)i));

        //collect 终止操作，收集到具体容器
        Stream.of(str.split(" ")).collect(Collectors.toList());

        System.out.println("");
        // reduce 终止操作
        Optional<String> letters = Stream.of(str.split(" ")).reduce((s1, s2) -> s1 + "/" + s2);
        System.out.println(letters.orElse(""));

        // findFirst 短路操作，
        OptionalInt first = new Random().ints().limit(50).findFirst();
        System.out.println(first.getAsInt());
    }
}
