package com.example.androiddashboard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ListofProduct extends AppCompatActivity {

    ListView listView;
    Button returntodashboard;
    String mTitle[] = {"Phở Hà Nội", "Giò cháo quẩy", "Nem rán Hà Nội"};
    String mPrice[] = {"22nd", "10nd", "50nd"};
    int images[] = {R.drawable.hanoipho, R.drawable.giochaoquay, R.drawable.nemranhn};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listof_product);
        listView = findViewById(R.id.ProductView);
        MyAdapter adapter = new MyAdapter(this, mTitle, mPrice, images);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Toast.makeText(ListofProduct.this, "22nd", Toast.LENGTH_SHORT).show();
                }

                if (i == 0) {
                    Toast.makeText(ListofProduct.this, "10nd", Toast.LENGTH_SHORT).show();
                }

                if (i == 0) {
                    Toast.makeText(ListofProduct.this, "50nd", Toast.LENGTH_SHORT).show();
                }
            }
        });
        returntodashboard = (Button) findViewById(R.id.returnbtn);
        returntodashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    OpenDashboardpage();
            }
        });
    }

    public void OpenDashboardpage()
    {
        Intent toDashboardpage = new Intent(this, MainActivity.class);
        startActivity(toDashboardpage);
    }

    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        String rtitle[];
        String mprice[];
        int mimg[];
        MyAdapter(Context c, String rtitle[], String mprice[], int mimg[])
        {
            super(c, R.layout.row, R.id.titletxt, rtitle);
            this.context = c;
            this.rtitle = rtitle;
            this.mprice = mprice;
            this.mimg = mimg;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView imgs = row.findViewById(R.id.imageView);
            TextView titles = row.findViewById(R.id.titletxt);
            TextView prices = row.findViewById(R.id.pricetxt);

            imgs.setImageResource(mimg[position]);
            titles.setText(rtitle[position]);
            prices.setText(mprice[position]);

            return row;
        }
    }
}

