package com.example.khatal.rfiddatabase;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


/*

Employee can press button to perform particular function in this activity

*/

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button database_operation,about_us,generate_bill;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        database_operation = (Button)findViewById(R.id.database_operations);
        about_us= (Button)findViewById(R.id.AboutUs);
        generate_bill= (Button)findViewById(R.id.GenerateBill);
        database_operation.setOnClickListener(this);
        about_us.setOnClickListener(this);
        generate_bill.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.database_operations) {
            Intent intent=new Intent(getApplicationContext(),DatabaseOperations.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.GenerateBill) {
            Intent intent=new Intent(getApplicationContext(),GenerateBillActivity.class);
            startActivity(intent);
        }

        if (v.getId() == R.id.AboutUs) {
            Intent intent=new Intent(getApplicationContext(),AboutusActivity.class);
            startActivity(intent);
        }

    }
}
