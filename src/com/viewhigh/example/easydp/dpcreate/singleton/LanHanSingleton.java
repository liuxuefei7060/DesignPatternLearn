package com.viewhigh.example.easydp.dpcreate.singleton;

import java.util.HashSet;

/**
 * 懒汉创建单例
 */
public class LanHanSingleton {

    public static int sCurrentInstanceNum = 0;
    private static LanHanSingleton sInstance;

    private LanHanSingleton() {
        System.out.println(getClass().getSimpleName() + " 创建实例");
        sCurrentInstanceNum++;
    }

    public static LanHanSingleton getInstance() {
        if (sInstance == null) {
            sInstance = new LanHanSingleton();
        }
        return sInstance;
    }

    public void say() {
        System.out.print("我是一个 懒汉 " + sCurrentInstanceNum + "   ");
    }

    @Override
    public String toString() {
        return super.toString() + "   mCurrentInstanceNum : " + sCurrentInstanceNum;
    }



    public static void main(String[] args) {

        //验证一下
        HashSet<LanHanSingleton>  set = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            set.add(LanHanSingleton.getInstance());
        }

        System.out.println("调用了1000次 LanHanSingle.getInstance() 把返回的对象放入Set中");
        System.out.println("Set当前拥有的实例数： " + set.size());

    }
}
