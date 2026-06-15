package felipe.model;

import java.time.LocalDate;

public abstract class Lancamento {
    private String descricao;
    private double valor;
    private LocalDate data;
    private String categoria;

    public Lancamento(String descricao, double valoritos, LocalDate date, String categoria){
        this.descricao = descricao;
        this.valor = valoritos;
        this.data = date;
        this.categoria = categoria;
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

	public String getCategoria() {
		return categoria;
	}

}
