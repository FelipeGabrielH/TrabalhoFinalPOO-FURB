package felipe.model;

import java.time.LocalDate;

/**
 * Representa um lançamento do tipo Receita no sistema financeiro.
 * <p>
 * Esta classe estende {@link Lancamento} e representa as entradas positivas
 * de capital no fluxo de caixa (como salários, rendimentos e vendas).
 */
public class Receita extends Lancamento {

    /**
     * Constrói uma nova Receita com a descrição, valor, data e categoria fornecidos.
     * Os dados fornecidos são validados e encapsulados diretamente na classe base
     * {@link Lancamento}. Diferente das despesas, o valor da receita mantém seu
     * comportamento positivo padrão para somatórios.*
     */
    public Receita(String descricao, double valor, LocalDate data, String categoria) {
        super(descricao, valor, data, categoria);
    }
}