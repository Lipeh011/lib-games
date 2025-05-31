package br.library.sp.libgames.enumeration;

public enum Plataforma {
    PC("PC"),
    PS4("PS4"),
    PS5("PS5"),
    XBOX("XBOX"),
    SWITCH("SWITCH");

    private Plataforma(String rotulo) {
        this.rotulo = rotulo;
    }

    private String rotulo;

    @Override
    public String toString() {
        return this.rotulo;
    }
}

