package com.viewhigh.example.easydp.dpcreate.singleton;

/**
 * 懒汉模式实现，在需要的实例的时候才创建，节省内存
 */
public class DoubleCheckNull {

    private static volatile DoubleCheckNull sInstance;

    /**
     * 单例模式实现
     * <p>
     * 双重判断使用在多线程
     *
     * @return 实例
     */
    public static DoubleCheckNull getInstance() {

        //为什么要双重判断？
        // 不双重会出现一种情况，多线程同时运行到到if语句内，争抢锁，有一个获得后，就开始创建一个对象实例。
        // 另一个对象在获取锁以后，也会去创建一个对象实例
        if (sInstance == null) {
            synchronized (DoubleCheckNull.class) {
                if (sInstance == null) {
                    sInstance = new DoubleCheckNull();
                }
            }
        }

        return sInstance;
    }

    private DoubleCheckNull() {
        System.out.println(getClass().getSimpleName() + " 创建实例");
    }

    public void say() {

    }
}
