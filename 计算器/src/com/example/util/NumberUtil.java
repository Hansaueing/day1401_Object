package com.example.util;

import android.widget.TextView;

public class NumberUtil {

	public static void showNum(String s, TextView tv) {
		if(FormulaUtil.isOperator){
			FormulaUtil.isOperator=false;
		}
		String s1 = tv.getText().toString();
		if(s1.equals("0")) {
			tv.setText(s);
		}else{
		tv.setText(tv.getText().toString() + s);}
	}

}
