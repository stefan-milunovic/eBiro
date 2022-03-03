package com.example.e_biro;



 import android.app.ProgressDialog;
 import android.content.Intent;
import android.os.Bundle;
 import android.os.Handler;
 import android.os.Vibrator;
 import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
 import android.widget.Toast;

 import androidx.appcompat.app.AppCompatActivity;

 import com.allyants.notifyme.NotifyMe;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import com.allyants.notifyme.NotifyMe;

import java.sql.Time;
import java.util.Calendar;

    public class Podsetnik extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {


        Calendar now = Calendar.getInstance();
        TimePickerDialog tpd;
        DatePickerDialog dpd;
        EditText naslov, poruka;
        Vibrator vibrator;
        ProgressDialog working_dialog;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_podsetnik);
            vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            naslov = findViewById(R.id.naslov);
            Button btn_podsetnik1 = findViewById(R.id.btn_podsetnik1);
            poruka = findViewById(R.id.poruka);
            Button btn_ponisti = findViewById(R.id.btn_ponisti);
            Button btn_back = findViewById(R.id.btn_back);

            dpd = DatePickerDialog.newInstance(
                    Podsetnik.this,
                    now.get(Calendar.YEAR),
                    now.get(Calendar.MONTH),
                    now.get(Calendar.DAY_OF_MONTH)
            );

            tpd = TimePickerDialog.newInstance(
                    Podsetnik.this,
                    now.get(Calendar.HOUR_OF_DAY),
                    now.get(Calendar.MINUTE),
                    now.get(Calendar.SECOND),
                    false
            );

            btn_ponisti.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vibrator.vibrate(10);
                    NotifyMe.cancel(getApplicationContext(), "this");
                    showWorkingDialog();
                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            removeWorkingDialog();
                        }

                    }, 2000);
                }
            });
            btn_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vibrator.vibrate(10);
                    Intent intentPrijava = new Intent();
                    intentPrijava.setClass(getApplicationContext(),Pocetna.class);
                    startActivity(intentPrijava);
                }
            });

            btn_podsetnik1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vibrator.vibrate(10);
                    dpd.show(getFragmentManager(), "Datapickerdialog");
                    showWorkingDialog1();
                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            removeWorkingDialog();
                        }

                    }, 6000);

                }
            });


        }





        private void showWorkingDialog()
        {
            working_dialog = ProgressDialog.show(Podsetnik.this, "","Brise se postavljeni podsetnik, molimo sačekajte...", true);
        }
        private void showWorkingDialog1()
        {
            working_dialog = ProgressDialog.show(Podsetnik.this, "","Uspešno ste podesili podsetnik!", true);
        }

        private void removeWorkingDialog() {
            if (working_dialog != null) {
                working_dialog.dismiss();
                working_dialog = null;
            }
        }


        @Override
        public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
            now.set(Calendar.YEAR, year);
            now.set(Calendar.MONTH, monthOfYear);
            now.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            tpd.show(getFragmentManager(), "Timepickerdialog");
        }

        @Override
        public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
            now.set(Calendar.HOUR_OF_DAY, hourOfDay);
            now.set(Calendar.MINUTE, minute);
            NotifyMe notifyMe = new NotifyMe.Builder(getApplicationContext())
                    .title(naslov.getText().toString())
                    .content(poruka.getText().toString())
                    .color(225, 0, 0, 255)
                    .led_color(255, 255, 255, 255)
                    .time(now)
                    .addAction(new Intent(), "Odlozi", false)
                    .key("test")
                    .addAction(new Intent(), "Ponisti", true, false)
                    .addAction(new Intent(), "Gotovo")
                    .large_icon(R.mipmap.ic_launcher_round)
                    .build();
        }
    }
