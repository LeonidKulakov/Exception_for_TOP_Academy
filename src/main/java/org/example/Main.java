package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 1) Рассказать про иерархию исключений
 * 2) Перечислить все варианты try/catch/finally
 * 3) Показать когда не выполняется finally
 */
public class Main {
    public static void main(String[] args) {
        testFinallyExceptionMethod();

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введи что-то");
            int i = scanner.nextInt();
            System.out.println(i);
        } catch (NoSuchElementException e) {
            System.out.println("Сканер был закрыт и не откроется");
        }

        testExceptionMethod();

        System.exit(0);
        throw new Error();
    }

    static void testExceptionMethod() {
        try {
            throw new Exception();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Файл не найден");
        } catch (IOException e) {
            throw new RuntimeException("Искобчение ввода вывода");
        } catch (NullPointerException e) {
            throw new RuntimeException("Null");
        } catch (RuntimeException e) {
            throw new RuntimeException("Ошибка в рантайме");
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка доступа к базе данных");
        } catch (Exception e) {
            throw new RuntimeException("Ошибка");
        }
    }

    static void testFinallyExceptionMethod() {
        try {
            throw new Exception();
        } catch (Exception e) {
            // throw new RuntimeException("Выброс исключения");
        } finally {
            System.out.println("А я работаю");
            System.out.println(testTWR());
        }
    }


    static String testTWR() {
        try (Scanner scanner = new Scanner(System.in)) {
            testThrows();
            return "Все отработало хорошо";
        } catch (NullPointerException e) {
            return "Null обнаружен";
        }
    }

    static void testThrows() throws NullPointerException {
        throw new NullPointerException();
    }

}