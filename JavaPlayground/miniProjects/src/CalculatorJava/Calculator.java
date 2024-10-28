package CalculatorJava;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculator {
    private double Total1 = 0.0 ;
    private double Total2 = 0.0 ;
    private char math_operator;

    private JPanel Calculator;
    private JTextField txtResult;  // Input
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnAC, btnDiv, btnMult, btnRest, btnAdd, btnEQ, btnPoint, btnDel, btnPorcent;

    private void getOperator (String btnText) {
        math_operator = btnText.charAt(0);
        Total1 = Total1 + Double.parseDouble(txtResult.getText());
        txtResult.setText("");
    }

    public Calculator() {
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn1Text = txtResult.getText() + btn1.getText();
                txtResult.setText (btn1Text);
            }
        });
        btn2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            String btn2Text = txtResult.getText() + btn2.getText();
                txtResult.setText (btn2Text);
            }
        });
        btn3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String btn3Text = txtResult.getText() + btn3.getText();
                txtResult.setText (btn3Text);
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn4Text = txtResult.getText() + btn4.getText();
                txtResult.setText (btn4Text);
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn5Text = txtResult.getText() + btn5.getText();
                txtResult.setText (btn5Text);
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn6Text = txtResult.getText() + btn6.getText();
                txtResult.setText (btn6Text);
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn7Text = txtResult.getText() + btn7.getText();
                txtResult.setText (btn7Text);
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn8Text = txtResult.getText() + btn8.getText();
                txtResult.setText (btn8Text);
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn9Text = txtResult.getText() + btn9.getText();
                txtResult.setText (btn9Text);
            }
        });
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btn0Text = txtResult.getText() + btn0.getText();
                txtResult.setText (btn0Text);
            }
        });
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button_text = btnAdd.getText();
                getOperator(button_text);
            }
        });
        btnRest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button_text = btnRest.getText();
                getOperator(button_text);
            }
        });

        btnDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button_text = btnDiv.getText();
                getOperator(button_text);
            }
        });
        btnMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button_text = btnMult.getText();
                getOperator(button_text);
            }
        });
        btnPorcent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button_text = btnPorcent.getText();
                getOperator(button_text);
            }
        });

        btnEQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (math_operator) {
                    case '+':
                        Total2 = Total1 + Double.parseDouble(txtResult.getText());
                        break;
                    case '-':
                        Total2 = Total1 - Double.parseDouble(txtResult.getText());
                        break;
                    case '/':
                        Total2 = Total1 / Double.parseDouble(txtResult.getText());
                        break;
                    case 'X':
                        Total2 = Total1 * Double.parseDouble(txtResult.getText());
                        break;
                    case '%':
                        Total2 = Total1 * (Double.parseDouble(txtResult.getText()) / 100);
                        break;


                }
                txtResult.setText(Double.toString(Total2));
                Total1 = 0;
            }
        });
        btnAC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Total2 = 0;
                txtResult.setText("");
            }
        });
        btnPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtResult.getText().equals("")) {
                    txtResult.setText("0.");
                } else if (txtResult.getText().contains(".")) {
                    btnPoint.setEnabled((false));
                } else {
                    String btnPointText = txtResult.getText() + btnPoint.getText();
                    txtResult.setText(btnPointText);
                }
                btnPoint.setEnabled(true);
            }
        });
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = txtResult.getText();
                    if (!text.isEmpty()) {
                        txtResult.setText(text.substring(0, text.length() - 1));
                    }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().Calculator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
