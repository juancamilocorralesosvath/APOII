package model;

public class StringReverser {


    public String reverse(String string, int n) {

        String helper = "";
        // int n = string.length();

        if (n == 0){
             // helper += Character.toString(string.charAt(n));
            helper += " ";
        } else {
            // por que no me manda por ejemplo un index out of bounds?
            helper += string.charAt(n - 1) + reverse(string, n-1);
        }
        return helper;
    }

    public static void main(String[] args){
        StringReverser s = new StringReverser();
        String prueba = "Abecedario";
        String result = s.reverse(prueba, prueba.length());
        System.out.println(result);
    }
}













