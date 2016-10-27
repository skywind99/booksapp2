package com.epong.fragmenttest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class RecomFragment extends Fragment implements OnClickListener {

	private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
	Fragment frReplaceFragment = null;
	private MainActivity mActivity;// popup

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_recom, container, false);
		mActivity = (MainActivity) getActivity();// popup2

		btn1 = (Button) view.findViewById(R.id.cert_r1_1);
		btn2 = (Button) view.findViewById(R.id.cert_r1_2);
		btn3 = (Button) view.findViewById(R.id.cert_r2_1);
		btn4 = (Button) view.findViewById(R.id.cert_r2_2);
		btn5 = (Button) view.findViewById(R.id.cert_r3_1);
		btn6 = (Button) view.findViewById(R.id.cert_r3_2);
		btn7 = (Button) view.findViewById(R.id.cert_r4_1);
		btn8 = (Button) view.findViewById(R.id.cert_r4_2);
//
//		btn1.setTag(1);
//		btn2.setTag(2);
//		btn3.setTag(3);
//		btn4.setTag(4);
//		btn5.setTag(5);
//		btn6.setTag(6);
//		btn7.setTag(7);
//		btn8.setTag(8);

		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		btn7.setOnClickListener(this);
		btn8.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Log.d(">> ", "" + (Integer) v.getTag());
		Customdialog mDialog;
		mDialog = new Customdialog(mActivity, v.getId());
		mDialog.show();
		// switch (v.getId()) {
		//
		// case R.id.cert_r1_1:
		// mDialog = new Customdialog(mActivity,R.id.cert_r1_1);
		// mDialog.show();
		// // frReplaceFragment = new RecomFragmentLog();
		// // setFragmentChange((Integer) v.getTag());
		// break;
		// case R.id.cert_r1_2:
		// mDialog = new Customdialog(mActivity);
		// mDialog.show();
		// // frReplaceFragment = new RecomFragmentGod();
		// // setFragmentChange((Integer) v.getTag());
		// break;
		// case R.id.cert_r2_1:
		// mDialog = new Customdialog(mActivity);
		// mDialog.show();
		// // frReplaceFragment = new RecomFragmentbird();
		// // setFragmentChange((Integer) v.getTag());
		// break;
		// case R.id.cert_r2_2:
		// mDialog = new Customdialog(mActivity);
		// mDialog.show();
		// // frReplaceFragment = new RecomFragmentroad();
		// // setFragmentChange((Integer) v.getTag());
		// break;
		// case R.id.cert_r3_1:
		// mDialog = new Customdialog(mActivity);
		// mDialog.show();
		// // frReplaceFragment = new RecomFragmentRoon();
		// // setFragmentChange((Integer) v.getTag());
		// break;
		// case R.id.cert_r3_2:
		// mDialog = new Customdialog(mActivity);
		// mDialog.show();
		// // frReplaceFragment = new RecomFragmentsanaun();
		// // setFragmentChange((Integer) v.getTag());
		// break;
		// case R.id.cert_r4_1:
		// mDialog = new Customdialog(mActivity);
		// mDialog.show();
		// // frReplaceFragment = new RecomFragmenttela();
		// // setFragmentChange((Integer) v.getTag());
		// break;
		// case R.id.cert_r4_2:
		// mDialog = new Customdialog(mActivity);
		// mDialog.show();
		// // frReplaceFragment = new RecomFragmentmagic();
		// // setFragmentChange((Integer) v.getTag());
		// break;
		// }
	}

	/*
	 * public void setFragmentChange(int fragmentIdx) { Log.d(">>>>",
	 * "FragmentIdx : " + fragmentIdx);
	 * 
	 * switch (fragmentIdx) { case 1:
	 * 
	 * frReplaceFragment = new RecomFragmentLog(); break; case 2:
	 * 
	 * frReplaceFragment = new RecomFragmentGod(); break; case 3:
	 * 
	 * frReplaceFragment = new RecomFragmentbird(); break; case 4:
	 * 
	 * frReplaceFragment = new RecomFragmentroad(); break; case 5:
	 * 
	 * frReplaceFragment = new RecomFragmentRoon(); break; case 6:
	 * 
	 * frReplaceFragment = new RecomFragmentsanaun(); break; case 7:
	 * 
	 * frReplaceFragment = new RecomFragmenttela(); break; case 8:
	 * 
	 * frReplaceFragment = new RecomFragmentmagic(); break; default: break; }
	 * 
	 * // replace fragment final FragmentTransaction transaction =
	 * getFragmentManager()// Fragment // inside // Fragment
	 * .beginTransaction(); transaction.replace(R.id.target_fragment,
	 * frReplaceFragment);
	 * 
	 * // Fragment Stack 異붽� // transaction.addToBackStack(null);
	 * 
	 * // Commit the transaction transaction.addToBackStack(null).commit(); }
	 */

}
