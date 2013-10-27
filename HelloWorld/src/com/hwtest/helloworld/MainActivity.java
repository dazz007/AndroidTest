package com.hwtest.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String[] elementy_listy = { "W³asna lista", "Druga lista", "Scrool View" };
		ListView prosta_lista = (ListView) findViewById(R.id.lv_prostalista);

		ArrayAdapter adapter_listy = new ArrayAdapter(this,
				android.R.layout.simple_list_item_1, elementy_listy);
		prosta_lista.setAdapter(adapter_listy);

		prosta_lista.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				Intent start = null;
				switch (pos) {
				case 0:
					start = new Intent(MainActivity.this,
							View_Custom_List.class);
					break;
				case 1:
					start = new Intent(MainActivity.this,
							View_Listener_Click.class);
					break;
				case 2:
					start = new Intent(MainActivity.this,
							View_Scroll.class);
				}
				startActivity(start);
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
