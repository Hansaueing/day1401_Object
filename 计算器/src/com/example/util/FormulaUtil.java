package com.example.util;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.util.Log;

import com.example.custom.MyIterator;

public class FormulaUtil {
	public static boolean isOperator=false; //最后一位是运算符
	private static LinkedList<Double> list1 = new LinkedList<Double>();
	private static LinkedList<String> list2 = new LinkedList<String>();

	public static void clearList(){
		list1.clear();
		list2.clear();
	}
	
	public static double caculate(String s) {
		String string=null;
		if(isOperator){
			string = s.substring(0, s.length()-1);
		}else{
			string = s;
		}
		MyIterator d = new MyIterator(string);

		while (d.hasNext()) {
			String str = d.next();
			if (str.matches("\\d+(\\.\\d+)?")) {
				list1.add(Double.parseDouble(str));
			} else if (str.matches("[+\\-]")) {
				list2.add(str);
			} else {
				double a = list1.removeLast();
				double b = Double.parseDouble(d.next());
				double result = jiSuan(a, str, b);
				list1.add(result);
				Log.i("list",result+"       chenchu");
			}
		}
		if(list1.size()<2)
			return list1.get(0);
		while (list2.size() != 0) {
			double a = list1.removeFirst();
			double b = list1.removeFirst();
			String str = list2.removeFirst();
			double result = jiSuan(a, str, b);
			list1.addFirst(result);
			Log.i("list",result+"      jiaqian");
		}

		return list1.get(0);

	}

	private static double jiSuan(double a, String s, double b) {
	
		char ch = s.charAt(0);
		BigDecimal a1=BigDecimal.valueOf(a);
		BigDecimal b1=BigDecimal.valueOf(b);
		BigDecimal c = BigDecimal.valueOf(0);
		switch (ch) {
		case '+':
			c = a1.add(b1);
			break;
		case '-':
			c = a1.subtract(b1);
			break;
		case 'x':
			c = a1.multiply(b1);
			break;
		case '/':
			c = a1.divide(b1,4,BigDecimal.ROUND_HALF_UP);
			break;
		}
		return c.doubleValue();
	}
}
