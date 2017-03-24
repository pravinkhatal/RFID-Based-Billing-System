package com.example.khatal.rfiddatabase;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by khatal on 05-Nov-16.
 */


/*

Manager can log in or create new account using this activity

*/


public class LogInManager extends AppCompatActivity implements View.OnClickListener {


    Button login,signup;
    EditText user_name,password;
    DBhelper database = new DBhelper(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginmanager);
        user_name=(EditText)findViewById(R.id.user_name_edittext);
        password=(EditText)findViewById(R.id.password_edittext);
        login=(Button)findViewById(R.id.login);
        signup=(Button)findViewById(R.id.signup);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login) {
            String s1=user_name.getText().toString();
            String s2=password.getText().toString();
            try {


              if(password.getText().toString().equals("admin") && user_name.getText().toString().equals("admin"))
                {
                    Intent intent = new Intent(getApplicationContext(), ManagerWorkingActivity.class);
                    startActivity(intent);
                }


                else if(password.getText().toString().equals("employee") && user_name.getText().toString().equals("employee"))
                {
                    Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
                }
                else {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, "Enter valid data", duration);
                    toast.show();
                }

            }
            catch (Exception e)
            {
                displayMsg("User Name or Password  is not valid");
            }
        }

      if (v.getId() == R.id.signup) {
            Intent intent=new Intent(getApplicationContext(),SignupActivity.class);
            startActivity(intent);
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
