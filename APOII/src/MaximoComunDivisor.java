public class MaximoComunDivisor {
    public int euclidesCrack(int a, int b){
        int result = 0;
        // caso base es cuando llego a un residuo cero:
        if(b == 0){
            result = a;
        } // si no he llegado al caso base, quiere decir que
        // tengo que avanzar mediante el calculo del modulo:
        else{
            result = euclidesCrack(b, a % b);
        }
        return result;
    }
    public static void main(String[] args){
        MaximoComunDivisor mcd = new MaximoComunDivisor();
        System.out.println(mcd.euclidesCrack(60, 48));
    }
}
// LAUDETUR IESUS CHRISTUS!