package com.example.wheelsup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Options extends AppCompatActivity {
    Button Car,Vehicle,Logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Car=(Button)findViewById(R.id.car);
        Vehicle=(Button)findViewById(R.id.vehicle);
        Logout=(Button)findViewById(R.id.Logout);

        Car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opencar();
            }
        });

        Vehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openvehicle();

            }
        });

        Logout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Loginactivity.class));
            }
        });

        }

    private void openvehicle() {
        Intent intent=new Intent(this,List_Vehicle.class);
        startActivity(intent);

    }


    private void opencar() {
        Intent intent=new Intent(this,ListCar.class);
        startActivity(intent);
    }
}