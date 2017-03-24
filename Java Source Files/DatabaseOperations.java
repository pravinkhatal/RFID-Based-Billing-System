package com.example.khatal.rfiddatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by khatal on 22-Oct-16.
 */


/*

 This activity contains buttons to perform operations

 */


public class DatabaseOperations extends AppCompatActivity implements View.OnClickListener {


    Button insert, delete, retrive,insert_cust,retrive_cust;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_operartins);
        delete=(Button)findViewById(R.id.delete);
        retrive=(Button)findViewById(R.id.retrive);
        insert = (Button)findViewById(R.id.insert);
        insert_cust = (Button)findViewById(R.id.insert_customer);
        retrive_cust=(Button)findViewById(R.id.retriveall_customer);
        insert.setOnClickListener(this);
        retrive.setOnClickListener(this);
        delete.setOnClickListener(this);
        insert_cust.setOnClickListener(this);
        retrive_cust.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.insert) {
            Intent intent=new Intent(getApplicationContext(),InsertActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.retrive) {
            Intent intent=new Intent(getApplicationContext(),RetriveAllActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.delete) {
            Intent intent=new Intent(getApplicationContext(),DeleteActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.insert_customer) {
            Intent intent=new Intent(getApplicationContext(),InsertCustomerActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.retriveall_customer) {
            Intent intent=new Intent(getApplicationContext(),RetriveAllCustomerActivity.class);
            startActivity(intent);
        }

    }
}
