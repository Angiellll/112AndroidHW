package com.example.raddiobutton1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayStringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_display_string);

        // 獲取上一頁傳遞過來的資訊
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String output = extras.getString("output");

            // 顯示資訊
            TextView textView = findViewById(R.id.txv);
            textView.setText(output);
        }
    }
}
