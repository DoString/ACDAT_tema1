package com.example.hola_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebMainActivity extends Activity {
	private WebView web;
	private Intent i;
	private final static String DATO = "URL";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_main);
		
		web = new WebView(this);		
		this.setContentView(web);
		
		final Activity activity = this;
		web.setWebViewClient(new WebViewClient() {
		    @Override
		    public void onReceivedError(WebView view, int errorCode, String descripcion, String UrlFallida) {
		            //Log.i("WEB_VIEW_TEST", "error code:" + errorCode);
		            Toast.makeText(activity, "Error!" + descripcion, Toast.LENGTH_SHORT).show();
		    }
		 });
		
		this.getIntent();
		this.i = this.getIntent();
		this.web.loadUrl(this.i.getStringExtra(DATO));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web_main, menu);
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
}
