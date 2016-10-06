package Data;

import android.provider.BaseColumns;

/**
 * Created by Valhalla on 9/17/16.
 */
public final class HabitContract {

    private HabitContract() {

    }

    public static final class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "habits";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABITS_HABIT = "habit";
        public static final String COLUMN_HABITS_DATE = "date";
        public static final String COLUMN_HABITS_SUCCESS = "success";


        //constants for whether habit was successfully done
        public static final int HABIT_SUCCESS = 1;
        public static final int HABIT_FAILURE = 0;
        public static final int HABIT_ONGOIGN = 2;
    }
}
