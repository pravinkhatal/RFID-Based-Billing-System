package com.example.khatal.rfiddatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.content.Context;
import android.widget.Toast;



/*

 This activity for adding new Customer to database

 */



public class InsertCustomerActivity extends AppCompatActivity implements OnClickListener
{
    Button buttonInsertData;
    EditText editTextName,editTextTagId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertcustomer);
        buttonInsertData=(Button)findViewById(R.id.insert);
        editTextName =(EditText)findViewById(R.id.customer_name_edittext);
        editTextTagId =(EditText)findViewById(R.id.customerid_edittext);

        buttonInsertData.setOnClickListener(this);

    }
    @Override
    public void onClick(View v)
    {
        try
        {
            String s1=editTextTagId.getText().toString();
            DBhelper database=new DBhelper(this);
            if( database.insertCustomer(editTextName.getText().toString(), Integer.parseInt(editTextTagId.getText().toString())))
            {
                displayMsg("New Customer added");
            }
        }
        catch (Exception e)
        {
            displayMsg("Enter valid Data");
        }


    }

    /**
     *  displays message using Toast
     */
    public void displayMsg(String msg)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context,msg, duration);
        toast.show();
    }

}
