package com.example.brodie.freemaccas;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Brodie on 14-Sep-17.
 */

public class MainMenu extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void menuClick(View menuItem)
    {
        Button button = (Button)findViewById(menuItem.getId());
        String selectedItem = button.getText().toString();
        Intent startPrize = new Intent(this, MainActivity.class);
        startPrize.putExtra("item",selectedItem);
        startActivity(startPrize);
    }
}
