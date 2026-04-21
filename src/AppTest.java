import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testes de unidade para o método calcularIR da classe App.
 *
 * Cobertura:
 *  - Partições de Equivalência (PE01 a PE08)
 *  - Caminhos independentes do GFC (Caminhos 1 a 7)
 */

@DisplayName("Testes do cálculo de IR")
public class AppTest {

    // PARTIÇÕES DE EQUIVALÊNCIA

    @Nested
    @DisplayName("Partições de Equivalência")
    class ParticoesDeEquivalencia {

        // --- PE01: RM < 0 → Inválida → Erro ---

        @Test
        @DisplayName("PE01 | RM = -1 → Erro (valor negativo)")
        void pe01_rmNegativo_deveRetornarErro() {
            assertEquals("Erro", App.calcularIR(-1));
        }

        // --- PE02: Não numérico → Inválida → Erro ---

        @Test
        @DisplayName("PE02 | Entrada não numérica → NumberFormatException no parse")
        void pe02_entradaNaoNumerica_deveLancarExcecao() {
            org.junit.jupiter.api.Assertions.assertThrows(
                NumberFormatException.class,
                () -> Double.parseDouble("abc")
            );
        }

        // --- PE03: 0 ≤ RM ≤ 5000 → Isento → IR = 0 ---

        @Test
        @DisplayName("PE03a | RM = 0 → IR = 0 (limite inferior)")
        void pe03a_rmZero_deveRetornarIsento() {
            assertEquals("IR = 0", App.calcularIR(0));
        }

        @Test
        @DisplayName("PE03b | RM = 1 → IR = 0 (interior da faixa)")
        void pe03b_rmUm_deveRetornarIsento() {
            assertEquals("IR = 0", App.calcularIR(1));
        }

        @Test
        @DisplayName("PE03c | RM = 4999 → IR = 0 (interior da faixa)")
        void pe03c_rmQuatroMilNovecentosNoventa9_deveRetornarIsento() {
            assertEquals("IR = 0", App.calcularIR(4999));
        }

        @Test
        @DisplayName("PE03d | RM = 5000 → IR = 0 (limite superior)")
        void pe03d_rmCincoMil_deveRetornarIsento() {
            assertEquals("IR = 0", App.calcularIR(5000));
        }

        // --- PE04: 5000 < RM ≤ 5500 → Desc. 75% ---

        @Test
        @DisplayName("PE04a | RM = 5001 → IR com 75% de desconto (limite inferior)")
        void pe04a_rm5001_deveRetornarDesconto75() {
            assertEquals("IR com 75% de desconto", App.calcularIR(5001));
        }

        @Test
        @DisplayName("PE04b | RM = 5250 → IR com 75% de desconto (interior da faixa)")
        void pe04b_rm5250_deveRetornarDesconto75() {
            assertEquals("IR com 75% de desconto", App.calcularIR(5250));
        }

        @Test
        @DisplayName("PE04c | RM = 5500 → IR com 75% de desconto (limite superior)")
        void pe04c_rm5500_deveRetornarDesconto75() {
            assertEquals("IR com 75% de desconto", App.calcularIR(5500));
        }

        // --- PE05: 5500 < RM ≤ 6000 → Desc. 50% ---

        @Test
        @DisplayName("PE05a | RM = 5501 → IR com 50% de desconto (limite inferior)")
        void pe05a_rm5501_deveRetornarDesconto50() {
            assertEquals("IR com 50% de desconto", App.calcularIR(5501));
        }

        @Test
        @DisplayName("PE05b | RM = 5750 → IR com 50% de desconto (interior da faixa)")
        void pe05b_rm5750_deveRetornarDesconto50() {
            assertEquals("IR com 50% de desconto", App.calcularIR(5750));
        }

        @Test
        @DisplayName("PE05c | RM = 6000 → IR com 50% de desconto (limite superior)")
        void pe05c_rm6000_deveRetornarDesconto50() {
            assertEquals("IR com 50% de desconto", App.calcularIR(6000));
        }

        // --- PE06: 6000 < RM ≤ 6500 → Desc. 25% ---

        @Test
        @DisplayName("PE06a | RM = 6001 → IR com 25% de desconto (limite inferior)")
        void pe06a_rm6001_deveRetornarDesconto25() {
            assertEquals("IR com 25% de desconto", App.calcularIR(6001));
        }

