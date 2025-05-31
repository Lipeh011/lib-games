package br.library.sp.libgames.enumeration;

public enum Status {
    ZERADO("ZERADO"),
    JOGANDO("JOGANDO"),
    NAO_INICIADO("NAO_INICIADO");

    private Status(String rotulo) {
        this.rotulo = rotulo;
    }

    private String rotulo;

    @Override
    public String toString() {
        return this.rotulo;
    }
}

