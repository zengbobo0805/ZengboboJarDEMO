package com.aidldemo;

import android.os.RemoteException;

/**
 * Created by bobo on 2017/5/8.
 */

public class MyCompute extends ICompute.Stub {
    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return 0;
    }
}
