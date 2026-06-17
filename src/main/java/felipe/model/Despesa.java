package felipe.model;

import java.time.LocalDate;

/**
 * Representa um lançamento do tipo Despesa no sistema financeiro.
 * Esta classe estende {@link Lancamento} e garante que o valor associado à despesa
 * seja sempre armazenado como um número negativo, refletindo corretamente a saída
 * de capital nos fluxos de caixa e saldos.
 */
public class Despesa extends Lancamento {

    /**
     * Constrói uma nova Despesa com a descrição, valor, data e categoria fornecidos.
     * O construtor avalia o parâmetro {@code valor}: caso ele seja enviado como positivo,
     * o método o converte automaticamente para negativo antes de repassá-lo para a
     */
    public Despesa(String descricao, double valor, LocalDate data, String categoria) {
        super(descricao, valor > 0 ? -valor : valor, data, categoria);
    }
}