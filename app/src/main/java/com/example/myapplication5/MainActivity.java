package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.KeyEvent;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    View view;
    ScrollView s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);
        view=(View)findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent m) {
                int action=m.getAction();
                float x=m.getX();
                float y=m.getY();

                if(action==MotionEvent.ACTION_DOWN){
                    textView.append(x+" : "+y+"눌림\n");
                }else if(action==MotionEvent.ACTION_MOVE){
                    textView.append(x+" : "+y+"움직임\n");
                }else if(action==MotionEvent.ACTION_UP){
                    textView.append(x+" : "+y+"손가락 뗌\n");
                }
                return false;
            }
        });

        //자동으로 스크롤 내려가도록
        final ScrollView scrollview = ((ScrollView) findViewById(R.id.s));

        scrollview.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                scrollview.post(new Runnable() {
                    public void run() {
                        scrollview.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });

    }//onCreate
}//class