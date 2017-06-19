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

            switch (parser.getEventType()) {
                case XmlPullParser.START_TAG:
                    if (parser.getName().equals(tipoAtracao)) {
                        begin = !begin;
                    }
                    if (parser.getName().equals("local") && begin) {
                        AtracaoHeaderDto dto = new AtracaoHeaderDto();

                        dto.setId(parser.getAttributeValue(0));
                        parser.next();
                        dto.setTitulo(parser.getText());

                        lista.add(dto);
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if (parser.getName().equals(tipoAtracao)) {
                        begin = false;
                    }
            }

        }
        return lista;
    }

    public static AtracaoDto carregarAtracao(XmlResourceParser xml, String idAtracao) throws XmlPullParserException, IOException {
        AtracaoDto dto = new AtracaoDto();

        XmlPullParser parser = xml;

        while (parser.next() != XmlPullParser.END_DOCUMENT) {
            switch (parser.getEventType()) {
                case XmlPullParser.START_TAG:
                    if (parser.getAttributeCount() > 0 && parser.getAttributeValue(0).equals(idAtracao)) {
                        boolean fim = false;
                        while (!fim) {
                            if (parser.getEventType() == XmlPullParser.START_TAG) {
                                switch (parser.getName()) {
                                    case "local":
                                        parser.next();
                                        dto.setNomeLocal(parser.getText());
                                        break;
                                    case "descricao":
                                        parser.next();
                                        dto.setDescricao(parser.getText());
                                        break;
                                    case "coordenadas":
                                        String[] coordenada = new String[2];
                                        coordenada[0] = parser.getAttributeValue(0);
                                        coordenada[1] = parser.getAttributeValue(1);
                                        dto.setCoordenada(coordenada);
                                        parser.next();
                                        break;
                                    default:
                                        parser.next();
                                }
                            } else {
                                if (parser.getEventType() == XmlPullParser.END_TAG && parser.getName().equals("atracao")) {
                                    fim = true;
                                } else {
                                    parser.next();
                                }
                            }
                        }
                    }
            }
        }

        return dto;
    }
}
