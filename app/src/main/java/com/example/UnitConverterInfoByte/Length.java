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

public class Length extends AppCompatActivity {
    String[] arr_length={
            "Select Conversion Type",
            "centimeter-meter","meter-kilometer","kilometer-centimeter","kilometer-feet","feet-meter"
    };
    Spinner spinner_length;
    TextView result_length;
    EditText units_length;
    Button button_length;
   int conv_sel_length;
    BigDecimal res_length;
    String calculated_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        spinner_length=findViewById(R.id.spinner_length);
        result_length=findViewById(R.id.result_length);
        units_length=findViewById(R.id.units_length);
        button_length=findViewById(R.id.button_length);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,arr_length);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_length.setAdapter(arrayAdapter);
        spinner_length.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                conv_sel_length=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        button_length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(units_length.getText())){
                    Toast.makeText(Length.this, "", Toast.LENGTH_SHORT).show();
                }
                else {
                    double num=Double.parseDouble(units_length.getText().toString());
                    if (conv_sel_length==1) {
                        res_length= BigDecimal.valueOf(num*0.01);
                        calculated_result=res_length+" meter";
                        result_length.setText(calculated_result);

                    }
                    if (conv_sel_length==2) {
                        res_length= BigDecimal.valueOf(num/1000);
                        calculated_result=res_length+" kilometer";
                        result_length.setText(calculated_result);
                    }
                    if (conv_sel_length==3) {
                        res_length= BigDecimal.valueOf(num*100000);
                        calculated_result=res_length+" centimeter";
                        result_length.setText(calculated_result);
                    }
                    if (conv_sel_length==4) {
                        res_length= BigDecimal.valueOf(num*3280);
                        calculated_result=res_length+" feet";
                        result_length.setText(calculated_result);
                    }
                    if (conv_sel_length==5) {
                        res_length= BigDecimal.valueOf(num*0.305);
                        calculated_result=res_length+" meter";
                        result_length.setText(calculated_result);
                    }


                    if(conv_sel_length==0) {
                        Toast.makeText(Length.this, "Select Conversion Type", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });
    }
}