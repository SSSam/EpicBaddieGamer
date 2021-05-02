package com.epicbaddiegamer.epicdab;

import android.media.MediaPlayer;
import android.os.Bundle;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private static ImageView imgview;
    private  Button left_right_dab;
    private int current_image_alt = 1;
    private int change_image = 0;
    private int change = 0;
    private int image_check = 1;
    public int clickCount = 0;
    private TextView countTextBox;
    int[][] images={
        {R.drawable.emoji_left, R.drawable.emoji_right},
        {R.drawable.panda_left, R.drawable.panda_right},
        {R.drawable.penguin_left, R.drawable.penguin_right},
        {R.drawable.monalisa_left, R.drawable.monalisa_right},
        {R.drawable.fortnite_left, R.drawable.fortnite_right},
        {R.drawable.minecraft_left, R.drawable.minecraft_right},
        {R.drawable.squidward_left, R.drawable.squidward_right},
        {R.drawable.low_dab_left, R.drawable.low_dab_right},
        {R.drawable.shrek_left, R.drawable.shrek_right},
        {R.drawable.waluigi_left, R.drawable.waluigi_right},
        {R.drawable.thanos_left, R.drawable.thanos_right}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dab_buttonclick();
        change_dabbing_char();
        change_dabbing_char1();

    }
    public void dab_buttonclick()
    {
        imgview=(ImageView)findViewById(R.id.dab);
        left_right_dab=(Button)findViewById(R.id.dabButton);

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.baddie_unlocked);
        Toast toast = Toast.makeText(getApplicationContext(), "New Baddie Unlocked !!!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,480);

        left_right_dab.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View view){

                        clickCount++;
                        image_check=clickCount/50+1;
                        countTextBox=findViewById(R.id.textView);
                        String clicks = String.valueOf(clickCount);
                        countTextBox.setText("Cringe Counter: " + clicks);

                        current_image_alt++;
                        current_image_alt=current_image_alt % 2;
                        Log.i("MyApp","currentimg,left right");
                        imgview.setImageResource(images[change][current_image_alt]);
                        if (clickCount % 50 == 0 && (clickCount / 50) <= images.length && clickCount != 0) {
                            toast.show();
                            mp.start();
                        }
                    }
                }
        );
    }

    public void change_dabbing_char()
    {
        imgview=(ImageView)findViewById(R.id.dab);
        Button change_char = (Button) findViewById(R.id.DiffDab);

        change_char.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view){

                        change_image++;
                        change= (change_image % image_check) % images.length;
                        Log.i("App", "change char");
                        imgview.setImageResource(images[change][current_image_alt]);
                    }
                }
        );
    }
    public void change_dabbing_char1()
    {
        imgview=(ImageView)findViewById(R.id.dab);
        Button change_char1 = (Button) findViewById(R.id.DiffDab1);

        change_char1.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        if (change_image >0) {
                            change_image--;
                        }
                        change= (change_image % image_check) % images.length ;
                        Log.i("App", "change char");
                        imgview.setImageResource(images[change][current_image_alt]);
                    }
                }
        );
    }
}