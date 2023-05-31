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

    public double getSalarioMesEspecifico(int mes, int ano) {
        if(this.cargo instanceof Vendedor) {
            double valorVendidoMes = ((Vendedor) this.cargo).getValorVendidoMes(mes, ano);

            double beneficio = (this.cargo.getBeneficio() / 100);
            
            return this.getSalarioSemBeneficio() + (beneficio * valorVendidoMes);
        }
        else return this.getSalario();
    }

    public double getSalario() { // Com beneficio
        double salario = 0;

        if(this.cargo instanceof Vendedor) { // Com base no valor vendido
            double beneficio = (this.cargo.getBeneficio() / 100);
            double valorVendido = ((Vendedor) this.cargo).getValorVendido(); // Total
            double totalBeneficio = beneficio * valorVendido;

            salario = this.getSalarioSemBeneficio() + totalBeneficio;
        }
        else {
            double beneficio = (this.cargo.getBeneficio() / 100) + 1;

            salario = beneficio * this.getSalarioSemBeneficio();
        }

        return salario;
    }

    public double getSalarioSemBeneficio() {
        Calendar dataAtual = Calendar.getInstance();

        int anoAtual = dataAtual.get(Calendar.YEAR);
        int anosServico = anoAtual - this.dataContratacao.get(Calendar.YEAR);

        double salarioCargo = this.getCargo().getSalario();
        double salarioSemBeneficio = salarioCargo + (this.getCargo().getBonusAnosServico() * anosServico);

        return salarioSemBeneficio;
    }
}
