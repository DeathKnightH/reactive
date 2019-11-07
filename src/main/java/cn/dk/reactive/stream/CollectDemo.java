package cn.dk.reactive.stream;

/**
 * 终止操作，收集器的样例
 * collect 对最终的流数据进行收集，收集到集合或者其他数据结构中
 * 尽量使用方法引用，这样会减少lambda 匿名函数的创建，节省资源
 */
public class CollectDemo {
    public static void main(String[] args) {
        // Collectors.partitioningBy() 分块，分为两组

        // Collectors.groupingBy() 分组，类似SQL中的 group by

        // Collectors.summarizingInt() 汇总信息，包括
    }
}
