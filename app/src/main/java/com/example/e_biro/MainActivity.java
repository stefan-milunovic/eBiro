package com.example.e_biro;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="MainActivity" ;
    EditText emailID,lozinkaID;
        Vibrator vibrator;
        Button btn_registracijaID,btn_prijavaID,btn_zaboravljenaID;
        FirebaseAuth mFirebaseAuth;
        private FirebaseAuth auth;
        CheckBox pass;
        private FirebaseAuth.AuthStateListener mAuthStateListener;
        RelativeLayout rellay1, rellay2;


        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                rellay1.setVisibility(View.VISIBLE);
                rellay2.setVisibility(View.VISIBLE);
            }
        };




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mFirebaseAuth = FirebaseAuth.getInstance();
            emailID=findViewById(R.id.email);
            lozinkaID=findViewById(R.id.lozinka);
            btn_prijavaID=findViewById(R.id.btn_prijava);
            btn_registracijaID=findViewById(R.id.btn_registracija);
            btn_zaboravljenaID=findViewById(R.id.btn_zaboravljena);
            pass=findViewById(R.id.pass);
            vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);

            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                // User is signed in
                Intent i = new Intent(MainActivity.this, Pocetna.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            } else {
                // User is signed out
                Log.d(TAG, "onAuthStateChanged:signed_out");
            }



            pass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                    if (b){
                        lozinkaID.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                    }
                    else {
                        lozinkaID.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                }
            });
            btn_zaboravljenaID.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentZaboravljena = new Intent (MainActivity.this, Reset.class);
                    startActivity(intentZaboravljena);
                    vibrator.vibrate(10);
                }
            });

            btn_registracijaID.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentRegistracija = new Intent (MainActivity.this, Registracija.class);
                    startActivity(intentRegistracija);
                    vibrator.vibrate(10);
                }
            });

            btn_prijavaID.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("NewApi")
                @Override
                public void onClick(View v) {
                    vibrator.vibrate(10);

                    if (emailID.getText().toString().isEmpty()){
                        Toast.makeText(MainActivity.this, "Unesite email adresu!", Toast.LENGTH_SHORT).show();
                    }
                    else if (lozinkaID.getText().toString().isEmpty()){
                        Toast.makeText(MainActivity.this, "Unesite lozinku!", Toast.LENGTH_SHORT).show();
                    }
                    else if (!(emailID.getText().toString().isEmpty()&&lozinkaID.getText().toString().isEmpty())){
                        validate(emailID.getText().toString(),lozinkaID.getText().toString());


                    }
                    else {
                        Toast.makeText(MainActivity.this, "Unesite podatke!", Toast.LENGTH_SHORT).show();
                    }
                }
            });




            rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
            rellay2 = (RelativeLayout) findViewById(R.id.rellay2);

            handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash




        }

        private void validate(final String emailID, final String lozinkaID) {
            mFirebaseAuth.signInWithEmailAndPassword(emailID,lozinkaID).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()){

                        Toast.makeText(MainActivity.this, "Email ili lozinka nije ispravna!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        checkifEmailVerified();
                    }
                }
            });
        }

        private void checkifEmailVerified() {
            FirebaseUser user = mFirebaseAuth.getCurrentUser();
            assert user !=null;
            if (user.isEmailVerified()){

                Toast.makeText(MainActivity.this, "Uspešno ste prijavljeni!", Toast.LENGTH_SHORT).show();
                Intent intentPrijava = new Intent (MainActivity.this, Pocetna.class);
                startActivity(intentPrijava);
            }
            else{
                Toast.makeText(MainActivity.this, "Proverite vaš email!", Toast.LENGTH_SHORT).show();
            }

        }
    }



