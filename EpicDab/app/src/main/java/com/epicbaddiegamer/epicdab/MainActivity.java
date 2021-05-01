package com.epicbaddiegamer.epicdab;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private static ImageView imgview;
    private  Button left_right_dab;
    private int current_image_alt=0;
    private int change_image=0;
    int[][] images={

            {R.drawable.dab_right, R.drawable.dab_left},
            {R.drawable.monalisa_left, R.drawable.monalisa_right},
            {R.drawable.squidward_left, R.drawable.squidward_right},
            {R.drawable.low_dab_left, R.drawable.low_dab_right}

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dab_buttonclick();
        change_dabbing_char();
    }


    public void dab_buttonclick()
    {
        imgview=(ImageView)findViewById(R.id.emoji);
        left_right_dab=(Button)findViewById(R.id.dabButton);

        left_right_dab.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        current_image_alt++;
                        current_image_alt=current_image_alt % 2;
                        Log.i("MyApp","currentimg,left right");
                        imgview.setImageResource(images[change_image][current_image_alt]);
                    }
                }
        );
    }
    public void change_dabbing_char()
    {
        imgview=(ImageView)findViewById(R.id.emoji);
        Button change_char = (Button) findViewById(R.id.DiffDab);

        change_char.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        change_image++;
                        change_image=change_image % images.length;
                        Log.i("App", "change char");
                        imgview.setImageResource(images[change_image][current_image_alt]);
                    }
                }
        );
    }


}