import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator{
    private static final Random RANDOM = new SecureRandom();
    private static final Random randChar = new Random();
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+<>?";

    public static String generatePassword(int length) {
        if (length < 8) {
            System.out.println("Password length should be at least 8 characters.");
            return null;
        }
        int randomNumber;
        StringBuilder password = new StringBuilder(length);
        
        for (int i = 0; i < length; i++) {
            randomNumber = randChar.nextInt(4);
            if(randomNumber == 0){
                password.append(UPPERCASE_CHARACTERS.charAt(RANDOM.nextInt(UPPERCASE_CHARACTERS.length())));
            }
            else if(randomNumber == 1){
                password.append(LOWERCASE_CHARACTERS.charAt(RANDOM.nextInt(LOWERCASE_CHARACTERS.length())));
            }
            else if(randomNumber == 3){
                password.append(NUMBERS.charAt(RANDOM.nextInt(NUMBERS.length())));
            }
            else{
            password.append(SPECIAL_CHARACTERS.charAt(RANDOM.nextInt(SPECIAL_CHARACTERS.length())));
            }
        }
        
        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(generatePassword(12));
    }
}