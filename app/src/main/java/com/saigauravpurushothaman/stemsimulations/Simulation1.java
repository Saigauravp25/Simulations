package com.saigauravpurushothaman.stemsimulations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;

public class Simulation1 extends AppCompatActivity {

    View v;
    ImageView ball;
    int time;
    double factor;
    boolean run;
    int buttonCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation1);

        this.run = true;
        this.factor = 1;
        this.time = 85;
        this.v = findViewById(R.id.con);
        this.ball = findViewById(R.id.ballImage);
    }

    public void bounceBall(View view){
        buttonCounter++;
        final Timer timerObj = new Timer();
        TimerTask timerTaskObj = new TimerTask() {
            public void run() {
                double a = accelerate(time);
                if (time >= 175) {
                    time = 0;
                    factor *= 0.75;
                } else {
                    height(a);
                }
                time += 1;
            }
        };
        if (run && buttonCounter < 2) {
            timerObj.scheduleAtFixedRate(timerTaskObj, 1, 5);
        }
    }

    private double accelerate(long t){
        return factor * (-0.2 * t * t + 35 * t);
    }

    private void height(double yPos){
        ball.setY((int) (v.getHeight() - yPos - 400));
    }

    public void reset(View view){
        run = false;
        buttonCounter = 0;
        this.time = 85;
        this.factor = 1;
    }
}