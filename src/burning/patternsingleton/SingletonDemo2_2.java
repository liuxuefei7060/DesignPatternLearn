package burning.patternsingleton;

/**
 * 懒汉模式实现，在需要的实例的时候才创建，节省内存
 */
public class SingletonDemo2_2 {

    private static SingletonDemo2_2 sInstance;

    /**
     * 单例模式实现，获取皇帝类的唯一实例
     * <p>
     * 双重判断使用在多线程
     *
     * @return 实例
     */
    public static SingletonDemo2_2 getInstance() {

        //为什么要双重判断？
        // 不双重会出现一种情况，多线程同时运行到到if语句内，争抢锁，有一个获得后，就开始创建一个对象实例。
        // 另一个对象在获取锁以后，也会去创建一个对象实例
        if (sInstance == null) {
            synchronized (SingletonDemo2_2.class) {
                if (sInstance == null) {
                    sInstance = new SingletonDemo2_2();
                }
            }
        }

        return sInstance;
    }

    private static int sCurrentInstanceNum = 0;

    private SingletonDemo2_2() {
        System.out.println(getClass().getSimpleName() + " 创建实例");
        sCurrentInstanceNum++;
    }


    public int getCurrentInstanceNum() {
        return sCurrentInstanceNum;
    }

    @Override
    public String toString() {
        return super.toString() + "   mCurrentInstanceNum : " + sCurrentInstanceNum;
    }

}
