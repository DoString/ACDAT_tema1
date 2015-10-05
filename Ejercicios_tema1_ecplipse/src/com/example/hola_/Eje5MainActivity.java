package com.example.hola_;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

public class Eje5MainActivity extends Activity implements OnClickListener, OnCheckedChangeListener {
	private EditText pass;
	private EditText hmac;
	private Button generar;
	private CheckBox clave;
	private EditText resNormal;
	private EditText resCaps;
	private TextView labelNormal;
	private TextView labelCaps;
	Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eje5_main);
		
		
		labelNormal = (TextView) findViewById(R.id.textViewResultado);
		labelCaps = (TextView) findViewById(R.id.textViewSha1Caps);
		pass = (EditText) findViewById(R.id.editTextPass);
		hmac = (EditText) findViewById(R.id.editTextHmac);
		clave = (CheckBox) findViewById(R.id.checkBoxHmac);
		clave.setOnCheckedChangeListener(this);
		generar = (Button) findViewById(R.id.buttonGenerar);
		generar.setOnClickListener(this);
		resNormal = (EditText) findViewById(R.id.editTextSha1Normal);
		resCaps = (EditText) findViewById(R.id.editTextSha1Caps);
		i = this.getIntent();
		
		labelNormal.setVisibility(View.INVISIBLE);
		labelCaps.setVisibility(View.INVISIBLE);
		resNormal.setVisibility(View.INVISIBLE);
		resNormal.setTextIsSelectable(true);
		resCaps.setVisibility(View.INVISIBLE);
		resCaps.setTextIsSelectable(true);
		this.hmac.setEnabled(false);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.eje5_main, menu);
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
		if (v == generar){
			try {
				if (this.clave.isChecked())
					this.resNormal.setText(Hash.ComputarHmacSha1(this.hmac.getText().toString(),this.pass.getText().toString()));					
				else 
					this.resNormal.setText(Hash.ComputarSha1(this.pass.getText().toString()));			
				
				this.resCaps.setText(Hash.Capitalizado(this.resNormal.getText().toString()));
				
				labelNormal.setVisibility(View.VISIBLE);
				labelCaps.setVisibility(View.VISIBLE);
				resNormal.setVisibility(View.VISIBLE);
				resCaps.setVisibility(View.VISIBLE);
				
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
				
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (buttonView == clave){
			if(isChecked)
				this.hmac.setEnabled(true);
			else{
				this.hmac.setEnabled(false);
				this.hmac.setText("");
			}
		}				
	}
}
