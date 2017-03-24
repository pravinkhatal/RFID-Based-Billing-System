package com.example.khatal.rfiddatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.widget.TextView;
import android.view.View;



/*

 This is java class for creating database & defining operations function's

 */

public class DBhelper extends  SQLiteOpenHelper
{

    SQLiteDatabase db;
    /*
    *   calling constructor for creating or opening database
    * */


    public DBhelper(Context c)

    {
        super(c, "Mydb1.db", null, 1);
    }


    /*
    *   Method for creating Schema, invoked only once when  database is created
    * */

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE IF NOT EXISTS Item(name varchar(30),price number,tagid varchar(30) primary key,discount number);");
        db.execSQL("CREATE TABLE IF NOT EXISTS Manager(m_name varchar(30),password varchar(30) primary key,m_id number );");
        db.execSQL("CREATE TABLE IF NOT EXISTS Bill(total_bill number,c_id number);");
        db.execSQL("CREATE TABLE IF NOT EXISTS Customer(c_name varchar(30), c_id varchar(30) primary key);");

    }

    /*
    *method for inserting data

    * */

    public boolean insertData(String nm,int prc,String tag, int disc)
     {
           db=this.getWritableDatabase();

           ContentValues c=new ContentValues();
           c.put("name",nm);
           c.put("price", prc);
           c.put("tagid", tag);
           c.put("discount", disc);

           db.insert("Item", null, c);

          return true;
     }
/*
    *   delete row based on tagid

    * */

    public boolean deleteRow(String tag)
    {
        db=this.getWritableDatabase();
        db.execSQL("delete from Item where tagid="+tag+";");

        return true;
    }




/*
    *   retrive data based on tagid
    * */


    public Cursor retriveData(String tag)
    {
        db=this.getWritableDatabase();
        Cursor cr=db.rawQuery("select * from Item where tagid="+tag+";", null);

        return cr;
    }


    public Cursor retriveAll()
    {
        db=this.getWritableDatabase();
        Cursor cr=db.rawQuery("select * from Item;", null);
        return cr;
    }


    //Managaer Table Operations

    public boolean insertManager(String nm,String pass, int id)
    {
        db=this.getWritableDatabase();

        ContentValues c=new ContentValues();
        c.put("m_name",nm);
        c.put("password", pass);
        c.put("m_id",id);

        db.insert("Manager", null, c);

        return true;
    }

    public Cursor retriveMan(String name)
    {
        db=this.getWritableDatabase();
        Cursor cr=db.rawQuery("select * from Item where password="+name+";", null);

        return cr;
    }
    public Cursor retriveAllManager()
    {
        db=this.getWritableDatabase();
        Cursor cr=db.rawQuery("select * from Manager ;", null);

        return cr;
    }

    //customer Table Operations


    public boolean insertCustomer(String nm, int id)
    {
        db=this.getWritableDatabase();

        ContentValues c=new ContentValues();
        c.put("c_name",nm);
        c.put("c_id",id);

        db.insert("Customer", null, c);

        return true;
    }

    public Cursor retriveCustomer(String id)
    {
        db=this.getWritableDatabase();
        Cursor cr=db.rawQuery("select * from Customer where c_id="+id+";", null);
        return cr;
    }

    public Cursor retAllCustomer()
    {
        db=this.getWritableDatabase();
        Cursor cr=db.rawQuery("select * from Customer;",null);
        return cr;
    }

    //Bill table operations


    public boolean insertBill( int bill,int cid)
    {
        db=this.getWritableDatabase();

        ContentValues c=new ContentValues();
        c.put("total_bill",bill);
        c.put("c_id",cid);

        db.insert("Bill", null, c);

        return true;
    }

    public Cursor retriveAllBill()
    {
        db=this.getWritableDatabase();
        Cursor cr=db.rawQuery("select * from Bill;", null);
        return cr;
    }

    public boolean deleteAllBill()
    {
        db=this.getWritableDatabase();
        db.execSQL("delete from Bill;");
        return true;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

}
