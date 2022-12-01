package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView kalkulasi;
    private EditText editKalkulasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kalkulasi = findViewById(R.id.kalkulasiText);
        editKalkulasi = findViewById((R.id.editKalkulasiText));

        editKalkulasi.setShowSoftInputOnFocus(false);
    }

    private void updateText(String strYgDtambah){
        String strLama = editKalkulasi.getText().toString();

        int posisiCursor = editKalkulasi.getSelectionStart();
        String strSebelahKiriCursor = strLama.substring(0, posisiCursor);
        String strSebelahKananCursor = strLama.substring(posisiCursor);

        editKalkulasi.setText(String.format("%s%s%s", strSebelahKiriCursor, strYgDtambah, strSebelahKananCursor));
        editKalkulasi.setSelection(posisiCursor + strYgDtambah.length());
    }

    public void tekanBtnNol(View view){
        updateText(getResources().getString(R.string.nolText));
    }

    public void tekanBtnSatu(View view){
        updateText(getResources().getString(R.string.satuText));
    }

    public void tekanBtnDua(View view){
        updateText(getResources().getString(R.string.duaText));
    }

    public void tekanBtnTiga(View view){
        updateText(getResources().getString(R.string.tigaText));
    }

    public void tekanBtnEmpat(View view){
        updateText(getResources().getString(R.string.empatText));
    }

    public void tekanBtnLima(View view){
        updateText(getResources().getString(R.string.limaText));
    }

    public void tekanBtnEnam(View view){
        updateText(getResources().getString(R.string.enamText));
    }

    public void tekanBtnTujuh(View view){
        updateText(getResources().getString(R.string.tujuhText));
    }

    public void tekanBtnDelapan(View view){
        updateText(getResources().getString(R.string.delapanText));
    }

    public void tekanBtnSembilan(View view){
        updateText(getResources().getString(R.string.sembilanText));
    }

    public void tekanBtnBagi(View view){
        updateText(getResources().getString(R.string.bagiText));
    }

    public void tekanBtnKali(View view){
        updateText(getResources().getString(R.string.kaliText));
    }

    public void tekanBtnKurang(View view){
        updateText(getResources().getString(R.string.kurangText));
    }

    public void tekanBtnTambah(View view){
        updateText(getResources().getString(R.string.tambahText));
    }

    public void tekanBtnSinus(View view){
        updateText("sin(");
    }

    public void tekanBtnCosinus(View view){
        updateText("cos(");
    }

    public void tekanBtnTangen(View view){
        updateText("tan(");
    }

    public void tekanBtnArcSinus(View view){
        updateText("arcsin(");
    }

    public void tekanBtnArcCosinus(View view){
        updateText("arccos(");
    }

    public void tekanBtnArcTangen(View view){
        updateText("arctan(");
    }

    public void tekanBtnLog(View view){
        updateText("log(");
    }

    public void tekanBtnNaturalLog(View view){
        updateText("ln(");
    }

    public void tekanBtnE(View view){
        updateText("e");
    }

    public void tekanBtnPi(View view){
        updateText("pi");
    }

    public void tekanBtnNilaiMutlak(View view){
        updateText("abs(");
    }

    public void tekanBtnBilanganPrima(View view){
        updateText("ispr(");
    }

    public void tekanBtnXPangkat2(View view){
        updateText("^(2)");
    }

    public void tekanBtnXPangkatY(View view){
        updateText("^(");
    }

    public void tekanBtnAkarPangkat2(View view){
        updateText("sqrt(");
    }

    public void tekanBtnTutupKurung(View view){
        updateText(getResources().getString(R.string.tutupKurungText));
    }

    public void tekanBtnBukaKurung(View view){
        updateText(getResources().getString(R.string.bukaKurungText));
    }

    public void tekanBtnKoma(View view){
        updateText(getResources().getString(R.string.komaText));
    }

    public void tekanBtnBersihkan(View view){
        editKalkulasi.setText("");
        kalkulasi.setText("");
    }

    public void tekanBtnHapus(View view){
        int posisiCursor = editKalkulasi.getSelectionStart();
        int panjangText = editKalkulasi.getText().length();

        if(posisiCursor != 0 && panjangText != 0){
            SpannableStringBuilder text =  (SpannableStringBuilder) editKalkulasi.getText();
            text.replace(posisiCursor - 1, posisiCursor, "");
            editKalkulasi.setText(text);
            editKalkulasi.setSelection(posisiCursor - 1);
        }
    }

    public void tekanBtnSamaDengan(View view){

        //Semua hasil proses operasi di dapat dengan menggunakan Mxparser library
        //https://mathparser.org/mxparser-downloads/
        String userExp = editKalkulasi.getText().toString();

        kalkulasi.setText(userExp);

        Expression exp = new Expression(userExp);
        String hasilOperasi = String.valueOf(exp.calculate());

        editKalkulasi.setText(hasilOperasi);

        editKalkulasi.setSelection(hasilOperasi.length());
    }


}