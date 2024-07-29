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

        String answer = context.getString(R.string.answer);
        String priceDesc = context.getString(R.string.harga_desc);
        builder.append(answer+ " ");

        EditText panjang = findViewById(R.id.textPanjang);
        EditText lebar = findViewById(R.id.textLebar);
        EditText harga = findViewById(R.id.textHargaBahan);
        TextView answerArea = findViewById(R.id.answerArea);
        double p = Double.parseDouble(panjang.getText().toString());
        double l = Double.parseDouble(lebar.getText().toString());
        double hargaDouble = 1;
        double luas = p * l;
        double output = 1;
        builder.append(luas + " ");
        if (harga!=null){
            hargaDouble = Double.parseDouble(harga.getText().toString());
            builder.append(priceDesc + " ");
            output = luas * hargaDouble;
            builder.append(output);
        }


        answerArea.setText(builder.toString());
    }
}