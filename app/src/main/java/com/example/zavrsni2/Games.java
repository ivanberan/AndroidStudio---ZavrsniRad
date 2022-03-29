package com.example.zavrsni2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Games extends AppCompatActivity {
private Button btnMemory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        btnMemory=(Button)findViewById(R.id.btnMemory);
        btnMemory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertdialogBuilder = new AlertDialog.Builder(Games.this);
                alertdialogBuilder
                        .setMessage("Choose player number").setCancelable(false)
                        .setPositiveButton("2 Players", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), Memory.class);
                        intent.putExtra("players",2);
                        startActivity(intent);

                    }
                }).setNegativeButton("1 Player", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), Memory.class);
                        intent.putExtra("players",1);
                        startActivity(intent);


                    }
                });
                AlertDialog alertDialog=alertdialogBuilder.create();
                alertDialog.show();
                //startActivity(new Intent(getApplicationContext(),Memory.class).putExtra("players",1));
            }
        });
    }
}
