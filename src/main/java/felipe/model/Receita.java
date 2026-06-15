package felipe.model;

import java.time.LocalDate;

public class Receita extends Lancamento {
    CategoriaReceita receita;

    public Receita(String descricao,double valor,LocalDate data,CategoriaReceita categoria) {
        super(descricao, valor, data);
        this.receita = categoria;
    }

    public CategoriaReceita getReceita() {
        return receita;
    }
}

