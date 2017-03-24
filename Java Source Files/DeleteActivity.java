package com.example.khatal.rfiddatabase;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.content.Context;
import android.widget.Toast;


/*

 Deleing Record Activity

 */

public class DeleteActivity extends AppCompatActivity implements OnClickListener
{
    Button buttonDeleteData;
    EditText editTextRollDelete;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        buttonDeleteData=(Button)findViewById(R.id.delete);
        editTextRollDelete=(EditText)findViewById(R.id.tagid_edittext);

        buttonDeleteData.setOnClickListener(this);

    }
    @Override
    public void onClick(View v)
    {
        try
        {
            DBhelper database=new DBhelper(this);
            if( database.deleteRow(editTextRollDelete.getText().toString()))    /* Deleting Particular tag record*/
              {
                displayMsg("row Deleted");
              }
        }
        catch(Exception e)
        {
            displayMsg("Tag Id not present or incorrect data");
        }


    }

    /**
     *  Displays message using Toast
     */

    public void displayMsg(String msg)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context,msg, duration);
        toast.show();
    }

}
