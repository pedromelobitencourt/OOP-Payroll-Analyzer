import java.util.ArrayList;
import java.util.Calendar;

public class Vendedor extends Cargo {
    private static final double SALARIO = 12000; // Salario padrao atualmente
    private static final double BONUS_ANOS_SERVICO = 1800; // Bonus de anos de servico padrao no momento
    private static final double BENEFICIO = 30; // Beneficio padrao atualmente
    
    private double valorVendido;
    private ArrayList<Venda> vendas;

    public Vendedor() {
        super(SALARIO, BENEFICIO);
        this.valorVendido = 0;

        vendas = new ArrayList<Venda>();
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

    public double getValorVendido() {
        return this.valorVendido;
    }

    public void updateSalario() {
        this.salario = SALARIO;
    }

    public double getValorVendidoMes(int mes, int ano) {
        double valor = 0;

        for(Venda venda : vendas) {
            Calendar dataVenda = venda.getData();

            Calendar dataProcurada = Calendar.getInstance();
            dataProcurada.set(Calendar.DAY_OF_MONTH, 1);
            dataProcurada.set(Calendar.YEAR, ano);
            Main.setMes(dataProcurada, mes);

            if((dataVenda.get(Calendar.YEAR) == dataProcurada.get(Calendar.YEAR)) && 
                (dataVenda.get(Calendar.MONTH) == dataProcurada.get(Calendar.MONTH))) 
                    valor += venda.getValor();
        }

        return valor;
    }

    public void realizarVenda(Venda venda) {
        vendas.add(venda);
        valorVendido += venda.getValor();
    }

    public void updateBeneficio() {
        this.beneficio = BENEFICIO; // Caso mude
    }
}
