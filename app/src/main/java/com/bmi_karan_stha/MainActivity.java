package com.bmi_karan_stha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

                if (validate()) {

                    //converting to float
                    float Height = Float.parseFloat(etHeight.getText().toString());
                    float Weight = Float.parseFloat(etWeight.getText().toString());

                    Calculate c = new Calculate();  //Initializing Calculate class
                    c.setHeight(Height);            //setting values
                    c.setWeight(Weight);

                    float BMI = c.BMI_Calc();       //calling Calculate class function
                    tvBMI.setText(Float.toString(BMI)); //setting returned value


                    //setting status according to result of BMI in Toast
                    if (BMI < 18.50) {
                        tvStatus.setText("Underweight");
                        Toast.makeText(getApplicationContext(), "Underweight", Toast.LENGTH_LONG).show();
                    } else if (BMI >= 18.5 && BMI <= 24.9) {
                        tvStatus.setText("Normal Weight");
                        Toast.makeText(getApplicationContext(), "Normal Weight", Toast.LENGTH_LONG).show();
                    } else if (BMI >= 25 && BMI <= 29.9) {
                        tvStatus.setText("Overweight");
                        Toast.makeText(getApplicationContext(), "Overweight", Toast.LENGTH_LONG).show();
                    } else if (BMI > 30) {
                        tvStatus.setText("Obesity");
                        Toast.makeText(getApplicationContext(), "Obesity", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });


    }

    private boolean validate() {
        boolean flag = true;
        Pattern p = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");
        Matcher m1 = p.matcher(etHeight.getText().toString());
        Matcher m2 = p.matcher(etWeight.getText().toString());

        //Validating for Empty Text
        if (TextUtils.isEmpty(etHeight.getText().toString())) {
            etHeight.setError("Enter Height");
            etHeight.requestFocus();
            flag = false;
        } else if (TextUtils.isEmpty(etWeight.getText().toString())) {
            etWeight.setError("Enter Weight");
            etWeight.requestFocus();
            flag = false;
        }
        else if (!m1.find())    //validating for number only
        {
            Toast.makeText(getApplicationContext(), "Enter a valid height number", Toast.LENGTH_LONG).show();
            etHeight.setError("Enter Valid Height Number");
            etHeight.requestFocus();
            flag = false;
        }
        else if (!m2.find())
        {
            Toast.makeText(getApplicationContext(), "Enter a valid weight number", Toast.LENGTH_LONG).show();
            etHeight.setError("Enter Valid Weight Number");
            etWeight.requestFocus();
            flag = false;
        }

        return flag;
    }
}
