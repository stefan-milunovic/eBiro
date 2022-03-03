package com.example.e_biro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class Pocetna extends AppCompatActivity {
    Button btn_oglasi, btn_eprijava,btn_obrazac, btn_filijale, btn_odjava, btn_podsetnik;
    Vibrator vibrator;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;
    ProgressDialog working_dialog;
    FirebaseAuth mFirebaseAuth;
    Handler handler = new Handler();
    RelativeLayout rellay1, rellay2;
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
        setContentView(R.layout.activity_pocetna);
        btn_oglasi = findViewById(R.id.btn_oglas);
        btn_eprijava = findViewById(R.id.btn_eprijava);
        btn_obrazac = findViewById(R.id.btn_obrazac);
        btn_odjava = findViewById(R.id.btn_odjava);
        btn_filijale = findViewById(R.id.btn_filijale);
        btn_podsetnik = findViewById(R.id.btn_podsetnik);
        mFirebaseAuth = FirebaseAuth.getInstance();

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);

        handler.postDelayed(runnable, 2000); //2000 is the timeout for the splash





        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        btn_oglasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOglas = new Intent(getApplicationContext(), Oglasi.class);
                startActivity(intentOglas);
                vibrator.vibrate(10);
            }
        });




        btn_podsetnik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {vibrator.vibrate(10);
                Intent intentPrijava = new Intent();
                intentPrijava.setClass(getApplicationContext(),Podsetnik.class);
                startActivity(intentPrijava);

            }

        });
        btn_filijale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {vibrator.vibrate(10);
                Intent intentPrijava = new Intent();
                intentPrijava.setClass(getApplicationContext(),Filijale.class);
                startActivity(intentPrijava);

            }

        });
btn_odjava.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        vibrator.vibrate(10);
        mFirebaseAuth.getInstance().signOut();
        finish();
        Intent intent = new Intent(Pocetna.this, MainActivity.class);
        startActivity(intent);
    }
});



        btn_eprijava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {vibrator.vibrate(10);
                Intent intentPrijava = new Intent();
                intentPrijava.setClass(getApplicationContext(),Elektronska_prijava.class);
                startActivity(intentPrijava);
            }

        });
        btn_obrazac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(10);
                download();
                showWorkingDialog();
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        removeWorkingDialog();
                    }

                }, 2000);

                // Intent intentObrazac = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nsz.gov.rs/live/digitalAssets/14/14385_obrazac_za_prijavljivanje_na_evidenciju_-_elektronski_zahtev.pdf"));
                // startActivity(intentObrazac);
               }
        });



    }

            private void download() {
                storageReference= firebaseStorage.getInstance().getReference();

                ref=storageReference.child("obrazac_za_prijavljivanje_na_evidenciju_-_elektronski_zahtev.docx");
                ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {


                        String url=uri.toString();

                    downloadFiles(Pocetna.this,"obrazac_za_prijavljivanje_na_evidenciju_-_elektronski_zahtev", ".docx",DIRECTORY_DOWNLOADS,url);

                    }


                }
                ).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
            }
    private void showWorkingDialog()
    {
        working_dialog = ProgressDialog.show(Pocetna.this, "","Preuzima se obrazac, molimo sačekajte...", true);
    }

    private void removeWorkingDialog() {
        if (working_dialog != null) {
            working_dialog.dismiss();
            working_dialog = null;
        }
    }


    private void downloadFiles(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {

                DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse(url);
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalFilesDir(context, destinationDirectory,fileName + fileExtension);

                downloadManager.enqueue(request);


            }




}











