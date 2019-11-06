package cn.dk.reactive.lambda;

import java.math.BigDecimal;
import java.util.function.*;

/**
 * 常用的内置function接口
 */
public class BuildInFunctionDemo {
    public static void main(String[] args) {
        // predicate
        Predicate<Integer> predicate = integer -> integer > 0;
        System.out.println(predicate.test(0));

        // consumer
        Consumer<String> stringConsumer = s -> System.out.println("消费：" + s);
        stringConsumer.accept("demo String");

        // supplier
        Supplier<BigDecimal> bigDecimalSupplier = () -> {
            BigDecimal bigDecimal = new BigDecimal("123456");
            System.out.println("提供：" + bigDecimal);
            return bigDecimal;
        };
        System.out.println(bigDecimalSupplier.get());

        // unary operator 一元函数
        UnaryOperator<Integer> operator = integer -> Math.max((integer + 1) * 2, 10 );
        System.out.println(operator.apply(5));
        System.out.println(operator.apply(50));

        // BiFunction 有两个输入的函数
        BiFunction<Integer, BigDecimal, String> biFunction = (integer, bigDecimal) -> {
            if(bigDecimal != null){
                bigDecimal = bigDecimal.add(BigDecimal.valueOf(integer));
                return bigDecimal.toString();
            }
            return null;
        };
        System.out.println("100 + 99.99 = " + biFunction.apply(100, new BigDecimal("99.99")));

        // BinaryOperator 二元函数
        BinaryOperator<Integer> binaryOperator = (x, y) -> {
            return x * (x + 1) - y * 52;
        };
        System.out.println("x = 4, y = 10, then result = " + binaryOperator.apply(4, 10));
    }
}
