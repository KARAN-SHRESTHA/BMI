package com.bmi_karan_stha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //creating variables
    private EditText etHeight, etWeight;
    private Button btnCalculate;
    private TextView tvBMI, tvStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pulling values according to specific variable names
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvBMI = findViewById(R.id.tvBMI);
        tvStatus = findViewById(R.id.tvStatus);

        //setting onclick listener
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //converting to float
                float Height = Float.parseFloat(etHeight.getText().toString());
                float Weight = Float.parseFloat(etWeight.getText().toString());

                Calculate c = new Calculate();  //Initializing Calculate class
                c.setHeight(Height);            //setting values
                c.setWeight(Weight);

                float BMI = c.BMI_Calc();       //calling Calculate class function
                tvBMI.setText(Float.toString(BMI)); //setting returned value


                //setting status according to result of BMI
                if (BMI<18.50)
                {
                    tvStatus.setText("Underweight");
                }
                else if (BMI>=18.5 && BMI<=24.9)
                {
                    tvStatus.setText("Normal Weight");
                }
                else if (BMI>=25 && BMI<=29.9)
                {
                    tvStatus.setText("Overweight");
                }
                else if (BMI>30)
                {
                    tvStatus.setText("Obesity");
                }

            }
        });


    }
}
