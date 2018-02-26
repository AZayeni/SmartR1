package DAL.SQLLiteHelper;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import DAL.TableHelpers.UserTable;


public final class SRSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_Version = 1;

    public final static String Base_Name = "SmartR";






    public SRSQLiteOpenHelper(Context context, SQLiteDatabase.CursorFactory factory) {

        super(context, Base_Name, factory, DATABASE_Version);
        //Log.v("DATABASE_Version",""+DATABASE_Version);

    }
    //Context context, SQLiteDatabase.CursorFactory factory
    public SRSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public String getDatabaseName() {
        return super.getDatabaseName();
    }

    @Override
    public void setWriteAheadLoggingEnabled(boolean enabled) {
        super.setWriteAheadLoggingEnabled(enabled);
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override
    public synchronized void close() {
        super.close();
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserTable.getCreateTableSQL());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (  DATABASE_Version!=oldVersion ) {
            //Log.v("Drop: ","Droped");
            db.execSQL("DROP TABLE " + UserTable.getTable_Name() + ";");
            onCreate(db);
        }
    }
}
