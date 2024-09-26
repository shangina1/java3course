import java.util.Scanner;

public class Calculator1309
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String operation;
        System.out.println("Калькулятор");
        System.out.println("Операции: +, -, *, /, log, ln, sin, cos");
        System.out.println("Введите выражение или 'exit' для выхода:");
        while (true)
        {
            System.out.print("> ");
            operation = scanner.nextLine();
            if (operation.equalsIgnoreCase("exit"))
            {
                System.out.println("Выход из программы.");
                break;
            }
            try
            {
                double result = calculate(operation);
                System.out.println("Ответ: " + result);
            }
            catch (Exception e)
            {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
        scanner.close();
    }
    private static double calculate(String operation)
    {
        String[] parts = operation.split(" ");
        if (parts.length == 3)
        {
            double num1 = Double.parseDouble(parts[0]);
            String op = parts[1];
            double num2 = Double.parseDouble(parts[2]);
            switch (op)
            {
                case "+":
                    return num1 + num2;
                case "-":
                    return num1 - num2;
                case "*":
                    return num1 * num2;
                case "/":
                    if (num2 == 0) throw new ArithmeticException("Деление на ноль невозможно");
                    return num1 / num2;
                default:
                    throw new UnsupportedOperationException("Операция невозможна: " + op);
            }
        }
        else if (parts.length == 2)
        {
            double num = Double.parseDouble(parts[1]);
            return switch (parts[0])
            {
                case "log" -> Math.log10(num);
                case "ln" -> Math.log(num);
                case "sin" -> Math.sin(Math.toRadians(num));
                case "cos" -> Math.cos(Math.toRadians(num));
                default -> throw new UnsupportedOperationException("Недоступная операция: " + parts[0]);
            };
        }
        else
        {
            throw new IllegalArgumentException("Неверный формат выражения");
        }
    }
}