package com.example.e_biro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Elektronska_prijava extends AppCompatActivity {
    EditText etEmail;
    EditText etSubject;
    EditText etMessage;
    Button Send;
    Button attachment;
    TextView tvAttachment;
    String email;
    String subject;
    String message;
    Uri URI = null;
    Vibrator vibrator;
    String TAG="MainActivity";
    ArrayList<Uri> uris = new ArrayList<Uri>();
    static final int PICK_FROM_GALLERY = 101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elektronska_prijava);

        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
            etEmail = findViewById(R.id.etTo);
            etSubject = findViewById(R.id.etSubject);
            etMessage = findViewById(R.id.etMessage);
            attachment = findViewById(R.id.btAttachment);
            tvAttachment = findViewById(R.id.tvAttachment);
            Send = findViewById(R.id.btSend);
        final Spinner contextChooser = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.custom_sppiner,
                getResources().getStringArray(R.array.context_names)
        );
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        contextChooser.setAdapter(adapter);

        contextChooser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String text=parent.getItemAtPosition(position).toString();
                if(position==0){
                    etEmail.setText("");
                }
               else if (text.equals("Beograd")){
                    etEmail.setText("pisarnica.Beograd@nsz.gov.rs ");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Bor")){
                    etEmail.setText("Pisarnica.Bor@nsz.gov.rs ");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Čačak")){
                    etEmail.setText("pisarnica.Cacak@nsz.gov.rs ");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Jagodina")){
                    etEmail.setText("pisarnica.Jagodina@nsz.gov.rs ");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Kikinda")){
                    etEmail.setText("pisarnica.Kikinda@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Kosovska Mitrovica")){
                    etEmail.setText("pisarnica.KosovskaMitrovica@nsz.gov.rs\n");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Kragujevac")){
                    etEmail.setText("pisarnica.Kragujevac@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Kraljevo")){
                    etEmail.setText("pisarnica.Kraljevo@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Kruševac")){
                    etEmail.setText("pisarnica.Krusevac@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Leskovac")){
                    etEmail.setText("pisarnica.Leskovac@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();
                    etEmail.setVisibility(View.VISIBLE);

                }
                else if (text.equals("Loznica")){
                    etEmail.setText("pisarnica.Loznica@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Niš")){
                    etEmail.setText("pisarnica.Nis@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Novi Sad")){
                    etEmail.setText("pisarnica.novisad@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Novi Pazar")){
                    etEmail .setText("pisarnica.NoviPazar@nsz.gov.rs ");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Pančevo")){
                    etEmail.setText("pisarnica.Pancevo@nsz.gov.rs ");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Pirot")){
                    etEmail.setText("pisarnica.Pirot@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();

                }
                else if (text.equals("Požarevac")){
                    etEmail.setText("pisarnica.Pozarevac@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Prijepolje")){
                    etEmail.setText("pisarnica.Prijepolje@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Prokuplje")){
                    etEmail.setText("pisarnica.Prokuplje@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Smederevo")){
                    etEmail.setText("pisarnica.Smederevo@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();

                }
                else if (text.equals("Sombor")){
                    etEmail.setText("pisarnica.Sombor@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();

                }
                else if (text.equals("Sremska Mitrovica")){
                    etEmail.setText("pisarnica.SremskaMitrovica@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Subotica")){
                    etEmail.setText("pisarnica.Subotica@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Šabac")){
                    etEmail.setText("pisarnica.Sabac@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Užice")){
                    etEmail.setText("pisarnica.Uzice@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Valjevo")){
                    etEmail.setText("pisarnica.Valjevo@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Vranje")){
                    etEmail.setText("pisarnica.Vranje@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();

                }
                else if (text.equals("Vršac")){
                    etEmail.setText("pisarnica.Vrsac@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();

                }
                else if (text.equals("Zaječar")){
                    etEmail.setText("pisarnica.Zajecar@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
                else if (text.equals("Zrenjanin")){
                    etEmail.setText("pisarnica.Zrenjanin@nsz.gov.rs");
                    Toast.makeText(Elektronska_prijava.this, "Izabrali ste filijalu grada "+text , Toast.LENGTH_SHORT).show();


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




            Send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sendEmail();
                    vibrator.vibrate(10);
                }
            });
            //attachment button listener
            attachment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   browseDocuments();
                    vibrator.vibrate(10);
                }
            });
        }



    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FROM_GALLERY && resultCode == RESULT_OK) {
            URI = data.getData();

            URI = data.getData();
            uris.add(URI);

            Toast.makeText(this, "Uspešno ste dodali fajl", Toast.LENGTH_SHORT).show();


        }
    }

    public void sendEmail() {
        try {

            email = etEmail.getText().toString();
            subject = etSubject.getText().toString();
            message = etMessage.getText().toString();
            final Intent emailIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
            emailIntent.setType("vnd.android.cursor.dir/email");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{email});
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
            if (URI != null) {

                emailIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM,uris);



            }
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
            this.startActivity(Intent.createChooser(emailIntent, "Sending email..."));
        } catch (Throwable t) {
            Toast.makeText(this, "Request failed try again: "+ t.toString(), Toast.LENGTH_LONG).show();
        }
    }





    private void browseDocuments() {

        String[] mimeTypes =
                {"application/msword", "text/plain", "application/*", "application/zip", "image/*"};

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.putExtra("return-data", true);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            intent.setType(mimeTypes.length == 1 ? mimeTypes[0] : "*/*");
            if (mimeTypes.length > 0) {
                intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
            }
        } else {
            String mimeTypesStr = "";
            for (String mimeType : mimeTypes) {
                mimeTypesStr += mimeType + "|";
            }
            intent.setType(mimeTypesStr.substring(0, mimeTypesStr.length() - 1));
        }
        startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_GALLERY);

    }




    }



