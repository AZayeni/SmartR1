package DAL.TableHelpers;



public class UserTable {
    public static String getTable_Name() {
        return Table_Name;
    }

    private static String Table_Name = "User";



    private static String Column_UserID = "UserID";
    private static int NUM_Column_UserID = 0;
    private static String Column_CompanyCode = "CompanyCode";
    private static int NUM_Column_CompanyCode = 1;

    private static String Column_FirstName = "FirstName";
    private static int NUM_Column_FirstName = 2;

    private static String Column_LastName = "LastName";
    private static int NUM_Column_LastName = 3;



    private static String Column_PayrollNo = "PayrollNo";
    private static int NUM_Column_PayrollNo = 4;

    private static String Column_Password = "Password";
    private static int NUM_Column_Password = 5;

    private static String Column_UserName = "UserName";
    private static int NUM_Column_UserName = 6;
    private static String Column_Active = "Active";
    private static int NUM_Column_Active = 7;



    private static  String CreateTableSQL = "CREATE TABLE " + Table_Name + " (" +
            Column_UserID + " Integer NOT NULL," +
            Column_CompanyCode + " Integer NOT NULL," +
            Column_FirstName + " TEXT NOT NULL, " +
            Column_LastName + " TEXT NOT NULL, " +
            Column_PayrollNo + " TEXT NOT NULL ,"+
            Column_UserName + " TEXT NOT NULL ,"+
            Column_Password+" TEXT NOT NULL, "+
            Column_Active+" Integer NOT NULL,"+
            "PRIMARY KEY ("+Column_UserID+","+Column_CompanyCode+")"+
            ");";
    private static String [] DefaultSelection = new String[]{
            UserTable.getColumn_UserID(),UserTable.getColumn_CompanyCode(), UserTable.getColumn_FirstName(),UserTable.getColumn_LastName(),
            UserTable.getColumn_PayrollNo(),UserTable.getColumn_UserName(), UserTable.getColumn_Password(),UserTable.getColumn_Active()
    };
    public static String getCreateTableSQL() {
        return CreateTableSQL;
    }

    public static String getColumn_UserID() {
        return Column_UserID;
    }

    public static String getColumn_CompanyCode() {
        return Column_CompanyCode;
    }

    public static String getColumn_FirstName() {
        return Column_FirstName;
    }

    public static String getColumn_LastName() {
        return Column_LastName;
    }

    public static String getColumn_PayrollNo() {
        return Column_PayrollNo;
    }

    public static String getColumn_Password() {
        return Column_Password;
    }

    public static String getColumn_Active() {
        return Column_Active;
    }

    public static String getColumn_UserName() {
        return Column_UserName;
    }


    public static String[] getDefaultSelection() {
        return DefaultSelection;
    }
}
