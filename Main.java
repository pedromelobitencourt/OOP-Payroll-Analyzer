/*
 * Pedro Vitor Melo Bitencourt
 * 
 * Poderia ter colocado várias verificações de exceções para observar se o usuário está passando valores consistentes
 */


import java.sql.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class Main {
    static void setMes(Calendar data, int mes) {
        switch(mes) {
            case 1: data.set(Calendar.MONTH, Calendar.JANUARY);
                break;
            case 2: data.set(Calendar.MONTH, Calendar.FEBRUARY);
                break;
            case 3: data.set(Calendar.MONTH, Calendar.MARCH);
                break;
            case 4: data.set(Calendar.MONTH, Calendar.APRIL);
                break;
            case 5: data.set(Calendar.MONTH, Calendar.MAY);
                break;
            case 6: data.set(Calendar.MONTH, Calendar.JUNE);
                break;
            case 7: data.set(Calendar.MONTH, Calendar.JULY);
                break;
            case 8: data.set(Calendar.MONTH, Calendar.AUGUST);
                break;
            case 9: data.set(Calendar.MONTH, Calendar.SEPTEMBER);
                break;
            case 10: data.set(Calendar.MONTH, Calendar.OCTOBER);
                break;
            case 11: data.set(Calendar.MONTH, Calendar.NOVEMBER);
                break;
            case 12: data.set(Calendar.MONTH, Calendar.DECEMBER);
                break;
            // Exceção
        }
    }

    static double totalPago(ArrayList<Funcionario> funcionarios, int mes, int ano) { // Contabiliza beneficio
        double answer = 0;

        for (Funcionario funcionario : funcionarios) {
            Calendar dataContratacao = funcionario.getDataContratacao();
            Calendar data = Calendar.getInstance();

            data.set(Calendar.DAY_OF_MONTH, 1);
            data.set(Calendar.YEAR, ano);

            setMes(data, mes);

            if(data.after(dataContratacao))
                answer += funcionario.getSalarioMesEspecifico(mes, ano);
        }

        return answer;
    }

    static double totalPagoSemBeneficio(ArrayList<Funcionario> funcionarios, int mes, int ano) {
        double answer = 0;

        for (Funcionario funcionario : funcionarios) {
            Calendar dataContratacao = funcionario.getDataContratacao();
            Calendar data = Calendar.getInstance();

            data.set(Calendar.DAY_OF_MONTH, 1);
            data.set(Calendar.YEAR, ano);

            setMes(data, mes);

            if(data.after(dataContratacao))
                answer += (funcionario.getSalarioSemBeneficio());
        }

        return answer;
    }

    static double totalPagoEmBeneficio(ArrayList<Funcionario> funcionarios, int mes, int ano) {
        double answer = 0;

        for (Funcionario funcionario : funcionarios) {
            Calendar dataContratacao = funcionario.getDataContratacao();
            Calendar data = Calendar.getInstance();

            data.set(Calendar.DAY_OF_MONTH, 1);
            data.set(Calendar.YEAR, ano);

            setMes(data, mes);

            if(data.after(dataContratacao)) {
                double salarioBeneficio = funcionario.getSalarioMesEspecifico(mes, ano);

                

                double salarioSemBeneficio = funcionario.getSalarioSemBeneficio();
                
                answer += (salarioBeneficio - salarioSemBeneficio);
            }
        }

        return answer;
    }

    static Funcionario funcionarioRecebeuMais(ArrayList<Funcionario> funcionarios, int mes, int ano) { // Recebeu o valor mais alto no mes
        double max = 0;
        Funcionario fun = null;

        for (Funcionario funcionario : funcionarios) {
            Calendar dataContratacao = funcionario.getDataContratacao();
            Calendar data = Calendar.getInstance();

            data.set(Calendar.DAY_OF_MONTH, 1);
            data.set(Calendar.YEAR, ano);

            setMes(data, mes);

            if(data.after(dataContratacao)) {
                double salario = funcionario.getSalarioMesEspecifico(mes, ano);

                if(salario > max) {
                    max = salario;
                    fun = funcionario;
                }
            }
        }

        return fun;
    }

    static Funcionario funcionarioRecebeuMaisBeneficio(ArrayList<Funcionario> funcionarios, int mes, int ano) { // Recebeu mais beneficio no mes
        double max = 0;
        Funcionario fun = null;

        for (Funcionario funcionario : funcionarios) {
            Calendar dataContratacao = funcionario.getDataContratacao();
            Calendar data = Calendar.getInstance();

            data.set(Calendar.DAY_OF_MONTH, 1);
            data.set(Calendar.YEAR, ano);
            setMes(data, mes);

            if(data.after(dataContratacao)) {
                double salarioComBeneficio = funcionario.getSalarioMesEspecifico(mes, ano);
                double salarioSemBeneficio = funcionario.getSalarioSemBeneficio();

                double salario = salarioComBeneficio - salarioSemBeneficio;

                if(salario > max) {
                    max = salario;
                    fun = funcionario;
                }
            }
        }

        return fun;
    }

    static Funcionario vendedorMaiorVenda(ArrayList<Funcionario> vendedores, int mes, int ano) {
        double max = 0;
        Funcionario ven = null;

        for (Funcionario vendedor : vendedores) {
            Vendedor cargo = (Vendedor) vendedor.getCargo();

            double valorVendido = cargo.getValorVendidoMes(mes, ano);

            if(valorVendido > max) {
                max = valorVendido;
                ven = vendedor;
            }
        }

        return ven;
    }

    public static void main(String[] args) {
        Calendar data1 = Calendar.getInstance();
        data1.set(Calendar.DAY_OF_MONTH, 3);
        data1.set(Calendar.MONTH, Calendar.SEPTEMBER);
        data1.set(Calendar.YEAR, 2019);

        Calendar data2 = Calendar.getInstance();
        data2.set(Calendar.DAY_OF_MONTH, 7);
        data2.set(Calendar.MONTH, Calendar.MAY);
        data2.set(Calendar.YEAR, 2021);

        Calendar data3 = Calendar.getInstance();
        data3.set(Calendar.DAY_OF_MONTH, Calendar.JULY);
        data3.set(Calendar.MONTH, 5);
        data3.set(Calendar.YEAR, 2019);

        Calendar data4 = Calendar.getInstance();
        data4.set(Calendar.DAY_OF_MONTH, Calendar.JULY);
        data4.set(Calendar.MONTH, 5);
        data4.set(Calendar.YEAR, 2019);

        Funcionario f1 = new Funcionario("Pedro", new Gerente(), data1);
        Funcionario f2 = new Funcionario("Rafael", new Gerente(), data2);
        Funcionario f3 = new Funcionario("Sergio", new Secretario(), data3);
        Funcionario f4 = new Funcionario("Lucas", new Vendedor(), data4);


        Venda v = new Venda(37000, data2);
        ((Vendedor) f4.getCargo()).realizarVenda(v);


        System.out.println(f1.getSalarioSemBeneficio());
        System.out.println(f1.getSalario());
        System.out.println();

        System.out.println(f2.getSalarioSemBeneficio());
        System.out.println(f2.getSalario());
        System.out.println();

        System.out.println(f3.getSalarioSemBeneficio());
        System.out.println(f3.getSalario());
        System.out.println();

        System.out.println(f4.getSalarioSemBeneficio());
        System.out.println(f4.getSalario());
        System.out.println();

        Funcionario ven1 = new Funcionario("V1", new Vendedor(), data4);
        Venda v1 = new Venda(27000, data2);
        ((Vendedor) ven1.getCargo()).realizarVenda(v1);


        Funcionario ven2 = new Funcionario("V2", new Vendedor(), data4);
        Venda v2 = new Venda(22000, data2);
        ((Vendedor) ven2.getCargo()).realizarVenda(v2);

        Funcionario ven3 = new Funcionario("V3", new Vendedor(), data4);
        Venda v3 = new Venda(23000, data2);
        ((Vendedor) ven3.getCargo()).realizarVenda(v3);


        Funcionario ven4 = new Funcionario("V4", new Vendedor(), data4);
        Venda v4 = new Venda(12000, data2);
        ((Vendedor) ven4.getCargo()).realizarVenda(v4);


        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        ArrayList<Funcionario> vendedores = new ArrayList<Funcionario>();

        funcionarios.add(f1);
        funcionarios.add(f2);
        funcionarios.add(f3);
        funcionarios.add(f4);

        vendedores.add(f4);
        vendedores.add(ven1);
        vendedores.add(ven2);
        vendedores.add(ven3);
        vendedores.add(ven4);

        System.out.println(vendedorMaiorVenda(vendedores, 5, 2021).getNome());
    }
}
