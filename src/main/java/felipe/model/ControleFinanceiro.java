package felipe.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Classe responsável pelo controle e gerenciamento financeiro do sistema.
 * Realiza operações de leitura, escrita, listagem e cálculo de saldos
 * baseando-se em receitas e despesas armazenadas em arquivos de texto.
 * * Extende {@link DataBaseConfig} para obter as configurações de caminhos dos arquivos.
 * @version 1.0
 */
public class ControleFinanceiro extends DataBaseConfig {

    private double saldoAtual;
    private double saldoTotal;
    private List<Receita> receitas = new ArrayList<>();
    private List<Despesa> despesas = new ArrayList<>();

    /**
     * Obtém o saldo atual calculado até a data presente (hoje).
     * * @return O valor do saldo atual líquido.
     */
    public double getSaldoAtual() {
        return saldoAtual;
    }

    /**
     * Calcula e atualiza o saldo atual da conta.
     * O cálculo considera apenas as receitas e despesas cuja data
     * seja menor ou igual à data atual do sistema (hoje).
     */
    public void setSaldoAtual() {
        List<Receita> receitasAtual = listarReceitas();
        double somatorio = 0;
        for (Receita r : receitasAtual) {
            if (!r.getData().isAfter(LocalDate.now())) {
                somatorio += r.getValor();
            }
        }

        List<Despesa> despesasAtual = listarDespesas();
        double diminuitorio = 0;
        for (Despesa d : despesasAtual) {
            if (!d.getData().isAfter(LocalDate.now())) {
                diminuitorio += d.getValor();
            }
        }

        // CORREÇÃO: Subtrai as despesas do somatório de receitas
        saldoAtual = somatorio + diminuitorio;
    }

    /**
     * Obtém o saldo total acumulado, incluindo lançamentos futuros.
     * * @return O valor do saldo total absoluto.
     */
    public double getSaldoTotal() {
        return saldoTotal;
    }

    /**
     * Calcula e atualiza o saldo total da conta.
     * O cálculo engloba todas as receitas e despesas cadastradas no sistema,
     * independentemente da data (inclui lançamentos futuros).
     */
    public void setSaldoTotal() {
        List<Receita> receitasAtual = listarReceitas();
        double somatorio = 0;
        for (Receita r : receitasAtual) {
            somatorio += r.getValor();
        }

        List<Despesa> despesasAtual = listarDespesas();
        double diminuitorio = 0;
        for (Despesa d : despesasAtual) {
            diminuitorio += d.getValor();
        }

        saldoTotal = somatorio + diminuitorio;
    }

    /**
     * Adiciona uma nova receita à lista em memória e a persiste no arquivo de banco de dados.
     * Os dados são salvos no formato CSV utilizando o caractere ';' como separador.
     * * @param receita O objeto {@link Receita} a ser adicionado e persistido.
     * @throws IOException Se ocorrer um erro de entrada/saída ao manipular o arquivo.
     */
    public void adicionarReceita(Receita receita) throws IOException {
        receitas.add(receita);
        File arquivo = new File(PATH_DATABASE_RECEITAS);

        String linha = receita.getDescricao() + ";" +
                receita.getValor() + ";" +
                receita.getData() + ";" +
                receita.getCategoria();

        FileWriter fw = new FileWriter(arquivo, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(linha);
        bw.newLine();
        bw.close();
    }

    /**
     * Adiciona uma nova despesa à lista em memória e a persiste no arquivo de banco de dados.
     * Os dados são salvos no formato CSV utilizando o caractere ';' como separador.
     * * @param despesa O objeto {@link Despesa} a ser adicionado e persistido.
     * @throws IOException Se ocorrer um erro de entrada/saída ao manipular o arquivo.
     */
    public void adicionarDespesa(Despesa despesa) throws IOException {
        despesas.add(despesa);
        File arquivo = new File(PATH_DATABASE_DESPESAS);

        String linha = despesa.getDescricao() + ";" +
                despesa.getValor() + ";" +
                despesa.getData() + ";" +
                despesa.getCategoria();

        FileWriter fw = new FileWriter(arquivo, true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(linha);
        bw.newLine();
        bw.close();
    }

    /**
     * Lê o arquivo de banco de dados de receitas e retorna uma lista de objetos do tipo Receita.
     * Ignora a primeira linha do arquivo por ser considerada o cabeçalho.
     * * @return Uma {@link List} contendo todas as receitas extraídas do arquivo.
     * @throws RuntimeException Se o arquivo de receitas estiver corrompido ou inacessível.
     */
    public List<Receita> listarReceitas() {
        File arquivo = new File(PATH_DATABASE_RECEITAS);
        List<Receita> receitas = new ArrayList<>();

        try (FileReader fr = new FileReader(arquivo);
             BufferedReader br = new BufferedReader(fr)) {

            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                String[] dados = linha.split(";");

                Receita receita = new Receita(
                        dados[0],
                        Double.parseDouble(dados[1]),
                        LocalDate.parse(dados[2]),
                        dados[3]
                );
                receitas.add(receita);
            }
            return receitas;

        } catch (Exception e) {
            throw new RuntimeException("O banco de dados receitas está com defeito", e);
        }
    }

    /**
     * Lê o arquivo de banco de dados de despesas e retorna uma lista de objetos do tipo Despesa.
     * Ignora a primeira linha do arquivo por ser considerada o cabeçalho.
     * * @return Uma {@link List} contendo todas as despesas extraídas do arquivo.
     * @throws RuntimeException Se o arquivo de despesas estiver corrompido ou inacessível.
     */
    public List<Despesa> listarDespesas() {
        File arquivo = new File(PATH_DATABASE_DESPESAS);
        List<Despesa> despesas = new ArrayList<>();

        try (FileReader fr = new FileReader(arquivo);
             BufferedReader br = new BufferedReader(fr)) {

            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                String[] dados = linha.split(";");

                Despesa despesa = new Despesa(
                        dados[0],
                        Double.parseDouble(dados[1]),
                        LocalDate.parse(dados[2]),
                        dados[3]
                );
                despesas.add(despesa);
            }
            return despesas;

        } catch (Exception e) {
            throw new RuntimeException("O banco de dados despesas está com defeito", e);
        }
    }

    /**
     * Consolida e organiza cronologicamente todos os lançamentos (receitas e despesas).
     * O método agrupa e ordena os fluxos por data, injetando um objeto {@link SaldoDoDia}
     * sempre que há a transição de um dia para o outro ou ao final da listagem.
     * * @return Uma {@link List} mesclada de objetos {@link Lancamento} e {@link SaldoDoDia},
     * ordenada por data.
     */
    public List<Lancamento> listarLancamentos() {

        List<Lancamento> lancamentos = new ArrayList<>();

        lancamentos.addAll(listarReceitas());
        lancamentos.addAll(listarDespesas());

        lancamentos.sort(Comparator.comparing(Lancamento::getData));

        List<Lancamento> resultado = new ArrayList<>();

        LocalDate dataAtual = null;
        double saldoDia = 0;

        for (Lancamento lancamento : lancamentos) {


            if (dataAtual == null) {
                dataAtual = lancamento.getData();
            }

            if (!lancamento.getData().equals(dataAtual)) {

                resultado.add(new SaldoDoDia(saldoDia, dataAtual));

                dataAtual = lancamento.getData();
            }

            resultado.add(lancamento);
            saldoDia += lancamento.getValor();
        }

        if (dataAtual != null) {
            resultado.add(new SaldoDoDia(saldoDia, dataAtual));
        }

        return resultado;
    }
}