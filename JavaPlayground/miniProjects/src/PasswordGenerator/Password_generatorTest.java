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
    public void LowercaseAndLengthOfTen() {
        passwordGenerator.setIncludeLowercase(true);
        passwordGenerator.setIncludeUppercase(false);
        passwordGenerator.setIncludeNumbers(false);
        passwordGenerator.setIncludeSymbols(false);

        String password = passwordGenerator.generatePassword(10);
        assertTrue(password.chars().allMatch(Character::isLowerCase));
    }

    @Test
    public void UppercaseAndLengthOfTwenty() {
        passwordGenerator.setIncludeLowercase(false);
        passwordGenerator.setIncludeUppercase(true);
        passwordGenerator.setIncludeNumbers(false);
        passwordGenerator.setIncludeSymbols(false);

        String password = passwordGenerator.generatePassword(20);
        assertTrue(password.chars().allMatch(Character::isUpperCase));
    }

    @Test
    public void NumberAndLengthOfFour() {
        passwordGenerator.setIncludeLowercase(false);
        passwordGenerator.setIncludeUppercase(false);
        passwordGenerator.setIncludeNumbers(true);
        passwordGenerator.setIncludeSymbols(false);

        String password = passwordGenerator.generatePassword(4);
        assertTrue(password.chars().allMatch(Character::isDigit));
    }

    @Test
    public void SymbolAndLengthOfSix() {
        passwordGenerator.setIncludeLowercase(false);
        passwordGenerator.setIncludeUppercase(false);
        passwordGenerator.setIncludeNumbers(false);
        passwordGenerator.setIncludeSymbols(true);

        String password = passwordGenerator.generatePassword(6);
        assertTrue(password.chars().noneMatch(Character::isLetterOrDigit));
    }




}
