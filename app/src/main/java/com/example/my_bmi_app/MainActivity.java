package com.example.my_bmi_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this below line connects our java to xml file
        setContentView(R.layout.activity_main);

        EditText wt, htft , htin , nm;
        TextView txtres;
        Button btn;
        LinearLayout llmain;

        wt = findViewById(R.id.edtWeight);
        htft = findViewById(R.id.edtHeight_ft);
        htin = findViewById(R.id.edtHeight_in);
        txtres = findViewById(R.id.txtresult);
        btn = findViewById(R.id.btncal);
        llmain = findViewById(R.id.llmain);
        nm = findViewById(R.id.name);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             int w  = Integer.parseInt(wt.getText().toString());
             int hf = Integer.parseInt(htft.getText().toString());
             int hn = Integer.parseInt(htin.getText().toString());


             double totalIn = hf*12 + hn;
             double totalM = (totalIn*2.53)/100;

             double bmi = w / (totalM*totalM);


             if(bmi > 25){
                 txtres.setText(nm.getText()+ " you are overweight");

                 llmain.setBackgroundColor(getResources().getColor(R.color.colorow));
             }
             else if(bmi <18){
                 txtres.setText(nm.getText()+ " you are under weight");
                 llmain.setBackgroundColor(getResources().getColor(R.color.colorun));
             }
             else
             {
                 txtres.setText(nm.getText()+ " you are a healthy guy");

                 llmain.setBackgroundColor(getResources().getColor(R.color.colorhl));
             }

            }
        });




    }
}