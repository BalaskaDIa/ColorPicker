package com.example.colorpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int SeekBarR, SeekBarG, SeekBarB;
    SeekBar red_Bar, green_Bar, blue_Bar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.vColor);
        red_Bar = findViewById(R.id.sRed);
        green_Bar = findViewById(R.id.sGreen);
        blue_Bar = findViewById(R.id.sBlue);

        ColorUpdate();

        red_Bar.setOnSeekBarChangeListener(seekBarChangeListener);
        green_Bar.setOnSeekBarChangeListener(seekBarChangeListener);
        blue_Bar.setOnSeekBarChangeListener(seekBarChangeListener);
    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean b) {
            ColorUpdate();
        }

        @Override
        public void onStartTrackingTouch(android.widget.SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(android.widget.SeekBar seekBar) {

        }
    };

    private void ColorUpdate(){
        SeekBarR = red_Bar.getProgress();
        SeekBarG = green_Bar.getProgress();
        SeekBarB = blue_Bar.getProgress();

        if (SeekBarR < 150 && SeekBarG < 150 && SeekBarB < 150){
            textView.setTextColor(Color.WHITE);
        } else {
            textView.setTextColor(Color.BLACK);
        }

        textView.setBackgroundColor(
                0xff000000
                        + SeekBarR * 0x100000
                        + SeekBarG * 0x100
                        + SeekBarB
        );

        textView.setText(SeekBarR + SeekBarG + SeekBarB);
    }
}