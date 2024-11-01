package PasswordGenerator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class Password_generatorTest {
    private Password_generatorLogic passwordGenerator;

    @BeforeEach
    public void setup() {
        passwordGenerator = new Password_generatorLogic();
    }

    @Test
    public void lowercaseAndLengthOfTen() {
        passwordGenerator.setIncludeLowercase(true);
        passwordGenerator.setIncludeUppercase(false);
        passwordGenerator.setIncludeNumbers(false);
        passwordGenerator.setIncludeSymbols(false);

        String password = passwordGenerator.generatePassword(10);
        assertTrue(password.chars().allMatch(Character::isLowerCase));
    }

    @Test
    public void uppercaseAndLengthOfTwenty() {
        passwordGenerator.setIncludeLowercase(false);
        passwordGenerator.setIncludeUppercase(true);
        passwordGenerator.setIncludeNumbers(false);
        passwordGenerator.setIncludeSymbols(false);

        String password = passwordGenerator.generatePassword(20);
        assertTrue(password.chars().allMatch(Character::isUpperCase));
    }

    @Test
    public void numberAndLengthOfFour() {
        passwordGenerator.setIncludeLowercase(false);
        passwordGenerator.setIncludeUppercase(false);
        passwordGenerator.setIncludeNumbers(true);
        passwordGenerator.setIncludeSymbols(false);

        String password = passwordGenerator.generatePassword(4);
        assertTrue(password.chars().allMatch(Character::isDigit));
    }

    @Test
    public void symbolAndLengthOfSix() {
        passwordGenerator.setIncludeLowercase(false);
        passwordGenerator.setIncludeUppercase(false);
        passwordGenerator.setIncludeNumbers(false);
        passwordGenerator.setIncludeSymbols(true);

        String password = passwordGenerator.generatePassword(6);
        assertTrue(password.chars().noneMatch(Character::isLetterOrDigit));
    }

    @Test
    public void allCharactersAndTwentyFourLength() {
        passwordGenerator.setIncludeLowercase(true);
        passwordGenerator.setIncludeUppercase(true);
        passwordGenerator.setIncludeNumbers(true);
        passwordGenerator.setIncludeSymbols(true);

        String password = passwordGenerator.generatePassword(24);
        assertTrue(password.chars().anyMatch(Character::isLowerCase));
        assertTrue(password.chars().anyMatch(Character::isUpperCase));
        assertTrue(password.chars().anyMatch(Character::isDigit));
        assertTrue(password.chars().anyMatch( ch -> !Character.isLetterOrDigit(ch)));
    }

    @Test
    public void testTogglePasswordVisibility() {
        assertFalse(passwordGenerator.isPasswordVisible());

        passwordGenerator.togglePasswordVisibility();
        assertTrue(passwordGenerator.isPasswordVisible());

        passwordGenerator.togglePasswordVisibility();
        assertFalse(passwordGenerator.isPasswordVisible());
    }

}
