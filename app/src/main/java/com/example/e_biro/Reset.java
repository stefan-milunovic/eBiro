package com.example.e_biro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Reset extends AppCompatActivity {
     Button btn_reset;
     EditText email2;
    FirebaseAuth mFirebaseAuth;
    Vibrator vibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        btn_reset=findViewById(R.id.btn_reset);
        email2=findViewById(R.id.email2);
        mFirebaseAuth = FirebaseAuth.getInstance();
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String useremail = email2.getText().toString();
                vibrator.vibrate(10);
                if (TextUtils.isEmpty(useremail)){
                    Toast.makeText(Reset.this, "Unesite email adresu!", Toast.LENGTH_SHORT).show();
                }
                else {
                    mFirebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Reset.this, "Proverite vaš email,kako bi resetovali lozinku! ", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Reset.this,MainActivity.class));
                            }
                            else{
                                String message = "Vaša lozinka nije ispravnog formata!";
                                Toast.makeText(Reset.this, "Dogodila se greška!"+message, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
