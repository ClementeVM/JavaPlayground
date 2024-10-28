package PasswordGenerator;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class password_generator implements ChangeListener {
    public JCheckBox checkMinus;
    private JCheckBox checkCapital;
    private JCheckBox checkNumber;
    private JCheckBox checkSymbol;
    private JButton btnCopy;
    private JButton btnNew;
    private JPanel password_generator;
    private JLabel textLength;
    private JPasswordField passwordText;
    private JProgressBar progressBar1;
    private JSlider slider1;
    private JCheckBox toggleVisibilityPassword;
    private final List<Integer> lowercaseChars;
    private final List<Integer> uppercaseChars;
    private final List<Integer> numberChars;
    private final List<Integer> symbolChars;
    private final List<Integer> characters;
    private final Random random;

    public password_generator() {
        lowercaseChars = IntStream.rangeClosed(97, 122).boxed().collect(Collectors.toList());
        uppercaseChars = IntStream.rangeClosed(65, 90).boxed().collect(Collectors.toList());
        numberChars = IntStream.rangeClosed(48, 57).boxed().collect(Collectors.toList());
        symbolChars = IntStream.concat(
                IntStream.rangeClosed(33, 47),
                IntStream.concat(
                        IntStream.rangeClosed(58, 64),
                        IntStream.rangeClosed(91, 96)
                )
        ).boxed().collect(Collectors.toList());
        characters = new ArrayList<>();
        random = new Random();

        checkMinus.addActionListener(e -> updateCharacterList());
        checkCapital.addActionListener(e -> updateCharacterList());
        checkNumber.addActionListener(e -> updateCharacterList());
        checkSymbol.addActionListener(e -> updateCharacterList());

        btnCopy.addActionListener(e -> {
            String textToCopy = String.valueOf(passwordText.getPassword());
            StringSelection stringSelection = new StringSelection(textToCopy);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            JOptionPane.showMessageDialog(passwordText, "Text copied to clipboard");
        });

        btnNew.addActionListener(e -> {
            int lengthPassword = slider1.getValue();
            String password = generatePassword(lengthPassword);
            passwordText.setText(password);
            updatePasswordStrength(password);
        });

        textLength.setText("Length: " + slider1.getValue());
        slider1.addChangeListener(this);

        toggleVisibilityPassword.addActionListener(e -> {
            if (toggleVisibilityPassword.isSelected()) {
                passwordText.setEchoChar((char) 0); // Show password
            } else {
                passwordText.setEchoChar('*'); // Hide password
            }
        });

        updateCharacterList();
        String initialPassword = generatePassword(slider1.getValue());
        passwordText.setText(initialPassword);
    }

    private void updateCharacterList() {
        characters.clear();
        if (checkMinus.isSelected()) characters.addAll(lowercaseChars);
        if (checkCapital.isSelected()) characters.addAll(uppercaseChars);
        if (checkNumber.isSelected()) characters.addAll(numberChars);
        if (checkSymbol.isSelected()) characters.addAll(symbolChars);
    }

    private void updatePasswordStrength(String password) {
        int strength = calculatePasswordStrength(password);
        progressBar1.setValue(strength);
    }
    private int calculatePasswordStrength(String password) {
        int length = password.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecial = true;
        }

        int varietyScore = (hasLower ? 1 : 0) + (hasUpper ? 1 : 0) + (hasDigit ? 1 : 0) + (hasSpecial ? 1 : 0);

        int lengthScore = Math.min(length * 2, 50);

        int varietyScoreNormalized = varietyScore * 12;

        return Math.min(lengthScore + varietyScoreNormalized, 100);
    }

    public String generatePassword(int length) {
        if (characters.isEmpty()) {
            return "";
        }
        return IntStream.range(0, length)
                .map(i -> characters.get(random.nextInt(characters.size())))
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        textLength.setText("Length: " + slider1.getValue());
        updatePasswordStrength(String.valueOf(passwordText.getPassword()));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Password generator");
        frame.setContentPane(new password_generator().password_generator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}