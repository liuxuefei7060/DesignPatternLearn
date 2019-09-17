package burning.patternsingleton;


/**
 * 静态内部类模式
 */
public class SingletonDemo3 {

    private static final class SingletonClassInstance {
        private static final SingletonDemo3 sSingletonDemo3 = new SingletonDemo3();
    }

    /**
     * 单例模式实现，获取皇帝类的唯一实例
     *
     * @return 实例
     */
    public static SingletonDemo3 getInstance() {
        return SingletonClassInstance.sSingletonDemo3;
    }


    private SingletonDemo3() {
        System.out.println(getClass().getSimpleName() + " 创建实例");
        sCurrentInstanceNum++;
    }

    private static int sCurrentInstanceNum = 0;

    /**
     * 获取当前的实例个数
     *
     * @return 数量
     */
    public int getCurrentInstanceNum() {
        return sCurrentInstanceNum;
    }

    @Override
    public String toString() {
        return super.toString() + "   sCurrentInstanceNum : " + sCurrentInstanceNum;
    }
}
