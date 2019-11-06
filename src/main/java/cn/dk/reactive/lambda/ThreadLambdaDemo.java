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
        Runnable target = () -> System.out.println("lambda");
        new Thread(target).start();
    }
}
