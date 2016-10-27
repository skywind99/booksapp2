package com.epong.fragmenttest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;

public class SiteMunFragment extends Fragment implements OnClickListener {
	private WebView web1;
	Fragment frReplaceFragment = null;
	private Button btn1;
	private ProgressDialog mProgress;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.webviewactivity, container, false);
		btn1 = (Button) view.findViewById(R.id.btn_site);
		btn1.setOnClickListener(this);
		btn1.setTag(1);
		web1 = (WebView) view.findViewById(R.id.web_site);
		web1.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				return super.shouldOverrideUrlLoading(view, url);
			}

			@SuppressWarnings("deprecation")
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				// TODO Auto-generated method stub
				super.onPageStarted(view, url, favicon);

				if (mProgress == null) {

					mProgress = new ProgressDialog(getActivity());
					mProgress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
					mProgress.setTitle("인터넷 연결중 ...");
					mProgress.setMessage("잠시만 기다려 주세요...");
					mProgress.setCancelable(false);
					mProgress.setButton("취소",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									mProgress.dismiss();
								}
							});
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
		web1.loadUrl("http://www.munpia.com/");
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		frReplaceFragment = new SiteFragment();
		setFragmentChange((Integer) v.getTag());
	}

	public void setFragmentChange(int fragmentIdx) {
		Log.d(">>>>", "FragmentIdx : " + fragmentIdx);
		switch (fragmentIdx) {
		case 1:

			frReplaceFragment = new SiteFragment();
			break;
		}
		final FragmentTransaction transaction = getFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.target_fragment, frReplaceFragment);

		// Fragment Stack 異붽� // transaction.addToBackStack(null);

		// Commit the transaction
		transaction.remove(this).commit();
	}
}