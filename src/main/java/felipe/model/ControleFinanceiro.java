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

public class ControleFinanceiro extends DatabaseConfig{
	private double saldoAtual;
	private double saldoTotal;
	private List<Receita> receitas = new ArrayList<>();
    private List<Despesa> despesas = new ArrayList<>();
	
    public double getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual() {
        List<Receita> receitasAtual = listarReceitas();
        double somatorio = 0;
        for (Receita r : receitasAtual) {
        	if(!r.getData().isAfter(LocalDate.now())) {
                somatorio += r.getValor();
        	}
        }

        List<Despesa> despesasAtual = listarDespesas();
        double diminuitorio = 0;
        for (Despesa d : despesasAtual) {
        	if(!d.getData().isAfter(LocalDate.now())) {
        		diminuitorio += d.getValor();
        	}
        }
        
        saldoAtual = somatorio - diminuitorio;
	}

	public double getSaldoTotal() {
		return saldoTotal;
	}

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
        
        saldoTotal = somatorio - diminuitorio;
	}

    public void adicionarReceita(Receita receita) throws IOException {
    	receitas.add(receita);
    	File arquivo = new File(PATH_DATABASE_RECEITAS);

    	String linha = receita.getDescricao() + ";" +
    			receita.getValor() + ";" +
    			receita.getData() + ";" +
    			receita.getReceita();

    	FileWriter fw = new FileWriter(arquivo, true);
    	BufferedWriter bw = new BufferedWriter(fw); 
    	bw.write(linha);
    	bw.newLine();
    	bw.close();
    }

    public void adicionarDespesa(Despesa despesa) throws IOException {
        despesas.add(despesa);
        // Copiado e colado (Verificar se não restou algo das receitas)
        File arquivo = new File(PATH_DATABASE_DESPESAS);

        String linha = despesa.getDescricao() + ";" +
        		despesa.getValor() + ";" +
        		despesa.getData() + ";" +
        		despesa.getDespesa();

        FileWriter fw = new FileWriter(arquivo, true);
        BufferedWriter bw = new BufferedWriter(fw);

        	bw.write(linha);
        	bw.newLine();
        	bw.close();
        }

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
    
    // NÃO FINALIZADO
    // Utilizar o código da última aula para ordenar
    // (Não salvei)
    public List<Lancamento> listarLancamentos() {
    	List<Lancamento> lancamentos = new ArrayList<Lancamento>(listarReceitas());
        lancamentos.addAll(listarDespesas());
        
        lancamentos.sort(Comparator.comparing(Lancamento::getData));
        
        return lancamentos;
    }
}