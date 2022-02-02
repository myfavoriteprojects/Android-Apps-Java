package com.mcm.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn_equal;
    private Button btn_multiply;
    private Button btn_divide;
    private Button btn_add;
    private Button btn_substract;
    private Button btn_clear;
    private Button btn_dot;
    private Button btn_para1;
    private Button btn_para2;
    private TextView textview1;
    private TextView textview2;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = '=';
    private final char EXTRA = '@';
    private final char MODULUS = '%';
    private char ACTION;
    private double value1 = Double.NaN;
    private double value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewSetup();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                textview1.setText(textview1.getText().toString() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                textview1.setText(textview1.getText().toString() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                textview1.setText(textview1.getText().toString() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                textview1.setText(textview1.getText().toString() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                textview1.setText(textview1.getText().toString() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                textview1.setText(textview1.getText().toString() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                textview1.setText(textview1.getText().toString() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                textview1.setText(textview1.getText().toString() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                textview1.setText(textview1.getText().toString() + "9");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ifErrorOnOutput();
                exceedLength();
                textview1.setText(textview1.getText().toString() + "0");
            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exceedLength();
                textview1.setText(textview1.getText().toString() + ".");
            }
        });

        btn_para1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textview1.getText().length() > 0) {
                    ACTION = MODULUS;
                    operation();
                    if (!ifReallyDecimal()) {
                        textview2.setText(value1 + "%");
                    } else {
                        textview2.setText((int) value1 + "%");
                    }
                    textview1.setText(null);
                } else {
                    textview2.setText("Error");
                }
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textview1.getText().length() > 0) {
                    ACTION = ADDITION;
                    operation();
                    if (!ifReallyDecimal()) {
                        textview2.setText(value1 + "+");
                    } else {
                        textview2.setText((int) value1 + "+");
                    }
                    textview1.setText(null);
                } else {
                    textview2.setText("Error");
                }
            }
        });

        btn_substract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textview1.getText().length() > 0) {
                    ACTION = SUBTRACTION;
                    operation();
                    if (textview1.getText().length() > 0)
                        if (!ifReallyDecimal()) {
                            textview2.setText(value1 + "-");
                        } else {
                            textview2.setText((int) value1 + "-");
                        }
                    textview1.setText(null);
                } else {
                    textview2.setText("Error");
                }
            }
        });

        btn_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textview1.getText().length() > 0) {
                    ACTION = MULTIPLICATION;
                    operation();
                    if (!ifReallyDecimal()) {
                        textview2.setText(value1 + "×");
                    } else {
                        textview2.setText((int) value1 + "×");
                    }
                    textview1.setText(null);
                } else {
                    textview2.setText("Error");
                }
            }
        });

        btn_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textview1.getText().length() > 0) {
                    ACTION = DIVISION;
                    operation();
                    if (ifReallyDecimal()) {
                        textview2.setText((int) value1 + "/");
                    } else {
                        textview2.setText(value1 + "/");
                    }
                    textview1.setText(null);
                } else {
                    textview2.setText("Error");
                }
            }
        });

        btn_para2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textview2.getText().toString().isEmpty() || !textview1.getText().toString().isEmpty()) {
                    value1 = Double.parseDouble(textview1.getText().toString());
                    ACTION = EXTRA;
                    textview2.setText("-" + textview1.getText().toString());
                    textview1.setText("");
                } else {
                    textview2.setText("Error");
                }
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textview1.getText().length() > 0) {
                    operation();
                    ACTION = EQU;
                    if (!ifReallyDecimal()) {
                        textview2.setText(String.valueOf(value1));
                    } else {
                        textview2.setText(String.valueOf((int) value1));
                    }
                    textview1.setText(null);
                } else {
                    textview2.setText("Error");
                }
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textview1.getText().length() > 0) {
                    CharSequence name = textview1.getText().toString();
                    textview1.setText(name.subSequence(0, name.length() - 1));
                } else {
                    value1 = Double.NaN;
                    value2 = Double.NaN;
                    textview1.setText("");
                    textview2.setText("");
                }
            }
        });

        btn_clear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                value1 = Double.NaN;
                value2 = Double.NaN;
                textview1.setText("");
                textview2.setText("");
                return true;
            }
        });
    }

    private void viewSetup() {
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btn0 = findViewById(R.id.button0);
        btn_equal = findViewById(R.id.button_equal);
        btn_multiply = findViewById(R.id.button_multi);
        btn_divide = findViewById(R.id.button_divide);
        btn_add = findViewById(R.id.button_add);
        btn_substract = findViewById(R.id.button_sub);
        btn_clear = findViewById(R.id.button_clear);
        btn_dot = findViewById(R.id.button_dot);
        btn_para1 = findViewById(R.id.button_para1);
        btn_para2 = findViewById(R.id.button_para2);
        textview1 = findViewById(R.id.input);
        textview2 = findViewById(R.id.output);
    }

    private void operation() {
        if (!Double.isNaN(value1)) {
            if (textview2.getText().toString().charAt(0) == '-') {
                value1 = (-1) * value1;
            }
            value2 = Double.parseDouble(textview1.getText().toString());

            switch (ACTION) {
                case ADDITION:
                    value1 = value1 + value2;
                    break;
                case SUBTRACTION:
                    value1 = value1 - value2;
                    break;
                case MULTIPLICATION:
                    value1 = value1 * value2;
                    break;
                case DIVISION:
                    value1 = value1 / value2;
                    break;
                case EXTRA:
                    value1 = (-1) * value1;
                    break;
                case MODULUS:
                    value1 = value1 % value2;
                    break;
                case EQU:
                    break;
            }
        } else {
            value1 = Double.parseDouble(textview1.getText().toString());
        }
    }

    private void ifErrorOnOutput() {
        if (textview2.getText().toString().equals("Error")) {
            textview2.setText("");
        }
    }

    private boolean ifReallyDecimal() {
        return value1 == (int) value1;
    }

    private void noOperation() {
        String inputExpression = textview2.getText().toString();
        if (!inputExpression.isEmpty() && !inputExpression.equals("Error")) {
            if (inputExpression.contains("-")) {
                inputExpression = inputExpression.replace("-", "");
                textview2.setText("");
                value1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("+")) {
                inputExpression = inputExpression.replace("+", "");
                textview2.setText("");
                value1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("/")) {
                inputExpression = inputExpression.replace("/", "");
                textview2.setText("");
                value1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("%")) {
                inputExpression = inputExpression.replace("%", "");
                textview2.setText("");
                value1 = Double.parseDouble(inputExpression);
            }
            if (inputExpression.contains("×")) {
                inputExpression = inputExpression.replace("×", "");
                textview2.setText("");
                value1 = Double.parseDouble(inputExpression);
            }
        }
    }

    private void exceedLength() {
        if (textview1.getText().toString().length() > 10) {
            textview1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        }
    }
}