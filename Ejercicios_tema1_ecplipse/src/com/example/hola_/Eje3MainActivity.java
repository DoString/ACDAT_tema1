package com.example.hola_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Eje3MainActivity extends Activity implements OnClickListener {
	private EditText url;
	private Button navegar;
	private Intent i;
	private final static String DATO = "URL";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eje3_main);
		
		this.navegar = (Button) findViewById(R.id.buttonNavegar);
		this.navegar.setOnClickListener(this);
		this.url = (EditText) findViewById(R.id.editTextURL);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.eje3_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		if (v == navegar){
			this.i = new Intent(this, WebMainActivity.class);
			this.i.putExtra(DATO, this.url.getText().toString());
			this.startActivity(i);
		}
	}
}
