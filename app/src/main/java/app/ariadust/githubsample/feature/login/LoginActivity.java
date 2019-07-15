package app.ariadust.githubsample.feature.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import app.ariadust.githubsample.R;
import app.ariadust.githubsample.feature.repositori.RepositoryListActivity;
import app.ariadust.githubsample.github.Github;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Bobby on 2019-06-20.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Github github = new Github(this);

        final EditText editTextEmail = findViewById(R.id.ediTextEmail);
        final EditText editTextPassword = findViewById(R.id.ediTextPassword);
        final Button buttonLogin = findViewById(R.id.buttonLogin);

//        buttonLogin.setOnClickListener(view -> {
//            github.getStorage().setCredentials(editTextEmail.getText().toString(), editTextPassword.getText().toString());
//            startActivity(new Intent(LoginActivity.this, RepositoryListActivity.class));
////            Intent intent = new Intent(LoginActivity.this, RepositoryListActivity.class);
////            intent.putExtra("username", editTextEmail.getText().toString());
////            startActivity(intent);
//            finish();
//        });

        buttonLogin.setOnClickListener(view -> {
            if (!validateEmail(editTextEmail.getText().toString())){
                editTextEmail.setError("Invalid Email");
                editTextEmail.requestFocus();
            }else if (!validatePassword(editTextPassword.getText().toString())) {
                editTextPassword.setError("Invalid Password");
                editTextPassword.requestFocus();
            }else {
                github.getStorage().setCredentials(editTextEmail.getText().toString(), editTextPassword.getText().toString());
                startActivity(new Intent(LoginActivity.this, RepositoryListActivity.class));
                finish();
            }
        });
    }

    private boolean validateEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    private boolean validatePassword(String password) {
        if (password != null && password.length()>3) {
            return true;
        }else {
            return false;
        }
    }
}
