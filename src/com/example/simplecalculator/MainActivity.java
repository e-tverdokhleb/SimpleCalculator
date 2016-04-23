package com.example.simplecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

	Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	Button btnPoint, btnEqual, btnPlus, btnMinus, btnMult, btnDiv, btnSqrt,
			btnC, btnCe, btnBackSpace;
	TextView tvSmallView, tvGeneralView;

	String operand1 = "", operand2 = "", operation = "=";
	double result = 0.0;
	long longResult = 0;
	boolean newOperation = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tvSmallView = (TextView) findViewById(R.id.tvSmallView);
		tvGeneralView = (TextView) findViewById(R.id.tvGeneralView);

		btn0 = (Button) findViewById(R.id.btn0);
		btn1 = (Button) findViewById(R.id.btn1);
		btn2 = (Button) findViewById(R.id.btn2);
		btn3 = (Button) findViewById(R.id.btn3);
		btn4 = (Button) findViewById(R.id.btn4);
		btn5 = (Button) findViewById(R.id.btn5);
		btn6 = (Button) findViewById(R.id.btn6);
		btn7 = (Button) findViewById(R.id.btn7);
		btn8 = (Button) findViewById(R.id.btn8);
		btn9 = (Button) findViewById(R.id.btn9);

		btnPoint = (Button) findViewById(R.id.btnPoint);
		btnEqual = (Button) findViewById(R.id.btnEqual);
		btnPlus = (Button) findViewById(R.id.btnPlus);
		btnMinus = (Button) findViewById(R.id.btnMinus);
		btnMult = (Button) findViewById(R.id.btnMult);
		btnDiv = (Button) findViewById(R.id.btnDiv);
		btnSqrt = (Button) findViewById(R.id.btnSqrt);
		btnC = (Button) findViewById(R.id.btnC);
		btnCe = (Button) findViewById(R.id.btnCe);
		btnBackSpace = (Button) findViewById(R.id.btnBackSpace);

		btn0.setOnClickListener(this);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		btn7.setOnClickListener(this);
		btn8.setOnClickListener(this);
		btn9.setOnClickListener(this);

		btnPoint.setOnClickListener(this);
		btnEqual.setOnClickListener(this);
		btnMinus.setOnClickListener(this);
		btnPlus.setOnClickListener(this);
		btnMult.setOnClickListener(this);
		btnDiv.setOnClickListener(this);
		btnSqrt.setOnClickListener(this);
		btnC.setOnClickListener(this);
		btnCe.setOnClickListener(this);
		btnBackSpace.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		operand1 = tvGeneralView.getText().toString();

		switch (v.getId()) {

		case R.id.btnPlus:
			if (newOperation) {
				operand2 = operand1;
				tvSmallView.setText(operand1 + " + ");
				tvGeneralView.setText("0");
				newOperation = false;
			} else {
				if (Double.valueOf(operand1).equals(0.0)) {
					break;
				}
				result = Double.valueOf(operand2) + Double.valueOf(operand1);
				if ((result - (int) result) != 0) {
					tvSmallView.setText(operand2 + " + " + operand1 + " = "
							+ result);
				} else {
					tvSmallView.setText(operand2 + " + " + operand1 + " = "
							+ (int) result);
				}
				tvGeneralView.setText("0");
				newOperation = true;
			}
			operation = "+";
			break;

		case R.id.btnMinus:
			if (newOperation) {
				operand2 = operand1;
				tvSmallView.setText(operand1 + " - ");
				tvGeneralView.setText("0");
				newOperation = false;
			} else {
				if (Double.valueOf(operand1).equals(0.0)) {
					break;
				}
				result = Double.valueOf(operand2) - Double.valueOf(operand1);
				if ((result - (int) result) != 0) {
					tvSmallView.setText(operand2 + " - " + operand1 + " = "
							+ result);
				} else {
					tvSmallView.setText(operand2 + " - " + operand1 + " = "
							+ (int) result);
				}
				tvGeneralView.setText("0");
				newOperation = true;
			}
			operation = "-";
			break;

		case R.id.btnMult:
			if (newOperation) {
				operand2 = operand1;
				tvSmallView.setText(operand1 + " * ");
				tvGeneralView.setText("0");
				newOperation = false;
			} else {
				if (Double.valueOf(operand1).equals(0.0)) {
					break;
				}
				result = Double.valueOf(operand2) * Double.valueOf(operand1);
				if ((result - (int) result) != 0) {
					tvSmallView.setText(operand2 + " * " + operand1 + " = "
							+ result);
				} else {
					tvSmallView.setText(operand2 + " * " + operand1 + " = "
							+ (int) result);
				}
				tvGeneralView.setText("0");
				newOperation = true;
			}
			operation = "*";
			break;

		case R.id.btnDiv:
			if (newOperation) {
				operand2 = operand1;
				tvSmallView.setText(operand1 + " / ");
				tvGeneralView.setText("0");
				newOperation = false;
			} else {
				if (Double.compare(Double.valueOf(operand1), 0.0) == 0) {
					tvSmallView.setText("Dividing to Zero");
					newOperation = true;
					break;
				}
				result = Double.valueOf(operand2) / Double.valueOf(operand1);
				if ((result - (int) result) != 0) {
					tvSmallView.setText(operand2 + " / " + operand1 + " = "
							+ result);
				} else {
					tvSmallView.setText(operand2 + " / " + operand1 + " = "
							+ (int) result);
				}
				tvGeneralView.setText("0");
				newOperation = true;
			}
			operation = "/";
			break;

		case R.id.btnSqrt:
			if (Double.valueOf(operand1) < 0.0) {
				tvSmallView.setText("Illegal operation");
				break;
			}
			result = Math.sqrt(Double.valueOf(operand1));
			if ((result - (int) result) != 0) {
				tvSmallView.setText("Sqrt(" + operand1 + ")" + " = " + result);
			} else {
				tvSmallView.setText("Sqrt(" + operand1 + ")" + " = " + (int)result);
			}
			tvGeneralView.setText("0");
			operation = "s";
			break;

		case R.id.btnEqual:
			switch (operation) {
			case "+":
				if (newOperation) {
					operand2 = operand1;
					tvSmallView.setText(operand1 + " + ");
					tvGeneralView.setText("0");
					newOperation = false;
				} else {
					if (Double.valueOf(operand1).equals(0.0)) {
						break;
					}
					result = Double.valueOf(operand2)
							+ Double.valueOf(operand1);
					if ((result - (int) result) != 0) {
						tvSmallView.setText(operand2 + " + " + operand1 + " = "
								+ result);
					} else {
						tvSmallView.setText(operand2 + " + " + operand1 + " = "
								+ (int) result);
					}
					tvGeneralView.setText("0");
					newOperation = true;
				}
				operation = "=";
				break;

			case "-":
				if (newOperation) {
					operand2 = operand1;
					tvSmallView.setText(operand1 + " - ");
					tvGeneralView.setText("0");
					newOperation = false;
				} else {
					if (Double.valueOf(operand1).equals(0.0)) {
						break;
					}
					result = Double.valueOf(operand2)
							- Double.valueOf(operand1);
					if ((result - (int) result) != 0) {
						tvSmallView.setText(operand2 + " - " + operand1 + " = "
								+ result);
					} else {
						tvSmallView.setText(operand2 + " - " + operand1 + " = "
								+ (int) result);
					}
					tvGeneralView.setText("0");
					newOperation = true;
				}
				operation = "-";
				break;

			case "*":
				if (newOperation) {
					operand2 = operand1;
					tvSmallView.setText(operand1 + " * ");
					tvGeneralView.setText("0");
					newOperation = false;
				} else {
					if (Double.valueOf(operand1).equals(0.0)) {
						break;
					}
					result = Double.valueOf(operand2) * Double.valueOf(operand1);
					if ((result - (int) result) != 0) {
						tvSmallView.setText(operand2 + " * " + operand1 + " = "
								+ result);
					} else {
						tvSmallView.setText(operand2 + " * " + operand1 + " = "
								+ (int) result);
					}
					tvGeneralView.setText("0");
					newOperation = true;
				}
				operation = "*";
				break;

			case "/":
				if (newOperation) {
					operand2 = operand1;
					tvSmallView.setText(operand1 + " / ");
					tvGeneralView.setText("0");
					newOperation = false;
				} else {
					if (Double.compare(Double.valueOf(operand1), 0.0) == 0) {
						tvSmallView.setText("Dividing to Zero");
						newOperation = true;
						break;
					}
					result = Double.valueOf(operand2) / Double.valueOf(operand1);
					if ((result - (int) result) != 0) {
						tvSmallView.setText(operand2 + " / " + operand1 + " = "
								+ result);
					} else {
						tvSmallView.setText(operand2 + " / " + operand1 + " = "
								+ (int) result);
					}
					tvGeneralView.setText("0");
					newOperation = true;
				}
				operation = "/";
				break;
			}
			break;
		case R.id.btnCe:
			tvGeneralView.setText("0");
			operand1 = "0";
			break;

		case R.id.btnC:
			tvGeneralView.setText("0");
			tvSmallView.setText("0");
			operand1 = "0";
			result = 0;
			newOperation = true;
			break;

		case R.id.btnBackSpace:
			if (operand1.length() <= 1) {
				tvGeneralView.setText("0");
				break;
			}
			tvGeneralView.setText(operand1.substring(0, operand1.length() - 1));
			break;

		case R.id.btnPoint:
			if (operand1.contains(".")) {
				break;
			}
			tvGeneralView.setText(operand1 + ".");
			break;

		case R.id.btn0:
			if (operand1.equals("0")) {
				break;
			}
			tvGeneralView.setText(operand1 + "0");
			break;

		case R.id.btn1:
			if (operand1.equals("0")) {
				tvGeneralView.setText("1");
				break;
			}
			tvGeneralView.setText(operand1 + "1");
			break;

		case R.id.btn2:
			if (operand1.equals("0")) {
				tvGeneralView.setText("2");
				break;
			}
			tvGeneralView.setText(operand1 + "2");
			break;

		case R.id.btn3:
			if (operand1.equals("0")) {
				tvGeneralView.setText("3");
				break;
			}
			tvGeneralView.setText(operand1 + "3");
			break;
		case R.id.btn4:
			if (operand1.equals("0")) {
				tvGeneralView.setText("4");
				break;
			}
			tvGeneralView.setText(operand1 + "4");
			break;
		case R.id.btn5:
			if (operand1.equals("0")) {
				tvGeneralView.setText("5");
				break;
			}
			tvGeneralView.setText(operand1 + "5");
			break;
		case R.id.btn6:
			if (operand1.equals("0")) {
				tvGeneralView.setText("6");
				break;
			}
			tvGeneralView.setText(operand1 + "6");
			break;
		case R.id.btn7:
			if (operand1.equals("0")) {
				tvGeneralView.setText("7");
				break;
			}
			tvGeneralView.setText(operand1 + "7");
			break;

		case R.id.btn8:
			if (operand1.equals("0")) {
				tvGeneralView.setText("8");
				break;
			}
			tvGeneralView.setText(operand1 + "8");
			break;

		case R.id.btn9:
			if (operand1.equals("0")) {
				tvGeneralView.setText("9");
				break;
			}
			tvGeneralView.setText(operand1 + "9");
			break;
		}
	}

	public double getResultOf(String oper1, String oper2, String operator,
			String result) {

		return 0;
	}
}
