package asa.empleados;

public class Empleado {
    private String primerNombre;
    private String apellidoPaterno;
    private double salario;
    private String departamento;

    //Constructor
    public Empleado(String primerNombre, String apellidoPaterno, double salario,
                    String departamento){
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.salario = salario;
        this.departamento = departamento;
    }

    //Establece Nombre
    public void establecerPrimerNombre(String primerNombre){
        this.primerNombre = primerNombre;
    }

    //Obtiene primer nombre
    public String obtenerPrimerNombre(){
        return primerNombre;
    }

    //Establece primer apellido
    public void establecerApellidoPaterno(String apellidoPaterno){
        this.apellidoPaterno = apellidoPaterno;
    }

    //Obtiene apellido paterno
    public String obtenerApellidoPaterno()
    {
        return apellidoPaterno;
    }

    //Establece salario
    public void establecerSalario(double salario){
        this.salario = salario;
    }

    //obtiene salario
    public double obtenerSalario()
    {
        return salario;
    }

    //Establece departamento
    public void establecerDepartamento(String departamento)
    {
        this.departamento = departamento;
    }

    //obtiene departamento
    public String obtenerDepartamento()
    {
        return departamento;
    }

    //devuelve primer nombre y apellido
    public String obtenerNombre()
    {
        return String.format("%s %s", obtenerPrimerNombre(), obtenerApellidoPaterno());
    }

    //devuelve primer objeto String que contiene la informaciòn del Empleado
    @Override
    public String toString()
    {
        return String.format("%-8s %-8s %8.2f  %s",
                obtenerPrimerNombre(),
                obtenerApellidoPaterno(),
                obtenerSalario(),
                obtenerDepartamento());
    }
}
