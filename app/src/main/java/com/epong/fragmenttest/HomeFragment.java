package com.epong.fragmenttest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.epong.fragmenttest.util.ImageLoader;

public class HomeFragment extends Fragment {
	private ListView listView;
	private ArrayList<HashMap<String, String>> mList;
	private ViewAdapter mAdapter;
	private String url = "http://m.book.naver.com/bestsell/list.nhn";
	private ImageLoader mImageLoader;
	private ProgressDialog mProgressDialog;
	static String TITLE = "title";
	static String NAME = "name";
	static String FLAG = "flag";
	static String HREFSTR = "href_str";
	static String RANK = "rank";
	private String href_str;
	private MainActivity mActivity;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.activity_home, container, false);
		mActivity = (MainActivity) getActivity();// popup2
		listView = (ListView) view.findViewById(R.id.customList);
		mImageLoader = new ImageLoader(getActivity());
		// Pass the results into ListViewAdapter.java
		mAdapter = new ViewAdapter(getActivity(), mImageLoader);
		// Set the adapter to the ListView
		listView.setAdapter(mAdapter);

		new JsoupListView().execute();
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Customdialog mDialog;
				mDialog = new Customdialog(mActivity, mList.get(position)
						.get(HREFSTR).toString());
				mDialog.show();
				// TODO Auto-generated method stub
				// Toast.makeText(getActivity(),
				// mList.get(position).get(HREFSTR).toString(),
				// Toast.LENGTH_SHORT).show();
			}
		});
		return view;
	}

	private class JsoupListView extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Create a progressdialog
			mProgressDialog = new ProgressDialog(getActivity());
			// Set progressdialog title
			mProgressDialog.setTitle("Books App");
			// Set progressdialog message
			mProgressDialog.setMessage("잠시만 기다려주세요...");
			mProgressDialog.setIndeterminate(false);
			// Show progressdialog
			mProgressDialog.show();
		}

		@Override
		protected Void doInBackground(Void... params) {
			// Create an array
			mList = new ArrayList<HashMap<String, String>>();

			try {
				// Connect to the Website URL
				Document doc = Jsoup.connect(url).get();
				// Identify Table Class "worldpopulation"
				int i = 0;
				for (Element table : doc.select("div[class=card_list]")) {
					// Log.i(9"aa", "table=" + table);
					// Identify all the table row's(tr)
					for (Element row : table.select("section[class=cds]")) {
						// for (Element row : table.select("h3[class=cds_h3]"))
						// {
						//
						HashMap<String, String> map = new HashMap<String, String>();

						// Identify all the table cell's(td)
						// Elements tds = row.select("td");

						// Identify all img src's
						// Elements imgSrc = row.select("img[src]");
						// Get only src from img src
						// String imgSrcStr = imgSrc.attr("src");

						Elements ranks = row.select("h3[class=cds_h3]");
						Elements name_str = row.select("span[class=name]");
						Elements imgSrc = row.select("img[src]");
						String imgSrcStr = imgSrc.attr("src");

						String rank_str = ranks.text().substring(0, 3).trim();
						String title_str = ranks.text().substring(3);
						Elements href = row.select("a[class=cds_a]");
						href_str = href.attr("href");
						// Log.i("aa", "img_str=" + imgSrcStr);

						// Retrive Jsoup Elements
						// Get the first td
						map.put("rank", rank_str);
						// Get the second td
						map.put("title", name_str.text());
						// // Get the third td
						map.put("name", title_str);
						// // Get the image src links
						map.put("href_str", href_str);
						map.put("flag", imgSrcStr);
						Log.i("aaa", "name" + name_str);
						Log.i("aaa", "title" + title_str);
						Log.i("aaa", "rank" + rank_str);
						Log.i("aaa", "href" + href_str);

						// // Set all extracted Jsoup Elements into the array
						mList.add(map);

					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {

			// Locate the listview in listview_main.xml

			mAdapter.setData(mList);
			// mPager.setAdapter(new BkPagerAdapter(getApplicationContext()));//
			// PagerAdapter로

			// Close the progressdialog
			mProgressDialog.dismiss();

		}
	}

	// @Override
	// public void onItemClick(AdapterView<?> parent, View view, int position,
	// long id) {
	// TODO Auto-generated method stub

	// Customdialog mDialog = new Customdialog(mActivity, position);
	// mDialog.show();
}

// @Override
// public void onItemClick(AdapterView<?> parent, View view, int position,
// long id) {
// // TODO Auto-generated method stub
// Customdialog dialog = Customdialog(HomeFragment.this);
// dialog.show();
// }

