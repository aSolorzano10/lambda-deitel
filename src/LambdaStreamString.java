import java.util.Arrays;
import java.util.stream.Collectors;

public class LambdaStreamString {

    public  static void main(String[] args){

        String[] cadenas = {"Rojo", "naranja", "Amarillo", "verde", "Azul", "indigo", "Violet"};

        //Muestra las cadenas originales
        System.out.printf("Cadenas originales: %s%n",
                Arrays.asList(cadenas));

        //Cadenas en Mayusculas
        System.out.printf("Cadenas en mayusculas: %s%n ",
                Arrays.stream(cadenas).map(String::toUpperCase)
                .collect(Collectors.toList()));

        //Cadenas mayores que "m" (sin suceptibilidad al uso de mayúsculas/Minúsculas)
        //en orden ascendente
        System.out.printf("Cadenas mayores que m en orden ascendente: %s%n",
                Arrays.stream(cadenas)
                        .filter(s -> s.compareToIgnoreCase("m") > 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER)
                        .collect(Collectors.toList()));

        //Cadenas mayores que "m" (sin suceptibilidad al uso de mayúsculas/Minúsculas)
        //en orden descendente
        System.out.printf("Cadenas mayores que m en orden descendente: %s%n",
                Arrays.stream(cadenas).filter(s -> s.compareToIgnoreCase("m") > 0)
                        .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                        .collect(Collectors.toList()));

    }
}
