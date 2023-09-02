public class DivisionSinRecursividad {

    public int division(int dividendo, int divisor){
        int c = 0;
        while (dividendo > divisor) {
            dividendo = dividendo - divisor;
            c = c + 1;
        }
        System.out.println("cociente: " + c);
        System.out.println("residuo: "+ dividendo);
        return divisor * c + dividendo;
    }

    public static void main(String[] args){
        DivisionSinRecursividad division = new DivisionSinRecursividad();

        int dividendo = 35;
        int divisor = 8;
        int result = division.division(dividendo, divisor);
        if(result == dividendo){
            System.out.println("quedo bien");
        }else {
            System.out.println("quedo malo");
        }
    }
}
