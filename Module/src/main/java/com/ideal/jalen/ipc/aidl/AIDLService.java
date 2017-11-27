package com.ideal.jalen.ipc.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * author: jalen
 * date: 2017/11/27
 * editor:
 * date:
 * describe:
 */
public class AIDLService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private Binder binder = new IShop.Stub() {

        @Override
        public Product buy() throws RemoteException {
            Log.i("dragon", "buy");
            return null;
        }

        @Override
        public void setProduct(Product product) throws RemoteException {
            Log.i("dragon", "product = " + product.name + " ; " + product.price);
        }
    };
}
