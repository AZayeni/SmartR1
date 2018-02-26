package Models;

/**
 * Created by AZayeni on 20/02/2018.
 */

public final class LoginVM {
    private int CompanyCode;
    private String UserName;
    private String Password;
    public LoginVM() {

    }
    public int getCompanyCode() {
        return CompanyCode;
    }

    public void setCompanyCode(int companyCode) {
        CompanyCode = companyCode;
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



}
