import java.io.InputStream;
import java.util.stream.IntStream;

public class LambdaInputStream {

    public static void main(String[] args) {

        int[] valores = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};

        //Muestra los valores originales
        System.out.println("Valores Originlaes: ");
        IntStream.of(valores).forEach(valor -> System.out.printf("%d ", valor));
        System.out.println();


        //
        System.out.printf("%n Cuenta: %d%n ", IntStream.of(valores).count());

        System.out.printf("%nMin: %d%n", IntStream.of(valores).min().getAsInt());

        System.out.printf("%nMax: %d%n", IntStream.of(valores).max().getAsInt());

        System.out.printf("%nSuma: %d%n", IntStream.of(valores).sum());

        System.out.printf("%nPromedio: %.2f%n", IntStream.of(valores).average().getAsDouble());

        // Suma de valores con el metodo reduce
        System.out.printf("%nSuma mediante el metodo reduce: %d%n", IntStream.of(valores).reduce(0, (x,y) ->x+y));

        System.out.printf("%nSuma de cuadrados mediante el metodo reduce: %d%n",
                IntStream.of(valores).reduce(0, (x,y) -> x + y * y));

        //Producto de los numeros con el metodo reduce
        System.out.printf("%nProdcuto de los numeros con el metodo reduce: %d%n",
                IntStream.of(valores).reduce(1, (x,y) -> x * y ));

        //Valores pares mostrados en orden
        System.out.printf("%nValores pares mostrados en orden:");
        IntStream.of(valores)
                .filter( valor -> valor % 2 == 0)
                .sorted()
                .forEach(valor -> System.out.printf("%d ", valor));
        System.out.println();

        //Valores impares multiplicados por 10 mostrados en orde
        System.out.printf("%nValores multiplicados por 10 en orden: ");
        IntStream.of(valores)
                .filter(valor -> valor % 2 != 0)
                .map(valor -> valor * 10)
                .sorted()
                .forEach(valor -> System.out.printf("%d ", valor));
       System.out.println();

        //Suma el rango de enteros del 1 al 10, exclusivo
        System.out.printf("%nSuma de enteros de, 1 al 9: %d%n",
                IntStream.range(1, 10).sum());

        //Suma el rango de enteros del 1 al 10, inclusivo
        System.out.printf("%nSuma el rango de enteros del 1 al 10: %d%n",
                IntStream.rangeClosed(1, 10).sum());

        System.out.println();
    }

}
