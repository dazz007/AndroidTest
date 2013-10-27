package com.hwtest.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class View_Listener_Click extends Activity implements OnClickListener{
	TextView text;
    Button button;
    ImageView image;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        
        setContentView(R.layout.view_listener_click);
         
        text = (TextView) findViewById(R.id.tv_click_listener);
        button = (Button) findViewById(R.id.bt_click_listener);
        image = (ImageView) findViewById(R.id.iv_click_listener);
        
        text.setOnClickListener(this);
        button.setOnClickListener(this);
        
        image.setOnClickListener(new OnClickListener() {
            
            public void onClick(View v) {
                v.setVisibility(View.GONE);
            }
            
        });
	}
	
	public void onClick(View v) {
		 
	    switch (v.getId()) {
	    case R.id.tv_click_listener:
	        text.setText("Test");
	        break;
	    case R.id.bt_click_listener:
	        Toast.makeText(this, "Klikn¹³eœ przycisk!", Toast.LENGTH_SHORT).show();
	        break;
	    }
	}

}
