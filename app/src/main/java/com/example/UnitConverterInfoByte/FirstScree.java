package com.example.UnitConverterInfoByte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.spinnerdemo.R;

public class FirstScree extends AppCompatActivity {
Button weight,currency,temperature,power,length,volume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_scree);
        weight=findViewById(R.id.weight);
        currency=findViewById(R.id.currency);
        temperature=findViewById(R.id.temperature);
        power=findViewById(R.id.power);
        length=findViewById(R.id.length);
        volume=findViewById(R.id.volume);
        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstScree.this,Weight.class));
            }
        });
        currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstScree.this,Currency.class));
            }
        });
        temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstScree.this,Temperature.class));
            }
        });
        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstScree.this,Length.class));

            }
        });
        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstScree.this,Volume.class));
            }
        });
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstScree.this, com.example.UnitConverterInfoByte.power.class));
            }
        });

    }
}