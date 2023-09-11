package model;

public class Calculator {
    // despues de mi años entendi: la funcion factorial me sirve para saber
    // las posibles maneras de organizar n cantidad de objetos que yo tenga.
    public int factorial(int n){
        if(n == 0 || n == 1) {
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }
}
