package com.epong.fragmenttest;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class Customdialog extends Dialog implements
		android.view.View.OnClickListener {
	private Button btn1;
	private ProgressDialog mProgress;

	public Customdialog(Context context, int certR11) {
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		switch (certR11) {
		case R.id.cert_r1_1:
			setContentView(R.layout.certactivitychoilog);
			break;
		case R.id.cert_r1_2:
			setContentView(R.layout.certactivitychoigod);
			break;
		case R.id.cert_r2_1:
			setContentView(R.layout.certactivityleebird);
			break;
		case R.id.cert_r2_2:
			setContentView(R.layout.certactivityleeroad);
			break;
		case R.id.cert_r3_1:
			setContentView(R.layout.certactivitykimroon);
			break;
		case R.id.cert_r3_2:
			setContentView(R.layout.certactivitykimsanaun);
			break;
		case R.id.cert_r4_1:
			setContentView(R.layout.certactivityseoktela);
			break;
		case R.id.cert_r4_2:
			setContentView(R.layout.certactivityseokmagic);
			break;
		case R.id.end_bt1:
			setContentView(R.layout.endactivityarc);
			break;
		case R.id.end_bt2:
			setContentView(R.layout.endactivityking);
			break;
		case R.id.end_bt3:
			setContentView(R.layout.endactivitymage);
			break;
		case R.id.end_bt4:
			setContentView(R.layout.endactivityroad);
			break;
		case R.id.elquiness:
			setContentView(R.layout.ingactivityelquines);
			break;
		case R.id.knife:
			setContentView(R.layout.ingactivityknife);
			break;
		case R.id.moon:
			setContentView(R.layout.ingactivitymoon);
			break;
		default:
			break;
		}

		TextView txt1 = (TextView) findViewById(R.id.textView1);
		txt1.setTextSize(20);
		btn1 = (Button) findViewById(R.id.bbb);
		btn1.setOnClickListener(this);

		// TODO Auto-generated constructor stub
	}

	public Customdialog(Context context) {
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_recom_god);

		btn1 = (Button) findViewById(R.id.bbb);
		btn1.setOnClickListener(this);

		// TODO Auto-generated constructor stub
	}

	public Customdialog(Context context, String url) {
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_recom_god);
		String bookhref = "http://m.book.naver.com" + url;
		WebView web1;
		web1 = (WebView) findViewById(R.id.book_web);
		web1.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				return super.shouldOverrideUrlLoading(view, url);

			}

			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				// TODO Auto-generated method stub
				super.onPageStarted(view, url, favicon);

				if (mProgress == null) {

					mProgress = new ProgressDialog(getContext());
					mProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
					mProgress.setTitle("인터넷 연결중 ...");
					mProgress.setMessage("잠시만 기다려 주세요...");
					mProgress.setCancelable(false);
					mProgress.show();
				}
			}

			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				// TODO Auto-generated method stub
				super.onReceivedError(view, errorCode, description, failingUrl);
				if (mProgress.isShowing()) {
					mProgress.dismiss();
				}
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				if (mProgress.isShowing()) {
					mProgress.dismiss();
				}
			}
		});
		web1.loadUrl(bookhref);

		btn1 = (Button) findViewById(R.id.bbb);
		btn1.setOnClickListener(this);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == btn1) {
			dismiss();
		}

	}

}