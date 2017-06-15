package com.maykon.guiaturistico.modelo;

/**
 * Created by Maykon on 14/06/2017.
 */

public enum EnumTipoAtracoes {
    GASTRONOMICO{
        @Override
        public String getNomeTipo() {
            return "Gastronômico";
        }
    },
    CULTURAL {
        @Override
        public String getNomeTipo() {
            return "Cultural";
        }
    },
    TURISTICO{
        @Override
        public String getNomeTipo() {
            return "Turístico";
        }
    };

    public abstract String getNomeTipo();
}
