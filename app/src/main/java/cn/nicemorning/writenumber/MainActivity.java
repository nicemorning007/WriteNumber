/*
 * Copyright (c) 2018. this file is create by nicemorning,contact email:oypebook@outlook.com
 */

package cn.nicemorning.writenumber;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    protected static boolean isPlay = true;
    private MediaPlayer mediaPlayer;
    private Button mMusic_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMusic_btn = (Button) findViewById(R.id.btn_music);
        playMusic();
    }

    protected void onRestart() {
        super.onRestart();
        if (isPlay) {
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
        mediaPlayer = MediaPlayer.create(this, R.raw.main_music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    public void onPlay(View view) {
        startActivity(new Intent(MainActivity.this, SelectActivity.class));
    }

    public void onMusic(View view) {
        if (isPlay) {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mMusic_btn.setBackgroundResource(R.drawable.btn_music2);
                isPlay = false;
            }
        } else {
            playMusic();
            mMusic_btn.setBackgroundResource(R.drawable.btn_music1);
            isPlay = true;
        }
    }

    public void onAbout(View view) {
        startActivity(new Intent(MainActivity.this, AboutActivity.class));
    }
}
