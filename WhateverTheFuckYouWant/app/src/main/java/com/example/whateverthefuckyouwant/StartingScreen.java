package com.example.whateverthefuckyouwant;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;



public class StartingScreen extends AppCompatActivity {

    Button teamNumbers;
    Button teamLogos;
    Button randomButton;
    Button about;
    TextView tv;
    ToggleButton muteToggleButton;

    boolean muteOrNaw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_screen);



        teamNumbers = (Button) findViewById(R.id.button2);
        //teamLogos = (Button) findViewById(R.id.button3);
        //randomButton = (Button) findViewById(R.id.button4);
        //about = (Button) findViewById(R.id.button5);
        //tv = (TextView) findViewById(R.id.textView);

        teamNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartingScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        /*

        teamLogos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartingScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(StartingScreen.this, MainActivity.class);
                //startActivity(i);
                finish();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(StartingScreen.this, MainActivity.class);
                //startActivity(i);
                finish();
            }
        });
        */



        muteToggleButton = (ToggleButton) findViewById(R.id.togglebutton);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        muteOrNaw = pref.getBoolean("muteOrNaw", true);

        muteToggleButton.setChecked(muteOrNaw);

        muteToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("muteOrNaw", isChecked);
                editor.commit();
            }
        });

    }
}
