package burning.patternsingleton;

/**
 * 懒汉模式实现，在需要的实例的时候才创建，节省内存
 */
public class SingletonDemo2 {

    private static SingletonDemo2 sInstance;

    /**
     * 单例模式实现，获取的唯一实例
     *
     * @return 实例
     */
    public static  SingletonDemo2  getInstance() {

        if (sInstance == null) {
            sInstance = new SingletonDemo2();
        }

        return sInstance;
    }

    private static int sCurrentInstanceNum = 0;

    private SingletonDemo2() {
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
