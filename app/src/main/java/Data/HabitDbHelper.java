package Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Valhalla on 9/17/16.
 */
public class HabitDbHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME="habit.db";

    private static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_HABITS_TABLE = "CREATE TABLE " + HabitContract.HabitEntry.TABLE_NAME + " ("
                + HabitContract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitContract.HabitEntry.COLUMN_HABITS_HABIT + " TEXT NOT NULL, "
                + HabitContract.HabitEntry.COLUMN_HABITS_DATE + " INTEGER NOT NULL, "
                + HabitContract.HabitEntry.COLUMN_HABITS_SUCCESS + " INTEGER NOT NULL DEFAULT 0);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void clearTableData(){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(HabitContract.HabitEntry.TABLE_NAME,null,null);
    }

    public void deleteDataBase(Context context){
        context.deleteDatabase(DATABASE_NAME);
    }
}
