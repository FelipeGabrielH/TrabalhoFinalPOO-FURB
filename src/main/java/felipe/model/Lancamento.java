package felipe.model;

import java.time.LocalDate;

/**
 * Classe abstrata que representa a estrutura base de um lançamento financeiro.
 * Servindo como superclasse para tipos específicos de movimentações, como
 * receitas e despesas, ela centraliza os atributos comuns e as regras de
 * validação de dados do domínio.
 * * @author Felipe
 * @version 1.0
 */
public abstract class Lancamento {
    private String descricao;
    private double valor;
    private LocalDate data;
    private String categoria;

    /**
     * Constrói um novo Lançamento e aciona os métodos internos de validação
     * para garantir a integridade dos dados fornecidos.
     */
    public Lancamento(String descricao, double valor, LocalDate data, String categoria){
        setDescricao(descricao);
        setValor(valor);
        setData(data);
        setCategoria(categoria);
    }

    /**
     * Obtém o valor monetário associado ao lançamento.
     * * @return O valor do lançamento (positivo para receitas, negativo para despesas).
     */
    public double getValor(){
        return valor;
    }

    /**
     * Obtém a data de ocorrência do lançamento.
     * * @return O objeto {@link LocalDate} representando a data do lançamento.
     */
    public LocalDate getData(){
        return data;
    }

    /**
     * Obtém a descrição ou título descritivo do lançamento.
     * * @return A string contendo a descrição.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Obtém a categoria/classificação do lançamento.
     * * @return A string contendo o nome da categoria.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Valida internamente e define a descrição do lançamento.
     * @throws IllegalArgumentException Se a descrição for nula, vazia ou composta apenas por espaços.
     */
    private void setDescricao(String descricao) {
        if (descricao == null || descricao.isBlank() || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição inválida");
        }

        this.descricao = descricao;
    }

    /**
     * Valida internamente e define o valor do lançamento.
     * @throws NumberFormatException Se o valor informado for exatamente igual a zero.
     */
    private void setValor(double valor) {
        if (valor == 0) {
            throw new NumberFormatException("Valor inválido");
        }

        this.valor = valor;
    }

    /**
     * Valida internamente e define a data do lançamento.
     * @throws IllegalArgumentException Se o objeto de data for nulo.
     */
    private void setData(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("Data inválida");
        }

        this.data = data;
    }

    /**
     * Valida internamente e define a categoria do lançamento.
     * @throws IllegalArgumentException Se a categoria for nula, vazia ou composta apenas por espaços.
     */
    private void setCategoria(String categoria) {
        if (categoria == null || categoria.isBlank() || categoria.isEmpty()) {
            throw new IllegalArgumentException("Categoria inválida");
        }

        this.categoria = categoria;
    }
    
    /**
     * Altera o método equals para comparar os valores de dois lançamentos.
     * * @return Um valor boolean representando se os lançamentos são iguais ou não.
     */
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
