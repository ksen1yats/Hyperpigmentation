package ru.krista.example;
import java.util.Scanner;

public class Calculator{
    //Поля класса для хранения входных данныхи результата
    private int firstNum;
    private int secondNum;
    private char operation;
    private int result;

    /*считывает выражение с консоли.
     * Ожидается формат: число пробел операция пробел число (например: 1 + 3)
     */
    public void readInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение (Например: 1 + 3):");
        String input = scanner.nextLine();
        //Разбиваем строку по пробелам 
        String[] tokens = input.trim().split("\\s+");
        if (tokens.length !=3){
            System.out.println("Ошибка: неверный формат ввода.");
            System.exit(1);
        }
        try{
            firstNum = Integer.parseInt(tokens[0]);
            //первый символ строки с операцией
            operation = tokens[1].charAt(0);
            secondNum = Integer.parseInt(tokens[2]);
        }
        catch(NumberFormatException e){
        System.out.println("Ошибка: числа должны быть целыми.");
        System.exit(1);
    } 
}
 /* Выполняет расчет в зависимости от выбранной операции. */
    public void calculate() {
        switch (operation) {
            case '+':
                result = firstNum + secondNum;
                break;
            case '-':
                result = firstNum - secondNum;
                break;
            case '*':
                result = firstNum * secondNum;
                break;
            case '/':
                if (secondNum == 0) {
                    throw new ArithmeticException("Ошибка: деление на ноль невозможно.");
                }
                result = firstNum / secondNum;
                break;
            default:
                System.out.println("Ошибка: недопустимая операция.");
                System.exit(1);
        }
    }

    /* Выводит результат вычисления на консоль. */
    public void printResult() {
        System.out.println(result);
    }

    /* Метод main для запуска программы.*/
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.readInput();
        calc.calculate();
        calc.printResult();
    }
}