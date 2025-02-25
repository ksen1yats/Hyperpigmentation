package ru.krista.example;
import java.util.Scanner;

public class Calculator{
    public static void main(String[] args){
        Calculator calc = new Calculator();
        calc.readInput();
        calc.calculate();
        calc.printResult();
    }
}