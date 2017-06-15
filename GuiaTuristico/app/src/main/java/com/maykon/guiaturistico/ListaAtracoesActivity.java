package com.maykon.guiaturistico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.maykon.guiaturistico.modelo.EnumTipoAtracoes;

public class ListaAtracoesActivity extends AppCompatActivity {

    private EnumTipoAtracoes tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_atracoes);
        tipo = (EnumTipoAtracoes) getIntent().getSerializableExtra("tipoAtracao");
        TextView label = (TextView) findViewById(R.id.labelAtracao);
        label.setText("Guia "+tipo.getNomeTipo());
    }
}
