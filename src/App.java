public class App {
    public static void main(String[] args) throws Exception {
        double rm = Double.parseDouble(args[0]);
        String result = calcularIR(rm);
        System.out.println(result);
    }

    public static String calcularIR(double rm) {
        if (rm < 0) {
            return "Erro";
        }
        if (rm <= 5000) {
           return "IR = 0";
        } else if (rm <= 5500) {
            return "IR com 75% de desconto";
        } else if (rm <= 6000) {
            return "IR com 50% de desconto";
        } else if (rm <= 6500) {
            return "IR com 25% de desconto";
        } else if (rm <= 7350) {
            return "IR com 10% de desconto";
        } else {
            return "IR com alíquota de 27,5%";
        }
    }
}
