package com.example.a35_sensorlight_music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.IBinder;
import android.widget.Toast;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
public class musicService extends Service {

    private static final String TAG = null;
    MediaPlayer player;
    public IBinder onBind(Intent arg0) {

        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.trav);

    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return START_NOT_STICKY;
    }

    public IBinder onUnBind(Intent arg0) {

        return null;
    }

    public void onStop() {
        player.pause();
    }
    public void onPause() {

    }
    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

}


