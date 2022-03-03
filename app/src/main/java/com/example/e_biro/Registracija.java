package com.example.e_biro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registracija extends AppCompatActivity {
    EditText emailID, lozinkaID, imeID, prezimeID, loz2ID;
    Button btn_registracijaID, btn_nazad;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    RelativeLayout rellay1, rellay2;
    CheckBox pass, pass1;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registracija);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        emailID = findViewById(R.id.email);
        lozinkaID = findViewById(R.id.lozinka1);
        loz2ID = findViewById(R.id.loz2);
        imeID = findViewById(R.id.ime);
        prezimeID = findViewById(R.id.prezime);
        btn_registracijaID = findViewById(R.id.btn_registracija1);
        btn_nazad = findViewById(R.id.btn_nazad);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = firebaseDatabase.getReference("users");
        pass = findViewById(R.id.pass);
        pass1 = findViewById(R.id.pass1);

        pass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b) {
                    loz2ID.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                } else {
                    loz2ID.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        pass1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b) {
                    lozinkaID.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                } else {
                    lozinkaID.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        btn_nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);


                startActivity(new Intent(Registracija.this, MainActivity.class));

            }
        });


        btn_registracijaID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                registracija();

            }
        });

    }

        private void registracija() {
        final String email = emailID.getText().toString();
        mFirebaseAuth = FirebaseAuth.getInstance();
        final String lozinka = lozinkaID.getText().toString();



        if (imeID.getText().toString().isEmpty()) {
            Toast.makeText(this, "Unesite ime!", Toast.LENGTH_LONG).show();
            return;
        }
        if (prezimeID.getText().toString().isEmpty()) {
            Toast.makeText(this, "Unesite prezime!", Toast.LENGTH_LONG).show();
            return;
        }
        if (emailID.getText().toString().isEmpty()) {
            Toast.makeText(this, "Unesite email adresu!", Toast.LENGTH_LONG).show();
            return;
        }

        if (lozinkaID.getText().toString().isEmpty()) {
            Toast.makeText(this, "Unesite lozinku", Toast.LENGTH_LONG).show();
            return;
        }
        if (loz2ID.getText().toString().isEmpty()) {
            Toast.makeText(this, "Potvrdite lozinku!", Toast.LENGTH_LONG).show();
            return;
        }



        mFirebaseAuth.getInstance().createUserWithEmailAndPassword(email, lozinka).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if (task.isSuccessful()) {
                    mFirebaseAuth.getCurrentUser().sendEmailVerification();
                    mFirebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(Registracija.this, MainActivity.class));
                                mFirebaseAuth.getInstance();

                            } else {
                                startActivity(new Intent(Registracija.this, MainActivity.class));
                                Toast.makeText(Registracija.this, "Proverite email radi verifikacije!", Toast.LENGTH_SHORT).show();
                                mFirebaseAuth.getInstance().signOut();
                                return;
                            }
                        }
                    });
                }

                else {
                    Toast.makeText(Registracija.this, "Dogodila se greška! Pokušajte ponovo!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}










