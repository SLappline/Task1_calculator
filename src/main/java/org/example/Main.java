package org.example;

import java.util.Scanner;

/**
 * Created by IBS on 28.07.2023
 * @author S.A.Layko
 * @see #getdouble() 
 * @see #getOperation() 
 * @see #calc(double, double, char) 
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double num1 = getdouble();
        double num2 = getdouble();
        char operation = getOperation();
        double result = calc(num1, num2, operation);
        //Выводим на экран результат с округлением до 4 знаков после запятой.
        System.out.printf("Результат операции: " + "%.4f", result);
    }

    /**
     *
     * @return input two double values
     */
    public static double getdouble(){
//        Запрашиваем ввод двух чисел через консоль.
//        В случае ошибки, вводим повторно.
        System.out.print("Введите дробное число:");
        double num;
        if (scanner.hasNextDouble()){
            num = scanner.nextDouble();
        }
        else {
            System.out.println("Вы неверно ввели число. Попробуйте снова.");
            scanner.next();
            num = getdouble();
        }
        return num; //Возвращаем введенные числа
    }

    /**
     *
     * @return the operation selection
     */
    public static char getOperation(){
        System.out.print("Выберите операцию:");
        char operation;
        if (scanner.hasNext()){
            operation = scanner.next().charAt(0);
        }
        else {
            System.out.println("Вы неверно ввели число. Попробуйте снова.");
            scanner.next();
            operation = getOperation();
        }
        return operation; //Возвращаем введенную операцию
    }

    /**
     *
     * @param num1 input value
     * @param num2 input value
     * @param operation input value
     * @return some double result
     */
    public static double calc(double num1, double num2, char operation){
        double result;
        /*Используем оператор выбора для полученного значения operation
        Если операция отличается от доступных, выводим ошибку с возможностью повторно ввести операцию.*/
        switch (operation) {
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> result = num1 / num2;
            default -> {
                System.out.println("Операция не верна. Попробуйте снова.");
                result = calc(num1, num2, getOperation());
            }
        }
        return result; //Возвращаем результат проведенной операции
    }
}

