package com.example.utsav.taskqr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ExampleDB extends SQLiteOpenHelper {
    private static final String DATABASE="sample_db";
    private  static final String TABLE_NAME="employee";
    public  static  final  String CODE="code";

    public ExampleDB(Context context) {
        super(context,DATABASE,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL( "Create table "+TABLE_NAME +"("+CODE+" TEXT"+")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL( "DROP TABLE IF EXISTS "+TABLE_NAME );
        onCreate( sqLiteDatabase );
    }
    public void  insert(String s1)
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues(  );
        contentValues.put( CODE,s1 );
        sqLiteDatabase.insert( TABLE_NAME,null,contentValues );
    }

    public ArrayList<String> getData() {
        ArrayList arr1=new ArrayList();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery( "SELECT code FROM " + TABLE_NAME,null );
        if (cursor != null && cursor.moveToFirst()){

            while(!cursor.isAfterLast()){
              arr1.add(cursor.getString(0));
                cursor.moveToNext();
            }
        }
        return arr1;


    }
}