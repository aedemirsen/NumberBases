package com.example.aed.numberbases;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aed on 26.10.2015.
 */
public class Calculation extends Activity {

    Spinner s;
    String[] array_spinner;
    EditText et1,et2;
    TextView tv1;
    TextView tv2,tv6;
    TextView tv3,tv4,tv5;
    Button b1;
    ViewSwitcher vs1;
    int control = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculation);

        s = (Spinner)findViewById(R.id.spinner);
        array_spinner = new String[4];
        array_spinner[0] = "Bin";
        array_spinner[1] = "Oct";
        array_spinner[2] = "Dec";
        array_spinner[3] = "Hex";
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, array_spinner);
        s.setAdapter(adapter);

        et1 = (EditText)findViewById(R.id.editText);et1.setText("");
        et2 = (EditText)findViewById(R.id.editText2);et2.setText("");
        tv1 = (TextView)findViewById(R.id.textView4);
        tv4 = (TextView)findViewById(R.id.textView5);
        tv5 = (TextView)findViewById(R.id.textView7);
        tv2 = (TextView)findViewById(R.id.textView6);
        tv3 = (TextView)findViewById(R.id.textView8);
        tv6 = (TextView)findViewById(R.id.textView9);
        b1 = (Button)findViewById(R.id.button);
        vs1 = (ViewSwitcher)findViewById(R.id.viewSwitcher);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                et2.setText("");
                clearLogs();
                if (s.getSelectedItem().equals("Bin")){
                    if (control == 1){
                        vs1.showNext();
                    }
                    tv1.setText("DECIMAL");
                    tv2.setText("OCTAL");
                    tv3.setText("HEXADECIMAL");
                }
                else if(s.getSelectedItem().equals("Oct")){
                    if (control == 1){
                        vs1.showNext();
                    }
                    tv1.setText("BINARY");
                    tv2.setText("DECIMAL");
                    tv3.setText("HEXADECIMAL");
                }
                else if(s.getSelectedItem().equals("Dec")){
                    if (control == 1){
                        vs1.showNext();
                    }
                    tv1.setText("BINARY");
                    tv2.setText("OCTAL");
                    tv3.setText("HEXADECIMAL");
                }
                else if(s.getSelectedItem().equals("Hex")){
                    tv1.setText("BINARY");
                    tv2.setText("DECIMAL");
                    tv3.setText("OCTAL");
                    vs1.showNext();
                    control = 1;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseConverter bc1 = new BaseConverter();
                if(!et2.getText().toString().equals("")){
                    if (s.getSelectedItemPosition() == 0) {
                        String binaryNum = et2.getText().toString();
                        Pattern p1 = Pattern.compile("[^10]");
                        Matcher m1 = p1.matcher(binaryNum);
                        if (m1.find()) {
                            dialog("Warning!", "Only binary numbers are allowed(1 , 0)", "OK");
                            et2.setText("");
                            clearLogs();
                        }else {
                            int decimal = bc1.binaryToDecimal(et2.getText().toString());
                            tv4.setText(decimal + "");
                            int octal = bc1.binaryToOctal(et2.getText().toString());
                            tv5.setText(octal + "");
                            String hexaDecimal = bc1.binaryToHexaDecimal(et2.getText().toString());
                            tv6.setText(hexaDecimal);
                        }
                    }
                    else if(s.getSelectedItemPosition() == 1){
                        String octalNum = et2.getText().toString();
                        Pattern p1 = Pattern.compile("[^01234567]");
                        Matcher m1 = p1.matcher(octalNum);
                        if (m1.find()){
                            dialog("Warning!","Only octal numbers are allowed(0,1,2,3,4,5,6,7)","OK");
                            et2.setText("");
                            clearLogs();
                        }else{
                            long decimal = bc1.octalToDecimal(Integer.parseInt(octalNum));
                            tv5.setText(decimal+"");
                            String binary = bc1.octalToBinary(Integer.parseInt(octalNum));
                            tv4.setText(binary);
                            String hexa = bc1.octalToHexadecimal(Integer.parseInt(octalNum));
                            tv6.setText(hexa);
                        }
                    }
                    else if(s.getSelectedItemPosition() == 2){
                        clearLogs();
                        int number = Integer.parseInt(et2.getText().toString());
                        int decimal = bc1.decimalToOctal(number);
                        tv5.setText(decimal + "");
                        String binary = bc1.decimalToBinary(number);
                        tv4.setText(binary);
                        String hexadecimal = bc1.decimalToHexadecimal(number);
                        tv6.setText(hexadecimal+"");
                    }
                }else if(et2.getText().toString().equals("") && et1.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Empty Value!",Toast.LENGTH_LONG).show();
                }
                if (!et1.getText().toString().equals("") && s.getSelectedItemPosition() == 3){
                    String binaryNum = et1.getText().toString();
                    Pattern p1 = Pattern.compile("[^0123456789ABCDEF]");
                    Matcher m1 = p1.matcher(binaryNum);
                    if (m1.find()){
                        dialog("Warning!","Only hexadecimal numbers are allowed(0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F)","OK");
                        et1.setText("");
                    }else {
                        int decimal = bc1.hexaToDecimal(et1.getText().toString());
                        tv5.setText(decimal+"");
                        int octal = bc1.hexaToOctal(et1.getText().toString());
                        tv6.setText(octal+"");
                        String binary = bc1.hexaToBinary(et1.getText().toString());
                        tv4.setText(binary);
                    }

                }
            }
        });
    }


    public void dialog(String title,String message,String buttonText1){
        AlertDialog.Builder d = new AlertDialog.Builder(this);
        d.setTitle(title);
        d.setMessage(message);
        d.setPositiveButton(buttonText1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = d.create();
        alertDialog.show();
    }

    public void clearLogs(){
        tv4.setText("");
        tv5.setText("");
        tv6.setText("");

    }
}
