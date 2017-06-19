package com.maykon.guiaturistico;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.maykon.guiaturistico.modelo.AtracaoHeaderDto;
import com.maykon.guiaturistico.modelo.EnumTipoAtracoes;
import com.maykon.guiaturistico.modelo.XMLParser;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ListaAtracoesActivity extends AppCompatActivity implements View.OnClickListener {

    private EnumTipoAtracoes tipo;
    private  LinkedList<AtracaoHeaderDto> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_atracoes);

        tipo = (EnumTipoAtracoes) getIntent().getSerializableExtra("tipoAtracao");
        TextView label = (TextView) findViewById(R.id.labelAtracao);
        label.setText("Guia "+tipo.getNomeTipo());

        popularTela();
    }

    private void popularTela(){
        this.lista = null;
        XmlResourceParser is = this.getResources().getXml(R.xml.listaatracoes);

        try {
           this.lista = XMLParser.lerListaAtracoes(is, tipo.getTag());
        }
        catch (XmlPullParserException | IOException e){
            Log.e("Erro ao ler o XML",e.getMessage());
        }
        TextView label = (TextView) findViewById(R.id.labelItem1);
        label.setText("1) "+lista.get(0).getTitulo());
        label.setOnClickListener(this);

        label = (TextView) findViewById(R.id.labelItem2);
        label.setText("2) "+lista.get(1).getTitulo());
        label.setOnClickListener(this);

        label = (TextView) findViewById(R.id.labelItem3);
        label.setText("3) "+lista.get(2).getTitulo());
        label.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, DescricaoAtracao.class);
        switch(v.getId()){
            case R.id.labelItem1:
                intent.putExtra("dto", this.lista.get(0).getId());
                break;
            case R.id.labelItem2:
                intent.putExtra("dto", this.lista.get(1).getId());
                break;
            case R.id.labelItem3:
                intent.putExtra("dto", this.lista.get(2).getId());
                break;
        }
        startActivity(intent);
    }
}
