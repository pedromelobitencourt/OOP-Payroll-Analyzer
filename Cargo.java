public abstract class Cargo {
    protected double salario;
    protected double beneficio;

    public Cargo(double salario, double beneficio) {
        this.salario = salario;
    }

    public abstract double getSalario(); // Sem beneficio

    public abstract void updateSalario(); // Caso mude o salario padrao do cargo

    public abstract double getBonusAnosServico();

    public abstract double getBeneficio();
}