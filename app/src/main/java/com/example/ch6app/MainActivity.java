package com.example.ch6app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button bttn1, bttn2;
    MediaPlayer mp1, mp2;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bttn1 = (Button) findViewById(R.id.button);
        bttn2 = (Button) findViewById(R.id.button2);
        bttn1.setOnClickListener(bttn1l);
        bttn2.setOnClickListener(bttn2l);

        mp1 = new MediaPlayer();
        mp2 = new MediaPlayer();
//
//

        mp1 = MediaPlayer.create(this,R.raw.track1);
        mp2 = MediaPlayer.create(this,R.raw.track2);
    }
    Button.OnClickListener bttn1l = new Button.OnClickListener(){
        @Override
        public void onClick(View view){
            if (mp2.isPlaying())
                bttn2.callOnClick();

            switch (playing){
                case 0:
                    mp1.start();
                    playing++;
                    bttn1.setText("pause");
                    break;
                case 1:
                    mp1.pause();
                    playing--;
                    bttn1.setText("play");
                    break;
            }
        }
    };

    Button.OnClickListener bttn2l = new Button.OnClickListener(){
        @Override
        public void onClick(View view){
            if (mp1.isPlaying())
                bttn1.callOnClick();

            switch (playing){
                case 0:
                    mp2.start();
                    playing++;
                    bttn2.setText("pause");
                    break;
                case 1:
                    mp2.pause();
                    playing--;
                    bttn2.setText("play");
                    break;
            }
        }
    };
}