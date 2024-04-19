package com.example.raddiobutton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.layout_main2);

        TextView txvGender = findViewById(R.id.txvGender);
        TextView txvTicketType = findViewById(R.id.txvTicketType);
        TextView txvQuantity = findViewById(R.id.txvQuantity);
        TextView txvPrice = findViewById(R.id.txvPrice);

        Intent intent = getIntent();
        String gender = intent.getStringExtra("gender");
        String ticketType = intent.getStringExtra("ticketType");
        int quantity = intent.getIntExtra("quantity", 0);
        int price = intent.getIntExtra("price", 0);

        // 在TextView中顯示性別、票種、張數和價錢
        txvGender.setText(gender);
        txvTicketType.setText(ticketType);
        txvQuantity.setText(quantity + "張");
        txvPrice.setText("金額: " + price);
    }
}