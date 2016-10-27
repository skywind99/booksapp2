package com.epong.fragmenttest;

import java.util.Calendar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements OnClickListener {
	// Button mBtn01, mBtn02, mBtn03; //�봽�옒洹몃㉫�듃 �씠�룞 踰꾪듉
	private Button btn1, btn2, btn3, btn4, btn5;
	Fragment frReplaceFragment = null;
	private boolean isBackKeyPressed = false; // flag
	private long currentTimeByMillis = 0; // calculate time interval

	private static final int MSG_TIMER_EXPIRED = 1; // switch - key
	private static final int BACKKEY_TIMEOUT = 2; // define interval
	private static final int MILLIS_IN_SEC = 1000; // define millisecond
	private Context mcontext;
	View view_line;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startActivity(new Intent(MainActivity.this, SplashActivity.class));
		mcontext = this;
		Typeface myNewFace = Typeface.createFromAsset(getAssets(),
				"fonts/snsm.ttf");
		view_line = (View) findViewById(R.id.view_line);
		view_line.setBackgroundColor(Color.argb(255, 255, 193, 158));
		// mBtn01 = (Button)findViewById(R.id.btn_01);
		// mBtn01.setTag(1);
		//
		// mBtn02 = (Button)findViewById(R.id.btn_02);
		// mBtn02.setTag(2);
		//
		// mBtn03 = (Button)findViewById(R.id.btn_03);
		// mBtn03.setTag(3);
		btn1 = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);
		btn3 = (Button) findViewById(R.id.button3);
		btn4 = (Button) findViewById(R.id.button4);
		btn5 = (Button) findViewById(R.id.button5);
		btn1.setTag(1);
		btn2.setTag(2);
		btn3.setTag(3);
		btn4.setTag(4);
		btn5.setTag(5);
		btn1.setTypeface(myNewFace);
		btn2.setTypeface(myNewFace);
		btn3.setTypeface(myNewFace);
		btn4.setTypeface(myNewFace);
		btn5.setTypeface(myNewFace);

		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);

		setFragmentChange(1);
	}

	@Override
	public void onClick(View v) {

		Log.d(">> ", "" + (Integer) v.getTag());
		switch (v.getId()) {

		case R.id.button1:
			// Toast.makeText(this, "01", Toast.LENGTH_SHORT).show();
			frReplaceFragment = new HomeFragment();
			setFragmentChange((Integer) v.getTag());
			break;

		case R.id.button2:
			frReplaceFragment = new RecomFragment();
			setFragmentChange((Integer) v.getTag());
			break;

		case R.id.button3:
			frReplaceFragment = new IngFragment();
			setFragmentChange((Integer) v.getTag());
			break;
		case R.id.button4:
			frReplaceFragment = new EndFragment();
			setFragmentChange((Integer) v.getTag());
			break;
		case R.id.button5:
			frReplaceFragment = new SiteFragment();
			setFragmentChange((Integer) v.getTag());
			break;

		}

	}

	// �봽�옒洹몃㉫�듃 �씠�룞
	public void setFragmentChange(int fragmentIdx) {
		frReplaceFragment = null;// addstack을 하기위한 작업
		Log.d(">>>>", "FragmentIdx : " + fragmentIdx);
		switch (fragmentIdx) {
		case 1:
			btn1.setTextColor(Color.BLACK);
			btn2.setTextColor(Color.GRAY);
			btn3.setTextColor(Color.GRAY);
			btn4.setTextColor(Color.GRAY);
			btn5.setTextColor(Color.GRAY);
			btn1.setBackgroundColor(Color.argb(255, 255, 193, 158));
			btn2.setBackgroundColor(Color.WHITE);
			btn3.setBackgroundColor(Color.WHITE);
			btn4.setBackgroundColor(Color.WHITE);
			btn5.setBackgroundColor(Color.WHITE);

			frReplaceFragment = new HomeFragment();
			break;
		case 2:
			btn2.setTextColor(Color.BLACK);
			btn1.setTextColor(Color.GRAY);
			btn3.setTextColor(Color.GRAY);
			btn4.setTextColor(Color.GRAY);
			btn5.setTextColor(Color.GRAY);
			btn2.setBackgroundColor(Color.argb(255, 255, 193, 158));

			btn1.setBackgroundColor(Color.WHITE);
			btn3.setBackgroundColor(Color.WHITE);
			btn4.setBackgroundColor(Color.WHITE);
			btn5.setBackgroundColor(Color.WHITE);

			frReplaceFragment = new RecomFragment();
			break;
		case 3:

			btn3.setTextColor(Color.BLACK);
			btn2.setTextColor(Color.GRAY);
			btn1.setTextColor(Color.GRAY);
			btn4.setTextColor(Color.GRAY);
			btn5.setTextColor(Color.GRAY);
			btn3.setBackgroundColor(Color.argb(255, 255, 193, 158));

			btn2.setBackgroundColor(Color.WHITE);
			btn1.setBackgroundColor(Color.WHITE);
			btn4.setBackgroundColor(Color.WHITE);
			btn5.setBackgroundColor(Color.WHITE);

			frReplaceFragment = new IngFragment();
			break;
		case 4:

			btn4.setTextColor(Color.BLACK);
			btn2.setTextColor(Color.GRAY);
			btn3.setTextColor(Color.GRAY);
			btn1.setTextColor(Color.GRAY);
			btn5.setTextColor(Color.GRAY);
			btn4.setBackgroundColor(Color.argb(255, 255, 193, 158));
			btn2.setBackgroundColor(Color.WHITE);
			btn3.setBackgroundColor(Color.WHITE);
			btn1.setBackgroundColor(Color.WHITE);
			btn5.setBackgroundColor(Color.WHITE);

			frReplaceFragment = new EndFragment();
			break;
		case 5:
			btn5.setTextColor(Color.BLACK);
			btn2.setTextColor(Color.GRAY);
			btn3.setTextColor(Color.GRAY);
			btn4.setTextColor(Color.GRAY);
			btn1.setTextColor(Color.GRAY);
			btn5.setBackgroundColor(Color.argb(255, 255, 193, 158));

			btn2.setBackgroundColor(Color.WHITE);
			btn3.setBackgroundColor(Color.WHITE);
			btn4.setBackgroundColor(Color.WHITE);
			btn1.setBackgroundColor(Color.WHITE);

			frReplaceFragment = new SiteFragment();
			break;

		default:
			break;
		}

		// replace fragment
		final FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.target_fragment, frReplaceFragment);

		// Fragment Stack 異붽�
		// transaction.addToBackStack(null);

		// Commit the transaction
		transaction.commit();
	}

	@Override
	public void onBackPressed() {
		if (isBackKeyPressed == false) {
			// first click
			isBackKeyPressed = true;

			currentTimeByMillis = Calendar.getInstance().getTimeInMillis();
			Toast.makeText(this, "\'뒤로\'버튼을 한번 더 누르시면 종료됩니다.",
					Toast.LENGTH_SHORT).show();

			startTimer();
		} else {
			// second click : 2초 이내면 종료! 아니면 아무것도 안한다.
			isBackKeyPressed = false;
			if (Calendar.getInstance().getTimeInMillis() <= (currentTimeByMillis + (BACKKEY_TIMEOUT * MILLIS_IN_SEC))) {
				finish();
			}
		}
	}

	// startTimer : 2초의 시간적 여유를 가지게 delay 시킨다.
	private void startTimer() {
		backTimerHandler.sendEmptyMessageDelayed(MSG_TIMER_EXPIRED,
				BACKKEY_TIMEOUT * MILLIS_IN_SEC);
	}

	private Handler backTimerHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case MSG_TIMER_EXPIRED: {
				isBackKeyPressed = false;
			}
				break;
			}
		}
	};
	// End of Back method

}
