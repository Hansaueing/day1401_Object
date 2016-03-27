package com.Hansaueing.day1704;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv1;
	private ArrayList<String> list = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv1 = (TextView) findViewById(R.id.tv1);
	}
	/*
	 * View android�ؼ�����
	 */
	public void doClick(View view) {
		CheckBox cb=(CheckBox) view;
		String s = cb.getText().toString();
		
		//�ж��Ƿ�ѡ
		if(cb.isChecked()){
			list.add(s);
		}else{
			list.remove(s);
		}
		tv1.setText("");
		for(int i=0;i<list.size();i++){
			if(i!=0){
				tv1.append(",");
			}
			tv1.append(list.get(i));
		}
	}
}
