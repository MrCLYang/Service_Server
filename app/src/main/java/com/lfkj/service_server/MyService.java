package com.lfkj.service_server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

public class MyService extends Service {
    // 实例化AIDL的Stub类(Binder的子类)
    AIDL_ServiceTest.Stub mBinder = new AIDL_ServiceTest.Stub() {

        //重写接口里定义的方法
        @Override
        public void AIDL_Service() throws RemoteException {
            System.out.println("客户端通过AIDL与远程后台成功通信");
        }
    };


    @Override
    public void onCreate() {
        super.onCreate();

        System.out.println("执行了onCreat()");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("执行了onStartCommand()");
        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("执行了onDestory()");
    }

    //在onBind()返回Stub类实例
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        System.out.println("执行了onBind()");

        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("执行了onUnbind()");
        return super.onUnbind(intent);
    }
}