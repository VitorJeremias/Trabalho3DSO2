package com.maykon.guiaturistico.modelo;

import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;

import com.maykon.guiaturistico.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class XMLParser {

    public static LinkedList<AtracaoHeaderDto> lerListaAtracoes(XmlResourceParser xml, String tipoAtracao) throws XmlPullParserException, IOException {
        LinkedList<AtracaoHeaderDto> lista = new LinkedList<>();

        XmlPullParser parser = xml;

        boolean begin = false;
        while (parser.next() != XmlPullParser.END_DOCUMENT) {

            switch(parser.getEventType()){
                case XmlPullParser.START_TAG:
                    if(parser.getName().equals(tipoAtracao)){
                        begin = !begin;
                    }
                    if(parser.getName().equals("local") && begin) {
                        AtracaoHeaderDto dto = new AtracaoHeaderDto();

                        dto.setId(parser.getAttributeValue(0));
                        parser.next();
                        dto.setTitulo(parser.getText());

                        lista.add(dto);
                    }
                    break;
                    case XmlPullParser.END_TAG:
                        if(parser.getName().equals(tipoAtracao)){
                            begin = false;
                        }
            }

        }
        return lista;
    }

    public static AtracaoDto gerarDto(){
        AtracaoDto dto = new AtracaoDto();

        return dto;
    }
}
