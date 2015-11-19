package magicbox.us.pitch.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import magicbox.us.pitch.database.DBHelper;
import magicbox.us.pitch.database.DBContract.*;
import magicbox.us.pitch.entities.Chat;
import magicbox.us.pitch.entities.Pitch;
import magicbox.us.pitch.entities.User;

/**
 * Entry class between UI and Database packages
 */
public class DBEntry {
    Context context;

    SQLiteDatabase db;
    DBHelper dbHelper;

    public DBEntry(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public long register(User user){
        ContentValues values = new ContentValues();

        values.put(UserDB.COLUMN_NAME_USER_NAME, user.getmName());
        values.put(UserDB.COLUMN_NAME_PASSWORD, user.getmPassword());
        values.put(UserDB.COLUMN_NAME_EMAIL, user.getmEmail());
        values.put(UserDB.COLUMN_NAME_HEADLINE, user.getmHeadline());
        values.put(UserDB.COLUMN_NAME_PICTURE, user.getmPictureUrl());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                UserDB.TABLE_NAME,
                null,
                values);

        return newRowId;
    }

    public long createPitch(Pitch pitch){
        ContentValues values = new ContentValues();

        values.put(PitchDB.COLUMN_NAME_TITLE, pitch.getTitle());
        values.put(PitchDB.COLUMN_NAME_DESCRIPTION, pitch.getDescription());
        values.put(PitchDB.COLUMN_NAME_DATE, pitch.getDate());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                UserDB.TABLE_NAME,
                null,
                values);

        return newRowId;
    }

    public long addChat(Chat chat){
        ContentValues values = new ContentValues();

        values.put(ChatDB.COLUMN_NAME_AUTHOR, chat.getAuthor());
        values.put(ChatDB.COLUMN_NAME_PID, chat.getPid());
        values.put(ChatDB.COLUMN_NAME_MESSAGE, chat.getMessage());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                UserDB.TABLE_NAME,
                null,
                values);

        return newRowId;
    }

}
