public class Inventario {
    public double calcularTotalInventario(int numeroProductos, double precioUnitario,
                                          int mesesCatalogo, int diasDesdeUltimaVenta, int stockActual, String tipoCategoria) {
// Cálculo del valor base del inventario
        double valorBase = numeroProductos * precioUnitario;
// Descuento por antigüedad (si lleva más de 12 meses
// en catálogo)
        double descuentoAntiguedad = calcularDescuentoAntiguedad(mesesCatalogo, valorBase);
// Penalización por baja rotación (más de 60 días sin vender)
        double penalizacionRotacion = calcularPenalizacionRotacion(diasDesdeUltimaVenta, valorBase);
// Bonificación por stock alto (más de 100 unidades)
        double bonificacionStock = calcularBonificacionStock(stockActual, valorBase);
// Ajuste por tipo de categoría
        double ajusteCategoria = calcularAjusteCategoria(tipoCategoria, valorBase);
// Cálculo final
        return valorBase - descuentoAntiguedad - penalizacionRotacion + bonificacionStock + ajusteCategoria;
    }

    private static double calcularAjusteCategoria(String tipoCategoria, double valorBase) {
        double ajusteCategoria = 0;
        if (tipoCategoria.equals("premium")) {
            ajusteCategoria = valorBase * 0.20;
        } else if (tipoCategoria.equals("basica")) {
            ajusteCategoria = -valorBase * 0.05;
        }
        return ajusteCategoria;
    }

    private static double calcularBonificacionStock(int stockActual, double valorBase) {
        double bonificacionStock = 0;
        if (stockActual > 100) {
            bonificacionStock = valorBase * 0.05;
        }
        return bonificacionStock;
    }

    private static double calcularPenalizacionRotacion(int diasDesdeUltimaVenta, double valorBase) {
        double penalizacionRotacion = 0;
        if (diasDesdeUltimaVenta > 60) {
            penalizacionRotacion = valorBase * 0.10;
        }
        return penalizacionRotacion;
    }

    private static double calcularDescuentoAntiguedad(int mesesCatalogo, double valorBase) {
        double descuentoAntiguedad = 0;
        if (mesesCatalogo > 12) {
            descuentoAntiguedad = valorBase * 0.15;
        }
        return descuentoAntiguedad;
    }
}