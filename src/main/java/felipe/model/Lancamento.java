package felipe.model;

import java.time.LocalDate;

public abstract class Lancamento {
    private String descricao;
    private double valor;
    private LocalDate data;
    private String categoria;

    public Lancamento(String descricao, double valor, LocalDate data, String categoria){
        setDescricao(descricao);
        setValor(valor);
        setData(data);
        setCategoria(categoria);
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
	
	private void setDescricao(String descricao) {
		if (descricao == null || descricao.isBlank() || descricao.isEmpty()) {
			throw new IllegalArgumentException("Descrição inválida");
		}
		
		this.descricao = descricao;
	}
	
	private void setValor(double valor) {
		if (valor == 0) {
			throw new NumberFormatException("Valor inválido");
		}
		
		this.valor = valor;
	}
	
	private void setData(LocalDate data) {
		if (data == null) {
			throw new IllegalArgumentException("Data inválida");
		}
		
		this.data = data;
	}
	
	private void setCategoria(String categoria) {
		if (categoria == null || categoria.isBlank() || categoria.isEmpty()) {
			throw new IllegalArgumentException("Categoria inválida");
		}
		
		this.categoria = categoria;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o ) {
			return true;
		}
		if(o.getClass() != this.getClass()) {
			return false;
		}
		
		Lancamento outro = (Lancamento) o;
		
		if (!outro.getDescricao().equals(this.descricao)) {
			return false;
		}
		if(outro.getValor() != this.valor) {
			return false;
		}
		if (!outro.getData().equals(this.data)) {
			return false;
		}
		if (!outro.getCategoria().equals(this.categoria)) {
			return false;
		}
		return true;
	}
}
