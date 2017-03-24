package com.example.khatal.rfiddatabase;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by khatal on 05-Nov-16.
 */


 /*

 This activity for adding new customers

 */

public class SignupActivity extends AppCompatActivity  implements View.OnClickListener{

    EditText name,mid,password;
    TextView bill;
    Button signup,retrive;
    DBhelper database = new DBhelper(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=(EditText)findViewById(R.id.user_name_edittext);
       password=(EditText)findViewById(R.id.password_edittext);
        mid=(EditText)findViewById(R.id.managerid_edittext);
        bill=(TextView)findViewById(R.id.bill_textview);
        signup=(Button)findViewById(R.id.signup);
        retrive=(Button)findViewById(R.id.retrive);
        signup.setOnClickListener(this);
        retrive.setOnClickListener(this);
    }
    public void onClick(View v) {
        if (v.getId() == R.id.signup) {
            String s1 = name.getText().toString();
            String s2 = password.getText().toString();
            String s3 = mid.getText().toString();
            int id = Integer.parseInt(s3);

            try {

                if (database.insertManager(s1, s2, id)) {
                    displayMsg("Account created");
                    Intent intent = new Intent(getApplicationContext(), LogInManager.class);
                    startActivity(intent);
                }
            } catch (Exception e) {
                displayMsg("Enter valid Data");
            }
        }
        if (v.getId() == R.id.retrive) {
            try {

                Cursor cursor = database.retriveAllManager();
                cursor.moveToFirst();
                while (cursor.moveToNext()) {
                    bill.setText(bill.getText() + System.getProperty("line.separator") + "\n" + cursor.getString(cursor.getColumnIndex("m_name")) + "       " + cursor.getString(cursor.getColumnIndex("password")));
                }
                }
            catch (Exception e)
            {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, "No data in database", duration);
                toast.show();
            }
            }


    }
    public void displayMsg(String msg)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, msg, duration);
        toast.show();
    }
}
