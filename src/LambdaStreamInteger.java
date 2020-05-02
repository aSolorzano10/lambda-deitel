import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LambdaStreamInteger {

    public static  void main(String[] args)
    {
        Integer[] valores= {2, 9, 5, 0, 3, 7, 1, 4, 8, 6};

        //Muestra los valores originales
        System.out.printf("Valores originales: %s%n",
                Arrays.asList(valores));

        //Ordena los valores en forma ascendentecon flujos.
        System.out.printf("Valores ordenados: %s%n",
                Arrays.stream(valores).sorted().collect(Collectors.toList()));

        //Valores mayores que 4
        List<Integer> mayorQue4 = Arrays.stream(valores)
                .filter(value -> value > 4).collect(Collectors.toList());

        //Filtra los valors mayores que cuatro y luego ordena los resultados
        System.out.printf("valores ordenados mayores que 4: %s%n",
                Arrays.stream(valores).
                        filter(value -> value > 4).sorted().collect(Collectors.toList()));


        //Objeto List mayorQue4 ordenado con flujos
        System.out.printf("Valores mayores que 4 (ascendente con flujos): %s%n",
                mayorQue4.stream().sorted().collect(Collectors.toList()));


    }
}
