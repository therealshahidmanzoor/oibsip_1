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

public class Volume extends AppCompatActivity {
    String[] arr_vol={
            "Select Conversion Type",
            "cubic meter- cubic centimeter","cubic feet-cubic meter","cubic meter-cubic feet","cubic centimeter-cubic meter"
    };
    Spinner spinner_vol;
    TextView result_vol;
    EditText units_vol;
    Button button_vol;
    int conv_sel_vol;
    BigDecimal res_vol;
    String calculated_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
        spinner_vol=findViewById(R.id.spinner_vol);
        result_vol=findViewById(R.id.result_vol);
        units_vol=findViewById(R.id.units_vol);
        button_vol=findViewById(R.id.button_vol);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,arr_vol);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_vol.setAdapter(arrayAdapter);
        spinner_vol.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                conv_sel_vol=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        button_vol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(units_vol.getText())){

                }
                else {
                    double num=Double.parseDouble(units_vol.getText().toString());
                    if (conv_sel_vol==1) {
                        res_vol= BigDecimal.valueOf(num*1000000);
                        calculated_result=res_vol+" cubic centimeter";
                        result_vol.setText(calculated_result);
                    }
                    if (conv_sel_vol==2) {
                        res_vol= BigDecimal.valueOf(num*0.0283);
                        calculated_result=res_vol+" cubic meter";
                        result_vol.setText(calculated_result);
                    }
                    if (conv_sel_vol==3) {
                        res_vol= BigDecimal.valueOf(num*35.315);
                        calculated_result=res_vol+" cubic feet";
                        result_vol.setText(calculated_result);
                    }
                    if (conv_sel_vol==4) {
                        res_vol= BigDecimal.valueOf(num*1000000);
                        calculated_result=res_vol+" cubic centimeter";
                        result_vol.setText(calculated_result);
                    }
                    if (conv_sel_vol==4) {
                        res_vol= BigDecimal.valueOf(num*0.000001);
                        calculated_result=res_vol+" cubic meter";
                        result_vol.setText(calculated_result);
                    }
                    if(conv_sel_vol==0) {
                        Toast.makeText(Volume.this, "Select Conversion Type", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });

    }
}