package Models;

import DAL.Contacts.ICRUD;

/**
 * Created by AZayeni on 20/02/2018.
 */

public class User {
    private  int UserID;
    private  int CompanyCode;
    private  String FirstName;
    private  String LastName;
    private  String PayrollNo;
    private  String UserName;
    private  String Password;
    private  Boolean Active;

    public User() {

    }

    public User(int userID, int companyCode, String firstName, String lastName, String payrollNo, String userName, String password, Boolean active) {
        UserID = userID;
        CompanyCode = companyCode;
        FirstName = firstName;
        LastName = lastName;
        PayrollNo = payrollNo;
        UserName = userName;
        Password = password;
        Active = active;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getCompanyCode() {
        return CompanyCode;
    }

    public void setCompanyCode(int companyCode) {
        CompanyCode = companyCode;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPayrollNo() {
        return PayrollNo;
    }

    public void setPayrollNo(String payrollNo) {
        PayrollNo = payrollNo;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Boolean getActive() {
        return Active;
    }

    public void setActive(Boolean active) {
        Active = active;
    }
}
