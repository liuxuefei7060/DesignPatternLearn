package com.viewhigh.example.easydp.dpcreate.singleton;

public class EHanSingleton {

    public static  int sCurrentInstanceNum = 0;

    //添加一个变量，防止反射生成实例
    private static boolean sFlagCreated = false;

    private static EHanSingleton sEHanSingleton = new EHanSingleton();

    /**
     * 单例模式,获取实例
     * <p>
     * 在类被加载的时候，就生成实例
     *
     * @return 实例
     */
    public static EHanSingleton getInstance() {
        return sEHanSingleton;
    }

    private EHanSingleton() {
        synchronized (EHanSingleton.class) {
            if (!sFlagCreated) {
                sFlagCreated = true;
            } else {
                throw new RuntimeException("单例模式被侵犯！");
            }

            sCurrentInstanceNum++;
            System.out.println(getClass().getSimpleName() + " 创建实例  sCurrentInstanceNum: " + sCurrentInstanceNum);
        }
    }

    public void say() {
        System.out.print("我是一个 恶汉 " + sCurrentInstanceNum + "   ");
    }


    @Override
    public String toString() {
        return super.toString() + "   sCurrentInstanceNum : " + sCurrentInstanceNum;
    }
}
