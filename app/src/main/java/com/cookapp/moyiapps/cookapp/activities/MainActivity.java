package com.cookapp.moyiapps.cookapp.activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cookapp.moyiapps.cookapp.R;

public class MainActivity extends AppCompatActivity {

    private View btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.buttonIrAmisRecetas);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){

                Intent intent= new Intent(MainActivity.this, MisRecetas.class);
                startActivity(intent);
            }
        });


        }



    }

