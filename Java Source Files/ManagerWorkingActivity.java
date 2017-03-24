package com.example.khatal.rfiddatabase;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by khatal on 05-Nov-16.

 */

/*

 Here Manager can perform functions


 */

public class ManagerWorkingActivity extends AppCompatActivity implements View.OnClickListener {
    TextView bill;
    Button clear_record;
    DBhelper database=new DBhelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managerworking);
        bill=(TextView)findViewById(R.id.bill_textview1);
        clear_record=(Button)findViewById(R.id.clear_rec);
        bill.setMovementMethod(new ScrollingMovementMethod());
        clear_record.setOnClickListener(this);

        try
        {
            int sum=0;
            Cursor cursor= database.retriveAllBill();

        /* Manager can see all bill records*/

            bill.setText("\nToatal Bill" + "                   " + " Customer Id");
            cursor.moveToFirst();

             do {
                bill.setText(bill.getText() + System.getProperty("line.separator") + " " + cursor.getInt(cursor.getColumnIndex("total_bill")) + "                         " + cursor.getInt(cursor.getColumnIndex("c_id")));
             sum=sum+   cursor.getInt(cursor.getColumnIndex("total_bill"));
             }while (cursor.moveToNext());
            bill.setText(bill.getText() + System.getProperty("line.separator") + " " +"Total sales = "+sum);


        }

        catch (Exception e)
        {
            displayMsg("Data is not present in Database");
        }
    }

    public void onClick(View v) {
        if(v.getId() == R.id.clear_rec) {
            try {

                /* Manager can delete all bill records*/

                if (database.deleteAllBill()) {
                    bill.setText("");
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, "Deleted all records", duration);
                    toast.show();
                }
                else
                {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, "Data not present in database", duration);
                    toast.show();
                }
            } catch (Exception e) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, "Error", duration);
                toast.show();

            }
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