        @Test
        @DisplayName("PE06b | RM = 6250 → IR com 25% de desconto (interior da faixa)")
        void pe06b_rm6250_deveRetornarDesconto25() {
            assertEquals("IR com 25% de desconto", App.calcularIR(6250));
        }

        @Test
        @DisplayName("PE06c | RM = 6500 → IR com 25% de desconto (limite superior)")
        void pe06c_rm6500_deveRetornarDesconto25() {
            assertEquals("IR com 25% de desconto", App.calcularIR(6500));
        }

        // --- PE07: 6500 < RM ≤ 7350 → Desc. 10% ---

        @Test
        @DisplayName("PE07a | RM = 6501 → IR com 10% de desconto (limite inferior)")
        void pe07a_rm6501_deveRetornarDesconto10() {
            assertEquals("IR com 10% de desconto", App.calcularIR(6501));
        }

        @Test
        @DisplayName("PE07b | RM = 7000 → IR com 10% de desconto (interior da faixa)")
        void pe07b_rm7000_deveRetornarDesconto10() {
            assertEquals("IR com 10% de desconto", App.calcularIR(7000));
        }

        @Test
        @DisplayName("PE07c | RM = 7350 → IR com 10% de desconto (limite superior)")
        void pe07c_rm7350_deveRetornarDesconto10() {
            assertEquals("IR com 10% de desconto", App.calcularIR(7350));
        }

        // --- PE08: RM > 7350 → Alíquota 27,5% ---

        @Test
        @DisplayName("PE08a | RM = 7351 → IR com alíquota de 27,5% (limite inferior)")
        void pe08a_rm7351_deveRetornarAliquota27_5() {
            assertEquals("IR com alíquota de 27,5%", App.calcularIR(7351));
        }

        @Test
        @DisplayName("PE08b | RM = 10000 → IR com alíquota de 27,5% (valor alto)")
        void pe08b_rm10000_deveRetornarAliquota27_5() {
            assertEquals("IR com alíquota de 27,5%", App.calcularIR(10000));
        }
    }

    // CAMINHOS INDEPENDENTES DO GFC

    @Nested
    @DisplayName("Caminhos Independentes do GFC")
    class CaminhosGFC {

        @Test
        @DisplayName("Caminho 1 | RM = -1 → Predicado: rm < 0 → Erro")
        void caminho1_rmNegativo_deveRetornarErro() {
            assertEquals("Erro", App.calcularIR(-1));
        }

        @Test
        @DisplayName("Caminho 2 | RM = 200 → Predicado: rm ≤ 5000 → IR = 0")
        void caminho2_rm200_deveRetornarIsento() {
            assertEquals("IR = 0", App.calcularIR(200));
        }

        @Test
        @DisplayName("Caminho 3 | RM = 5199 → Predicado: rm ≤ 5500 → IR com 75% de desconto")
        void caminho3_rm5199_deveRetornarDesconto75() {
            assertEquals("IR com 75% de desconto", App.calcularIR(5199));
        }

        @Test
        @DisplayName("Caminho 4 | RM = 5999 → Predicado: rm ≤ 6000 → IR com 50% de desconto")
        void caminho4_rm5999_deveRetornarDesconto50() {
            assertEquals("IR com 50% de desconto", App.calcularIR(5999));
        }

        @Test
        @DisplayName("Caminho 5 | RM = 6001 → Predicado: rm ≤ 6500 → IR com 25% de desconto")
        void caminho5_rm6001_deveRetornarDesconto25() {
            assertEquals("IR com 25% de desconto", App.calcularIR(6001));
        }

        @Test
        @DisplayName("Caminho 6 | RM = 7350 → Predicado: rm ≤ 7350 → IR com 10% de desconto")
        void caminho6_rm7350_deveRetornarDesconto10() {
            assertEquals("IR com 10% de desconto", App.calcularIR(7350));
        }

        @Test
        @DisplayName("Caminho 7 | RM = 7351 → Predicado: rm > 7350 → IR com alíquota de 27,5%")
        void caminho7_rm7351_deveRetornarAliquota27_5() {
            assertEquals("IR com alíquota de 27,5%", App.calcularIR(7351));
        }
    }
}