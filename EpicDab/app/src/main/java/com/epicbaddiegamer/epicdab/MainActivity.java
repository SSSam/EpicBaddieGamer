package com.epicbaddiegamer.epicdab;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private static ImageView imgview;
    private static Button buttonsbm;
    private int current_image;
    int[] images={R.drawable.emoji_right, R.drawable.emoji_left, R.drawable.low_dab_right, R.drawable.low_dab_left, R.drawable.panda_right, R.drawable.panda_left, R.drawable.squidward_right, R.drawable.squidward_left};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonclick();

    }
    public void buttonclick()
    {
        imgview=(ImageView)findViewById(R.id.emoji);
        buttonsbm=(Button)findViewById(R.id.dabButton);
        buttonsbm.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        current_image++;
                        current_image=current_image % images.length;
                        imgview.setImageResource(images[current_image]);
                    }
                }

        );
    }

}