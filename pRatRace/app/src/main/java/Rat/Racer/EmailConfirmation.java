package Rat.Racer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.result.AuthSignInResult;
import com.amplifyframework.auth.result.AuthSignUpResult;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.datastore.DataStoreException;
import com.amplifyframework.datastore.DataStoreItemChange;
import com.amplifyframework.datastore.generated.model.AppUser;

public class EmailConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_confirmation);
    }

    public void onConfirmButtonPressed(View view) {
        // 1. Confirm the code sent to email
        // 2. Re-login (automatically)
        // 3. Save users details in data store

        EditText txtConfirmCode = findViewById(R.id.txtConfirmationCode);

        Amplify.Auth.confirmSignUp(
                getEmail(),
                txtConfirmCode.getText().toString(),
                this::onSuccess,
                this::onError
        );}

    private void onSuccess(AuthSignUpResult authSignUpResult) {
        relogin();
    }

    private void relogin() {
        String email = getEmail();
        String password = getPassword();

        Amplify.Auth.signIn(
                email,
                password,
                this::onLoginSuccess,
                this::onError
        );
    }

    private void onLoginSuccess(AuthSignInResult authSignInResult) {
        String userId = Amplify.Auth.getCurrentUser().getUserId();
        String username = getUsername();

        Amplify.DataStore.save(
                AppUser.builder().id(userId).name(username).build(),
                this::onSavedSuccess,
                this::onError

        );
    }

    private <T extends Model> void onSavedSuccess(DataStoreItemChange<T> tDataStoreItemChange) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void onError(DataStoreException e) {
        this.runOnUiThread(() -> {
            Log.e ("datastore", "unable to store data");
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG)
                    .show();
        });
    }

    private void onError(AuthException e) {
        this.runOnUiThread(() -> {
            Log.e ("Auth", "SIGNUP ERROR");
            Toast.makeText(getApplicationContext(), "Unable to Sign Up at the moment...", Toast.LENGTH_LONG)
                    .show();
        });
    }

    private String getEmail() {
        return getIntent().getStringExtra("email");
    }

    private String getPassword() {
        return getIntent().getStringExtra("password");
    }

    private String getUsername() {
        return getIntent().getStringExtra("username");
    }

}