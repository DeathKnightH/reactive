package cn.dk.reactive.lambda;

public class ThreadLambdaDemo {
    public static void main(String[] args) {
        normalThread();
        lambdaThread();
    }

    public static void normalThread(){
        new Thread(new Runnable() {
            public void run() {
                System.out.println("normal");
            }
        }).start();
    }

    public static void lambdaThread(){
        // 方法体只有一行时可以省略{}和return关键字
        Runnable target = () -> System.out.println("lambda");
        new Thread(target).start();
    }
}
