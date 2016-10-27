package com.epong.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class EndFragment extends Fragment implements OnClickListener {

	private Button btn1, btn2, btn3, btn4;
	Fragment frReplaceFragment = null;
	private MainActivity mActivity;// popup

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.endactivity, container, false);
		mActivity = (MainActivity) getActivity();// popup2

		btn1 = (Button) view.findViewById(R.id.end_bt1);
		btn2 = (Button) view.findViewById(R.id.end_bt2);
		btn3 = (Button) view.findViewById(R.id.end_bt3);
		btn4 = (Button) view.findViewById(R.id.end_bt4);

		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Customdialog mDialog;
		mDialog = new Customdialog(mActivity, v.getId());
		mDialog.show();
	}
}
