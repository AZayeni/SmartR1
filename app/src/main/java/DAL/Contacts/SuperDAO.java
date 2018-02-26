package DAL.Contacts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import DAL.SQLLiteHelper.SRSQLiteOpenHelper;

/**
 * Created by AZayeni on 20/02/2018.
 */

public abstract class SuperDAO<T> implements ICRUD<T>{
    private SRSQLiteOpenHelper srSQLiteOpenHelper;
    protected SQLiteDatabase db;

    public SuperDAO(Context context) {
          srSQLiteOpenHelper= new SRSQLiteOpenHelper(context, null);
        if(srSQLiteOpenHelper==null)
            Log.v("dberror: ",""+context.getClass());
    }

    public void Open() {

        db = srSQLiteOpenHelper.getWritableDatabase();
    }

    public SQLiteDatabase get_DATABASE() {
        return db;
    }

    public void SET_DATABASE(SQLiteDatabase dbb) {
        db = dbb;
    }

    public void Close() {
        db.close();
    }
}
