package burning.patternsingleton;

/**
 * 恶汉模式实现，在类被加载的时候，就生成实例，天生线程安全
 */
public class SingletonDemo1 {

    private static boolean sFlagCreated = false;
    private static  SingletonDemo1 sSingletonDemo1 = new SingletonDemo1();

    /**
     * 单例模式实现，获取皇帝类的唯一实例
     *
     * @return 实例
     */
    public static SingletonDemo1 getInstance() {

        return sSingletonDemo1;
    }

    private SingletonDemo1() {
        synchronized (SingletonDemo1.class) {
            System.out.println("状态：" + sFlagCreated);
            if (!sFlagCreated) {
                sFlagCreated = true;
            } else {
                throw new RuntimeException("单例模式被侵犯！");
            }
        }


        System.out.println("状态：" + sFlagCreated);
        System.out.println(getClass().getSimpleName() + " 创建实例");
        sCurrentInstanceNum++;
    }

    private static int sCurrentInstanceNum = 0;

    public int getCurrentInstanceNum() {
        return sCurrentInstanceNum;
    }


    @Override
    public String toString() {
        return super.toString() + "   sCurrentInstanceNum : " + sCurrentInstanceNum;
    }
}
