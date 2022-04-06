package model;

public enum TipoPagamento implements Taxa {
    
    DINHEIRO {
        @Override
        public double calcularParcela(double valor, int numParcelas) {
            double subtotal = valor/numParcelas, total = 0;
            double parcelaAnterior = 0;
            //Corrigir taxa de juros
            for(int i = 0; i < numParcelas; i++){
                parcelaAnterior = subtotal * 1.02;
                subtotal = parcelaAnterior;
                total += parcelaAnterior;
            }
            return total;
        }

        @Override
        public double calcularJuros() {
            return 0;
        }
        
    },
    CARTAO_CREDITO {
        @Override
        public double calcularParcela(double valor, int numParcelas) {
            double subtotal = valor/numParcelas, total = 0;
            double parcelaAnterior = 0;
            //Corrigir taxa de juros
            for(int i = 0; i < numParcelas; i++){
                parcelaAnterior = subtotal * 1.06;
                subtotal = parcelaAnterior;
                total += parcelaAnterior;
            }
            total *= 1.018;
            return total/numParcelas;
        }

        @Override
        public double calcularJuros() {
            return 0;
        }
    },
    CARTAO_DEBITO { // NECESSÁRIO IMPLEMENTAR
        @Override
        public double calcularParcela(double valor, int numParcelas) {
            double subtotal = valor/numParcelas, total = 0;
            double parcelaAnterior = 0;
            //Corrigir taxa de juros
            for(int i = 0; i < numParcelas; i++){
                parcelaAnterior = subtotal * 1.02;
                subtotal = parcelaAnterior;
                total += parcelaAnterior;
            }
            return total;
        }

        @Override
        public double calcularJuros() {
            return 0;
        }
    },
    PIX { // NECESSÁRIO IMPLEMENTAR
        @Override
        public double calcularParcela(double valor, int numParcelas) {
            double subtotal = valor/numParcelas, total = 0;
            double parcelaAnterior = 0;
            //Corrigir taxa de juros
            for(int i = 0; i < numParcelas; i++){
                parcelaAnterior = subtotal * 1.02;
                subtotal = parcelaAnterior;
                total += parcelaAnterior;
            }
            return total;
        }

        @Override
        public double calcularJuros() {
            return 0;
        }
    }
}
