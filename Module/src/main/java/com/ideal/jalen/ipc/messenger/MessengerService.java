package com.ideal.jalen.ipc.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.ideal.jalen.constant.KeyConstant;

/**
 * author: jalen
 * date: 2017/11/27
 * editor:
 * date:
 * describe: Messenger服务
 */
public class MessengerService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

    private static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //获取客服端接受消息的Messenger
            Messenger messenger = msg.replyTo;
            Bundle data = msg.getData();
            String string = data.getString(KeyConstant.KEY_STRING);
            Log.i("dragon", string);

            Message message = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putString(KeyConstant.KEY_STRING, "Jalen");
            message.setData(bundle);
            try {
                messenger.send(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }
    };

    Messenger messenger = new Messenger(handler);
}
