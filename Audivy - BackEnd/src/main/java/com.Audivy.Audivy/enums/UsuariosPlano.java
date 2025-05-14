package com.Audivy.Audivy.enums;

public enum UsuariosPlano {
    PREMIUM("Plano Premium"),
    CONVENCIONAL("Plano COnvencional");

    private final String Plano;

    UsuariosPlano(String Plano){
        this.Plano = Plano;
    }

    public String getPlano(){
        return Plano;
    }
}
