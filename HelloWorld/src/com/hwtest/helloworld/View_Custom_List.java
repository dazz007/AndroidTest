package com.hwtest.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class View_Custom_List  extends Activity {

	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        ListView rozbudowana_lista = (ListView) findViewById(R.id.lv_prostalista);
	        String[] przykladowe_dane = {"Test 1", "Test 2", "Test 3", "Test 4", "Test 5", "Test 6", "Test 7", "Test 8", "Test 9"};
	        List_Custom_List adapter_listy = new List_Custom_List(this, przykladowe_dane);
	     
	        rozbudowana_lista.setAdapter(adapter_listy);
	    }


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
}
