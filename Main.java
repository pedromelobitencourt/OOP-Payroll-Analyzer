/*
 * Pedro Vitor Melo Bitencourt
 * 
 * Poderia ter colocado várias verificações de exceções para observar se o usuário está passando valores consistentes
 * Nas classes dos cargos, coloquei como variavel padrao o salario, beneficio e bonus de anos de servico, pois caso no futuro mude, facilmente conseguiria
 * mudar dessa maneira
 */


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

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

    // Podia apenas ter retornado totalPago(....) - totalPagoSemBeneficio(....)
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
            System.out.println(valorVendido);

            if(valorVendido > max) {
                max = valorVendido;
                ven = vendedor;
            }
        }

        return ven;
    }

    public static void main(String[] args) {
        //Criar datas
        Calendar dataJorge = Calendar.getInstance();
        dataJorge.set(Calendar.DAY_OF_MONTH, 1);
        dataJorge.set(Calendar.MONTH, Calendar.JANUARY);
        dataJorge.set(Calendar.YEAR, 2018);

        Calendar dataMaria = Calendar.getInstance();
        dataMaria.set(Calendar.DAY_OF_MONTH, 1);
        dataMaria.set(Calendar.MONTH, Calendar.DECEMBER);
        dataMaria.set(Calendar.YEAR, 2015);

        Calendar dataAna = Calendar.getInstance();
        dataAna.set(Calendar.DAY_OF_MONTH, 1);
        dataAna.set(Calendar.MONTH, Calendar.DECEMBER);
        dataAna.set(Calendar.YEAR, 2021);

        Calendar dataJoao = Calendar.getInstance();
        dataJoao.set(Calendar.DAY_OF_MONTH, 1);
        dataJoao.set(Calendar.MONTH, Calendar.DECEMBER);
        dataJoao.set(Calendar.YEAR, 2021);

        Calendar dataJuliana = Calendar.getInstance();
        dataJuliana.set(Calendar.DAY_OF_MONTH, 1);
        dataJuliana.set(Calendar.MONTH, Calendar.JULY);
        dataJuliana.set(Calendar.YEAR, 2017);

        Calendar dataBento = Calendar.getInstance();
        dataBento.set(Calendar.DAY_OF_MONTH, 1);
        dataBento.set(Calendar.MONTH, Calendar.MARCH);
        dataBento.set(Calendar.YEAR, 2014);


        // Criar os funcionarios
		Funcionario jorgeCarvalho = new Funcionario("Jorge Carvalho", new Secretario(), dataJorge);
		Funcionario mariaSouza = new Funcionario("Maria Souza", new Secretario(), dataMaria);
		Funcionario anaSilva = new Funcionario("Ana Silva", new Vendedor(), dataAna);
		Funcionario joaoMendes = new Funcionario("João Mendes", new Vendedor(), dataJoao);
		Funcionario julianaAlves = new Funcionario("Juliana Alves", new Gerente(), dataJuliana);
		Funcionario bentoAlbino = new Funcionario("Bento Albino", new Gerente(), dataBento);
		
		// Criar as listas necessárias para os testes
		ArrayList<Funcionario> listaCompleta = new ArrayList<Funcionario>();
		ArrayList<Funcionario> listaBeneficios = new ArrayList<Funcionario>();
		ArrayList<Funcionario> listaVendedores = new ArrayList<Funcionario>();
		
		listaCompleta.add(jorgeCarvalho);
		listaCompleta.add(mariaSouza);
		listaCompleta.add(anaSilva);
		listaCompleta.add(joaoMendes);
		listaCompleta.add(julianaAlves);
		listaCompleta.add(bentoAlbino);
		
		listaBeneficios.add(jorgeCarvalho);
		listaBeneficios.add(mariaSouza);
		listaBeneficios.add(anaSilva);
		listaBeneficios.add(joaoMendes);
		
		listaVendedores.add(anaSilva);
		listaVendedores.add(joaoMendes);

        // Criar datas venda
        Calendar data1 = Calendar.getInstance();
        data1.set(Calendar.DAY_OF_MONTH, 1);
        data1.set(Calendar.MONTH, Calendar.DECEMBER);
        data1.set(Calendar.YEAR, 2021);

        Calendar data2 = Calendar.getInstance();
        data2.set(Calendar.DAY_OF_MONTH, 1);
        data2.set(Calendar.MONTH, Calendar.JANUARY);
        data2.set(Calendar.YEAR, 2022);

        Calendar data3 = Calendar.getInstance();
        data3.set(Calendar.DAY_OF_MONTH, 1);
        data3.set(Calendar.MONTH, Calendar.FEBRUARY);
        data3.set(Calendar.YEAR, 2022);

        Calendar data4 = Calendar.getInstance();
        data4.set(Calendar.DAY_OF_MONTH, 1);
        data4.set(Calendar.MONTH, Calendar.MARCH);
        data4.set(Calendar.YEAR, 2022);

        Calendar data5 = Calendar.getInstance();
        data5.set(Calendar.DAY_OF_MONTH, 1);
        data5.set(Calendar.MONTH, Calendar.APRIL);
        data5.set(Calendar.YEAR, 2022);

        // Criar Vendas
        Venda vendaAna1 = new Venda(5200, data1);
        Venda vendaAna2 = new Venda(4000, data2);
        Venda vendaAna3 = new Venda(4200, data3);
        Venda vendaAna4 = new Venda(5850, data4);
        Venda vendaAna5 = new Venda(7000, data5);

        Venda vendaJoao1 = new Venda(3400, data1);
        Venda vendaJoao2 = new Venda(7700, data2);
        Venda vendaJoao3 = new Venda(5000, data3);
        Venda vendaJoao4 = new Venda(5900, data4);
        Venda vendaJoao5 = new Venda(6500, data5);

        // Realizar vendas
        Vendedor ana = (Vendedor) anaSilva.getCargo();
        Vendedor joao = (Vendedor) joaoMendes.getCargo();

        ana.realizarVenda(vendaAna1);
        ana.realizarVenda(vendaAna2);
        ana.realizarVenda(vendaAna3);
        ana.realizarVenda(vendaAna4);
        ana.realizarVenda(vendaAna5);

        joao.realizarVenda(vendaJoao1);
        joao.realizarVenda(vendaJoao2);
        joao.realizarVenda(vendaJoao3);
        joao.realizarVenda(vendaJoao4);
        joao.realizarVenda(vendaJoao5);
		
		Scanner input = new Scanner(System.in);
		
		// Menu
		while(true) {
			int op = 0;

			System.out.println("Escolha a opção de teste:");
			System.out.println("1 - Soma de todos os salarios completos em um mês");
			System.out.println("2 - Soma de todos os salarios sem os beneficios em um mês");
			System.out.println("3 - Soma de somento que foi gasto em beneficios em um mês");
			System.out.println("4 - Funcionario que recebeu o maior salario em um determinado mês");
			System.out.println("5 - Funcionario que recebeu mais beneficio em um determinado mês");
			System.out.println("6 - Vendedor que mais vendeu em um determinado mes");
			System.out.println("(Qualque outro numero) - Sair");
			System.out.println("Digite o numero");

			op = input.nextInt();
			input.nextLine();
			switch (op) {
                case 1:		
                    System.out.println("Digite o numero do mês (Sem o 0 na frente, como '1' para Janeiro).");

                    int mes = input.nextInt();
                    input.nextLine();

                    System.out.println("Digite o ano");
                    int ano = input.nextInt();
                    input.nextLine();

                    double valorTotal = totalPago(listaCompleta, mes, ano);
                    System.out.printf("O valor da soma de todos os salarios na data %d/%d é: R$ %.2f \n", mes, ano, valorTotal);

                    break;
                case 2:
                    System.out.println("Digite o numero do mês (Sem o 0 a frente, como '1' para Janeiro).");

                    mes = input.nextInt();
                    input.nextLine();

                    System.out.println("Digite o ano");
                    ano = input.nextInt();
                    input.nextLine();

                    double valorSemBeneficios = totalPagoSemBeneficio(listaCompleta, mes, ano);
                    System.out.printf("O valor da soma de todos os salarios sem os bonus na data %d/%d é: R$ %.2f \n ", mes, ano, valorSemBeneficios);

                    break;
                case 3:
                    System.out.println("Digite o numero do mês (Sem o 0 a frente, como '1' para Janeiro).");

                    mes = input.nextInt();
                    input.nextLine();

                    System.out.println("Digite o ano");
                    ano = input.nextInt();
                    input.nextLine();

                    double valorBeneficios = totalPagoEmBeneficio(listaBeneficios,mes,ano);
                    System.out.printf("O valor da soma dos bonus na data %d/%d é: R$ %.2f \n ", mes, ano, valorBeneficios);

                    break;
                case 4:
                    System.out.println("Digite o numero do mês (Sem o 0 a frente, como '1' para Janeiro).");

                    mes = input.nextInt();
                    input.nextLine();

                    System.out.println("Digite o ano");
                    ano = input.nextInt();
                    input.nextLine();

                    Funcionario ganhaMais = funcionarioRecebeuMais(listaCompleta, mes, ano);
                    System.out.printf("Na data %d/%d quem mais recebeu foi o(a) %s o valor foi: R$ %.2f \n", mes, ano, ganhaMais.getNome(), ganhaMais.getSalarioMesEspecifico(mes, ano));

                    break;
                case 5:
                    System.out.println("Digite o numero do mês (Sem o 0 a frente, como '1' para Janeiro).");

                    mes = input.nextInt();
                    input.nextLine();

                    System.out.println("Digite o ano");
                    ano = input.nextInt();
                    input.nextLine();

                    Funcionario maisBeneficio = funcionarioRecebeuMaisBeneficio(listaBeneficios, mes, ano);
                    System.out.printf("Na data %d/%d quem recebeu o maior bonus foi o(a) %s o valor foi: R$ %.2f \n", mes, ano, maisBeneficio.getNome(), maisBeneficio.getSalarioMesEspecifico(mes, ano) - maisBeneficio.getSalarioSemBeneficio());

                    break;
                case 6:
                    System.out.println("Digite o numero do mês (Sem o 0 a frente, como '1' para Janeiro).");

                    mes = input.nextInt();
                    input.nextLine();

                    System.out.println("Digite o ano");
                    ano = input.nextInt();
                    input.nextLine();

                    Funcionario maisVendeu = vendedorMaiorVenda(listaVendedores, mes, ano);
                    Vendedor cargo = (Vendedor) maisVendeu.getCargo();

                    double valorVendido = cargo.getValorVendidoMes(mes, ano);
                    System.out.printf("Na data %d/%d quem mais vendeu foi o(a) %s. O valor vendido foi: R$ %.2f \n", mes, ano, maisVendeu.getNome(), valorVendido);

                    break;
                default:
                    System.exit(0);
                    break;
                }
			System.out.println();
		}
    }
}
