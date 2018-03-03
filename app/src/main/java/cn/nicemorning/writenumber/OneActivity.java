/*
 * Copyright (c) 2018. this file is create by nicemorning,contact email:oypebook@outlook.com
 */

package cn.nicemorning.writenumber;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

import cn.nicemorning.writenumber.util.CustomProgressDialog;


public class OneActivity extends Activity {
    public CustomProgressDialog customProgressDialog;
    private MediaPlayer mediaPlayer;
    private ImageView mIvFrame;
    private LinearLayout linearLayout = null;
    protected int i = 1;
    protected float x1;
    protected float y1;
    protected float x2;
    protected float y2;
    protected float x3;
    protected float y3;
    protected int igvx;
    protected int igvy;
    protected int type = 0;
    protected int widthPixels;
    protected int heightPixels;
    protected float scaleWidth;
    protected float scaleHeight;
    protected Timer touchTimer = null;
    protected Bitmap arrdown;
    protected boolean typedialog = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        if (MainActivity.isPlay == true) {
            playMusic();
        }
        initView();
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

    private void initView() {
        mIvFrame = (ImageView) findViewById(R.id.iv_frame);
        linearLayout = (LinearLayout) findViewById(R.id.LinearLayout1);
        LinearLayout write_layout = (LinearLayout) findViewById(R.id.LinearLayout_number);
        write_layout.setBackgroundResource(R.drawable.bg1);
        widthPixels = this.getResources().getDisplayMetrics().widthPixels;
        heightPixels = this.getResources().getDisplayMetrics().heightPixels;
        scaleWidth = ((float) widthPixels / 720);
        scaleHeight = ((float) heightPixels / 1280);
        try {
            InputStream inputStream = getResources().getAssets().open("on1_1.png");
            arrdown = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LinearLayout.LayoutParams layoutParams =
                (LinearLayout.LayoutParams) mIvFrame.getLayoutParams();
        layoutParams.width = (int) (arrdown.getWidth() * scaleHeight);
        layoutParams.height = (int) (arrdown.getHeight() * scaleHeight);
        mIvFrame.setLayoutParams(layoutParams);
        loadimagep(1);
        @SuppressLint("HandlerLeak") final Handler mHandler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 2:
                        jlodimage();
                        break;
                    default:
                        break;
                }
                super.handleMessage(msg);
            }
        };
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x1 = motionEvent.getX();
                        y1 = motionEvent.getY();
                        igvx = mIvFrame.getLeft();
                        igvy = mIvFrame.getTop();
                        if (x1 >= igvx && x1 <= igvx + (int) (arrdown.getWidth() * scaleWidth)
                                && y1 >= igvy & y1 <= igvy + (int) (arrdown.getWidth() * scaleWidth)) {
                            type = 1;
                        } else {
                            type = 0;
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        igvx = mIvFrame.getLeft();
                        igvy = mIvFrame.getTop();
                        x2 = motionEvent.getX();
                        y2 = motionEvent.getY();
                        if (type == 1) {
                            if (x2 >= igvx && x2 <= igvx + (int) (arrdown.getWidth() * scaleWidth)) {
                                if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 && y2 >= igvy) {
                                    loadimagep(1);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 2) {
                                    loadimagep(2);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 3) {
                                    loadimagep(3);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 4) {
                                    loadimagep(4);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 5) {
                                    loadimagep(5);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 6) {
                                    loadimagep(6);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 7) {
                                    loadimagep(7);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 8) {
                                    loadimagep(8);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 9) {
                                    loadimagep(9);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 10) {
                                    loadimagep(10);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 11) {
                                    loadimagep(11);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 12) {
                                    loadimagep(12);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 13) {
                                    loadimagep(13);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 14) {
                                    loadimagep(14);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 15) {
                                    loadimagep(15);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 16) {
                                    loadimagep(16);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 17) {
                                    loadimagep(17);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 18) {
                                    loadimagep(18);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 19) {
                                    loadimagep(19);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 20) {
                                    loadimagep(20);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 21) {
                                    loadimagep(21);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 22) {
                                    loadimagep(22);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 23) {
                                    loadimagep(23);
                                } else if (y2 <= igvy + (int) (arrdown.getHeight() * scaleHeight) / 24 * 24) {
                                    loadimagep(24);
                                } else {
                                    type = 0;
                                }
                            }
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        type = 0;
                        if (touchTimer != null) {
                            touchTimer.cancel();
                            touchTimer = null;
                        }
                        touchTimer = new Timer();
                        touchTimer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                Thread thread = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Message message = new Message();
                                        message.what = 2;
                                        mHandler.sendMessage(message);
                                    }
                                });
                                thread.start();
                            }
                        }, 300, 200);
                }
                return true;
            }
        });
    }

    public void onDemo(View view) {
        if (customProgressDialog == null) {
            customProgressDialog = new CustomProgressDialog(this,
                    "Click other area to dismiss", R.drawable.frame1);
            customProgressDialog.show();
        }
    }

    private void jlodimage() {
        if (i == 25) {
        } else if (i < 25) {
            if (i > 1) {
                i--;
            } else if (i == 1) {
                i = 1;
                if (touchTimer != null) {
                    touchTimer.cancel();
                    touchTimer = null;
                }
            }
            String name = "on1_" + i;
            int imgid = getResources().getIdentifier(name, "drawable",
                    "cn.nicemorning.writenumber");
            mIvFrame.setBackgroundResource(imgid);
        }
    }


    private void loadimagep(int j) {
        i = j;
        if (i < 25) {
            String name = "on1_" + i;
            int imgid = getResources().getIdentifier(name, "drawable",
                    "cn.nicemorning.writenumber");
            mIvFrame.setBackgroundResource(imgid);
            i++;
        }
        if (j == 24) {
            if (typedialog) {
                dialog();
            }
        }
    }

    protected void dialog() {
        typedialog = false;
        AlertDialog.Builder builder = new AlertDialog.Builder(OneActivity.this);
        builder.setMessage("Done!");
        builder.setTitle("Congratulations");
        builder.setPositiveButton("Finished", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                typedialog = true;
                finish();
            }
        });
        builder.setNegativeButton("Once again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                typedialog = true;
                i = 1;
                loadimagep(i);
            }
        });
        builder.create().show();
    }

    private void playMusic() {
        mediaPlayer = MediaPlayer.create(this, R.raw.music1);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

}
