
package com.example.msap_seminarska;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class Service extends android.app.Service {
    MediaPlayer myPlayer;

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();
        myPlayer = MediaPlayer.create(this, R.raw.song);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        int songNum = intent.getIntExtra("extraSongNum", 1);
        if(songNum == 1)
        {
            myPlayer = MediaPlayer.create(this, R.raw.song);
        }
        else if(songNum == 2)
        {
            myPlayer = MediaPlayer.create(this, R.raw.song2);
        }
        else if(songNum == 3)
        {
            myPlayer = MediaPlayer.create(this, R.raw.song3);
        }
        else if(songNum == 4)
        {
            myPlayer = MediaPlayer.create(this, R.raw.song4);
        }

        myPlayer.setLooping(false);
        Log.i("SARA", "Service started");
        //Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        myPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onStart(Intent intent, int startid) {
        Log.i("SARA", "Service started");
        //Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        myPlayer.start();
    }
    @Override
    public void onDestroy() {
        Log.i("SARA", "Service stopped");
        //Toast.makeText(this, "Service Stopped", Toast.LENGTH_LONG).show();
        myPlayer.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}