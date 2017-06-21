package com.maykon.guiaturistico;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.maykon.guiaturistico.modelo.AtracaoHeaderDto;
import com.maykon.guiaturistico.modelo.EnumTipoAtracoes;
import com.maykon.guiaturistico.modelo.XMLParser;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.LinkedList;

public class ListaAtracoesActivity extends AppCompatActivity implements View.OnClickListener {

    private EnumTipoAtracoes tipo;
    private LinkedList<AtracaoHeaderDto> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_atracoes);

        tipo = (EnumTipoAtracoes) getIntent().getSerializableExtra("tipoAtracao");
        TextView label = (TextView) findViewById(R.id.labelAtracao);
        label.setText("Guia " + tipo.getNomeTipo());

        popularTela();
        loadButtons();
    }

    private void popularTela() {
            XmlResourceParser xml = this.getResources().getXml(R.xml.listaatracoes);

            try {
                this.lista = XMLParser.lerListaAtracoes(xml, tipo.getTag());
            } catch (XmlPullParserException | IOException e) {
                Log.e("Erro ao ler o XML", e.getMessage());
            }

        TextView label = (TextView) findViewById(R.id.labelItem1);

        label.setText(lista.get(0).getTitulo());
        label.setOnClickListener(this);

        label = (TextView) findViewById(R.id.labelItem2);

        label.setText(lista.get(1).getTitulo());
        label.setOnClickListener(this);

        label = (TextView) findViewById(R.id.labelItem3);

        label.setText(lista.get(2).getTitulo());
        label.setOnClickListener(this);

    }

    private void loadButtons(){
        int [] arrayIds = {R.id.btnFav1, R.id.btnFav2, R.id.btnFav3};
        Button button;
        for(int i =0; i<lista.size();i++){
            button = (Button) findViewById(arrayIds[i]);
            if (lista.get(i).isFavorite()) {
                button.setBackgroundResource(R.drawable.favon);
            } else {
                button.setBackgroundResource(R.drawable.favoff);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, DescricaoAtracaoActivity.class);
        switch (v.getId()) {
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

    public void onClickFavoritos(View view) {
        Button btnClicked = (Button) findViewById(view.getId());
        btnClicked.setActivated(!btnClicked.isActivated());

        if (btnClicked.isActivated()) {
            btnClicked.setBackgroundResource(R.drawable.favon);
        } else {
            btnClicked.setBackgroundResource(R.drawable.favoff);
        }

        switch (view.getId()) {
            case R.id.btnFav1:
                lista.get(0).setFavorite(btnClicked.isActivated());
                break;
            case R.id.btnFav2:
                lista.get(1).setFavorite(btnClicked.isActivated());
                break;
            case R.id.btnFav3:
                lista.get(2).setFavorite(btnClicked.isActivated());
                break;
        }
    }
}
