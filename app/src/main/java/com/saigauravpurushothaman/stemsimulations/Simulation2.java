package com.saigauravpurushothaman.stemsimulations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;

public class Simulation2 extends AppCompatActivity {

    View v;
    ImageView ball;
    int time;
    boolean run;
    int buttonCounter;
    int xPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation2);

        this.run = true;
        this.time = 85;
        this.v = findViewById(R.id.con);
        this.ball = findViewById(R.id.ballImage);
    }

    public void bounceBall(final View view){
        buttonCounter++;
        final Timer timerObj = new Timer();
        TimerTask timerTaskObj = new TimerTask() {
            public void run() {
                ball.setX(xPos);
                double a = accelerate(time);
                if (time >= 175) {
                    time = 0;
                } else {
                    height(a);
                }
                xPos += 12;
                time += 1;
            }
        };
        if (run && buttonCounter < 2) {
            timerObj.scheduleAtFixedRate(timerTaskObj, 10, 10);
        }
    }

    private double accelerate(long t){
        return (-0.2 * t * t + 35 * t);
    }

    private void height(double yPos){
        ball.setY((int) (v.getHeight() - yPos - 400));
    }

    public void reset(View view){
        run = false;
        xPos = 0;
        ball.setX(0);
        ball.setY(500);
        buttonCounter = 0;
        this.time = 85;
    }
}
