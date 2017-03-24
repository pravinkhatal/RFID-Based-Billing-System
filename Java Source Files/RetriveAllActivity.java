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

This activty retrives all item records from the database

*/

public class RetriveAllActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive);
        TextView retriveData=(TextView)findViewById(R.id.retrive_text);
        retriveData.setMovementMethod(new ScrollingMovementMethod());
        try {
            DBhelper database = new DBhelper(this);
            Cursor cursor = database.retriveAll();
            cursor.moveToFirst();
            retriveData.setText("Name" + "   " + " Price " + "   " + " Tag Id " + "   " + " Discount");

            /*   Retriving All Data*/

            do {
                retriveData.setText(retriveData.getText() + System.getProperty("line.separator") + " " + cursor.getString(cursor.getColumnIndex("name")) + "    " + cursor.getInt(cursor.getColumnIndex("price")) + "   " + cursor.getString(cursor.getColumnIndex("tagid")) + "   " + cursor.getInt(cursor.getColumnIndex("discount")));
            } while (cursor.moveToNext());
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
