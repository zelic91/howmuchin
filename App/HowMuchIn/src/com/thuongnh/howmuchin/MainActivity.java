package com.thuongnh.howmuchin;

import com.thuongnh.howmuchin.util.ResizeAnimation;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tvFrom;
	TextView tvTo;
	LinearLayout lFrom;
	LinearLayout lTo;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tvFrom 	= (TextView)findViewById(R.id.tvFrom);
        tvTo	= (TextView)findViewById(R.id.tvTo);
        
        lFrom	= (LinearLayout)findViewById(R.id.lFrom);
        lTo		= (LinearLayout)findViewById(R.id.lTo);
        
        int width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        
        final ResizeAnimation anim = new ResizeAnimation(lFrom, width, 0, width, 500);
        anim.setDuration(300);
        lFrom.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				lFrom.startAnimation(anim);
				
			}
		});
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
