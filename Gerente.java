public class Gerente extends Cargo {
    private static final double SALARIO = 20000; // Caso mude o salario
    private static final double BONUS_ANOS_SERVICO = 3000;
    private static final double BENEFICIO = 0;

    public Gerente() {
        super(SALARIO, 0);
    }

    public double getSalario() {
        return SALARIO;
    }

    public double getBonusAnosServico() {
        return BONUS_ANOS_SERVICO;
    }

    public double getBeneficio() {
        return BENEFICIO;
    }

    public void updateSalario() {
        this.salario = SALARIO; // Caso mude
    }
}
