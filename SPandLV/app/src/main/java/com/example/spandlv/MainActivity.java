package com.example.spandlv;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private String[] food,hamburger;

    private Spinner spfood,sphamburger;
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        food = getResources().getStringArray(R.array.food);
        hamburger = getResources().getStringArray(R.array.hamburger);
        lv = (ListView)  findViewById(R.id.listview);

        spfood = (Spinner) findViewById(R.id.spinner);
        //sphamburger = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adpfood = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, food);
        ArrayAdapter<String> adphamburger = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, hamburger);

        spfood.setAdapter(adpfood);
        //sphamburger.setAdapter(adphamburger);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView output = (TextView) findViewById(R.id.mainoutput);
                output.setText(hamburger[position]);


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        TextView output = (TextView) findViewById(R.id.mainoutput);
        TextView output1 = (TextView) findViewById(R.id.sidedishOutput);
        TextView output2 = (TextView) findViewById(R.id.drinkOutput);
        int itemId = item.getItemId();
        if(itemId == R.id.cancel){
            output.setText("請選擇");
            output1.setText("請選擇");
            output2.setText("請選擇");
        }

        return super.onOptionsItemSelected(item);
    }

}