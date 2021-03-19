package com.viewhigh.example.easydp.dpcreate.singleton;

/**
 * 懒汉模式实现，在需要的实例的时候才创建，节省内存
 */
public class LanHanSingletonSyn {

    private static LanHanSingletonSyn sInstance;

    /**
     * 单例模式实现
     *
     * @return 实例
     */
    public static synchronized LanHanSingletonSyn getInstance() {

        if (sInstance == null) {
            sInstance = new LanHanSingletonSyn();
        }

        return sInstance;
    }


    private LanHanSingletonSyn() {
    }

    public void say() {

    }

}
