package magicbox.us.pitch.database;

import android.provider.BaseColumns;

/**
 * Created by yangwu on 11/13/15.
 */
public final class DBContract {

    public DBContract() {}

    /* Inner class that defines the table contents */
    public static abstract class UserDB implements BaseColumns {
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME_USER_ID = "uid";
        public static final String COLUMN_NAME_USER_NAME = "name";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_HEADLINE = "headline";
        public static final String COLUMN_NAME_PICTURE = "picture";
        public static final String COLUMN_NAME_PICTCHABLE = "pitchable";
    }

    public static abstract class ChatDB implements BaseColumns {
        public static final String TABLE_NAME = "chat";
        public static final String COLUMN_NAME_MESSAGE = "message";
        public static final String COLUMN_NAME_AUTHOR = "author";
        public static final String COLUMN_NAME_PID = "pid";
    }

    public static abstract class PitchDB implements BaseColumns {
        public static final String TABLE_NAME = "pitch";
        public static final String COLUMN_NAME_PITCH_ID = "pid";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
    }

}
