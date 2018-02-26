package DAL.Implementations;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.content.Context;

import DAL.Contacts.ICRUD;
import DAL.Contacts.SuperDAO;
import DAL.TableHelpers.UserTable;
import Models.User;

/**
 * Created by AZayeni on 20/02/2018.
 */

public class UserDAO extends SuperDAO<User>   {


    public UserDAO(Context context) {
        super(context);
    }

    public long Add(User entity){
        ContentValues values = new ContentValues();

        this.Open();
        values.put(UserTable.getColumn_UserID(), entity.getUserID());
        values.put(UserTable.getColumn_CompanyCode(), entity.getCompanyCode());
        values.put(UserTable.getColumn_FirstName(), entity.getFirstName());
        values.put(UserTable.getColumn_LastName(), entity.getLastName());
        values.put(UserTable.getColumn_PayrollNo(), entity.getPayrollNo());
        values.put(UserTable.getColumn_UserName(), entity.getUserName());
        values.put(UserTable.getColumn_Password(), entity.getPassword());
        values.put(UserTable.getColumn_Active(), entity.getActive()?1:0);
        long result= db.insert(UserTable.getTable_Name(), null, values);
        this.Close();
        return result;
    }
    public void Update(User entity){
        ContentValues values = new ContentValues();

        this.Open();
        values.put(UserTable.getColumn_UserID(), entity.getUserID());
        values.put(UserTable.getColumn_CompanyCode(), entity.getCompanyCode());
        values.put(UserTable.getColumn_FirstName(), entity.getFirstName());
        values.put(UserTable.getColumn_LastName(), entity.getLastName());
        values.put(UserTable.getColumn_PayrollNo(), entity.getPayrollNo());
        values.put(UserTable.getColumn_UserName(), entity.getUserName());
        values.put(UserTable.getColumn_Password(), entity.getPassword());
        values.put(UserTable.getColumn_Active(), entity.getActive()?1:0);
        db.update(UserTable.getTable_Name(),values,UserTable.getColumn_UserID()+"=?",
                new String[]{String.valueOf(entity.getUserID())});
        this.Close();
    }
    public User Get(int id,int CompanyCode){

        return  Get(String.valueOf(id),String.valueOf(CompanyCode));
    }
    public User Get(String id,String CompanyCode){
        User user ;
        this.Open();
        Cursor c = db.query(UserTable.getTable_Name(), UserTable.getDefaultSelection(),
                UserTable.getColumn_UserID()+"=? and "+UserTable.getColumn_CompanyCode()+"=?",new String[]{id,CompanyCode} , null, null, null);
        int count = c.getCount();

        if (count == 0) {
            return null;
        }



        else if (count == 1 && c.moveToNext()) {
            user = new User(c.getInt(0),c.getInt(1), c.getString(2), c.getString(3),c.getString(4), c.getString(5), c.getString(6),c.getInt(7)!=0 );




        }
        else
        {
            throw new RuntimeException("more than one user with the same id");

        }

        c.close();
        this.Close();
        return  user;
    }
    public List<User> GetALL(){
        List<User> users =new ArrayList<User>();
        this.Open();
        Cursor c = db.query(UserTable.getTable_Name(), UserTable.getDefaultSelection(),
                null,null , null, null, null);
        int count = c.getCount();

        if (count == 0) {
            return null;
        }
        else
        {
            while ( c.moveToNext()) {
                User user = new User(c.getInt(0),c.getInt(1), c.getString(2), c.getString(3),c.getString(4), c.getString(5), c.getString(6),c.getInt(7)!=0 );
                users.add(user);
            }

        }

        c.close();
        this.Close();
        return  users;
    }
    public void Delete(int id,int CompanyCode){
        this.Open();
        db.delete(UserTable.getTable_Name(),UserTable.getColumn_UserID()+ "=?",new String[]{String.valueOf(id)});
        this.Close();
    }
    public void setInactiveExcept(int userID,int CompanyCode)
    {
        ContentValues values = new ContentValues();

        this.Open();

        values.put(UserTable.getColumn_Active(), 0);
        db.update(UserTable.getTable_Name(),values,UserTable.getColumn_UserID()+"<>? or "+UserTable.getColumn_CompanyCode()+"<>?",
                new String[]{String.valueOf(userID),String.valueOf(CompanyCode)});
        this.Close();
    }
    public long Attach(User entity){

        long result;
        this.Open();
        User user=Get(entity.getUserID(),entity.getCompanyCode());
        if(user==null)
        {
            result=Add(entity);
        }
        else
        {
            Update(entity);
            result=entity.getUserID();
        }
        this.Close();
        return result;
    }
    public  User GetCurrentUser(){
        User user ;
        this.Open();
        Cursor c = db.query(UserTable.getTable_Name(), UserTable.getDefaultSelection(),
                UserTable.getColumn_Active()+"=1",null , null, null, null);
        int count = c.getCount();

        if (count == 0) {
            return null;
        }



        else if (count == 1 && c.moveToNext()) {
            user = new User(c.getInt(0),c.getInt(1), c.getString(2), c.getString(3),c.getString(4), c.getString(5), c.getString(6),c.getInt(7)!=0 );




        }
        else
        {
            throw new RuntimeException("more than one user with the same id");

        }
        return user;
    }
    public   void SetCurrentUser(User entity){
        Attach(entity);
        setInactiveExcept(entity.getUserID(),entity.getCompanyCode());
    }
}
