package edu.uga.cs.countriestovisitfragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/*
    Intro activity class
    Runs the activity intro layout

    @Author: Tommy Fricano
    @Date: 9/27/2022
 */
public class IntroActivity extends AppCompatActivity {

    private Button startButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        startButton = findViewById(R.id.button);                    //start button
        startButton.setOnClickListener(new ButtonClickListener());

    }

        /*
            class for the button
            allocates intent with the main activity
         */
        private class ButtonClickListener implements View.OnClickListener{

            @Override
            public void onClick(View view){
                if(view.getId() == R.id.button){
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    view.getContext().startActivity(intent);
                }
            }
    }
}
