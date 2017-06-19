package com.maykon.guiaturistico;

import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.maykon.guiaturistico.modelo.AtracaoDto;
import com.maykon.guiaturistico.modelo.EnumTipoAtracoes;
import com.maykon.guiaturistico.modelo.XMLParser;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class DescricaoAtracaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_atracao);

        carregarTela((String) getIntent().getSerializableExtra("dto"));
    }

    private void carregarTela(String id) {
        XmlResourceParser xml = this.getResources().getXml(R.xml.descricaoatracoes);
        AtracaoDto dto = null;
        try {
            dto = XMLParser.carregarAtracao(xml, id);
        } catch (XmlPullParserException | IOException e) {
            Log.e("Erro ao ler o XML", e.getMessage());
        }

        TextView label = (TextView) findViewById(R.id.labelTitulo);
        label.setText(dto.getNomeLocal());

        label = (TextView) findViewById(R.id.labelDescText);
        label.setText(dto.getDescricao());
    }
}
