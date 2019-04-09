package com.bmi_karan_stha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText etHeight, etWeight;
    private Button btnCalculate;
    private TextView tvBMI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvBMI = findViewById(R.id.tvBMI);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float Height = Integer.parseInt(etHeight.getText().toString());
                float Weight = Integer.parseInt(etWeight.getText().toString());

                Calculate c = new Calculate();


            }
        });


    }
}
