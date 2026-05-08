import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InventarioAlmacenTest {

    @Test
    void testCalcularAjusteCategoriaPremium() {
        double valorBase = 100.0;
        double esperado = 20.0;
        double resultado = InventarioAlmacen.calcularAjusteCategoria("premium", valorBase);
        assertEquals(esperado, resultado, 0.001, "El ajuste premium debería ser el 20% del valor base");
    }

    @Test
    void testCalcularAjusteCategoriaBasica() {
        double valorBase = 100.0;
        double esperado = 5.0;
        double resultado = InventarioAlmacen.calcularAjusteCategoria("basica", valorBase);
        assertEquals(esperado, resultado, 0.001, "El ajuste básico debería resultar en 5.0 debido a la multiplicación de negativos");
    }

    @Test
    void testCalcularAjusteCategoriaInexistente() {
        double valorBase = 100.0;
        double esperado = 0.0;
        double resultado = InventarioAlmacen.calcularAjusteCategoria("estandar", valorBase);
        assertEquals(esperado, resultado, 0.001, "Si la categoría no es premium ni basica, el ajuste debe ser 0");
    }
}