package cn.dk.reactive.lambda;

// 函数接口，FunctionalInterface可用作约束函数接口（方法数量不符合标准时编译报错）
@FunctionalInterface
interface  InterfaceDemo{
    // 只有一个方法需要实现
    int doubleNum(int i);

    // default方法不受数量限制，因为default方法有自己的实现
    // 如果在多重接口的实现中 default 方法重复，需要指定使用哪个接口的 default 方法
    default int addNum(int x, int y){
        return x + y;
    }
}
public class LambdaDefineDemo {
    public static void main(String[] args) {
        InterfaceDemo interfaceDemo1 = (i) -> i * 2;
        // 最常用的写法
        InterfaceDemo interfaceDemo2 = i -> i * 2;
        InterfaceDemo interfaceDemo3 = (int i) -> i * 2;
        InterfaceDemo interfaceDemo4 = (int i) -> {
            System.out.println("最复杂的写法");
            return i * 2;
        };
    }
}
