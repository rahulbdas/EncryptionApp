package edu.nyu.cs101.android.rbd285;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//version 1.2
public class MainActivity extends AppCompatActivity {

    String enc, dec;

    private EditText decrpty1;

    private EditText encrypt1;

    Button button;
    Button button2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instantiateing all ths variables used above

        decrpty1 = (EditText) findViewById(R.id.decrpty1);
        encrypt1 = (EditText) findViewById(R.id.encrypt1);



        //made 2 buttons, one for encryption and one for decrytpion

        button = (Button) findViewById(R.id.button);

        button2 = (Button) findViewById(R.id.button2);






        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                //instiating new variabls to get when the button is pressed



                dec = decrpty1.getText().toString();

                //this will perform the decryption on it



                String dec2 = decrypt(dec);

                //this will display the data
                Show( dec2);







            }



        });

        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                //instiating new variabls to get when the button is pressed


                String encrpyt = encrypt1.getText().toString();

                //this will perform the decryption on it


                String enc = encrypt(encrpyt);



                //this will display the data


                Show(enc);


            }
        });






    }

    /**
     * this will print the string on the deivce by making it visible
     * @param text
     */

    private void Show(String text){

        Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();

    }







    /**
     * this code is meant to get the ascii values of the entered values, type char, and encrypt it through changing the ascii value by increasing it by one and returning the resulting char
     * also all char'z' are turned into ')"
     * also this only works well alphabetical values, like words not other char types
     * @author rahuldas
     * @param s
     */
    private String encrypt(String s){

        String d = "";

        for (int x = 0; x< s.length(); x ++ ) {

            char w = s.charAt(x);

            int ascii= (int) w;

            //addding 1 value to the ascii table to encode
            int b = ascii + 1;

            //for z in the ascii tabl i mace a special if statement to make sure that it gets converted to a different character
            if (b > 90 & b < 97 ) {

                b = 36;

            }
            else if( b >122) {
                b = 42;


            }
            char e = (char) b;
            d += e;



        }

        System.out.println(d);



        //decode


        return d;
    }
    /**
     * this code is meant to get the ascii values of the entered values, type char, and encrypt it through changing the ascii value by increasing it by one and returning the resulting char
     * also all char'z' are turned into ')"
     * also this only works well alphabetical values, like words not other char types
     * @author rahuldas
     * @param d
     */

    private String decrypt(String d){

        //decode

        String decode = "";
        for (int h = 0; h< d.length(); h ++ ) {

            char g = d.charAt(h);

            int ascii= (int) g;
            //subtracting 1 value to the ascii to decode
            int b = ascii - 1;
            if (b == 41) {

                b = 122 ;

            }



            else if (b == 35) {

                b = 90;

            }
            char e = (char) b;
            decode += e;



        }

        System.out.println(decode);
        return decode;



    }




    }





