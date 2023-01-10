package com.example.my_bmi_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //objects are declared in MainActivity class ,if declare onCreate then method calling becomes not easy
    EditText wt, htft , htin , nm;  //here EditText is a class and wt, htft,... are its objects/variables
    TextView txtres;
    Button btn;
    LinearLayout llmain;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
//        this below line connects our java to xml file
        setContentView(R.layout.activity_main);

        ids(); //method calling

        //setOnClickListener is class and inside view class, onClickListener is a interface class.
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //w, hf , hn , name are variables which are fetching the values of editTexts
             int w  = Integer.parseInt(wt.getText().toString());
             int hf = Integer.parseInt(htft.getText().toString());
             int hn = Integer.parseInt(htin.getText().toString());
             String name = nm.getText().toString();

             //calculation part
             double totalIn = hf*12 + hn;
             double totalM = (totalIn*2.53)/100;
             double bmi = w / (totalM*totalM);

             //logic part
             if(bmi > 25){
                 txtres.setText("sorry " + name + " you're overweight");
                 llmain.setBackgroundColor(getResources().getColor(R.color.colorow));
             }
             else if(bmi <18){
                 txtres.setText("sorry " + name + " you're under weight");
                 //llmain.setBackgroundColor(Color.RED);
                 llmain.setBackgroundColor(getResources().getColor(R.color.colorun));
             }
             else
             {
                 txtres.setText(name+ " you're a healthy guy");
                 llmain.setBackgroundColor(getResources().getColor(R.color.colorhl));
                 txtres.setBackgroundColor(getResources().getColor(R.color.colorres));
             }

            }
        });


    }
    public void ids(){
        //here we connect ids to objs/variables
        //res(R) to id(hidden folder) to idName
        wt = findViewById(R.id.edtWeight);
        htft = findViewById(R.id.edtHeight_ft);
        htin = findViewById(R.id.edtHeight_in);
        txtres = findViewById(R.id.txtresult);
        btn = findViewById(R.id.btncal);
        llmain = findViewById(R.id.llmain);
        nm = findViewById(R.id.name);
    }
}