package com.example.naw.f;


import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {



    private SlotMachine slotMachine;
    private Wheel wheel1;
    private Wheel wheel2;
    private Wheel wheel3;
    private ImageView symbol1;
    private ImageView symbol2;
    private ImageView symbol3;
    private ImageView wheel1Top;
    private ImageView wheel2Top;
    private ImageView wheel3Top;
    private ImageView wheel1Bottom;
    private ImageView wheel2Bottom;
    private ImageView wheel3Bottom;
    private Button spinButton;
    private AnimationDrawable animation1;
    private ImageView animation1Image;
    private AnimationDrawable animation2;
    private ImageView animation2Image;
    private AnimationDrawable animation3;
    private ImageView animation3Image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("FLUTUR");


        slotMachine = new SlotMachine(3);
        symbol1 = findViewById(R.id.imageSymbol1);
        symbol2 = findViewById(R.id.imageSymbol2);
        symbol3 = findViewById(R.id.imageSymbol3);
        wheel1Top = findViewById(R.id.wheel1TopImage);
        wheel2Top = findViewById(R.id.wheel2TopImage);
        wheel3Top = findViewById(R.id.wheel3TopImage);
        wheel1Bottom = findViewById(R.id.wheel1BottomImage);
        wheel2Bottom = findViewById(R.id.wheel2BottomImage);
        wheel3Bottom = findViewById(R.id.wheel3BottomImage);
        spinButton = findViewById(R.id.spinButton);

        ArrayList<Wheel> slots = slotMachine.getSlots();
        wheel1 = slots.get(0);
        wheel2 = slots.get(1);
        wheel3 = slots.get(2);

        animation1Image = findViewById(R.id.animation1);
        animation1Image.setBackgroundResource(R.drawable.wheel1animation);
        animation1 = (AnimationDrawable) animation1Image.getBackground();

        animation2Image = findViewById(R.id.animation2);
        animation2Image.setBackgroundResource(R.drawable.wheel2animation);
        animation2 = (AnimationDrawable) animation2Image.getBackground();

        animation3Image = findViewById(R.id.animation3);
        animation3Image.setBackgroundResource(R.drawable.wheel3animation);
        animation3 = (AnimationDrawable) animation3Image.getBackground();


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        spinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSpinButtonClicked(spinButton);
            }
        });



    }

    //ANIMATION FUNCTION

    public void startAnimation1(){

            animation1Image.setVisibility(View.VISIBLE);
            animation1.start();

    }

    public void clearAnimation1View(){
        animation1Image.setVisibility(View.INVISIBLE);
    }

    public void startAnimation2(){

            animation2Image.setVisibility(View.VISIBLE);
            animation2.start();

    }

    public void clearAnimation2View(){
        animation2Image.setVisibility(View.INVISIBLE);
    }

    public void startAnimation3(){

            animation3Image.setVisibility(View.VISIBLE);
            animation3.start();

    }

    public void clearAnimation3View(){
        animation3Image.setVisibility(View.INVISIBLE);
    }

    public void startSlotAnimations(){

        startAnimation1();
        startAnimation2();
        startAnimation3();
        spinButton.setVisibility(View.INVISIBLE);
    }

    public void clearSlotAnimations(){
        clearAnimation1View();
        clearAnimation2View();
        clearAnimation3View();
        spinButton.setVisibility(View.VISIBLE);
    }



    //SPIN FUNCTIONS

    public void onSpinButtonClicked(View button){
            spin();
            startSlotAnimations();
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable(){
                public void run(){
                    clearSlotAnimations();

                }
            }, 1300);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(),wheel1.getCurrentSymbol().name()+","+wheel2.getCurrentSymbol().name()+","+wheel3.getCurrentSymbol().name(),Toast.LENGTH_SHORT).show();

                }
            },1500);


        }


    public ArrayList<Symbols> spin(){
        final ArrayList<Symbols> newLine = slotMachine.spin();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                updateCurrentLine(newLine);
                updateTopLine();
                updateBottomLine();

            }
        }, 1300);
        return newLine;

    }

    public void updateCurrentLine(ArrayList<Symbols> newLine){
        ArrayList<String> lineImages = slotMachine.getLineImages(newLine);
        String image1 = lineImages.get(0);
        String image2 = lineImages.get(1);
        String image3 = lineImages.get(2);
        int idImage1 = getResources().getIdentifier(image1, "drawable", getPackageName());
        int idImage2 = getResources().getIdentifier(image2, "drawable", getPackageName());
        int idImage3 = getResources().getIdentifier(image3, "drawable", getPackageName());
        symbol1.setImageResource(idImage1);
        symbol2.setImageResource(idImage2);
        symbol3.setImageResource(idImage3);
    }

    public void updateTopLine(){
        ArrayList<Symbols> topLine = slotMachine.getTopLineSymbols();
        ArrayList<String> lineImages = slotMachine.getLineImages(topLine);
        String image1 = lineImages.get(0);
        String image2 = lineImages.get(1);
        String image3 = lineImages.get(2);
        int idImage1 = getResources().getIdentifier(image1, "drawable", getPackageName());
        int idImage2 = getResources().getIdentifier(image2, "drawable", getPackageName());
        int idImage3 = getResources().getIdentifier(image3, "drawable", getPackageName());
        wheel1Top.setImageResource(idImage1);
        wheel2Top.setImageResource(idImage2);
        wheel3Top.setImageResource(idImage3);
    }

    public void updateBottomLine(){
        ArrayList<Symbols> bottomLine = slotMachine.getBottomLineSymbols();
        ArrayList<String> lineImages = slotMachine.getLineImages(bottomLine);
        String image1 = lineImages.get(0);
        String image2 = lineImages.get(1);
        String image3 = lineImages.get(2);
        int idImage1 = getResources().getIdentifier(image1, "drawable", getPackageName());
        int idImage2 = getResources().getIdentifier(image2, "drawable", getPackageName());
        int idImage3 = getResources().getIdentifier(image3, "drawable", getPackageName());
        wheel1Bottom.setImageResource(idImage1);
        wheel2Bottom.setImageResource(idImage2);
        wheel3Bottom.setImageResource(idImage3);
    }

}
