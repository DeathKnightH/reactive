package cn.dk.reactive.lambda;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.function.Function;

interface Format{
    String format(BigDecimal money);
}

/**
 * 比较使用jdk8自带的函数接口和
 * 使用自定义接口
 */
public class FunctionInterfaceDemo {
    /**
     * jdk8自带的函数接口可以省去自定义接口的过程，同时本身还支持链式调用
     * @param args
     */
    public static void main(String[] args) {
        BigDecimal money = new BigDecimal("99999999.99");
        moneyFormatCustom(value -> new DecimalFormat("#,###").format(value), money);
        Function<BigDecimal, String> bigDecimalStringFunction = value -> new DecimalFormat("#,###").format(value);
        // 函数接口能使用andThen 默认方法实现简洁的链式接口调用
        moneyFormatFuncion(bigDecimalStringFunction.andThen(s -> "链式接口：" + s), money);
    }

    /**
     * 正常的做法，将接口的实例作为参数传入方法，在方法体中调用
     * @param format
     * @param money
     * @return
     */
    private static void moneyFormatCustom(Format format, BigDecimal money){
        System.out.println("使用自定义接口：" + format.format(money));
    }

    /**
     * 使用函数接口，不用预先编写自定义的接口，只需指定入参和返回值类型
     * @param function
     * @param money
     * @return
     */
    private static void moneyFormatFuncion(Function<BigDecimal,String> function, BigDecimal money){
        System.out.println("使用函数接口：" + function.apply(money));
    }
}
