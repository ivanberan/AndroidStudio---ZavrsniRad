package com.example.zavrsni2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button btnLogout,btnGames,btnProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        btnLogout=(Button)findViewById(R.id.btnLogout);
        btnGames=(Button)findViewById(R.id.btnGames);
        btnProfile=(Button)findViewById(R.id.btnProfile);
        firebaseAuth=FirebaseAuth.getInstance();

        FirebaseUser user= firebaseAuth.getCurrentUser();
        //Toast toast= Toast.makeText(getApplicationContext(),user.getEmail()+"!",Toast.LENGTH_SHORT);
        if(firebaseAuth.getCurrentUser()== null){
            finish();
            startActivity(new Intent(this,Login.class));
        }
        btnProfile.setText(user.getEmail());
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Profile.class));
            }
        });
        btnGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),Games.class));
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               logout();
            }
        });
    }
    private void logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(this, Login.class));
    }
}
