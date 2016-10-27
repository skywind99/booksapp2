package com.epong.fragmenttest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

		Handler hd = new Handler();
		hd.postDelayed(new Runnable() {
			@Override
			public void run() {
				finish();
			}
		}, 3000);
	}
}
