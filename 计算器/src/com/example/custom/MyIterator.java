package com.example.custom;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyIterator {
	private Matcher m;
	private int from;
	private String s;

	public MyIterator(String s) {
		this.s = s;
		m = Pattern.compile("\\d+(\\.\\d+)?|[+\\-x/]").matcher(s);

	}

	
	public boolean hasNext() {
		return from < s.length();
	}

	public String next() {
		m.find();
		String str = m.group();
		from = m.end();
		return str;

	}
}
