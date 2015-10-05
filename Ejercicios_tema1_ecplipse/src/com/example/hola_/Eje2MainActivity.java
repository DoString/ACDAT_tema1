package com.example.hola_;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Eje2MainActivity extends Activity implements OnClickListener {
	
	private final Double FACTOR = 0.393700787; // 1 cm = 0,393700787 pulgadas.
	Button calcular;
	Button salir;
	TextView texto;
	EditText cmText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eje2_main);
		
		this.calcular = (Button)findViewById(R.id.button8);
		this.calcular.setOnClickListener(this);
		this.salir = (Button) findViewById(R.id.button9);
		this.salir.setOnClickListener(this);
		this.texto = (TextView) findViewById(R.id.textPulgadas);
		this.cmText = (EditText) findViewById(R.id.editTextCM);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.eje2_main, menu);
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
		String contenido = this.cmText.getText().toString();
		//if (contenido == "") return; //Si esta vacío salimos.
		
		if (v == this.calcular){
			try {
				this.texto.setText(String.format("%.4f", Double.parseDouble(contenido) * this.FACTOR));
			
			} catch (Exception e) {
				return;
			}
		}
		else if (v == this.salir)
			this.finish();
	}
}
