package com.mediocremidgardian.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import Data.HabitContract.HabitEntry;
import Data.HabitDbHelper;



public class MainActivity extends AppCompatActivity {

    private HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDbHelper = new HabitDbHelper(this);

        insertData();

        readData();

        //dummy value for illustrative purposes
        long rowId = 1;
        updateData(rowId);

    }


    public void insertData(){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABITS_HABIT, "Floss");
        values.put(HabitEntry.COLUMN_HABITS_DATE, "10/1/16");
        values.put(HabitEntry.COLUMN_HABITS_SUCCESS,
                HabitEntry.HABIT_SUCCESS);

        if (db.insert(HabitEntry.TABLE_NAME,null,values)==-1){
            Toast.makeText(this,"Error saving habit data",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Habit saved successfully",Toast.LENGTH_LONG).show();
        }

        values.clear();
        values.put(HabitEntry.COLUMN_HABITS_HABIT, "Run");
        values.put(HabitEntry.COLUMN_HABITS_DATE, "9/30/16");
        values.put(HabitEntry.COLUMN_HABITS_SUCCESS,
                        HabitEntry.HABIT_FAILURE);

        if (db.insert(HabitEntry.TABLE_NAME,null,values)==-1){
            Toast.makeText(this,"Error saving habit data",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Habit saved successfully",Toast.LENGTH_LONG).show();
        }

    }

    public Cursor readData() {

        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor c = db.query(HabitEntry.TABLE_NAME,null,null,null,null,null,null);
        return c;
    }

    public void updateData(long rowId){

        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues updateValues = new ContentValues();

        updateValues.put(HabitEntry.COLUMN_HABITS_HABIT,"Run");
        updateValues.put(HabitEntry.COLUMN_HABITS_DATE,"9/30/16");
        updateValues.put(HabitEntry.COLUMN_HABITS_SUCCESS,
                                       HabitEntry.HABIT_SUCCESS);

        String selection = HabitEntry._ID + " LIKE ?";
        String[] selectionArgs = { String.valueOf(rowId) };

        db.update(HabitEntry.TABLE_NAME,updateValues,selection,selectionArgs);

    }

}
