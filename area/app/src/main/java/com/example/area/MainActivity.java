package com.example.area;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText widthField, heightField, radiusField;
    TextView resultTextView;
    Spinner spinner;

    Double widthy = 0.0;
    Double heighty = 0.0;
    Double radiusy = 0.0;
    Double result = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        widthField = (EditText) findViewById(R.id.widthField);
        heightField = (EditText) findViewById(R.id.heightField);
        radiusField  = (EditText) findViewById(R.id.radiusField);
        resultTextView = (TextView) findViewById(R.id.resultTextView);

        spinner = (Spinner) findViewById(R.id.spinner);

        List<String> shapes = new ArrayList<String>();
        shapes.add("Select the Shape!");
        shapes.add("Circle");
        shapes.add("Square");
        shapes.add("Rectangle");
        shapes.add("Spehre ");
        shapes.add("Cube ");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, shapes);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String selectedItem = adapterView.getItemAtPosition(i).toString();

                heighty = Double.parseDouble(heightField.getText().toString());
                widthy = Double.parseDouble(widthField.getText().toString());
                radiusy = Double.parseDouble(radiusField.getText().toString());

                if (selectedItem.equals("Select the Shape!")){
                    Toast.makeText(MainActivity.this, "Select Any Shape", Toast.LENGTH_SHORT).show();


                }
                else if (selectedItem.equals("Circle")){

                    result = 3.14 * radiusy * radiusy;

                    resultTextView.setText("The area is:" + result);

                }
                else if (selectedItem.equals("Square")){
                    result = widthy * heighty;
                    resultTextView.setText("The area is " + result);

                }
                else if (selectedItem.equals("Rectangle")){
                    result = widthy * heighty;
                    resultTextView.setText("The area is " + result);

                }
                else if (selectedItem.equals("Spehre")){
                    result =(4/3)*3.14 * widthy;
                    resultTextView.setText("the area is "+result);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
