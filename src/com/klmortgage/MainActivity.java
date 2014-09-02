package com.klmortgage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Krish Venkat on 8/28/2014.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    EditText loanAmt;
    EditText roi;
    EditText yrs;
    EditText pmi;
    EditText result;
    TextView error;

    Button btnDisplay;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btnDisplay = (Button) findViewById(R.id.display);

        btnDisplay.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        double resultValue = 0;
        try {
            Core core = new Core();
            loanAmt = (EditText) findViewById(R.id.loan_amt);
            roi = (EditText) findViewById(R.id.roi);
            yrs = (EditText) findViewById(R.id.years);
            pmi = (EditText) findViewById(R.id.pmi);
            error = (TextView) findViewById(R.id.error);

            double temp=0;
            try{
                temp = Double.parseDouble(pmi.getText().toString());
            }catch(Exception e){
                temp=0;
            }finally {

                result = (EditText) findViewById(R.id.result);

                if(isUsableDouble(loanAmt.getText().toString())){
                }

                if(isUsableDouble(roi.getText().toString())){
                }

                if(isUsableDouble(yrs.getText().toString())){
                }

                resultValue = core.calculateMortgage(
                        Double.parseDouble(loanAmt.getText().toString()),
                        Double.parseDouble(yrs.getText().toString()),
                        Double.parseDouble(roi.getText().toString()),
                        temp);
            }
            error.setText("");
        }catch(RuntimeException re){
            resultValue = 0;
            error.setText(re.getMessage());
        }finally{
            result.setText(String.valueOf(resultValue));
        }
    }

    public boolean isUsableDouble(String string){

        if(string.isEmpty() || string==null){
            throw new RuntimeException("Please enter valid numbers");
        }

        return false;
    }

}
