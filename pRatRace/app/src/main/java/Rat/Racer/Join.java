package Rat.Racer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignInOptions;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.auth.result.AuthSignUpResult;
import com.amplifyframework.core.Amplify;

public class Join extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

    }

    public void onPressJoinPressed(View view) {
        EditText txtEmail = findViewById(R.id.txtEmail);
        EditText txtPassword = findViewById(R.id.txtPassword);
        EditText txtUsername = findViewById(R.id.txtUsername);

        AuthSignUpOptions options = AuthSignUpOptions.builder()
                .userAttribute(AuthUserAttributeKey.preferredUsername(), txtUsername.getText().toString())
                .build();
        Amplify.Auth.signUp(
                txtEmail.getText().toString(),
                txtPassword.getText().toString(),
                options,
                this::onJoinSucces,
                this::onJoinError
        );
    }

    private void onJoinError(AuthException e) {
        this.runOnUiThread(() -> {
            Log.e ("Auth", "SIGNUP ERROR");
            Toast.makeText(getApplicationContext(), "Unable to Sign Up at the moment...", Toast.LENGTH_LONG)
                    .show();
        });
    }

    private void onJoinSucces(AuthSignUpResult authSignUpResult) {
        Intent intent = new Intent(this, EmailConfirmation.class);

        EditText txtEmail = findViewById(R.id.txtEmail);
        EditText txtPassword = findViewById(R.id.txtPassword);
        EditText txtUsername = findViewById(R.id.txtUsername);

        intent.putExtra("email", txtEmail.getText().toString());
        intent.putExtra("password", txtPassword.getText().toString());
        intent.putExtra("username", txtUsername.getText().toString());

        startActivity(intent);
        finish();
    }
}