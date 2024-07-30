package com.elens.java_material_v112;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TrialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_trial);

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // This method closes the current activity
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void countLuas(View view){
        Context context = this;
        StringBuilder builder = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String answer = context.getString(R.string.answer);
        String priceDesc = context.getString(R.string.harga_desc);
        String rupiah = context.getString(R.string.RP);
        builder.append(answer).append(" ");

        EditText panjang = findViewById(R.id.textPanjang);
        EditText lebar = findViewById(R.id.textLebar);
        EditText hargaText = findViewById(R.id.textHargaBahan);
        TextView answerArea = findViewById(R.id.answerArea);

        long p = Integer.parseInt(panjang.getText().toString());
        long l = Integer.parseInt(lebar.getText().toString());
        long harga;
        long luas = p * l;
        builder.append(luas).append(" ");
        if (hargaText!=null){
            harga = Long.parseLong(hargaText.getText().toString());
            builder.append(priceDesc).append(" ").append(rupiah).append(".").append(" ");
            harga = luas * harga;
            builder.append(decimalFormat.format(harga));
        }


        answerArea.setText(builder.toString());
    }
}