public class DivisionConRecursividad {

    //LAUDETUR IESUS CHRISTUS!
    // mostrarle al profesor.
    public ResultadoDivisionRecursividad division(int dividendo, int divisor, int cociente){
        ResultadoDivisionRecursividad result;

        // mi caso base es una vez que ya no pueda continuar con la resta
        //
        if(divisor > dividendo){
            result = new ResultadoDivisionRecursividad(cociente, dividendo);
        }else {
            dividendo = dividendo - divisor;
            cociente++;
            result = division(dividendo, divisor, cociente);
        }
        return result;
    }

    public static void main(String[] args){

        DivisionConRecursividad division = new DivisionConRecursividad();

        int dividendo = 35;
        int divisor = 8;

        ResultadoDivisionRecursividad result = division.division(dividendo, divisor, 0) ;
        System.out.println("cociente: " + result.getCociente() + " residuo: " + result.getResiduo());
        System.out.println(60 % 48);
        System.out.println(48 % 12);
    }
}
