package roster.smart.extech.smartr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import DAL.Implementations.UserDAO;
import Models.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserDAO userDAO=new UserDAO(MainActivity.this);
        User user=userDAO.GetCurrentUser();
        if (user==null) {
            Intent intent;
            intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
