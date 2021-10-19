package com.example.takeaway;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.takeaway.Modelss.OrdersModel;

import java.util.ArrayList;

public class DBOhelper extends SQLiteOpenHelper {

    final static String DATANAME= "databasetwo.db";
    final static int DBversion=2;

    public DBOhelper(@Nullable Context context ) {
        super(context, DATANAME, null, DBversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table orders"+
                "(id integer primary key autoincrement," +
                "name text," +
                "phone text," +
                "address text," +
                "price int," +
                "image int," +
                "quantity int," +
                "description text," +
                "foodname text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table if exists orders");
        onCreate(db);

    }

    public boolean insertOrder(String name,String phone,String address, int price, int image,
                               int quantity,String desc,String foodname){

        SQLiteDatabase database=getReadableDatabase();
        ContentValues values= new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("address",address);
        values.put("price",price);
        values.put("image",image);
        values.put("quantity",quantity);
        values.put("description",desc);
        values.put("foodname",foodname);
       long d= database.insert("orders",null,values);

       if(d <= 0)
       {
           return false;
       }
       else
       {
           return true;
       }


    }

    public ArrayList<OrdersModel> getOrders(){
        ArrayList<OrdersModel> orders=new ArrayList<>();
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("Select id,foodname,image,price from orders",null);
        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                OrdersModel model=new OrdersModel();
                model.setOrderNumber(cursor.getString(0));
                model.setSoldItem(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setPrice(cursor.getString(3));
                orders.add(model);

            }
        }
        cursor.close();
        database.close();
        return orders;
    }
    public Cursor getOrderById(int id){
        SQLiteDatabase database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("Select * from orders where id=" +id,null);

        if (cursor!=null)
        {
            cursor.moveToFirst();
        }

        return cursor;
    }

    public boolean updateOrder(String name,String phone,String address, int price, int image,
                               int quantity,String desc,String foodname,int id){

        SQLiteDatabase database=getReadableDatabase();
        ContentValues values= new ContentValues();
        values.put("name",name);
        values.put("phone",phone);
        values.put("address",address);
        values.put("price",price);
        values.put("image",image);
        values.put("quantity",quantity);
        values.put("description",desc);
        values.put("foodname",foodname);

        long row=database.update("orders",values,"id="+id,null);

        if(row <= 0)
        {
            return false;
        }
        else
        {
            return true;
        }


    }

    public int deleteOrder(String id){
        SQLiteDatabase database=this.getWritableDatabase();
        return database.delete("orders","id="+id,null);
    }


}
