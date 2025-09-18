package Kurs_2.Pr1;

public class Var15 {
    
    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return "ауоыиэяюёеaeiouy".indexOf(c) != -1;
    }
    
    private static boolean isConsonant(char c) {
        c = Character.toLowerCase(c);
        return (c >= 'а' && c <= 'я' && !isVowel(c)) || 
               (c >= 'a' && c <= 'z' && !isVowel(c));
    }
    
    public static void main(String[] args) {
        String text = "Привет, мир! Это тестовый текст. Hello world! Как дела?";
        
        String[] sentences = text.split("[.!?]+");
        
        System.out.println("Анализ текста:\n" + text + "\n");
        
        for (int i = 0; i < sentences.length; i++) {
            if (sentences[i].trim().isEmpty()) continue;
            
            String sentence = sentences[i].trim();
            int vowels = 0;
            int consonants = 0;
            
            for (char c : sentence.toCharArray()) {
                if (isVowel(c)) vowels++;
                else if (isConsonant(c)) consonants++;
            }
            
            System.out.println("Предложение " + (i + 1) + ": \"" + sentence + "\"");
            System.out.println("Гласных: " + vowels + ", Согласных: " + consonants);
            
            if (vowels > consonants) {
                System.out.println("✓ Гласных больше\n");
            } else if (consonants > vowels) {
                System.out.println("✓ Согласных больше\n");
            } else {
                System.out.println("✓ Равное количество\n");
            }
        }
    }
}