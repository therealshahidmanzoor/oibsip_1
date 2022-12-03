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

public class Currency extends AppCompatActivity {
    String[] arr_currency={
            "Select Conversion Type",
            "rupees-dollar","dollar-rupees","euro-rupees","rupees-dinar","rupees-riyal"
    };
    Spinner spinner_currency;
    TextView result_currency;
    EditText units_currency;
    Button button_currency;
    int conv_sel_currency;
   BigDecimal res_currency;
    String calculated_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        spinner_currency=findViewById(R.id.spinner_currency);
        result_currency=findViewById(R.id.result_currency);
        units_currency=findViewById(R.id.units_currency);
        button_currency=findViewById(R.id.button_currency);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,arr_currency);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_currency.setAdapter(arrayAdapter);
        spinner_currency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                conv_sel_currency=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        button_currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(units_currency.getText())){
                }
                else {
                    double num=Double.parseDouble(units_currency.getText().toString());
                    if (conv_sel_currency==1) {
                        res_currency= BigDecimal.valueOf(num*0.012);
                        calculated_result=String.valueOf(res_currency)+" Dollar";
                        result_currency.setText(calculated_result);
                    }
                    if (conv_sel_currency==2) {
                        res_currency= BigDecimal.valueOf(num*81.42);
                        calculated_result=String.valueOf(res_currency)+" Rupees";
                        result_currency.setText(calculated_result);
                    }
                    if (conv_sel_currency==3) {
                        res_currency= BigDecimal.valueOf(num/(80.5));
                        calculated_result=String.valueOf(res_currency)+" Rupees";
                        result_currency.setText(calculated_result);
                    }
                    if (conv_sel_currency==4) {
                        res_currency= BigDecimal.valueOf(num*(0.45359));
                        calculated_result=String.valueOf(res_currency)+" Dinar";
                        result_currency.setText(calculated_result);
                    }
                    if(conv_sel_currency==5){
                        res_currency= BigDecimal.valueOf(num*(0.04));
                        calculated_result=String.valueOf(res_currency)+" Riyal";
                        result_currency.setText(calculated_result);
                    }

                    if(conv_sel_currency==0) {
                        Toast.makeText(Currency.this, "Select Conversion Type", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });


    }
}