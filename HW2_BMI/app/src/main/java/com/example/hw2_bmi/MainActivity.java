package com.example.hw2_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextUtils;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    private TextView txvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvShow = (TextView) findViewById(R.id.txvShow);
        txvShow.setTextSize(36);
        EditText edtHeight = (EditText) findViewById(R.id.edtHeight);
        EditText edtWeight = (EditText) findViewById(R.id.edtWeight);
        Button btnCalc = (Button) findViewById(R.id.btnCalc);
        Button btnClear = (Button) findViewById(R.id.btnClear);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                String heightStr = edtHeight.getText().toString();
                String weightStr = edtWeight.getText().toString();



                if (TextUtils.isEmpty(heightStr) || TextUtils.isEmpty(weightStr)) {
                    txvShow.setText("請輸入身高和體重");
                    return; // 停止執行，因為輸入不完整
                }

                double height = Double.parseDouble(edtHeight.getText().toString());
                double weight = Double.parseDouble(edtWeight.getText().toString());



                if (height <= 0 && weight <= 0 ) {
                    txvShow.setText("請輸入正確身高體重");
                    return; // 停止執行，因為輸入不正確
                }
                else if (height <= 0 ) {
                    txvShow.setText("請輸入正確身高");
                    return; // 停止執行，因為輸入不正確
                }
                if (weight <= 0) {
                    txvShow.setText("請輸入正確體重");
                    return; // 停止執行，因為輸入不正確
                }


                double bmi = weight / Math.pow(height / 100.0, 2);
                if (bmi >= 24)
                    txvShow.setTextColor(Color.RED);
                else if (bmi < 18.5)
                    txvShow.setTextColor(Color.BLUE);
                else
                    txvShow.setTextColor(Color.GREEN);

                txvShow.setText(String.format("%.2f", bmi));


            }
        });



        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                edtHeight.setText("");
                edtWeight.setText("");
                txvShow.setText("");
            }
        });


    }
}
