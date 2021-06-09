package com.example.brodie.freemaccas;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String selectedItem = intent.getStringExtra("item");

        final ImageView image_prize = (ImageView)findViewById(R.id.iv_prize);
        if(selectedItem.equals(getString(R.string.applepie)))
            image_prize.setImageResource(R.drawable.applepie);
        else if(selectedItem.equals(getString(R.string.baconegg)))
            image_prize.setImageResource(R.drawable.baconandegg);
        else if(selectedItem.equals(getString(R.string.bigmac)))
            image_prize.setImageResource(R.drawable.bigmac);
        else if(selectedItem.equals(getString(R.string.cheeseburger)))
            image_prize.setImageResource(R.drawable.cheeseburger);
        else if(selectedItem.equals(getString(R.string.frozendrink)))
            image_prize.setImageResource(R.drawable.frozendrink);
        else if(selectedItem.equals(getString(R.string.fruitbag)))
            image_prize.setImageResource(R.drawable.fruitbag);
        else if(selectedItem.equals(getString(R.string.hamandcheese)))
            image_prize.setImageResource(R.drawable.hamandcheese);
        else if(selectedItem.equals(getString(R.string.hamburger)))
            image_prize.setImageResource(R.drawable.hamburger);
        else if(selectedItem.equals(getString(R.string.mcchicken)))
            image_prize.setImageResource(R.drawable.mcchicken);
        else if(selectedItem.equals(getString(R.string.quarterpounder)))
            image_prize.setImageResource(R.drawable.quarterpounder);
        else if(selectedItem.equals(getString(R.string.sausageegg)))
            image_prize.setImageResource(R.drawable.sausageandegg);
        else if(selectedItem.equals(getString(R.string.sausagemcmuffin)))
            image_prize.setImageResource(R.drawable.sausagemcmuffin);
        else if(selectedItem.equals(getString(R.string.smalldrink)))
            image_prize.setImageResource(R.drawable.smalldrink);
        else if(selectedItem.equals(getString(R.string.smallfries)))
            image_prize.setImageResource(R.drawable.smallfries);
        else if(selectedItem.equals(getString(R.string.smallcoffee)))
            image_prize.setImageResource(R.drawable.smallmccafecoffee);
        else if(selectedItem.equals(getString(R.string.smalltea)))
            image_prize.setImageResource(R.drawable.smallmccafetea);
        else if(selectedItem.equals(getString(R.string.smallsundae)))
            image_prize.setImageResource(R.drawable.smallsundae);

        LinearLayout layout = (LinearLayout)findViewById(R.id.ring_container);
        ProgressBar pb = (ProgressBar) layout.findViewById(R.id.circleBar);

        Animation an = new RotateAnimation(0.0f, 270.0f, 250f, 273f);
        an.setFillAfter(true);
        pb.startAnimation(an);

        final TextView timer_sec = (TextView)findViewById(R.id.tv_timer);
        Typeface timerFont = Typeface.createFromAsset(getAssets(), "fonts/ItcKabel-Bold.ttf");
        timerFont.isBold();
        timer_sec.setTypeface(timerFont);

        Calendar currTime = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd MM yy h:mma");

        final TextView sys_time = (TextView)findViewById(R.id.tv_systime);
        sys_time.setTypeface(timerFont);
        sys_time.setText(format.format(currTime.getTime()));

        new CountDownTimer(59000, 1000) {
            int mins = 2;
            LinearLayout layout = (LinearLayout)findViewById(R.id.ring_container);
            ProgressBar pb = (ProgressBar) layout.findViewById(R.id.circleBar);

            public void onTick(long millsUntilFinished) {
                String mills;
                pb.incrementProgressBy(1);
                if(millsUntilFinished/1000 < 10)
                {
                    mills = "0"+Long.toString(millsUntilFinished/1000);
                }
                else mills = Long.toString(millsUntilFinished/1000);

                timer_sec.setText(mins+":"+mills);
            }

            public void onFinish()
            {
                timer_sec.setText(mins+":00");
                if(mins == 2 || mins == 1)
                {
                    mins--;
                    start();
                }
                else
                    timer_sec.setText("0:00");
            }
        }.start();
    }
    public void redeemItem(View v)
    {
        Button button = (Button)findViewById(v.getId());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quit = new Intent(Intent.ACTION_MAIN);
                quit.addCategory(Intent.CATEGORY_HOME);
                startActivity(quit);
            }
        });
        final ImageView image_prize = (ImageView)findViewById(R.id.iv_prize);

        Intent intent = getIntent();
        String selectedItem = intent.getStringExtra("item");
        if(selectedItem.equals(getString(R.string.applepie)))
            image_prize.setImageResource(R.drawable.applepie_redeemed);
        else if(selectedItem.equals(getString(R.string.baconegg)))
            image_prize.setImageResource(R.drawable.baconandegg_redeemed);
        else if(selectedItem.equals(getString(R.string.bigmac)))
            image_prize.setImageResource(R.drawable.bigmac_redeemed);
        else if(selectedItem.equals(getString(R.string.cheeseburger)))
            image_prize.setImageResource(R.drawable.cheeseburger_redeemed);
        else if(selectedItem.equals(getString(R.string.frozendrink)))
            image_prize.setImageResource(R.drawable.frozendrink_redeemed);
        else if(selectedItem.equals(getString(R.string.fruitbag)))
            image_prize.setImageResource(R.drawable.fruitbag_redeemed);
        else if(selectedItem.equals(getString(R.string.hamandcheese)))
            image_prize.setImageResource(R.drawable.hamandcheese_redeemed);
        else if(selectedItem.equals(getString(R.string.hamburger)))
            image_prize.setImageResource(R.drawable.hamburger_redeemed);
        else if(selectedItem.equals(getString(R.string.mcchicken)))
            image_prize.setImageResource(R.drawable.mcchicken_redeemed);
        else if(selectedItem.equals(getString(R.string.quarterpounder)))
            image_prize.setImageResource(R.drawable.quarterpounder_redeemed);
        else if(selectedItem.equals(getString(R.string.sausageegg)))
            image_prize.setImageResource(R.drawable.sausageandegg_redeemed);
        else if(selectedItem.equals(getString(R.string.sausagemcmuffin)))
            image_prize.setImageResource(R.drawable.sausagemcmuffin_redeemed);
        else if(selectedItem.equals(getString(R.string.smalldrink)))
            image_prize.setImageResource(R.drawable.smalldrink_redeemed);
        else if(selectedItem.equals(getString(R.string.smallfries)))
            image_prize.setImageResource(R.drawable.smallfries_redeemed);
        else if(selectedItem.equals(getString(R.string.smallcoffee)))
            image_prize.setImageResource(R.drawable.smallmccafecoffee_redeemed);
        else if(selectedItem.equals(getString(R.string.smalltea)))
            image_prize.setImageResource(R.drawable.smallmccafetea_redeemed);
        else if(selectedItem.equals(getString(R.string.smallsundae))) {
            image_prize.setImageResource(R.drawable.smallsundae_redeemed);
        }

        LinearLayout layout = (LinearLayout)findViewById(R.id.ring_container);
        ProgressBar pb = (ProgressBar) layout.findViewById(R.id.circleBar);
        pb.setVisibility(View.GONE);

        final TextView timer_sec = (TextView)findViewById(R.id.tv_timer);
        timer_sec.setVisibility(View.INVISIBLE);

        final TextView sys_time = (TextView)findViewById(R.id.tv_systime);

        //timer_sec.setTypeface(timerFont);
        Calendar currTime = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd MM yy h:mma");
        sys_time.setText(format.format(currTime.getTime()));
        // ViewGroup.LayoutParams newParams = sys_time.getLayoutParams();
        RelativeLayout.LayoutParams newParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        newParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        sys_time.setLayoutParams(newParams);
        Typeface timerFont = Typeface.createFromAsset(getAssets(), "fonts/ItcKabel-Bold.ttf");
        sys_time.setTypeface(timerFont);
        sys_time.setTextColor(Color.BLACK);
        sys_time.setTextSize(7);
        sys_time.setPadding(510,70,0,0);
    }
}