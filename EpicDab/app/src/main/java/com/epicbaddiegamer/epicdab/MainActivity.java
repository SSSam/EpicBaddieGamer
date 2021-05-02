package com.epicbaddiegamer.epicdab;

import android.os.Bundle;

import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private ImageView imgView;
    private int current_image_alt = 1;
    private int change_image = 0;
    private int change = 0;
    private int image_check = 1;
    public int clickCount = 0;
    private TextView countTextBox;

    int[][] images = {
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
        dabButtonClick();
        change_dabbing_char();
        change_dabbing_char1();
    }

    public void dabButtonClick()
    {
        Button left_right_dab;
        imgView = findViewById(R.id.dab);
        left_right_dab = findViewById(R.id.dabButton);

        left_right_dab.setOnClickListener(
                view -> {
                    clickCount++;
                    image_check=clickCount/50+1;
                    countTextBox=findViewById(R.id.textView);
                    String clicks = String.valueOf(clickCount);
                    countTextBox.setText("Cringe Counter: " + clicks);

                    current_image_alt++;
                    current_image_alt=current_image_alt % 2;
                    Log.i("MyApp","currentImg,left right");
                    imgView.setImageResource(images[change][current_image_alt]);

                    if (clickCount % 50 == 0 && clickCount != 0) {
                        Toast toast = Toast.makeText(getApplicationContext(), "New Baddie Unlocked !!!", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,0,480);
                        toast.show();
                    }
                }
        );
    }

    public void change_dabbing_char()
    {
        imgView = findViewById(R.id.dab);
        Button change_char = findViewById(R.id.DiffDab);

        change_char.setOnClickListener(
                view -> {
                    change_image++;
                    change= (change_image % image_check) % images.length;
                    Log.i("App", "change char");
                    imgView.setImageResource(images[change][current_image_alt]);
                }
        );
    }
    public void change_dabbing_char1()
    {
        imgView = findViewById(R.id.dab);
        Button change_char1 = findViewById(R.id.DiffDab1);

        change_char1.setOnClickListener(
                view -> {
                    if (change_image >0) {
                        change_image--;
                    }
                    change= (change_image % image_check) % images.length ;
                    Log.i("App", "change char");
                    imgView.setImageResource(images[change][current_image_alt]);
                }
        );
    }

}