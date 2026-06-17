package felipe.model;

import java.time.LocalDate;

/**
 * Representa o balanço consolidado de saldo ao final de um dia específico.
 * Esta classe estende {@link Lancamento} e é utilizada como um elemento informativo
 * nos relatórios de extrato (como no método de listagem de lançamentos), injetando
 * de forma fixa a descrição e a categoria como "SALDO DO DIA".
 */
public class SaldoDoDia extends Lancamento {

    /**
     * Constrói um novo registro de SaldoDoDia com o valor acumulado e a data informada.
     * Ao chamar o construtor da superclasse {@link Lancamento}, define automaticamente
     * o texto "SALDO DO DIA" tanto para a descrição quanto para a categoria da linha.
     */
    public SaldoDoDia(double valor, LocalDate data) {
        super("SALDO DO DIA", valor, data, "SALDO DO DIA");
    }
}