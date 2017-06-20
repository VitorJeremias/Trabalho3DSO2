package com.maykon.guiaturistico;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.maykon.guiaturistico.modelo.AtracaoDto;
import com.maykon.guiaturistico.modelo.MapFotos;
import com.maykon.guiaturistico.modelo.XMLParser;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.Locale;

public class DescricaoAtracaoActivity extends AppCompatActivity {

    private AtracaoDto dto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_atracao);

        carregarTela((String) getIntent().getSerializableExtra("dto"));
    }

    public void openMaps(View view){
        if(dto.getCoordenada() != null){
            String uri = "http://maps.google.com/maps?daddr=" +  dto.getCoordenada()[0] + "," + dto.getCoordenada()[1];
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            intent.setPackage("com.google.android.apps.maps");
            this.startActivity(intent);
        }
    }

    private void carregarTela(String id) {
        XmlResourceParser xml = this.getResources().getXml(R.xml.descricaoatracoes);
        dto = null;
        try {
            dto = XMLParser.carregarAtracao(xml, id);
        } catch (XmlPullParserException | IOException e) {
            Log.e("Erro ao ler o XML", e.getMessage());
        }

        TextView label = (TextView) findViewById(R.id.labelTitulo);
        label.setText(dto.getNomeLocal());

        label = (TextView) findViewById(R.id.labelDescText);
        label.setText(dto.getDescricao());

        setFotos(dto.getIdFotos());
    }

    private void setFotos(String[] ids){
        if(ids != null){
            int idFoto = (MapFotos.getMap().get(ids[0]) == null ? 0 : MapFotos.getMap().get(ids[0]));
            ImageView foto = (ImageView) findViewById(R.id.foto1);
            foto.setImageResource(idFoto);

            idFoto = (MapFotos.getMap().get(ids[1]) == null ? 0 : MapFotos.getMap().get(ids[1]));
            foto = (ImageView) findViewById(R.id.foto2);
            foto.setImageResource(idFoto);
        }
    }
}
