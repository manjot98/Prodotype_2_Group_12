package com.example.prototype_1_group_12;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class AddRouteActivity extends AppCompatActivity {

    EditText routeN;
    EditText date;
    EditText gps;
    EditText tags;
    TextView consign;
    Button btnSave, btnBack2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_route);

        routeN = findViewById(R.id.editTxtRouteName);
        date = findViewById(R.id.editTxtDate);
        gps = findViewById(R.id.editTxtGPS);
        tags = findViewById(R.id.editTxtTags);
        btnSave = findViewById(R.id.btnSave);
        btnBack2 = findViewById(R.id.btnBack2);
        consign = findViewById(R.id.txtConsign);

        btnSave.setOnClickListener(new View.OnClickListener() {
           @RequiresApi(api = Build.VERSION_CODES.O)
           @Override
           public void onClick(View v) {


               String txtRouteN = routeN.getText().toString();
               String txtDate = date.getText().toString();
               String txtGps = gps.getText().toString();
               String txtTags = tags.getText().toString();

               if(!txtRouteN.equals("") && txtRouteN.length()>0 && !txtGps.equals("") && txtGps.length()>0 && !txtTags.equals("") && txtTags.length()>0){

                   Route NewRoute = new Route(txtRouteN,txtDate,txtGps,txtTags);
                   RouteList.addRoute(NewRoute);
                   consign.setText("Route is saved successfully.");
               }
               else{
                   consign.setText("Please enter correct input to save it.");
               }

           }
        });

        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
