package cn.dk.reactive.lambda;

import java.util.function.Function;

/**
 * 级联表达式与curry化
 * curry化：把多个参数的函数转换为只有一个参数的函数
 * 高阶函数、标准函数
 */
public class CurryDemo {
    public static void main(String[] args) {
        // 使用级联实现 x + y + z
        Function<Integer, Function<Integer, Function<Integer,Integer>>> function = x -> y -> z -> x + y + z;
        System.out.println(function.apply(1).apply(2).apply(3));
    }
}
