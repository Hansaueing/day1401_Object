package com.example.day0000;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

import com.example.util.FormulaUtil;
import com.example.util.NumberUtil;
import com.example.util.OperatorUtil;

public class MainActivity extends Activity {

	private TextView tv;
	//private boolean flag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.window);
	}

	public void doClick(View view) {
		switch (view.getId()) {
		case R.id.btn0:
			NumberUtil.showNum("0", tv);
			break;
		case R.id.btn1:
			NumberUtil.showNum("1", tv);
			break;
		case R.id.btn2:
			NumberUtil.showNum("2", tv);
			break;
		case R.id.btn3:
			NumberUtil.showNum("3", tv);
			break;
		case R.id.btn4:
			NumberUtil.showNum("4", tv);
			break;
		case R.id.btn5:
			NumberUtil.showNum("5", tv);
			break;
		case R.id.btn6:
			NumberUtil.showNum("6", tv);
			break;
		case R.id.btn7:
			NumberUtil.showNum("7", tv);
			break;
		case R.id.btn8:
			NumberUtil.showNum("8", tv);
			break;
		case R.id.btn9:
			NumberUtil.showNum("9", tv);
			break;
		case R.id.btn_dot:
			OperatorUtil.setOperator(".", tv);
			break;
		case R.id.btn_add:
			OperatorUtil.setOperator("+", tv);
			break;
		case R.id.btn_sub:
			OperatorUtil.setOperator("-", tv);
			break;
		case R.id.btn_mul:
			OperatorUtil.setOperator("x", tv);
			break;
		case R.id.btn_div:
			OperatorUtil.setOperator("/", tv);
			break;
		case R.id.btn_equ:
			equals();
			break;
		case R.id.c:
			clear();
			break;
		case R.id.del:
			del();
			break;

		}
	}

	private void equals() {
		double result = FormulaUtil.caculate(tv.getText().toString());
		tv.setText("" + result);
		FormulaUtil.clearList();
		OperatorUtil.flag=false;
	}

	// Çå¿Õwindow
	private void clear() {
		FormulaUtil.clearList();
		tv.setText("0");
		OperatorUtil.flag=true;
	}

	// »ØÉ¾
	public void del() {
		if(FormulaUtil.isOperator&&OperatorUtil.flag){
			OperatorUtil.flag = false;
			FormulaUtil.isOperator=false;
		}
		String s = tv.getText().toString();
		int len = s.length();
		String s1 = s.substring(0, len - 1);
		tv.setText(s1);
	}

}
