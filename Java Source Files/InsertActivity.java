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

 This activity for adding Particular Item data to database

 */


public class InsertActivity extends AppCompatActivity implements OnClickListener
{
    Button buttonInsertData;
    EditText editTextName,editTextPrice,editTextTagId,editTextDiscount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        buttonInsertData=(Button)findViewById(R.id.insert);
        editTextName=(EditText)findViewById(R.id.item_name_edittext);
        editTextPrice=(EditText)findViewById(R.id.price_edittext);
        editTextTagId=(EditText)findViewById(R.id.tag_id_edittext);
        editTextDiscount=(EditText)findViewById(R.id.discount_edittext);

        buttonInsertData.setOnClickListener(this);

    }
    @Override
    public void onClick(View v)
    {
        try
        {
             DBhelper database=new DBhelper(this);
             if( database.insertData(editTextName.getText().toString(), Integer.parseInt(editTextPrice.getText().toString()),"1"+editTextTagId.getText().toString(), Integer.parseInt(editTextDiscount.getText().toString())))
            {
                displayMsg("New Item inserted");
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
