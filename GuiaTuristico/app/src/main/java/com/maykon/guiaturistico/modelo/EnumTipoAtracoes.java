package com.maykon.guiaturistico.modelo;

/**
 * Created by Maykon on 14/06/2017.
 */

public enum EnumTipoAtracoes {
    GASTRONOMICO {
        @Override
        public String getNomeTipo() {
            return "Gastronômico";
        }

        @Override
        public String getTag() {
            return "gastronomico";
        }
    },
    CULTURAL {
        @Override
        public String getNomeTipo() {
            return "Cultural";
        }

        @Override
        public String getTag() {
            return "cultural";
        }
    },
    TURISTICO {
        @Override
        public String getNomeTipo() {
            return "Turístico";
        }

        @Override
        public String getTag() {
            return "turistico";
        }
    };

    public abstract String getNomeTipo();

    public abstract String getTag();
}
