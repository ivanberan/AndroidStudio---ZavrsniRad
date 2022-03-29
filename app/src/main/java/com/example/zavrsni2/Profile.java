package com.example.zavrsni2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

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

public class Profile extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private FirebaseUser FireUser;
    private DatabaseReference reff;
    private User user;
    private String temp;
    private TextView tvusername,tvfirstname,tvlastname,tvprogress1,tvprogress2,tvprogress3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth=FirebaseAuth.getInstance();
        FireUser= firebaseAuth.getCurrentUser();
        temp=FireUser.getEmail();
        temp=temp.replace("@","");
        temp=temp.replace(".","");
        temp=md5(temp);

        tvfirstname=(TextView)findViewById(R.id.tvPfirstname);
        tvlastname=(TextView)findViewById(R.id.tvPlastname);
        tvusername=(TextView)findViewById(R.id.tvPusername);
        tvprogress1=(TextView)findViewById(R.id.tvProgress1);

        reff= FirebaseDatabase.getInstance().getReference().child("User").child(temp);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String firstname=dataSnapshot.child("firstname").getValue().toString();
                String lastname=dataSnapshot.child("lastname").getValue().toString();
                String username=dataSnapshot.child("username").getValue().toString();
                String score=dataSnapshot.child("score").getValue().toString();
                tvfirstname.setText(firstname);
                tvlastname.setText(lastname);
                tvprogress1.setText(score);
                tvusername.setText(username);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
