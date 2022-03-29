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

//
public class Registration extends AppCompatActivity implements View.OnClickListener {

    private EditText edUsername;
    private EditText edPassword;

    private Button btnRegister,btnSignin;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firebaseAuth=FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!= null){
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }


        progressDialog=new ProgressDialog(this);


        edUsername = (EditText) findViewById(R.id.etUsername);
        edPassword=(EditText)findViewById(R.id.edPassword);
        btnSignin = (Button) findViewById(R.id.btnSignin);
        btnRegister=(Button)findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(this);
        btnSignin.setOnClickListener(this);
    }


    private void registerUser(){
        String Email = edUsername.getText().toString().trim();
        String Password= edPassword.getText().toString().trim();

        if(TextUtils.isEmpty(Email)){
            Toast.makeText(this,"Unesite Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Password)){
            Toast.makeText(this,"Unesite lozinku", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Making your profile...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(),ProfileDetails.class));
                        }else{
                            Toast.makeText(Registration.this,"Registracija nije uspjela", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }
    @Override
    public void onClick(View view) {
        if(view==btnRegister){
            registerUser();
        }
        if(view==btnSignin){
            startActivity(new Intent(this, Login.class));
        }
    }
}
