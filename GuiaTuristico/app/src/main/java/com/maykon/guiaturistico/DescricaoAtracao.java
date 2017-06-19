package com.maykon.guiaturistico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.maykon.guiaturistico.modelo.EnumTipoAtracoes;

public class DescricaoAtracao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_atracao);

        TextView labelTitulo = (TextView) findViewById(R.id.labelTitulo);
        labelTitulo.setText("id: "+(String) getIntent().getSerializableExtra("dto"));
    }
}
