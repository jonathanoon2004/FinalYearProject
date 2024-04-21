package com.example.finalyearprojectdemo3;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HelpPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_page);

        TextView text1 = findViewById(R.id.text1);
        TextView text2 = findViewById(R.id.text2);
        TextView text3 = findViewById(R.id.text3);
        TextView text4 = findViewById(R.id.text4);
        TextView text5 = findViewById(R.id.text5);

        ImageView button1 = findViewById(R.id.button1);
        ImageView button2 = findViewById(R.id.button2);
        ImageView button3 = findViewById(R.id.button3);
        ImageView button4 = findViewById(R.id.button4);
        ImageView button5 = findViewById(R.id.button5);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (text1.getVisibility() == View.GONE){
                    text1.setVisibility(View.VISIBLE);
                    button1.setImageResource(R.drawable.ic_arrow_up);
                    text2.setVisibility(View.GONE);
                    button2.setImageResource(R.drawable.ic_arrow_down);
                    text3.setVisibility(View.GONE);
                    button3.setImageResource(R.drawable.ic_arrow_down);
                    text4.setVisibility(View.GONE);
                    button4.setImageResource(R.drawable.ic_arrow_down);
                    text5.setVisibility(View.GONE);
                    button5.setImageResource(R.drawable.ic_arrow_down);
                } else {
                    text1.setVisibility(View.GONE);
                    button1.setImageResource(R.drawable.ic_arrow_down);
                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (text2.getVisibility() == View.GONE){
                    text2.setVisibility(View.VISIBLE);
                    button2.setImageResource(R.drawable.ic_arrow_up);
                    text1.setVisibility(View.GONE);
                    button1.setImageResource(R.drawable.ic_arrow_down);
                    text3.setVisibility(View.GONE);
                    button3.setImageResource(R.drawable.ic_arrow_down);
                    text4.setVisibility(View.GONE);
                    button4.setImageResource(R.drawable.ic_arrow_down);
                    text5.setVisibility(View.GONE);
                    button5.setImageResource(R.drawable.ic_arrow_down);
                } else {
                    text2.setVisibility(View.GONE);
                    button2.setImageResource(R.drawable.ic_arrow_down);
                }

            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (text3.getVisibility() == View.GONE){
                    text3.setVisibility(View.VISIBLE);
                    button3.setImageResource(R.drawable.ic_arrow_up);
                    text1.setVisibility(View.GONE);
                    button1.setImageResource(R.drawable.ic_arrow_down);
                    text2.setVisibility(View.GONE);
                    button2.setImageResource(R.drawable.ic_arrow_down);
                    text4.setVisibility(View.GONE);
                    button4.setImageResource(R.drawable.ic_arrow_down);
                    text5.setVisibility(View.GONE);
                    button5.setImageResource(R.drawable.ic_arrow_down);
                } else {
                    text3.setVisibility(View.GONE);
                    button3.setImageResource(R.drawable.ic_arrow_down);
                }

            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (text4.getVisibility() == View.GONE){
                    text4.setVisibility(View.VISIBLE);
                    button4.setImageResource(R.drawable.ic_arrow_up);
                    text1.setVisibility(View.GONE);
                    button1.setImageResource(R.drawable.ic_arrow_down);
                    text2.setVisibility(View.GONE);
                    button2.setImageResource(R.drawable.ic_arrow_down);
                    text3.setVisibility(View.GONE);
                    button3.setImageResource(R.drawable.ic_arrow_down);
                    text5.setVisibility(View.GONE);
                    button5.setImageResource(R.drawable.ic_arrow_down);
                } else {
                    text4.setVisibility(View.GONE);
                    button4.setImageResource(R.drawable.ic_arrow_down);
                }

            }
        });

        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (text5.getVisibility() == View.GONE){
                    text5.setVisibility(View.VISIBLE);
                    button5.setImageResource(R.drawable.ic_arrow_up);
                    text1.setVisibility(View.GONE);
                    button1.setImageResource(R.drawable.ic_arrow_down);
                    text2.setVisibility(View.GONE);
                    button2.setImageResource(R.drawable.ic_arrow_down);
                    text3.setVisibility(View.GONE);
                    button3.setImageResource(R.drawable.ic_arrow_down);
                    text4.setVisibility(View.GONE);
                    button4.setImageResource(R.drawable.ic_arrow_down);
                } else {
                    text5.setVisibility(View.GONE);
                    button5.setImageResource(R.drawable.ic_arrow_down);
                }

            }
        });

    }
}
