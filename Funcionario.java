/*
 * Preferir composicao a heranca
 */

import java.util.Calendar;

public class Funcionario {
    private String nome;
    private Cargo cargo;
    private final Calendar dataContratacao;


    public Funcionario(String nome, Cargo cargo, Calendar dataContratacao) {
        this.nome = nome;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
    }

    public String getNome() {
        return this.nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Calendar getDataContratacao() {
        return dataContratacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario(int mes, int ano) { // Com beneficio
        double salario = 0;

        if(this.cargo instanceof Vendedor) { // Com base no valor vendido
            double beneficio = (this.cargo.getBeneficio() / 100);
            double valorVendido = ((Vendedor) this.cargo).getValorVendidoMes(mes, ano); // Total
            double totalBeneficio = beneficio * valorVendido;

            salario = this.getSalarioSemBeneficio(mes, ano) + totalBeneficio;
        }
        else {
            double beneficio = (this.cargo.getBeneficio() / 100) + 1;

            salario = beneficio * this.getSalarioSemBeneficio(mes, ano);
        }

        return salario;
    }

    public double getSalarioSemBeneficio(int mes, int ano) {
        Calendar dataAtual = Calendar.getInstance();
        dataAtual.set(Calendar.DAY_OF_MONTH, 1);
        dataAtual.set(Calendar.MONTH, mes);
        dataAtual.set(Calendar.YEAR, ano);

        Calendar dataContratacao = this.getDataContratacao();

        int anosServico = dataAtual.get(Calendar.YEAR) - dataContratacao.get(Calendar.YEAR);
        if(dataContratacao.get(Calendar.MONTH) > dataAtual.get(Calendar.MONTH) || 
            (dataContratacao.get(Calendar.MONTH) == dataAtual.get(Calendar.MONTH) && dataAtual.get(Calendar.DATE) >= dataContratacao.get(Calendar.DATE))) {
            anosServico--;
        }

        double salarioCargo = this.getCargo().getSalario();
        double salarioSemBeneficio = salarioCargo + (this.getCargo().getBonusAnosServico() * anosServico);

        return salarioSemBeneficio;
    }
}
