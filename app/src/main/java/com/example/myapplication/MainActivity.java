package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ProgressBar pB;
    private TextView tb,t1,t2,tt;
    private int txt;
    private String st;
    private Dialog dialog;
    private ConstraintLayout cl;
    private ImageView yo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        pB=findViewById(R.id.progressBar);
        tb=findViewById(R.id.tbb);
        tb=findViewById(R.id.sad);
        cl=findViewById(R.id.lala);
        t1=findViewById(R.id.t2);
        t2=findViewById(R.id.t3);
        yo=findViewById(R.id.imageView3);
        dialog=new Dialog(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dothemagic();

            }
        });

    }

    private void dothemagic() {
        button.clearAnimation();
        button.setVisibility(View.GONE);
        button.setVisibility(View.INVISIBLE);
        pB.setVisibility(View.VISIBLE);
        tb.setVisibility(View.VISIBLE);
        txt=0;
        int inc=100/12;

        new CountDownTimer(6600,500)
        {
            @Override
            public void onTick(long millisUntilFinished) {
                txt+=inc;
                Random rand = new Random();
                if(txt<90)
                {
                    int ri = rand.nextInt(88)+10;
                    st= String.valueOf(txt)+'.'+String.valueOf(ri);
                    tb.setText(st+"%");
                    Log.d("abc",st+"%");
                }
                else
                {
                    tb.setText("100.0%");
                }
            }
            @Override
            public void onFinish() {
                setdialog();
                //button.setVisibility(View.VISIBLE);
                pB.clearAnimation();
                tb.clearAnimation();
                pB.setVisibility(View.GONE);
                pB.setVisibility(View.INVISIBLE);
                tb.setVisibility(View.GONE);
                tb.setVisibility(View.INVISIBLE);
                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
                yo.setVisibility(View.VISIBLE);
                tt.setVisibility(View.VISIBLE);
            }
        }.start();




    }

    private void setdialog() {
        dialog.setContentView(R.layout.dialogbox);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        /*
        shownum.setText(rann);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ig.animate().rotationBy(360).withEndAction(this).setDuration(6000).setInterpolator(new LinearInterpolator()).start();
            }
        };
        ig.animate().rotationBy(360).withEndAction(runnable).setDuration(6000).setInterpolator(new LinearInterpolator()).start();
        */

    }
}