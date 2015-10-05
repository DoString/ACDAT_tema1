package com.example.hola_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	private final String DATO = "saludo";
	private Button eje1;
	private Button eje2;
	private Button eje3;
	private Button eje4;
	private Button eje5;
	
	private Intent i;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Buscar botones:
		Button[] botones = { 
				eje1 = (Button) findViewById(R.id.button1),
				eje2 = (Button) findViewById(R.id.button2),
				eje3 = (Button) findViewById(R.id.button3),
				eje4 = (Button) findViewById(R.id.button4),
				eje5 = (Button) findViewById(R.id.button5) 
				};
		
		for (Button boton : botones) {
			boton.setOnClickListener(this);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
		if (v == eje1){
			i = new Intent (this, Eje1MainActivity.class);
			//i.putExtra(DATO, "Hola mundo");
			startActivity(i);
		}
		else if (v == eje2){
			i = new Intent (this, Eje2MainActivity.class);
			startActivity(i);
		}
		else if (v == eje3){
			i = new Intent(this, Eje3MainActivity.class);
			startActivity(i);
		}
		else if (v == eje4){
			i = new Intent(this, Eje4MainActivity.class);
			startActivity(i);
		}
		else if (v == eje5){
			i = new Intent (this, Eje5MainActivity.class);
			startActivity(i);
		}
	}
}
