package com.ideal.jalen.ipc.aidl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * author: jalen
 * date: 2017/11/27
 * editor:
 * date:
 * describe:
 */
public class AIDLServiceConnection implements ServiceConnection {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        //获取服务器传过来的对象
        IShop iShop = IShop.Stub.asInterface(service);

        Product product = new Product();
        product.name = "哈哈";
        product.price = 25;
        try {
            iShop.setProduct(product);
            iShop.buy();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
