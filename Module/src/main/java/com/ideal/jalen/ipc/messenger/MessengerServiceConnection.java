package com.ideal.jalen.ipc.messenger;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import com.ideal.jalen.constant.KeyConstant;

/**
 * author: jalen
 * date: 2017/11/27
 * editor:
 * date:
 * describe: Messenger
 */
public class MessengerServiceConnection implements ServiceConnection {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Messenger messenger = new Messenger(service);
        Message msg = Message.obtain();
        //通过msg把客服端的Messenger传递给服务器端
        msg.replyTo = messengerLocal;
        Bundle bundle = new Bundle();
        bundle.putString(KeyConstant.KEY_STRING, "你是谁?");
        msg.setData(bundle);
        try {
            messenger.send(msg);
            Log.i("dragon", " messenger.send(msg)");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.i("dragon", "onServiceDisconnected");
    }

    private static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String string = data.getString(KeyConstant.KEY_STRING);
            Log.i("dragon", string);
        }
    };

    private static Messenger messengerLocal = new Messenger(handler);
}
