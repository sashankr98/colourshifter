package com.example.sashank.colourshifter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RelativeLayout rLayout;

    Button gButton;
    TextView gText;
    String gString;
    int g = 0;

    Button rButton;
    TextView rText;
    String rString;
    int r = 0;

    Button bButton;
    TextView bText;
    String bString;
    int b = 0;

    Button resetButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rLayout = (RelativeLayout)findViewById(R.id.rLayout);

        gButton = (Button)findViewById(R.id.gButton);
        gButton.setOnClickListener(this);
        gText = (TextView)findViewById(R.id.gText);
        gString = getString(R.string.greenText) + Integer.toString(g);
        gText.setText(gString);

        rButton = (Button)findViewById(R.id.rButton);
        rButton.setOnClickListener(this);
        rText = (TextView)findViewById(R.id.rText);
        rString = getString(R.string.redText) + Integer.toString(r);
        rText.setText(rString);

        bButton = (Button)findViewById(R.id.bButton);
        bButton.setOnClickListener(this);
        bText = (TextView)findViewById(R.id.bText);
        bString = getString(R.string.blueText) + Integer.toString(g);
        bText.setText(bString);

        resetButton = (Button)findViewById(R.id.resetButton);
        resetButton.setOnClickListener(this);
        rLayout.setBackgroundColor(Color.rgb(r,g,b));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.gButton:
                switch (g) {
                    case 255:
                        g = 32;
                        break;
                    case 224:
                        g = 0;
                        break;
                    default:
                        g += 32;
                        break;
                }
                gString = getString(R.string.greenText) + Integer.toString(g);
                gText.setText(gString);
                break;
            case R.id.rButton:
                switch (r) {
                    case 255:
                        r = 32;
                        break;
                    case 224:
                        r = 0;
                        break;
                    default:
                        r += 32;
                        break;
                }
                rString = getString(R.string.redText) + Integer.toString(r);
                rText.setText(rString);
                break;
            case R.id.bButton:
                switch (b) {
                    case 255:
                        b = 32;
                        break;
                    case 224:
                        b = 0;
                        break;
                    default:
                        b += 32;
                        break;
                }
                bString = getString(R.string.blueText) + Integer.toString(b);
                bText.setText(bString);
                break;
            case R.id.resetButton:
                r = 0;
                g = 0;
                b = 0;

                rString = getString(R.string.redText) + Integer.toString(r);
                rText.setText(rString);
                gString = getString(R.string.greenText) + Integer.toString(g);
                gText.setText(gString);
                bString = getString(R.string.blueText) + Integer.toString(b);
                bText.setText(bString);
                break;
            }
        rLayout.setBackgroundColor(Color.rgb(r,g,b));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("r",r);
        outState.putInt("g",g);
        outState.putInt("b",b);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        r = savedInstanceState.getInt("r");
        g = savedInstanceState.getInt("g");
        b = savedInstanceState.getInt("b");
        rLayout.setBackgroundColor(Color.rgb(r,g,b));

        rString = getString(R.string.redText) + Integer.toString(r);
        rText.setText(rString);
        gString = getString(R.string.greenText) + Integer.toString(g);
        gText.setText(gString);
        bString = getString(R.string.blueText) + Integer.toString(b);
        bText.setText(bString);
    }
}
