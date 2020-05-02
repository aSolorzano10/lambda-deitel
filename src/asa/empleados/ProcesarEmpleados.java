package asa.empleados;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProcesarEmpleados {

    public static void main(String[] args)
    {
        Empleado[] empleados ={
                new Empleado("Jason", "Red", 5000, "TI"),
                new Empleado("Ashley", "Green", 7600, "TI"),
                new Empleado("Matthew", "Indigo", 3587.5, "Ventas"),
                new Empleado("James", "Indiog", 4700.77, "Marketing"),
                new Empleado("Luke", "Indigo", 6200, "TI"),
                new Empleado("Jason", "Blue", 3200, "Ventas"),
                new Empleado("Wendy", "Brown", 4236.4, "Markeitng")
        };

        //obtiene vista List de los objetos Empleados
        List<Empleado> lista = Arrays.asList(empleados);

        //muestra todos los objetos Empleado
        System.out.println("Lista completa de empleados:");
        lista.stream().forEach(System.out :: println);

        //Predicado que devuelve true para salario con el ranfo $4000 - $6000
        Predicate<Empleado> cuatroSeisMil = e -> (e.obtenerSalario() >= 4000 && e.obtenerSalario() <= 6000);

        //Muestra los empelados con salarios en el rango $4000 - $6000
        //en roden ascendente por salario
        System.out.printf("%nEmpleados que ganan $4000 - $6000 mensauales ordenados por salario: %n");
        lista.stream()
                .filter(cuatroSeisMil)
                .sorted(Comparator.comparing(Empleado :: obtenerSalario))
        .forEach(System.out::println);

        //Muestra el primer empleado con salario en el rango $4000 - $6000
        System.out.printf("%nPrimer Empleado que gana $4000 - $6000:%n%s%n",
            lista.stream()
                    .filter(cuatroSeisMil)
                .findFirst()
                .get());

        //Funciones para obtener el primer nombre y apellido de un empleado
        Function<Empleado, String> porPrimerNombre = Empleado::obtenerPrimerNombre;
        Function<Empleado, String> porApellidoPaterno = Empleado::obtenerApellidoPaterno;

        //Comparator para comparar empleados por primer nombre y luego por apellido paterno
        Comparator<Empleado> apellidoLuegoNombre = Comparator.comparing(porApellidoPaterno).thenComparing(porPrimerNombre);

        //Ordena empelados por apellido paterno y luego por primer nombre
        System.out.printf("%nEmpleados en orden ascendente por apellido y luego por nombre:%n");
        lista.stream().sorted(apellidoLuegoNombre).forEach(System.out :: println);

        //Ordena Empleados en forma descendente por apellido, luego por nombre
        System.out.printf("%nEmpelados en orden descendente por apellido y luego por nombre:%n");
        lista.stream().sorted(apellidoLuegoNombre.reversed()).forEach(System.out :: println);

        //Muestra apellidos de empleados únicos ordenados
        System.out.printf("%nApellidos de Empleados únicos:%n");
        lista.stream().map(Empleado::obtenerApellidoPaterno).distinct().sorted().forEach(System.out :: println);

        //Muestra solo el nombre y apellido
        System.out.printf("%nNombres de empleados en orden por apellido y luego por nombre:%n");
        lista.stream().sorted(apellidoLuegoNombre).map(Empleado::obtenerNombre).forEach(System.out :: println);

        //Suma de salarios de empleados con el método sum de DoubleStream
        System.out.printf("%nSuma de los salarios de los empleados (mediante el metodo sum): %.2f%n",
                lista.stream().mapToDouble(Empleado::obtenerSalario).sum());

        //Calcula la suma de los salarios de los empleados con el mètodo reduce de Stream
        System.out.printf("Suma de los alarios de los empleados (mediante el metodo reduce): %.2f%n",
                lista.stream().mapToDouble(Empleado::obtenerSalario).reduce(0, (valor1, valor2) -> valor1 + valor2));

        //Promedio de salarios de empleado en el método average de DoubleStream
        System.out.printf("Promedio de los salarios de los empleados: %.2f%n",
                lista.stream().mapToDouble(Empleado::obtenerSalario).average().getAsDouble());
    }
}
