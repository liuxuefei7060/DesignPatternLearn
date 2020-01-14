package burning.patternsingleton;


/**
 * 枚举方式
 */
public enum SingletonDemo4 {

    INSTANCE;

    private int mCurrentInstanceNum = 0;

    SingletonDemo4() {
        mCurrentInstanceNum++;
    }

    public int getCurrentInstanceNum() {
        return mCurrentInstanceNum;
    }
}
