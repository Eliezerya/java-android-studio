package com.elens.java_material_v112;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void newActivity(View view){
        view.setEnabled(false);
        Button b = (Button) view;
        b.setText("Disabled");
        Toast.makeText(this,"Setting Opened", Toast.LENGTH_SHORT).show();

        //intent generate new activity
        Intent intent = new Intent(this, SettingActivity.class);
        TextView textView = findViewById(R.id.input);
        String name = textView.getText().toString();
        //send a message to other activity
        intent.putExtra("name", name);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(
                this, R.anim.fade_in, R.anim.fade_out);
        startActivity(intent,options.toBundle());

    }

    public void turnOnButton(View view){
        Button b = findViewById(R.id.button11);
        b.setEnabled(true);
        b.setText("Click Again");
        Button buttonInput = findViewById(R.id.buttonInput);
        buttonInput.setEnabled(true);
        buttonInput.setText("Enter");
    }

    public void inputButton(View view) {
        Button b = findViewById(R.id.buttonInput);
        b.setEnabled(false);
        b.setText("Submitted");
        TextView input = findViewById(R.id.input);
        TextView showInput = findViewById(R.id.hello11);
        Toast.makeText(this,"Submitted", Toast.LENGTH_SHORT).show();
        showInput.setText("Watashi no namae wa "+ input.getText().toString());
    }
    public void openTrial(View view){
        Intent intent = new Intent(this, TrialActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(
                this, R.anim.fade_in, R.anim.fade_out);
        Toast.makeText(this,"Trial Opened", Toast.LENGTH_SHORT).show();
        startActivity(intent,options.toBundle());
    }
    public void openDynamic(View view){
        Intent intent = new Intent(this, dynamicActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(
                this, R.anim.fade_in, R.anim.fade_out);
        startActivity(intent,options.toBundle());
    }
}