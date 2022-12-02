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

public class Weight extends AppCompatActivity {
    String[] arr_weight={
            "Select Conversion Type",
            "grams-kilograms","grams-pounds","pounds-kilograms","kilograms-pounds"
    };
    Spinner spinner_weight;
    TextView result_weight;
    EditText units_weight;
    Button button_weight;
   int conv_sel_weight=0;
   BigDecimal res_weight;
    String calculated_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        spinner_weight=findViewById(R.id.spinner_weight);
        result_weight=findViewById(R.id.result_weight);
        units_weight=findViewById(R.id.units_weight);
        button_weight=findViewById(R.id.button_weight);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,arr_weight);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_weight.setAdapter(arrayAdapter);
        spinner_weight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                conv_sel_weight=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        button_weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(units_weight.getText())){
                    Toast.makeText(Weight.this, "Enter Valid Input", Toast.LENGTH_SHORT).show();
                }
                else {
                    double num=Double.parseDouble(units_weight.getText().toString());
                    if (conv_sel_weight==1) {
                        res_weight= BigDecimal.valueOf(num/1000);
                        calculated_result=String.valueOf(res_weight)+" kg";
                        result_weight.setText(calculated_result);
                    }
                    if (conv_sel_weight==2) {
                        res_weight= BigDecimal.valueOf(num*(0.0022));
                        calculated_result=String.valueOf(res_weight)+" pounds";
                        result_weight.setText(calculated_result);
                    }
                    if (conv_sel_weight==3) {
                        res_weight= BigDecimal.valueOf(num*(0.454));
                        calculated_result=String.valueOf(res_weight)+" kg";
                        result_weight.setText(calculated_result);
                    }
                    if (conv_sel_weight==4) {
                        res_weight= BigDecimal.valueOf(num*(2.205));
                        calculated_result=String.valueOf(res_weight)+" Pounds";
                        result_weight.setText(calculated_result);
                    }
                    if(conv_sel_weight==0) {
                        Toast.makeText(Weight.this, "Select Conversion Type", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

    }
}