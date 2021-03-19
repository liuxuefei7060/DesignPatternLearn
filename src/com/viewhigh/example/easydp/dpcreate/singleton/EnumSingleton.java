package com.viewhigh.example.easydp.dpcreate.singleton;

/**
 * 枚举方式
 */
public enum EnumSingleton {

    INSTANCE;

    private int mCurrentInstanceNum = 0;

    EnumSingleton() {
        mCurrentInstanceNum++;
    }

    public int getCurrentInstanceNum() {
        return mCurrentInstanceNum;
    }
}
