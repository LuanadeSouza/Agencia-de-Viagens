package com.example.agenciaapplication.model;


import java.math.BigDecimal;

public class Pacote  {

    private final String local;
    private final String image;
    private final int dias;
    private final BigDecimal preco;

    public Pacote(String local, String image, int dias, BigDecimal preco) {
        this.local = local;
        this.image = image;
        this.dias = dias;
        this.preco = preco;
    }

    public String getLocal() {
        return local;
    }

    public String getImage() {
        return image;
    }

    public int getDias() {
        return dias;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
