package com.epong.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class SiteFragment extends Fragment implements OnClickListener {
	private LinearLayout li1, li2, li3, li4;
	Fragment frReplaceFragment = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_site, container, false);
		li1 = (LinearLayout) view.findViewById(R.id.li1_site);
		li1.setOnClickListener(this);
		li2 = (LinearLayout) view.findViewById(R.id.li2_site);
		li2.setOnClickListener(this);
		li3 = (LinearLayout) view.findViewById(R.id.li3_site);
		li3.setOnClickListener(this);
		li4 = (LinearLayout) view.findViewById(R.id.li4_site);
		li4.setOnClickListener(this);
		li1.setTag(1);
		li2.setTag(2);
		li3.setTag(3);
		li4.setTag(4);
		return view;

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.li1_site:
			frReplaceFragment = new SiteJoaraFragment();
			setFragmentChange((Integer) v.getTag());
			break;
		case R.id.li2_site:
			frReplaceFragment = new SiteDasoolFragment();
			setFragmentChange((Integer) v.getTag());
			break;
		case R.id.li3_site:
			frReplaceFragment = new SiteMunFragment();
			setFragmentChange((Integer) v.getTag());
			break;
		case R.id.li4_site:
			frReplaceFragment = new SiteIjakFragment();
			setFragmentChange((Integer) v.getTag());
			break;

		}
	}

	public void setFragmentChange(int fragmentIdx) {
		Log.d(">>>>", "FragmentIdx : " + fragmentIdx);

		switch (fragmentIdx) {
		case 1:

			frReplaceFragment = new SiteJoaraFragment();
			break;
		case 2:

			frReplaceFragment = new SiteDasoolFragment();
			break;
		case 3:

			frReplaceFragment = new SiteMunFragment();
			break;
		case 4:

			frReplaceFragment = new SiteIjakFragment();
			break;

		default:
			break;
		}

		// replace fragment // Fragment inside Fragment

		final FragmentTransaction transaction = getFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.target_fragment, frReplaceFragment);

		// Fragment Stack 異붽� // transaction.addToBackStack(null);

		// Commit the transaction
		transaction.addToBackStack(null).commit();
	}

}
