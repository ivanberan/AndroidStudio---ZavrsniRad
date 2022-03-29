package com.example.zavrsni2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText etUsernameLogin;
    private EditText etPasswordLogin;
    private Button btnSignIn,btnRegister;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }

        progressDialog = new ProgressDialog(this);


        etUsernameLogin = (EditText) findViewById(R.id.etUsernameLogin);
        etPasswordLogin = (EditText) findViewById(R.id.etPasswordLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }


    private void userLogin() {
        String Username = etUsernameLogin.getText().toString().trim();
        String Password = etPasswordLogin.getText().toString().trim();

        if (TextUtils.isEmpty(Username)) {
            Toast.makeText(this, "Unesite Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(Password)) {
            Toast.makeText(this, "Unesite lozinku", Toast.LENGTH_SHORT).show();
            return;
        }


        progressDialog.setMessage("Logiranje...");
        progressDialog.show();


        firebaseAuth.signInWithEmailAndPassword(Username, Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                    }
                });

    }

    @Override
    public void onClick(View view) {
        if (view == btnSignIn) {
            userLogin();
        }
        if (view == btnRegister) {
            finish();
            startActivity(new Intent(this, Registration.class));
        }
    }

}

