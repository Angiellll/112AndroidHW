package com.example.raddiobutton1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        // 宣告所有需要的元件
        RadioGroup genderGroup = findViewById(R.id.rgGender);
        RadioGroup ticketGroup = findViewById(R.id.rgType);
        EditText numEditText = findViewById(R.id.num);
        TextView outputTextView = findViewById(R.id.lblOutput);

        // 監聽性別選擇
        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                updateOutput(outputTextView, genderGroup, ticketGroup, numEditText);
            }
        });

        // 監聽票種選擇
        ticketGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                updateOutput(outputTextView, genderGroup, ticketGroup, numEditText);
            }
        });

        // 監聽填寫張數
        numEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    updateOutput(outputTextView, genderGroup, ticketGroup, numEditText);
                }
            }
        });

        // 監聽按鈕
        Button confirmButton = findViewById(R.id.button);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 獲取選擇的性別、票種和填寫的張數
                RadioButton selectedGender = findViewById(genderGroup.getCheckedRadioButtonId());
                String gender = selectedGender.getText().toString();
                RadioButton selectedTicket = findViewById(ticketGroup.getCheckedRadioButtonId());
                String ticketType = selectedTicket.getText().toString();
                String numString = numEditText.getText().toString();

                int numTickets;
                try {
                    numTickets = Integer.parseInt(numString);
                } catch (NumberFormatException e) {
                    numTickets = 0;
                }

                // 計算總價
                int totalPrice;
                if (ticketType.equals(getString(R.string.rdbAdult))) {
                    totalPrice = numTickets * 500;
                } else if (ticketType.equals(getString(R.string.rdbChild))) {
                    totalPrice = numTickets * 250;
                } else if (ticketType.equals(getString(R.string.rdbStudent))) {
                    totalPrice = numTickets * 400;
                } else {
                    totalPrice = 0; // 其他情況下總價為0
                }

                // 顯示結果
                String output = getString(R.string.gender) + gender + "\n" +
                        getString(R.string.ticket_type) + ticketType + "\n" +
                        getString(R.string.num_tickets) + numTickets + getString(R.string.tickets) + "\n" +
                        getString(R.string.total_price) + totalPrice;
                outputTextView.setText(output);

                // 跳轉到下一頁
                Intent intent = new Intent(MainActivity.this, DisplayStringActivity.class);
                intent.putExtra("output", output);
                startActivity(intent);
            }
        });
    }

    // 更新 lblOutput
    private void updateOutput(TextView outputTextView, RadioGroup genderGroup, RadioGroup ticketGroup, EditText numEditText) {
        RadioButton selectedGender = findViewById(genderGroup.getCheckedRadioButtonId());
        String gender = selectedGender != null ? selectedGender.getText().toString() : "";

        RadioButton selectedTicket = findViewById(ticketGroup.getCheckedRadioButtonId());
        String ticketType = selectedTicket != null ? selectedTicket.getText().toString() : "";

        String numString = numEditText.getText().toString();
        int numTickets;
        try {
            numTickets = Integer.parseInt(numString);
        } catch (NumberFormatException e) {
            numTickets = 0;
        }

        int totalPrice;
        if (ticketType.equals(getString(R.string.rdbAdult))) {
            totalPrice = numTickets * 500;
        } else if (ticketType.equals(getString(R.string.rdbChild))) {
            totalPrice = numTickets * 250;
        } else if (ticketType.equals(getString(R.string.rdbStudent))) {
            totalPrice = numTickets * 400;
        } else {
            totalPrice = 0; // 其他情況下總價為0
        }

        // 顯示更新的結果
        String output = getString(R.string.gender) + gender + "\n" +
                getString(R.string.ticket_type) + ticketType + "\n" +
                getString(R.string.num_tickets) + numTickets + getString(R.string.tickets) + "\n" +
                getString(R.string.total_price) + totalPrice;
        outputTextView.setText(output);
    }
}