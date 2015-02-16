package com.example.samsung.calculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    String buttonText = "0";
    boolean equal_pressed = false;
    private TextView t;
    private String number1 = "0";
    private String number2 = "0";
    private float result = 0;
    private float temp_result = 0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("buttontext", buttonText);
        savedInstanceState.putBoolean("equal_pressed", equal_pressed);
        savedInstanceState.putString("number1", number1);
        savedInstanceState.putString("number2", number2);
        savedInstanceState.putFloat("result", result);
        savedInstanceState.putFloat("temp_result", temp_result);
        savedInstanceState.putString("operator", operator);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        buttonText = savedInstanceState.getString("buttontext");
        equal_pressed = savedInstanceState.getBoolean("equal_pressed");
        number1 = savedInstanceState.getString("number1");
        number2 = savedInstanceState.getString("number2");
        result = savedInstanceState.getFloat("result");
        temp_result = savedInstanceState.getFloat("temp_result");
        operator = savedInstanceState.getString("operator");
    }
    public void onClick(View v) {
        Button b = (Button) v;
// Retrieving edit text from UI id by using findViewById and passing edit text id.
        t = (TextView) findViewById(R.id.editText);
        //System.out.println("Value"+b.getText().toString());

			/*Here I am checking button press in multiple else if conditions. 
                First I am checking if any operator button is pressed.
				If any operation button is pressed whatever is being displayed
				on the screen will be stored in First Number and screen display will be cleared to enter  second number

   */
        if ((b.getText().equals("+") || b.getText().equals("-") || b.getText().equals("x") || b.getText().equals("÷") || b.getText().equals("^")) && (!t.getText().toString().equals(""))) {
            equal_pressed = false;

            if (operator.equals("")) {
                System.out.println("Operator" + b.getText().toString());
                operator = b.getText().toString();
                number1 = buttonText;


                buttonText = "0";
                t.setText("");

            }
            /*Here I am checking whether it is sequential operation and if it is a sequential operation
            then I am performing corresponding operation stored in operator variable. */
            else {
                // If previous operation is '+' addition will be performed
                if (operator.equals("+")) {
                    operator = b.getText().toString();
                    System.out.println("Repeat Operation:" + operator);
                    number1 = Float.toString(Float.parseFloat(number1) + Float.parseFloat(buttonText));
                    System.out.println("First Number:" + number1 + " " + buttonText);
                    buttonText = "0";
                    t.setText(number1);
                }
                // If previous operation is '-' Multiplication will be performed
                else if (operator.equals("-")) {
                    operator = b.getText().toString();
                    System.out.println("Repeat Operation:" + operator);
                    number1 = Float.toString(Float.parseFloat(number1) - Float.parseFloat(buttonText));

                    System.out.println("First Number:" + number1);
                    buttonText = "0";
                    t.setText(number1);
                }
                // If previous operation is '*' subtraction will be performed
                else if (operator.equals("x")) {
                    operator = b.getText().toString();
                    System.out.println("Repeat Operation:" + operator);
                    number1 = Float.toString(Float.parseFloat(number1) * Float.parseFloat(buttonText));
                    System.out.println("First Number:" + number1 + " " + buttonText);
                    buttonText = "0";
                    t.setText(number1);
                } else if (operator.equals("÷")) {
                    // Checking for Divide by zero error
                    if (buttonText.equals("0")) {

                        t.setText("Can Not Divide by Zero");
                    }
                    // If previous operation is '/' division will be performed
                    else {
                        operator = b.getText().toString();
                        System.out.println("Repeat Operation:" + operator);
                        number1 = Float.toString(Float.parseFloat(number1) / Float.parseFloat(buttonText));
                        System.out.println("First Number:" + number1 + " " + buttonText);
                        buttonText = "0";
                        t.setText(number1);
                    }
                } else if (operator.equals("^")) {
                    operator = b.getText().toString();
                    System.out.println("Repeat Operation:" + operator);
                    number1 = Double.toString(Math.pow(Double.parseDouble(number1), Double.parseDouble(buttonText)));
                    System.out.println("First Number:" + number1 + " " + buttonText);
                    buttonText = "0";
                    t.setText(number1);
                }
            }


        } else if ((b.getText().equals("+") || b.getText().equals("-") || b.getText().equals("x") || b.getText().equals("÷") || b.getText().equals("^")) && (t.getText().toString().equals(""))) {
            equal_pressed = false;
            operator = b.getText().toString();

        } else if (b.getText().toString().equals("=")) {
        /*
        Whenever user presses = button operation is performed on two numbers as per the operation stored in variable
         and result will be displayed on the screen.
         */
            equal_pressed = true;
            if (operator != null) {
                number2 = buttonText;

                System.out.println("Second Number " + Float.parseFloat(number2));
                if (operator.equals("+")) {
                    result = Float.parseFloat(number1) + Float.parseFloat(number2) + temp_result;
                    System.out.println("Addition " + String.valueOf(result));

                    t.setText(String.valueOf(result));
                    buttonText = String.valueOf(result);
                    operator = "";
                    number1 = "0";

                } else if (operator.equals("-")) {
                    result = Float.parseFloat(number1) - Float.parseFloat(number2);
                    System.out.println("Subtraction " + String.valueOf(result));

                    t.setText(String.valueOf(result));
                    buttonText = String.valueOf(result);
                    operator = "";
                    number1 = "0";
                } else if (operator.equals("x")) {
                    result = Float.parseFloat(number1) * Float.parseFloat(number2);
                    System.out.println("Multiplication " + String.valueOf(result));

                    t.setText(String.valueOf(result));
                    buttonText = String.valueOf(result);
                    operator = "";
                    number1 = "0";
                } else if (operator.equals("÷")) {
                    if (number2.equals("0")) {
                        // Checking for divide by zero error.
                        t.setText("Can Not Divide by Zero");
                    } else {
                        result = Float.parseFloat(number1) / Float.parseFloat(number2);
                        System.out.println("Division " + String.valueOf(result));

                        t.setText(String.valueOf(result));
                        buttonText = String.valueOf(result);
                        operator = "";
                        number1 = "0";
                    }
                } else if (operator.equals("^")) {
                    // result = Float.parseFloat(number1) * Float.parseFloat(number2);
                    System.out.println("Multiplication " + String.valueOf(Double.toString(Math.pow(Double.parseDouble(number1), Double.parseDouble(number2)))));

                    t.setText(String.valueOf(Double.toString(Math.pow(Double.parseDouble(number1), Double.parseDouble(number2)))));
                    buttonText = String.valueOf(Double.toString(Math.pow(Double.parseDouble(number1), Double.parseDouble(number2))));
                    operator = "";
                    number1 = "0";
                }


            } else {

                number1 = buttonText;


                t.setText(buttonText);
                operator = "";

            }
        } else if (b.getText().toString().equals("√")) {

            equal_pressed = true;
            if (!number1.contains("-")) {
                if (operator.equals("")) {
                    number1 = buttonText;
                    if (!number1.contains("-")) {
                        t.setText(String.valueOf(Math.sqrt(Float.parseFloat(number1))));
                        buttonText = String.valueOf(Math.sqrt(Float.parseFloat(number1)));
                        operator = "";
                        number1 = "0";
                    } else {
                        t.setText("Invalid Input");
                        number1 = "0";
                        number2 = "0";
                        buttonText = "0";
                        operator = "";
                        operator = "";
                    }

                } else {
                    if (operator.equals("+")) {

                        System.out.println("Repeat Operation:" + operator);
                        number1 = Float.toString(Float.parseFloat(number1) + Float.parseFloat(buttonText));
                        if (!number1.contains("-")) {
                            t.setText(String.valueOf(Math.sqrt(Float.parseFloat(number1))));
                            buttonText = String.valueOf(Math.sqrt(Float.parseFloat(number1)));
                            System.out.println("First Number:" + number1 + " " + buttonText);
                            operator = "";
                            number1 = "0";
                        } else {
                            t.setText("Invalid Input");
                            number1 = "0";
                            number2 = "0";
                            buttonText = "0";
                            operator = "";
                        }

                    } else if (operator.equals("-")) {
                        System.out.println("Repeat Operation:" + operator);
                        number1 = Float.toString(Float.parseFloat(number1) - Float.parseFloat(buttonText));
                        if (!number1.contains("-")) {
                            t.setText(String.valueOf(Math.sqrt(Float.parseFloat(number1))));
                            buttonText = String.valueOf(Math.sqrt(Float.parseFloat(number1)));
                            System.out.println("First Number:" + number1 + " " + buttonText);
                            operator = "";
                            number1 = "0";

                        } else {
                            t.setText("Invalid Input");
                            number1 = "0";
                            number2 = "0";
                            buttonText = "0";
                            operator = "";
                        }
                    } else if (operator.equals("x")) {
                        System.out.println("Repeat Operation:" + operator);
                        number1 = Float.toString(Float.parseFloat(number1) * Float.parseFloat(buttonText));
                        if (!number1.contains("-")) {
                            t.setText(String.valueOf(Math.sqrt(Float.parseFloat(number1))));
                            buttonText = String.valueOf(Math.sqrt(Float.parseFloat(number1)));
                            System.out.println("First Number:" + number1 + " " + buttonText);
                            operator = "";
                            number1 = "0";
                        } else {
                            t.setText("Invalid Input");
                            number1 = "0";
                            number2 = "0";
                            buttonText = "0";
                            operator = "";
                        }
                    } else if (operator.equals("÷")) {

                        if (number2.equals("0")) {

                            t.setText("Can Not Divide by Zero");
                        } else {
                            System.out.println("Repeat Operation:" + operator);
                            number1 = Float.toString(Float.parseFloat(number1) / Float.parseFloat(buttonText));
                            if (!number1.contains("-")) {
                                t.setText(String.valueOf(Math.sqrt(Float.parseFloat(number1))));
                                buttonText = String.valueOf(Math.sqrt(Float.parseFloat(number1)));
                                System.out.println("First Number:" + number1 + " " + buttonText);
                                operator = "";
                                number1 = "0";
                            } else {
                                t.setText("Invalid Input");
                                number1 = "0";
                                number2 = "0";
                                buttonText = "0";
                                operator = "";
                            }
                        }
                    } else if (operator.equals("^")) {
                        System.out.println("Repeat Operation:" + operator);
                        number1 = Double.toString(Math.pow(Double.parseDouble(number1), Double.parseDouble(buttonText)));
                        if (!number1.contains("-")) {
                            t.setText(String.valueOf(Math.sqrt(Float.parseFloat(number1))));
                            buttonText = String.valueOf(Math.sqrt(Float.parseFloat(number1)));
                            System.out.println("First Number:" + number1 + " " + buttonText);
                            operator = "";
                            number1 = "0";
                        } else {
                            t.setText("Invalid Input");
                            number1 = "0";
                            number2 = "0";
                            buttonText = "0";
                            operator = "";
                        }
                    }

                }
            } else {
                t.setText("Invalid Input");
                number1 = "0";
                number2 = "0";
                buttonText = "0";
                operator = "";
            }
        } else if (b.getText().toString().equals("C")) {
            // On pressing Clear all button display text will be set to default value 0
            equal_pressed = false;
            buttonText = "0";
            number1 = "0";
            number2 = "0";
            operator = "";
            t.setText("0");
        } else if (b.getText().toString().equals("DELETE")) {
            // Whenever delete is pressed display text is reduced by one character
            equal_pressed = false;
            System.out.println("In Delete");
            if (buttonText.length() > 0) {
                buttonText = buttonText.substring(0, buttonText.length() - 1);
            } else {
                buttonText = "";
            }

            t.setText(buttonText);
        } else {
            if (buttonText.contains(".") && b.getText().equals(".")) {

                if (!equal_pressed) {
                    t.setText(buttonText);

                }
                // Whenever user presses point first time 0 will be padded before that decimal.
                else {
                    buttonText = "0" + b.getText().toString();
                    t.setText(buttonText);
                    equal_pressed = false;

                }
            } else if (equal_pressed) {
                System.out.println("Equal pressed");
                buttonText = "";
                buttonText = buttonText + b.getText().toString();

                t.setText(buttonText);
                equal_pressed = false;

            }
            // Check for not allowing pressing . button twice if decimal point is already pressed once.
            else if (b.getText().equals(".") && (t.getText().toString().equals("0") || t.getText().toString().equals(""))) {
                buttonText = "0" + b.getText().toString();
                t.setText(buttonText);
            } else {
                //System.out.println("Value" + b.getText().toString());
                if (buttonText.equals("0")) {
                    buttonText = b.getText().toString();

                    t.setText(buttonText);
                } else {
                    if (buttonText.length() <= 6) {
                        /// Checking if input is greater than 7 digits.
                        buttonText = buttonText + b.getText().toString();
                        System.out.println(buttonText + "Length" + buttonText.length());

                        t.setText(buttonText);
                    } else {
                        // if input is greater than 7 displaying error message

                        Toast.makeText(this, "Maximum Length 7 Reached", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
