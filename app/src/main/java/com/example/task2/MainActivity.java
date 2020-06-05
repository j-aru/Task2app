package com.example.task2;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Button1 (Add)
        final Button btn1 = (Button) findViewById(R.id.button1);
        final Button btn2 = (Button) findViewById(R.id.button2);


        // Perform action on click
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Open Form Add
                Intent newActivity = new Intent(MainActivity.this, AddActivity.class);
                startActivity(newActivity);

            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, DisplaySQLiteDataActivity.class);
                startActivity(intent);
            }
        });

    }
}