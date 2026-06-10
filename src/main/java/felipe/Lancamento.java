package felipe;

import java.time.LocalDate;

public abstract class Lancamento {
    private String descricao;
    private double valor;
    private LocalDate data;

    public double getValor(){
        return 0;
    }
    public LocalDate getData(){
        return data;
    }

    public String getDescricao() {
        return descricao;
    }
}
