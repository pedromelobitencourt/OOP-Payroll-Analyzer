import java.util.Calendar;

public class Venda {
    private double valor;
    private Calendar data;

    public Venda(double valor, Calendar data) {
        this.valor = valor;
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public Calendar getData() {
        return data;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
}
