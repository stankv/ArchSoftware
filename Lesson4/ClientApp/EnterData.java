package Lesson4.ClientApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Абстрактный класс валидации вводимых данных
 */
public abstract class EnterData {
    /**
     * Метод ввода и проверки целого числа в заданном диапазоне
     *
     * @param min минимальное число
     * @param max максимальное число
     * @return введенное целое число
     * @throws RuntimeException
     */
    protected int inputInt(int min, int max) throws RuntimeException {
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException ex) {
            throw new RuntimeException("Введено не число!");
        } catch (Exception ex) {
            throw new RuntimeException("Ошибка ввода!");
        }
        if (number < min || number > max) {
            throw new RuntimeException("Введенное число вне допустимого диапазона!");
        }
        
        return number;
    }

    /**
     * Метод ввода и проверки  большого целого числа в заданном диапазоне
     *
     * @param min минимальное число
     * @param max максимальное число
     * @return введенное целое число
     * @throws RuntimeException
     */
    protected long inputLong(long min, long max) throws RuntimeException {
        long number = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            number = scanner.nextLong();
        } catch (InputMismatchException ex) {
            throw new RuntimeException("Введено не число!");
        } catch (Exception ex) {
            throw new RuntimeException("Ошибка ввода данных!");
        }
        if (number < min || number > max) {
            throw new RuntimeException("Введенное число вне допустимого диапазона!");
        }
        return number;
    }

    /**
     * Метод ввода строки и ее проверка на корректность
     *
     * @return String
     */
    protected String inputString() throws RuntimeException {
        Scanner scanner = new Scanner(System.in);
        String textLine;
        try {
            textLine = scanner.next();
        } catch (Exception ex) {
            throw new RuntimeException("Ошибка ввода данных!");
        }
        if (textLine.isEmpty()) {
            throw new RuntimeException("Не были введены данные!");
        }
        return textLine;
    }

    /**
     * Meтод ввода даты и ее проверки на корректность
     *
     * @return дата
     * @throws RuntimeException
     */
    protected Date inputDate() throws RuntimeException {
        SimpleDateFormat formattedText = new SimpleDateFormat("dd-MM-yyyy");
        Scanner scanner = new Scanner(System.in);
        String textDate;
        Date date;
        try {
            textDate = scanner.nextLine();
        } catch (Exception ex) {
            throw new RuntimeException("Ошибка ввода данных!");
        }
        if (textDate.isEmpty()) {
            throw new RuntimeException("Не были введены данные!");
        }
        try {
            date = formattedText.parse(textDate);
        } catch (ParseException ex) {
            throw new RuntimeException("Введенные данные не являются датой!");
        }
        
        return date;
    }
}
