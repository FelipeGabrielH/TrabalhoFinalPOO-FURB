package felipe.model;

import java.time.LocalDate;

public abstract class Lancamento {
    private String descricao;
    private double valor;
    private LocalDate data;

    public Lancamento(String descricao, double valoritos, LocalDate date){
        this.descricao = descricao;
        this.valor = valoritos;
        this.data = date;
    }

    public double getValor(){
        return valor;
    }
    public LocalDate getData(){
        return data;
    }

    public String getDescricao() {
        return descricao;
    }
}
