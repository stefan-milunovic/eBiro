package com.example.e_biro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;

public class Filijale extends AppCompatActivity {

    EditText editText;
    Vibrator vibrator;
    PhotoView imageView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filijale);
        editText=findViewById(R.id.editText);
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        imageView5=findViewById(R.id.imageView5);
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

                if (position==0){
                    editText.setVisibility(View.INVISIBLE);
                    imageView5.setVisibility(View.INVISIBLE);
                }

                else if (text.equals("Beograd")){
                    editText.setText("Filijala Beograd.\nGundulićev venac 23-25, 11000 Beograd\n" +
                            "Telefoni: 011/2929100, 2929000\n" +
                            "Rad sa strankama: od 8 do 14.30 časova\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Beograd@nsz.gov.rs ");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.mapa);
                    imageView5.setVisibility(View.VISIBLE);

                }

                else if (text.equals("Bor")){
                    editText.setText("Filijala Bor.\n 7. jula 29, 19210 Bor\n" +
                            "Telefon: 030/453-100\n" +
                            "\n" +
                            "e-mail adresa za informacije i pitanja: Lidija.Nacic@nsz.gov.rs\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: Pisarnica.Bor@nsz.gov.rs ");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.bor);
                    imageView5.setVisibility(View.VISIBLE);

                }
                else if (text.equals("Čačak")){
                    editText.setText("Filijala Čačak.\nŽupana Stracimira 35, 32000 Čačak\n" +
                            "Telefon: 032/303-747\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Cacak@nsz.gov.rs ");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.cacak);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Jagodina")){
                    editText.setText("Filijala Jagodina.\nLjubiše Uroševića 16, 35000 Jagodina\n" +
                            "Telefon: 035/201-047\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Jagodina@nsz.gov.rs ");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.jagodina);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Kikinda")){
                    editText.setText("Filijala Kikinda.\nDositejeva 4, 23000 Kikinda\n" +
                            "Telefon: 0230/411-700\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Kikinda@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.kikinda);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Kosovska Mitrovica")){
                    editText.setText("Filijala Kosovska Mitrovica\n" +
                            "Ul.Džona Kenedija bb\n" +
                            "Tel: 028/420-637\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.KosovskaMitrovica@nsz.gov.rs\n");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.km);
                    imageView5.setVisibility(View.VISIBLE);

                }
                else if (text.equals("Kragujevac")){
                    editText.setText("Filijala Kragujevac\nSvetozara Markovića 37, 34000 Kragujevac\n" +
                            "Telefon: 034/505-500\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Kragujevac@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.kg);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Kraljevo")){
                    editText.setText("Filijala Kraljevo\nCara Dušana 78, 36000 Kraljevo\n" +
                            "Telefon: 036/302-000\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Kraljevo@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.kv);
                    imageView5.setVisibility(View.VISIBLE);

                }
                else if (text.equals("Kruševac")){
                    editText.setText("Filijala Kruševac\nBalkanska 33, 37000 Kruševac\n" +
                            "Telefon: 037/412-501\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Krusevac@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.kr);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Leskovac")){
                    editText.setText("Filijala Leskovac\n" +
                            "Mlinska 16, 16000 Leskovac\n" +
                            "Telefon: 016/202-400\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Leskovac@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.les);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Loznica")){
                    editText.setText("Filijala Loznica\n" +
                            "Kneza Miloša 3, 15300 Loznica\n" +
                            "Telefon: 015/879-700\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Loznica@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.loz);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Niš")){
                    editText.setText("Filijala Niš\n" +
                            "Ratka Vukićevića 3, 18000 Niš\n" +
                            "Telefon: 018/501-313\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Nis@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.nis);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Novi Sad")){
                    editText.setText("Filijala Novi Sad\n" +
                            "Alberta Tome 2, 21000 Novi Sad " +

                            "Pozivni centar: 0800-300-301 - besplatan poziv iz fiksne mreže;  021/488-5500, 021/488-5599\n" +
                            "\n" +
                            "e-mail adresa za opšte informacije i pitanja: mirjana.bogdanovic@nsz.gov.rs ; 021/488-5549\n" +

                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.novisad@nsz.gov.rs\n" +
                            " ");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.ns);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Novi Pazar")){
                    editText.setText("Filijala Novi Pazar\n" +
                            "Šabana Koče 18, 36300 Novi Pazar\n" +
                            "Telefon: 020/330-000\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.NoviPazar@nsz.gov.rs ");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.np);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Pančevo")){
                    editText.setText("Filijala Pančevo\n" +
                            "Vojvode Radomira Putnika 20, 26000 Pančevo\n" +
                            "Telefon: 013/306-800\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Pancevo@nsz.gov.rs ");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.pan);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Pirot")){
                    editText.setText("Filijala Pirot\n" +
                            "Kneza Miloša 59, 18300 Pirot\n" +
                            "Telefon: 010/305-000\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Pirot@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.pir);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Požarevac")){
                    editText.setText("Filijala Požarevac\n" +
                            "Šumadijska 31, 12000 Požarevac\n" +
                            "Telefon: 012/538-100\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Pozarevac@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.po);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Prijepolje")){
                    editText.setText("Filijala Prijepolje\n" +
                            "Sandžačkih brigada 11, 31300 Prijepolje\n" +
                            "Telefon: 033/719-011\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Prijepolje@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.pri);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Prokuplje")){
                    editText.setText("Filijala Prokuplje\n" +
                            "Cara Lazara 49, 18400 Prokuplje\n" +
                            "Telefon: 027/32-00-00\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Prokuplje@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.pro);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Smederevo")){
                    editText.setText("Filijala Smederevo\n" +
                            "Dr Miladina Milića 2, 26000 Smederevo\n" +
                            "Telefon: 026/633-900\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Smederevo@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.sme);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Sombor")){
                    editText.setText("Filijala Sombor\n" +
                            "Apatinski put 1, 25000 Sombor\n" +
                            "Telefon: 025/464-000\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Sombor@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.som);
                    imageView5.setVisibility(View.VISIBLE);

                }
                else if (text.equals("Sremska Mitrovica")){
                    editText.setText("Filijala Sremska Mitrovica\n" +
                            "Svetog Dimitrija 31, 22000 Sremska Mitrovica\n" +
                            "Telefon: 022/638-801\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.SremskaMitrovica@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.sm);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Subotica")){
                    editText.setText("Filijala Subotica\n" +
                            "Jovana Mikića 12, 24000 Subotica\n" +
                            "Telefon: 024/644-600\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Subotica@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.sub);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Šabac")){
                    editText.setText("Filijala Šabac\n" +
                            "Masarikova 31, 15000 Šabac\n" +
                            "Telefon: 015/361-700\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Sabac@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.sab);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Užice")){
                    editText.setText("Filijala Užice\n" +
                            "Železnička 22, 31000 Užice\n" +
                            "Telefon: 031/590-600\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Uzice@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.uz);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Valjevo")){
                    editText.setText("Filijala Valjevo\n" +
                            "Vladike Nikolaja 1, 14000 Valjevo\n" +
                            "Telefon: 014/295-600\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Valjevo@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.valj);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Vranje")){
                    editText.setText("Filijala Vranje\n" +
                            "Todora Španca 1, 17000 Vranje\n" +
                            "Telefon: 017/407-101\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Vranje@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.vra);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Vršac")){
                    editText.setText("Filijala Vršac\n" +
                            "Feliksa Milekera 21, 13000 Vršac\n" +
                            "Telefon: 013/802-400\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Vrsac@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.vrsac);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Zaječar")){
                    editText.setText("Filijala Zaječar\n" +
                            "Nikole Pašića 77, 19000 Zaječar\n" +
                            "Telefon: 019/444-500\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Zajecar@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.zj);
                    imageView5.setVisibility(View.VISIBLE);
                }
                else if (text.equals("Zrenjanin")){
                    editText.setText("Filijala Zrenjanin\n" +
                            "Sarajlijina 4, 23000 Zrenjanin\n" +
                            "Telefon: 023/519-801\n" +
                            "\n" +
                            "e-mail adresa za dostavljanje dokumentacije i zahteva: pisarnica.Zrenjanin@nsz.gov.rs");
                    Toast.makeText(Filijale.this, "Izabrali ste "+text , Toast.LENGTH_SHORT).show();
                    editText.setVisibility(View.VISIBLE);
                    imageView5.setImageResource(R.drawable.zr);
                    imageView5.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

