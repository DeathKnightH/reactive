package cn.dk.reactive.stream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * 并行流，让流处理在设定好的线程池中并行进行
 */
public class ParallelDemo {
    public static void main(String[] args) {
        // parallel 并行流
        // 默认使用 ForkJoinPool.commonPool 线程池，大小默认为cpu数量
        //IntStream.range(1,100).parallel().peek(ParallelDemo::debugParallel).count();

        // 使用多个 parallel / sequential 时以最后一个为准
        // 最后一个为 sequential ，串行化
        //IntStream.range(1,100).parallel().peek(ParallelDemo::debugParallel).sequential().peek
        // (ParallelDemo::debugSequential).count();

        // 改变默认线程池大小
        //System.setProperty("java.util.concurrent.ForkJoinPool.commonPool.parallelism","20");

        // 不使用默认，因为默认线程池是所有并行任务共用的
        // 自定义线程池
        ForkJoinPool customPool = new ForkJoinPool(20);
    }

    private static void debugParallel(int i){
        System.out.println(Thread.currentThread().getName() + "：parallel" + i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void debugSequential(int i){
        System.out.println(Thread.currentThread().getName() + "：sequential" + i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
