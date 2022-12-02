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

public class Temperature extends AppCompatActivity {
    String[] arr_temp={
            "Select Conversion Type",
            "degree-fahrenheit","fahrenheit-degree","degree-kelvin","kelvin-degree","fahrenheit-kelvin"
    };
    Spinner spinner_temp;
    TextView result_temp;
    EditText units_temp;
    Button button_temp;
   int conv_sel_temp;
   BigDecimal res_temp;
    String calculated_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        spinner_temp=findViewById(R.id.spinner_temp);
        result_temp=findViewById(R.id.result_temp);
        units_temp=findViewById(R.id.units_temp);
        button_temp=findViewById(R.id.button_temp);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,arr_temp);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_temp.setAdapter(arrayAdapter);
        spinner_temp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                conv_sel_temp=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        button_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(units_temp.getText())){
                    Toast.makeText(Temperature.this, "Enter Valid Input", Toast.LENGTH_SHORT).show();
                }
                else {
                    double num=Double.parseDouble(units_temp.getText().toString());
                    if (conv_sel_temp==1) {
                        res_temp= BigDecimal.valueOf(num*9/5+32);
                        calculated_result=String.valueOf(res_temp)+" fahrenheit";
                        result_temp.setText(calculated_result);
                    }
                    if (conv_sel_temp==2) {
                        res_temp= BigDecimal.valueOf((num-32)*5/9);
                        calculated_result=String.valueOf(res_temp)+" degrees";
                        result_temp.setText(calculated_result);
                    }
                    if (conv_sel_temp==3) {
                        res_temp= BigDecimal.valueOf(num+273.15);
                        calculated_result=String.valueOf(res_temp)+" Kelvin";
                        result_temp.setText(calculated_result);
                    }
                    if (conv_sel_temp==4) {
                        res_temp= BigDecimal.valueOf(num-273.1);
                        calculated_result=String.valueOf(res_temp)+" degrees";
                        result_temp.setText(calculated_result);
                    }
                    if (conv_sel_temp==5) {
                        res_temp= BigDecimal.valueOf((num-32)*5/9+273.15);
                        calculated_result=String.valueOf(res_temp)+" kelvin";
                        result_temp.setText(calculated_result);
                    }
                    if (conv_sel_temp==0) {
                        Toast.makeText(Temperature.this, "Select Conversion Type", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });


    }
}