package com.example.UnitConverterInfoByte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spinnerdemo.R;

import java.math.BigDecimal;

public class power extends AppCompatActivity {
    String[] arr_power={
            "Select Conversion Type",
            "watt-kilowatt","joule-kilojoule","watt hour-joules"
    };
    Spinner spinner_power;
    TextView result_power;
    EditText units_power;
    Button button_power;
    int conv_sel_power;
   BigDecimal res_power;
    String calculated_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);
        spinner_power=findViewById(R.id.spinner_power);
        result_power=findViewById(R.id.result_power);
        units_power=findViewById(R.id.units_power);
        button_power=findViewById(R.id.button_power);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,arr_power);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_power.setAdapter(arrayAdapter);
        spinner_power.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                conv_sel_power=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        button_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(units_power.getText())){
                    Toast.makeText(power.this, "Enter Valid Input", Toast.LENGTH_SHORT).show();
                }
                else {
                    double num=Double.parseDouble(units_power.getText().toString());
                    if (conv_sel_power==1) {
                        res_power= BigDecimal.valueOf(num*0.001);
                        calculated_result=res_power+" kilowatts";
                        result_power.setText(calculated_result);

                    }
                    if (conv_sel_power==2) {
                        res_power= BigDecimal.valueOf(num*0.001);
                        calculated_result=res_power+" kilojoules";
                        result_power.setText(calculated_result);
                    }
                    if (conv_sel_power==3) {
                        res_power= BigDecimal.valueOf(num*3600);
                        calculated_result=res_power+" joules";
                        result_power.setText(calculated_result);
                    }

                    if (conv_sel_power==0) {
                        Toast.makeText(power.this, "Select Conversion Type", Toast.LENGTH_SHORT).show();

                    }


                }

            }
        });

    }
}