package com.epong.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.TextView;

public class IngFragment extends Fragment implements OnClickListener {
	private Button btn1, btn2, btn3;
	Fragment frReplaceFragment = null;
	private MainActivity mActivity;// popup

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.ingactivity, container, false);
		mActivity = (MainActivity) getActivity();// popup2
		
		btn1 = (Button) view.findViewById(R.id.elquiness);
		btn2 = (Button) view.findViewById(R.id.knife);
		btn3 = (Button) view.findViewById(R.id.moon);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.d(">> ", "" + (Integer) v.getTag());
		Customdialog mDialog;
		mDialog = new Customdialog(mActivity, v.getId());
		mDialog.show();
	}
}