package com.miri.materialdesign.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.SeekBar;

/**
 * 〈一句话功能简述〉〈功能详细描述〉
 *
 * @author PengL, , 2015/11/30.
 */
public class CardViewActivity extends AppCompatActivity {
    CardView cardView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_view);
        cardView = (CardView) findViewById(R.id.card_view);

        SeekBar seek1 = (SeekBar) findViewById(R.id.seek1);
        SeekBar seek2 = (SeekBar) findViewById(R.id.seek2);

        seek1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    cardView.setCardElevation(i);//shadow
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seek2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    cardView.setRadius(i);//圆角大小设置
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
