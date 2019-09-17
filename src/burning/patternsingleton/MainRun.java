package burning.patternsingleton;

import java.lang.reflect.Constructor;

public class MainRun {


    public static void main(String[] args) {

//        runSingletonDemo1();
//        runSingletonDemo2();
//        runSingletonDemo3();
//        runSingletonDemo4();
        modifiedByAttack();
    }


    /**
     * 运行单例实例1
     */
    private static void runSingletonDemo1() {
        System.out.println("__________________runSingletonDemo1_________________________");
        //运行创建实例
        System.out.println("SingletonDemo1 单例模式创建实例");
        System.out.println("加载类：单独声明一个类的引用，不会走类的静态初始化。");
        SingletonDemo1 singletonDemo1;
        System.out.println("单线程访问");
        for (int i = 0; i < 10; i++) {
            SingletonDemo1 instance = SingletonDemo1.getInstance();
            System.out.println(instance);
        }

        //多线程访问
/*        System.out.println("多线程访问");
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                SingletonDemo1 instance = SingletonDemo1.getInstance();
                System.out.println(Thread.currentThread().getName() + "   " + instance);
            });

            thread.start();
        }*/


/*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/

        //开始反射获取
        System.out.println("反射获取实例");
        try {
//            Class<?> aClass = Class.forName("burning.patternsingleton.SingletonDemo1");
//            Constructor<?> constructor = aClass.getDeclaredConstructor();
            Constructor<SingletonDemo1> constructor = SingletonDemo1.class.getDeclaredConstructor();
            constructor.setAccessible(true);

            SingletonDemo1 instance = constructor.newInstance();

            System.out.println(Thread.currentThread().getName() + "   " + instance);
            System.out.println(instance == SingletonDemo1.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 运行单例实例2
     */
    private static void runSingletonDemo2() {
        System.out.println("__________________runSingletonDemo2_________________________");
/*        System.out.println("开始循环创建");
        for (int i = 0; i < 10; i++) {
            SingletonDemo2 instance = SingletonDemo2.getInstance();
            System.out.println(instance);
        }*/

        System.out.println("多线程访问");
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                SingletonDemo2 instance = SingletonDemo2.getInstance();
                System.out.println(Thread.currentThread().getName() + "   " + instance);
            });

            thread.start();
        }
    }

    private static void runSingletonDemo3() {
        System.out.println("__________________runSingletonDemo3_________________________");
        for (int i = 0; i < 10; i++) {
            SingletonDemo3 instance = SingletonDemo3.getInstance();
            System.out.println(instance);
        }


        System.out.println("多线程访问");
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() -> {
                SingletonDemo3 instance = SingletonDemo3.getInstance();
                System.out.println(Thread.currentThread().getName() + "   " + instance);
            });

            thread.start();
        }
    }

    private static void runSingletonDemo4() {
        System.out.println("__________________runSingletonDemo4_________________________");

        for (int i = 0; i < 10; i++) {
            SingletonDemo4 instance = SingletonDemo4.INSTANCE;
            System.out.println(instance + "   " + instance.getCurrentInstanceNum());
        }


        System.out.println("多线程访问");
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                SingletonDemo4 instance = SingletonDemo4.INSTANCE;
                System.out.println(Thread.currentThread().getName() + "    " + instance + "   " + instance.getCurrentInstanceNum());
            });

            thread.start();
        }
    }


    private static void runSingletonDemo5() {

    }


    public static void modifiedByAttack() {
        try {
            Class<SingletonDemo1> classType = SingletonDemo1.class;
            Constructor<SingletonDemo1> constructor = classType.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            SingletonDemo1 singleton = (SingletonDemo1) constructor.newInstance();

            SingletonDemo1 singleton2 = SingletonDemo1.getInstance();

            System.out.println(singleton == singleton2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
