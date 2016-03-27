package com.example.util;

import android.widget.TextView;

public class OperatorUtil {
	public static boolean flag = true;

	public static void setOperator(String s, TextView tv) {
		if (!s.equals(".")) {
			flag = true;
			if(!FormulaUtil.isOperator){
				FormulaUtil.isOperator=true;
			}
		} else {
			if (!flag) {
				return;
			}else{
				flag=false;
			}
		}

		String string = tv.getText().toString();
		if (string.charAt(string.length() - 1) == '+'
				| string.charAt(string.length() - 1) == '-'
				| string.charAt(string.length() - 1) == 'x'
				| string.charAt(string.length() - 1) == '/') {// 前一个字符为+ - x /
																// 则输入无效
			return;
		} else {
			tv.setText(tv.getText().toString() + s);
		}
	}
}
