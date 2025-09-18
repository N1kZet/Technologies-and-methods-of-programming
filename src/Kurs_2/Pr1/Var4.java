package Kurs_2.Pr1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Var4 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Введите k (1-based): ");
        String kLine = reader.readLine();
        if (kLine == null || kLine.trim().isEmpty()) {
            System.out.println("k не задано");
            return;
        }
        int k;
        try {
            k = Integer.parseInt(kLine.trim());
        } catch (NumberFormatException e) {
            System.out.println("Некорректное k");
            return;
        }
        if (k <= 0) {
            System.out.println("k должно быть положительным");
            return;
        }

        System.out.print("Введите символ замены: ");
        String symLine = reader.readLine();
        if (symLine == null || symLine.isEmpty()) {
            System.out.println("Символ замены не задан");
            return;
        }
        char replacement = symLine.charAt(0);

        System.out.println("Введите текст (несколько строк). Завершите ввод EOF (Ctrl+D):");
        StringBuilder textBuilder = new StringBuilder();
        String line;
        boolean any = false;
        while ((line = reader.readLine()) != null) {
            any = true;
            textBuilder.append(line).append('\n');
        }
        if (!any) {
            System.out.println("Текст не задан");
            return;
        }
        String text = textBuilder.toString();

        // Match words consisting of letters (supports Unicode letters, e.g., Russian and English)
        Pattern wordPattern = Pattern.compile("[\\p{L}]+", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = wordPattern.matcher(text);

        StringBuilder result = new StringBuilder(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String word = text.substring(start, end);
            if (word.length() >= k) {
                // Replace k-th letter (1-based) within the overall string builder
                result.setCharAt(start + (k - 1), replacement);
            }
        }

        System.out.print(result.toString());
    }
}


