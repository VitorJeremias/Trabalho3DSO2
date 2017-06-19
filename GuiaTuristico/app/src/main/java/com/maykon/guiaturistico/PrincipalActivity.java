package com.maykon.guiaturistico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.maykon.guiaturistico.modelo.EnumTipoAtracoes;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void mostrarAtracoes(View view){
        Intent intent = new Intent(this, ListaAtracoesActivity.class);

        switch(view.getId()){
            case R.id.btnCultural:
                intent.putExtra("tipoAtracao", EnumTipoAtracoes.CULTURAL);
                break;
            case R.id.btnGastronomico:
                intent.putExtra("tipoAtracao", EnumTipoAtracoes.GASTRONOMICO);
                break;
            case R.id.btnTuristico:
                intent.putExtra("tipoAtracao", EnumTipoAtracoes.TURISTICO);
                break;
        }

        startActivity(intent);
    }
}
