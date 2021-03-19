package com.viewhigh.example.easydp.dpcreate.singleton;

import java.lang.reflect.Constructor;

public class MainRun {


    public static void main(String[] args) {

        runEHanSingleton();

        runLanHanSingleton();

//        runSingletonDemo3();
//        runSingletonDemo4();
//        modifiedByAttack();
    }


    /**
     * 运行恶汉方式实现单例实例
     */
    private static void runEHanSingleton() {
        System.out.println("__________________runEHanSingleton_________________________");
        //运行创建实例
        System.out.println("EHanSingleton 单例模式创建实例");
        System.out.println("加载类：单独声明一个类的引用，不会走类的静态初始化。");
        EHanSingleton eHanSingleton;

        System.out.println("\n-----单线程访问 调用10次-------\n");
        for (int i = 0; i < 10; i++) {
            EHanSingleton instance = EHanSingleton.getInstance();
            instance.say();
        }

        if (EHanSingleton.sCurrentInstanceNum == 1) {
            System.out.println("\n=======多次调用只有一个实例");
        } else {
            System.out.println("\n=======多次调用，有多个实例");
        }

        //多线程访问
        System.out.println("\n---------多线程访问---------\n");
        System.out.println("\n---------启动1000个线程获取实例---------\n");
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() -> {
                EHanSingleton instance = EHanSingleton.getInstance();
//                System.out.println(Thread.currentThread().getName() + "   " + instance);
            });

            thread.start();
        }


        try {
            Thread.sleep(1000);
            System.out.println("线程休眠一下1s，等待多线程执行");
            System.out.println("当前系统创建过实例数量是：" + EHanSingleton.sCurrentInstanceNum);
            if (EHanSingleton.sCurrentInstanceNum == 1) {
                System.out.println("\n=======线程安全");
            } else {
                System.out.println("\n=======线程不安全");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //开始反射获取
        System.out.println("\n---------反射获取实例---------\n");
        try {
            Constructor<EHanSingleton> constructor = EHanSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            EHanSingleton instance = constructor.newInstance();
            System.out.println(Thread.currentThread().getName() + "   " + instance);
            System.out.println(instance == EHanSingleton.getInstance());
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("=======成功防止通过反射获取实例");
        }

    }


    private static void runLanHanSingleton() {
        System.out.println("__________________runLanHanSingleton_________________________");
        //运行创建实例
        System.out.println("LanHanSingleton 单例模式创建实例");
        System.out.println("\n-----单线程访问-------\n");
        for (int i = 0; i < 10; i++) {
            LanHanSingleton instance = LanHanSingleton.getInstance();
            instance.say();
        }

        if (LanHanSingleton.sCurrentInstanceNum == 1) {
            System.out.println("\n=======多次调用只有一个实例");
        } else {
            System.out.println("\n=======多次调用，有多个实例");
        }

        //多线程访问
        System.out.println("\n---------多线程访问---------\n");
        System.out.println("\n---------启动1000个线程获取实例---------\n");
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() -> {
                LanHanSingleton instance = LanHanSingleton.getInstance();
            });

            thread.start();
        }

        try {
            Thread.sleep(1000);
            System.out.println("线程休眠一下1s，等待多线程执行");
            System.out.println("当前系统创建过实例数量是：" + LanHanSingleton.sCurrentInstanceNum);
            if (EHanSingleton.sCurrentInstanceNum == 1) {
                System.out.println("\n=======线程安全");
            } else {
                System.out.println("\n=======线程不安全");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //开始反射获取
        System.out.println("\n---------反射获取实例---------\n");
        try {
            Constructor<LanHanSingleton> constructor = LanHanSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            LanHanSingleton instance = constructor.newInstance();
            System.out.println(Thread.currentThread().getName() + "   " + instance);
            System.out.println(instance == LanHanSingleton.getInstance());
            System.out.println("=========代码中没有做防止反射的设置，成功通过反射获取实例");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("=========成功防止通过反射获取实例");
        }

    }


    public static void modifiedByAttack() {
        try {
            Class<EHanSingleton> classType = EHanSingleton.class;
            Constructor<EHanSingleton> constructor = classType.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            EHanSingleton singleton = constructor.newInstance();

            EHanSingleton singleton2 = EHanSingleton.getInstance();

            System.out.println(singleton == singleton2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
