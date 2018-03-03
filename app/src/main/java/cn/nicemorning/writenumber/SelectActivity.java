/*
 * Copyright (c) 2018. this file is create by nicemorning,contact email:oypebook@outlook.com
 */

package cn.nicemorning.writenumber;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class SelectActivity extends Activity {
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        if (MainActivity.isPlay) {
            playMusic();
        }
    }

    protected void onRestart() {
        super.onRestart();
        if (MainActivity.isPlay) {
            playMusic();
        }
    }

    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    private void playMusic() {
        mediaPlayer = MediaPlayer.create(this, R.raw.number_music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    public void onOne(View view) {
        startActivity(new Intent(SelectActivity.this, OneActivity.class));
    }
}
