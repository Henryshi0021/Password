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
    public static String checkPassword(String userPassword){
        if(userPassword.length()<8){
            return "Password too short";
        }
        if(userPassword.length()>16){
            return "Password too long";
        }
        int numCount = 0;
        int uppercaseCount = 0;
        int lowercaseCount = 0;
        int specialCount = 0;
        for(int i =0; i<userPassword.length(); i++){
            if(UPPERCASE_CHARACTERS.indexOf(userPassword.charAt(i))==-1){
                uppercaseCount++;
            }
            else if(LOWERCASE_CHARACTERS.indexOf(userPassword.charAt(i))==-1){
                lowercaseCount++;
            }
            else if(NUMBERS.indexOf(userPassword.charAt(i))==-1){
                numCount++;
            }
            else if(SPECIAL_CHARACTERS.indexOf(userPassword.charAt(i))==-1){
                specialCount++;
            }
        }
        if(specialCount<1){
            return "Needs special characters";
        }
        if(numCount<1){
            return "Needs numbers";
        }
        if(lowercaseCount<1){
            return "Needs lowercase characters";
        }
        if(uppercaseCount<1){
            return "Needs uppercase characters";
        }
        return "Strong Password";
    }
    public static boolean checkInput(String userInput){
        if(userInput == "Y" || userInput == "Yes" || userInput == "y" || userInput == "yes"){
            System.out.println(generatePassword(12));
            return true;
        }
        else if(userInput == "N" || userInput == "No" || userInput == "n" || userInput == "no"){
            System.out.println("Thank you, have a great day!");
            return true;
        }
        System.out.println("Could not understand input, please try again");
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a password: ");
        String userPassword = scanner.nextLine();
        System.out.println(checkPassword(userPassword));
        System.out.println("Would you like a new password? (Y/N)");
        String userInput = scanner.nextLine();
        if(!checkInput(userInput)){

        }
        scanner.close();
    }
}