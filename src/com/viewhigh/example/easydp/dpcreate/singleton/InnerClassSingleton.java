package com.viewhigh.example.easydp.dpcreate.singleton;

/**
 * 静态内部类模式
 */
public class InnerClassSingleton {


    private static final class SingletonHolder {
        private static final InnerClassSingleton INNER_CLASS_INSTANCE = new InnerClassSingleton();
    }

    /**
     * 单例模式实现
     *
     * @return 实例
     */
    public static InnerClassSingleton getInstance() {
        return SingletonHolder.INNER_CLASS_INSTANCE;
    }


    private InnerClassSingleton() {
    }
}
