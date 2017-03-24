package com.example.khatal.rfiddatabase;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by khatal on 24-Oct-16.
 */



/*

 This activity generates bill & sends to customer using whatsapp

 */

public class GenerateBillActivity extends AppCompatActivity implements View.OnClickListener {


    EditText data,cust_id;
    Button generate_bill,send_message;
    TextView bill;
    DBhelper database=new DBhelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generatebill);
        cust_id=(EditText)findViewById(R.id.custidd_edittext);
        data=(EditText)findViewById(R.id.data_edittext);
        generate_bill=(Button)findViewById(R.id.genarate);
        send_message=(Button)findViewById(R.id.send_message);
        bill=(TextView)findViewById(R.id.bill_textview);
        bill.setMovementMethod(new ScrollingMovementMethod());
        generate_bill.setOnClickListener(this);
        send_message.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.genarate) {
            try {
                String c_id=cust_id.getText().toString();
                Cursor cur_cust = database.retriveCustomer(c_id);
                cur_cust.moveToFirst();

                String s2 = data.getText().toString();

                String tag_id_array[] = s2.split("\n");
                int sum = 0;

                bill.setText("* Your Bill *");

                bill.setText(bill.getText() + System.getProperty("line.separator")+"Customer Name - "+cur_cust.getString(cur_cust.getColumnIndex("c_name"))+"\n    Custome Id - " + cur_cust.getInt(cur_cust.getColumnIndex("c_id")));;

                bill.setText(bill.getText() + System.getProperty("line.separator") + "\nName" + "       " + " Price " + "        Discount");

                for (int i = 0; i < tag_id_array.length; i++) {
                    String id = tag_id_array[i];
                    Cursor cursor = database.retriveData("1"+id);
                    cursor.moveToFirst();
                    bill.setText(bill.getText() + System.getProperty("line.separator") + "\n" + cursor.getString(cursor.getColumnIndex("name")) + "       " + cursor.getInt(cursor.getColumnIndex("price")) + "        " + cursor.getInt(cursor.getColumnIndex("discount")) + "%");
                    int price = cursor.getInt(cursor.getColumnIndex("price"));
                    int per = cursor.getInt(cursor.getColumnIndex("discount"));


                    /* Price & Discount Calculation*/

                    int disc = price * per / 100;
                    sum = sum + price;
                    sum = sum - disc;
                }

                bill.setText(bill.getText() + System.getProperty("line.separator") + "\nYour total Bill is " + sum + " Rupees");
                if(database.insertBill(sum, cur_cust.getInt(cur_cust.getColumnIndex("c_id"))))
                {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context,"Data inserted to bill table", duration);
                    toast.show();
                }
            }
            catch (Exception e)
            {

                displayMsg("Tag Id not Present or Customer not Present in Database");
            }
        }

        if (v.getId() == R.id.send_message) {
                String whatsAppMessage =bill.getText().toString();

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, whatsAppMessage);
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
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
