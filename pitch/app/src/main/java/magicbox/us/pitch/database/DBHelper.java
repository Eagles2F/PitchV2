package magicbox.us.pitch.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import magicbox.us.pitch.database.DBContract.ChatDB;
import magicbox.us.pitch.database.DBContract.PitchDB;
import magicbox.us.pitch.database.DBContract.UserDB;

/**
 * Helper class to sqlite3
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String REFERENCES = " REFERENCES ";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_USER =
            "CREATE TABLE " + UserDB.TABLE_NAME + " (" +
                    UserDB._ID + " INTEGER PRIMARY KEY," +
                    UserDB.COLUMN_NAME_PASSWORD + TEXT_TYPE + COMMA_SEP +
                    UserDB.COLUMN_NAME_USER_NAME + TEXT_TYPE + COMMA_SEP +
                    UserDB.COLUMN_NAME_EMAIL + TEXT_TYPE + COMMA_SEP +
                    UserDB.COLUMN_NAME_HEADLINE + TEXT_TYPE + COMMA_SEP +
                    // 0: false, 1: true
                    UserDB.COLUMN_NAME_PICTCHABLE + INTEGER_TYPE + COMMA_SEP +
                    UserDB.COLUMN_NAME_PICTURE + TEXT_TYPE + // COMMA_SEP +
                    ")";
//                    " PRIMARY KEY (" +
//                    UserDB.COLUMN_NAME_USER_ID +
//                    "))";

    private static final String SQL_CREATE_PITCH =
            "CREATE TABLE " + PitchDB.TABLE_NAME + " (" +
                    PitchDB._ID + " INTEGER PRIMARY KEY," +
                    PitchDB.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    PitchDB.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    PitchDB.COLUMN_NAME_DATE + TEXT_TYPE + // COMMA_SEP +
                    ")";
//                    " PRIMARY KEY (" +
//                    PitchDB.COLUMN_NAME_PITCH_ID +
//                    "))";

    private static final String SQL_CREATE_CHAT =
            "CREATE TABLE " + ChatDB.TABLE_NAME + " (" +
                    ChatDB._ID + " INTEGER PRIMARY KEY," +
                    ChatDB.COLUMN_NAME_AUTHOR + INTEGER_TYPE + COMMA_SEP +
                    ChatDB.COLUMN_NAME_PID + INTEGER_TYPE + COMMA_SEP +
                    ChatDB.COLUMN_NAME_MESSAGE + TEXT_TYPE + COMMA_SEP +
                    " FOREIGN KEY (" +
                    ChatDB.COLUMN_NAME_AUTHOR + ")" + REFERENCES + UserDB.TABLE_NAME + "(" + UserDB._ID + "), " +
                    " FOREIGN KEY (" +
                    ChatDB.COLUMN_NAME_PID + ")" + REFERENCES + PitchDB.TABLE_NAME + "(" + PitchDB._ID + ")" +
                    ")";

    private static final String SQL_DELETE_USER =
            "DROP TABLE IF EXISTS " + UserDB.TABLE_NAME;

    private static final String SQL_DELETE_PITCH =
            "DROP TABLE IF EXISTS " + PitchDB.TABLE_NAME;

    private static final String SQL_DELETE_CHAT =
            "DROP TABLE IF EXISTS " + ChatDB.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "pitch.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        // do NOT change order
        db.execSQL(SQL_DELETE_USER);
        db.execSQL(SQL_DELETE_PITCH);
        db.execSQL(SQL_DELETE_CHAT);

        db.execSQL(SQL_CREATE_USER);
        db.execSQL(SQL_CREATE_PITCH);
        db.execSQL(SQL_CREATE_CHAT);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_USER);
        db.execSQL(SQL_DELETE_PITCH);
        db.execSQL(SQL_DELETE_CHAT);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
