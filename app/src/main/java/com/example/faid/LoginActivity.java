package com.example.faid;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    RelativeLayout relative;
    Snackbar snackbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

    }

    public void goToSignUp(View view) {
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
    }

    public void logIn(View view) {
        TextInputEditText loginet = findViewById(R.id.emaillog);
        TextInputEditText passwordet = findViewById(R.id.passwordlog);
        String email = loginet.getText().toString();
        String password = passwordet.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("state", "login");
                            intent.putExtras(bundle);
                            startActivity(intent);
                            //Toast.makeText(LoginActivity.this, "Welcome.", Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                           Snackbar.make(findViewById(android.R.id.content), "Log in failed.", Snackbar.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    }

