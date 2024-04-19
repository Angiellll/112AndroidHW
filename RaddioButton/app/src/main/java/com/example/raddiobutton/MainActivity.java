package com.example.raddiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                EditText edtnum = findViewById(R.id.edtnum);
                int num = Integer.parseInt(edtnum.getText().toString());
                intent.putExtra("quantity", num);

                RadioButton boy = findViewById(R.id.rdbBoy);
                RadioButton girl = findViewById(R.id.rdbGirl);
                String gender = boy.isChecked() ? "男性" : (girl.isChecked() ? "女性" : "");
                intent.putExtra("gender", gender);

                RadioGroup type = findViewById(R.id.rgType);
                int selectedId = type.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);
                String ticketType = selectedRadioButton.getText().toString();
                intent.putExtra("ticketType", ticketType);

                int price = 0;
                if (type.getCheckedRadioButtonId() == R.id.rdbAdult)
                    price = 500 * num;
                else if (type.getCheckedRadioButtonId() == R.id.rdbChild)
                    price = 250 * num;
                else
                    price = 400 * num;
                intent.putExtra("price", price);

                startActivity(intent);
            }
        });
    }
}

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String outputStr = "";
                EditText edtnum = findViewById(R.id.edtnum);
                String string2Send = edtnum.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("outputStr", string2Send);
                startActivity(intent);

                RadioButton boy = (RadioButton) findViewById(R.id.rdbBoy);
                RadioButton girl = (RadioButton) findViewById(R.id.rdbGirl);
                String gender = "";
                if (boy.isChecked())
                    outputStr += "男性\n";
                else if (girl.isChecked())
                    outputStr += "女性\n";

                RadioGroup type = (RadioGroup) findViewById(R.id.rgType);


                String ticketType = "";
                if (type.getCheckedRadioButtonId() == R.id.rdbAdult)
                    outputStr += "成人票\n";
                else if (type.getCheckedRadioButtonId() == R.id.rdbChild)
                    outputStr += "孩童票\n";
                else
                    outputStr += "學生票\n";


                int num = Integer.parseInt(edtnum.getText().toString());
                outputStr += num + "張\n";

                int price = 0;
                if (type.getCheckedRadioButtonId()  == R.id.rdbAdult)
                    price = 500;
                else if (type.getCheckedRadioButtonId()  == R.id.rdbChild)
                    price = 250;
                else
                    price = 400;

                int total = price * num;
                outputStr += "金額：" + total + "元";

                intent.putExtra("gender", gender); // 將性別添加到Intent中
                intent.putExtra("ticketType", ticketType); // 將票種添加到Intent中
                intent.putExtra("quantity", num); // 將張數添加到Intent中
                intent.putExtra("price", total); // 將價錢添加到Intent中
                startActivity(intent);



            }
        });
    }*/
