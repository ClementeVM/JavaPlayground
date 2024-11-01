package PasswordGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Password_generatorLogic {
    private final List<Integer> lowercaseChars;
    private final List<Integer> uppercaseChars;
    private final List<Integer> numberChars;
    private final List<Integer> symbolChars;
    private final List<Integer> characters;
    private final Random random;

    public Password_generatorLogic() {
        lowercaseChars = IntStream.rangeClosed(97, 122).boxed().collect(Collectors.toList());
        uppercaseChars = IntStream.rangeClosed(65, 90).boxed().collect(Collectors.toList());
        numberChars = IntStream.rangeClosed(48, 57).boxed().collect(Collectors.toList());
        symbolChars = IntStream.concat(
                IntStream.rangeClosed(33, 47),
                IntStream.concat(IntStream.rangeClosed(58, 64), IntStream.rangeClosed(91, 96))
        ).boxed().collect(Collectors.toList());
        characters = new ArrayList<>();
        random = new Random();
    }

    public void setIncludeLowercase(Boolean include) {
        if (include) characters.addAll(lowercaseChars);
        else characters.removeAll(lowercaseChars);
    }

    public void setIncludeUppercase(Boolean include) {
        if (include) characters.addAll(uppercaseChars);
        else characters.removeAll(uppercaseChars);
    }

    public void setIncludeNumbers(Boolean include) {
        if (include) characters.addAll(numberChars);
        else characters.removeAll(numberChars);
    }

    public void setIncludeSymbols(Boolean include) {
        if (include) characters.addAll(symbolChars);
        else characters.removeAll(symbolChars);
    }

    public String generatePassword(int length) {
        if (length < 4 || length > 24) {
            throw new IllegalArgumentException("Paasword length must be between 4 and 24 characters");
        }
        if (characters.isEmpty()) return "";
        return IntStream.range(0, length)
                .map(i -> characters.get(random.nextInt(characters.size())))
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());
    }

    public int calculatePasswordStrength(String password) {
        int length = password.length();
        boolean hasLower = false, hasUpper = false, hasNumber = false, hasSymbol = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasNumber = true;
            else hasSymbol = true;
        }
        int varietyScore = (hasLower ? 1 : 0) + (hasUpper ? 1 : 0) + (hasNumber ? 1 : 0) + (hasSymbol ? 1 : 0);
        int lengthScore = Math.min(length * 2, 50);
        int varietyScoreNormalized = varietyScore * 12;

        return Math.min(lengthScore + varietyScoreNormalized, 100);
    }
}
