package com.elens.java_material_v112;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dynamicActivity extends AppCompatActivity {

    private LinearLayout container;
    private LinearLayout childContainer;
    private List<EditText> editTextList = new ArrayList<>(); // List to store references to EditText views

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dynamic);

        // Find the container layout where EditTexts will be added
        container = findViewById(R.id.dynamic_container);

        // Find the button that will trigger adding EditTexts
        Button addButton = findViewById(R.id.add_button);
        Button retrieveButton = findViewById(R.id.submitDynamic);
        addEditText();

        // Set an OnClickListener on the button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEditText(); // Method to add an EditText to the layout
            }
        });
        // Set an OnClickListener on the button to retrieve EditText inputs
        retrieveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrieveInputs();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addEditText() {
        Button retrieveButton = findViewById(R.id.submitDynamic);
        retrieveButton.setEnabled(true);

        childContainer = new LinearLayout(this);
        childContainer.setOrientation(LinearLayout.HORIZONTAL);
        // Create a new EditText
        EditText editText = new EditText(this);
        editText.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        editText.setHint("Enter text here");
        EditText price = new EditText(this);
        price.setInputType(InputType.TYPE_CLASS_NUMBER);
        price.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        price.setHint("input price here");

        childContainer.addView(editText);
        childContainer.addView(price);

        // Add the EditText to the container
        container.addView(childContainer);
        // Store the reference to the EditText in the list
        editTextList.add(editText);
        editTextList.add(price);
    }

    // Method to retrieve inputs from all EditTexts
    private void retrieveInputs() {
        boolean hasEmptyFields = false;
        StringBuilder inputs = new StringBuilder();
        for (EditText editText : editTextList) {
            String text = editText.getText().toString();
            if (text.isEmpty()) {
                hasEmptyFields = true;
                break;
            }
            inputs.append(text).append("\n");
        }

        if (hasEmptyFields) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            Log.d("elDebug", "input: " + inputs.toString());
            Toast.makeText(this, inputs.toString(), Toast.LENGTH_LONG).show();
        }
    }

    public void resetEntire(View view){
        (findViewById(R.id.submitDynamic)).setEnabled(false);
        container.removeAllViews();
        editTextList.clear();
    }

}