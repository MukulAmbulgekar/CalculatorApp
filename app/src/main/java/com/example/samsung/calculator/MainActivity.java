package com.example.samsung.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.samsung.calculator.R.id.editText;


public class MainActivity extends ActionBarActivity {

    private Button button;
    private TextView t;
    String buttonText="";
    private String number1;
    private String number2;
    private float result;
    private String operator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onClick(View v) {

        Button b = (Button)v;
        //System.out.println("Value"+b.getText().toString());
        if (b.getText().equals("+")|| b.getText().equals("-")||b.getText().equals("*")|| b.getText().equals("/")){
            System.out.println("In operator"+b.getText().toString());
            operator=b.getText().toString();
            number1=buttonText;

            t=(TextView) findViewById(R.id.editText);
            buttonText="";
            t.setText(null);
            System.out.println("First Number " + number1);
        }
        else if(b.getText().toString().equals("=")){


            if (operator!=null)
            {
                number2 = buttonText;

                System.out.println("Second n Number " + Float.parseFloat(number2));
                if (operator.equals("+")) {
                    result = Float.parseFloat(number1) + Float.parseFloat(number2);
                    System.out.println("Addition " + String.valueOf(result));
                    t = (TextView) findViewById(R.id.editText);
                    t.setText(String.valueOf(result));
                    buttonText = String.valueOf(result);
                } else if (operator.equals("-")) {
                    result = Float.parseFloat(number1) - Float.parseFloat(number2);
                    System.out.println("Subtraction " + String.valueOf(result));
                    t = (TextView) findViewById(R.id.editText);
                    t.setText(String.valueOf(result));
                    buttonText = String.valueOf(result);
                } else if (operator.equals("*")) {
                    result = Float.parseFloat(number1) * Float.parseFloat(number2);
                    System.out.println("Subtraction " + String.valueOf(result));
                    t = (TextView) findViewById(R.id.editText);
                    t.setText(String.valueOf(result));
                    buttonText = String.valueOf(result);
                } else if (operator.equals("/")) {
                    if(number2.equals("0")){

                        t.setText("Can Not Divide by Zero");
                    }
                    else {
                        result = Float.parseFloat(number1) / Float.parseFloat(number2);
                        System.out.println("Subtraction " + String.valueOf(result));
                        t = (TextView) findViewById(R.id.editText);
                        t.setText(String.valueOf(result));
                        buttonText = String.valueOf(result);
                    }
                }
            }
            else{
                number1=buttonText;
                t = (TextView) findViewById(R.id.editText);
                t.setText(buttonText);

            }
        }
        else if(b.getText().toString().equals("C")){
            t=(TextView) findViewById(R.id.editText);
            buttonText="";
            number1="";
            number2="";
            t.setText(null);
        }
        else {
            System.out.println("Value"+b.getText().toString());
            buttonText = buttonText + b.getText().toString();
            t = (TextView) findViewById(R.id.editText);
            t.setText(buttonText);
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
