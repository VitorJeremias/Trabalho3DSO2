package com.maykon.guiaturistico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void clickGuiaTuristico(View view){
        Intent intent = new Intent(this, TuristicoActivity.class);
        startActivity(intent);
    }

    public void clickGuiaCultural(View view){
        Intent intent = new Intent(this, CulturalActivity.class);
        startActivity(intent);
    }

    public void clickGuiaGastronomico(View view){
        Intent intent = new Intent(this, GastronomicoActivity.class);
        startActivity(intent);
    }
}
