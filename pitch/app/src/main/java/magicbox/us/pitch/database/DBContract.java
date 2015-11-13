package magicbox.us.pitch.database;

import android.provider.BaseColumns;

/**
 * Created by yangwu on 11/13/15.
 */
public final class DBContract {
    
    public DBContract() {}

    /* Inner class that defines the table contents */
    public static abstract class DBEntry implements BaseColumns {
        public static final String TABLE_NAME = "pitch";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        // TODO: complete columns
    }
}
