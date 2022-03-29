package com.example.zavrsni2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ProfileDetails extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseUser FireUser;
    private EditText etUsername,etFirstname,etLastname;
    private Spinner spinSex;
    private Button btnSignup;
    private DatabaseReference reff;
    private User user;
    String email;
    long maxid=0;
    String temp2;
    String[] temp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details);

        firebaseAuth=FirebaseAuth.getInstance();
        reff= FirebaseDatabase.getInstance().getReference().child("User");

        etUsername=(EditText)findViewById(R.id.etUsername);
        etFirstname=(EditText)findViewById(R.id.etFirstname);
        etLastname=(EditText)findViewById(R.id.etLastname);
        spinSex=(Spinner)findViewById(R.id.spinSex);
        btnSignup=(Button)findViewById(R.id.btnSignup);
        user=new User();

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    maxid=(dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        if(firebaseAuth.getCurrentUser()== null){
            finish();
            startActivity(new Intent(this,Registration.class));
        }else{
            FireUser= firebaseAuth.getCurrentUser();
        }


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username=(etUsername.getText().toString().trim());
                String firstname=(etFirstname.getText().toString().trim());
                String lastname=(etLastname.getText().toString().trim());
                String sex=(spinSex.getSelectedItem().toString().trim());
                email=FireUser.getEmail().toString();
                Integer progress=0;
                Integer score=0;


                if(TextUtils.isEmpty(username)){
                    Toast.makeText(ProfileDetails.this,"Enter Username",Toast.LENGTH_LONG).show();

                }
                else if(TextUtils.isEmpty(firstname)){
                    Toast.makeText(ProfileDetails.this,"Enter first name",Toast.LENGTH_LONG).show();

                }
                else if(TextUtils.isEmpty(lastname)){
                    Toast.makeText(ProfileDetails.this,"Enter last name",Toast.LENGTH_LONG).show();

                }
                else {
                    user.setUsername(username);
                    user.setFirstname(firstname);
                    user.setLastname(lastname);
                    user.setEmail(email);
                    user.setSex(sex);
                    user.setProgress(0);
                    user.setScore(0);
                    //String id=reff.push().getKey();
                    String id=String.valueOf(maxid+1);
                    user.setUserID(id);
                    String[] temp1=email.split("@");

                    temp3=temp1[1].split(".");
                    temp2=email.replace("@","");
                    temp2=temp2.replace(".","");

                    //temp1=temp2.split(".");
                    //temp2=temp1[0]+""+temp1[1];
                    reff.child(md5(temp2)).setValue(user);
                    finish();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
            }
        });


    }
    public static String md5(String s)
    {
        MessageDigest digest;
        try
        {
            digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes(Charset.forName("US-ASCII")),0,s.length());
            byte[] magnitude = digest.digest();
            BigInteger bi = new BigInteger(1, magnitude);
            String hash = String.format("%0" + (magnitude.length << 1) + "x", bi);
            return hash;
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return "";
    }

}

