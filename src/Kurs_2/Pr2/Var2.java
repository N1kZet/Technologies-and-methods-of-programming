package Kurs_2.Pr2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Var2 {
    private static final Pattern GUID_PATTERN = Pattern.compile(
            "^(?:\\{[0-9a-fA-F]{8}(?:-[0-9a-fA-F]{4}){3}-[0-9a-fA-F]{12}\\}|[0-9a-fA-F]{8}(?:-[0-9a-fA-F]{4}){3}-[0-9a-fA-F]{12})$"
    );

    public static boolean isGuid(String s) {
        if (s == null) return false;
        return GUID_PATTERN.matcher(s).matches();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        boolean anyInput = false;
        while ((line = reader.readLine()) != null) {
            anyInput = true;
            boolean ok = isGuid(line.trim());
            System.out.println(ok);
        }
        if (!anyInput) {
            // Пример использования:
            String[] examples = new String[] {
                "{550e8400-e29b-41d4-a716-446655440000}", // true
                "550e8400-e29b-41d4-a716-446655440000",   // true
                "{550e8400-e29b-41d4-a716-44665544000}",  // false (11 в конце)
                "550e8400e29b-41d4-a716-446655440000",    // false (нет первой -)
                "{550e8400-e29b-41d4-a716-446655440000"    // false (нет закрывающей скобки)
            };
            for (String s : examples) {
                System.out.printf("%s -> %s%n", s, isGuid(s));
            }
        }
    }
}


