package com.example.androiddashboard;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button gotolistofproduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gotolistofproduct = (Button) findViewById(R.id.tolistofproduct);
        gotolistofproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToListofProduct();
            }
        });
    }

    public void ToListofProduct()
    {
        Intent tolistofproductpage = new Intent(this, ListofProduct.class);
        startActivity(tolistofproductpage);
    }
}