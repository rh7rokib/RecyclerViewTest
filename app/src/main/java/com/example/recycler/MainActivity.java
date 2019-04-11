package com.example.recycler;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String []myData = {"Dhaka", "Khulna", "Sylhet"};
    String []myData1 = {"Dhaka_1", "Khulna_1", "Sylhet_1"};
    int []myData2 = {R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.reycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new Myadapter());

    }
    public class Myadapter extends RecyclerView.Adapter{

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(MainActivity.this).inflate(R.layout.list_item, viewGroup, false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            ((MyViewHolder)viewHolder).nameText.setText(myData[i]);
            ((MyViewHolder)viewHolder).descText.setText(myData1[i]);
            ((MyViewHolder)viewHolder).iv.setImageResource(myData2[i]);


        }

        @Override
        public int getItemCount() {
            return myData.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView nameText;
            TextView descText;
            ImageView iv;

            public MyViewHolder(@NonNull View itemView) {

                super(itemView);
                nameText = itemView.findViewById(R.id.test_1);
                descText = itemView.findViewById(R.id.test_2);
            }
        }
    }
}
