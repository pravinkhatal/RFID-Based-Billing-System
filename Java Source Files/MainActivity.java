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

 Starting Activity

 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    Button employee,manager,about_us;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        employee= (Button)findViewById(R.id.employee);
        manager= (Button)findViewById(R.id.manager1);
        about_us= (Button)findViewById(R.id.AboutUs);
        employee.setOnClickListener(this);
        manager.setOnClickListener(this);
        about_us.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        /*   Opens Log In activity For Manager*/

        if (v.getId() == R.id.employee) {
            Intent intent=new Intent(getApplicationContext(),LogInManager.class);
            startActivity(intent);
        }
        /*   Opens Log In activity For Employee*/

        if (v.getId() == R.id.manager1) {
            Intent intent=new Intent(getApplicationContext(),LogInManager.class);
            startActivity(intent);
        }
        /*   Shows the name of Developers*/

        if (v.getId() == R.id.AboutUs) {
            Intent intent=new Intent(getApplicationContext(),AboutusActivity.class);
            startActivity(intent);
        }

    }
}
