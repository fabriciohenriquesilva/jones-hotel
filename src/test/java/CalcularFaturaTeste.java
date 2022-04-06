
import model.Fatura;


public class CalcularFaturaTeste {
    
    public static void main(String[] args) {
        
        double parcela = new Fatura().getTipoPagamento().CARTAO_CREDITO.calcularParcela(300, 3);
        
        System.out.println("Teste de valor da parcela conforme exemplo do trabalho");
        System.out.println(parcela);
    }
}
