package com.example.khatal.rfiddatabase;
import android.app.Activity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;


/*

This activty retrives all customer data

*/

public class RetriveAllCustomerActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retriveallcustomerdata);
        TextView retriveData=(TextView)findViewById(R.id.retrive_text1);
        retriveData.setMovementMethod(new ScrollingMovementMethod());
        try {
            retriveData.setText("   Name" + "             " + "Customer Id " );
            DBhelper database = new DBhelper(this);
            Cursor cursor = database.retAllCustomer();
            cursor.moveToFirst();

            do {
                retriveData.setText(retriveData.getText() + System.getProperty("line.separator") + "             " + cursor.getString(cursor.getColumnIndex("c_name")) + "             " + cursor.getInt(cursor.getColumnIndex("c_id")));
            }while (cursor.moveToNext());
        }
        catch (Exception e)
        {
            displayMsg("Data is not present in Database");
        }
    }
    public void displayMsg(String msg)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context,msg, duration);
        toast.show();
    }


}
