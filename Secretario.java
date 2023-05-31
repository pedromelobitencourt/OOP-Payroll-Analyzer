public class Secretario extends Cargo {
    private static final double SALARIO = 7000; // Salario padrao atualmente
    private static final double BONUS_ANOS_SERVICO = 1000; // Bonus de anos de servico padrao no momento
    private static final double BENEFICIO = 20; // Beneficio padrao atualmente

    public Secretario() {
        super(SALARIO, BENEFICIO);
    }

    public double getSalario() {
        return SALARIO;
    }

    public double getBonusAnosServico() {
        return BONUS_ANOS_SERVICO;
    }

    public void updateSalario() {
        this.salario = SALARIO;
    }

    public double getBeneficio() {
        return BENEFICIO;
    }

    public void updateBeneficio() {
        this.beneficio = BENEFICIO; // Caso mude
    }
}