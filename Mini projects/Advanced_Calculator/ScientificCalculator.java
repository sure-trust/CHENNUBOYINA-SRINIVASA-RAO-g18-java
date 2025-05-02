import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.BigInteger;

public class ScientificCalculator extends JFrame implements ActionListener {

    JTextField inputDisplay, resultDisplay;
    String expression = "";
    String lastAnswer = "";
    DecimalFormat df = new DecimalFormat("0.######");

    ScientificCalculator() {
        setTitle("Scientific Calculator");
        setSize(480, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.DARK_GRAY);

        // Display Panel
        JPanel displayPanel = new JPanel(new GridLayout(2, 1));
        displayPanel.setBackground(Color.BLACK);

        inputDisplay = new JTextField();
        inputDisplay.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
        inputDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
        inputDisplay.setEditable(false);
        inputDisplay.setBackground(Color.BLACK);
        inputDisplay.setForeground(Color.LIGHT_GRAY);
        displayPanel.add(inputDisplay);

        resultDisplay = new JTextField();
        resultDisplay.setFont(new Font("Segoe UI Symbol", Font.BOLD, 30));
        resultDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
        resultDisplay.setEditable(false);
        resultDisplay.setBackground(Color.BLACK);
        resultDisplay.setForeground(Color.WHITE);
        displayPanel.add(resultDisplay);

        add(displayPanel, BorderLayout.NORTH);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new GridLayout(9, 4, 8, 8));
        buttonPanel.setBackground(Color.DARK_GRAY);

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "sin", "cos", "tan", "log",
                "ln", "√", "x^y", "x!",
                "e^x", "1/x", "C", "DEL",
                "Fraction", "∛", "%", "π",
                "+/-", "Ans"
        };

        for (String label : buttons) {
            JButton button = new JButton(label);
            button.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
            button.setFocusPainted(false);
            button.setBackground(new Color(60, 63, 65));
            button.setForeground(Color.WHITE);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        try {
            switch (cmd) {
                case "C":
                    inputDisplay.setText("");
                    resultDisplay.setText("");
                    expression = "";
                    break;

                case "DEL":
                    if (!expression.isEmpty()) {
                        expression = expression.substring(0, expression.length() - 1);
                        inputDisplay.setText(expression);
                    }
                    break;

                case "=":
                    double result = evaluate(expression);
                    resultDisplay.setText(df.format(result));
                    lastAnswer = df.format(result);
                    expression = lastAnswer;
                    break;

                case "Fraction":
                    double val = Double.parseDouble(resultDisplay.getText());
                    String fraction = toFraction(val);
                    resultDisplay.setText(fraction);
                    break;

                case "sin": case "cos": case "tan": case "log":
                case "ln": case "√": case "x!": case "e^x":
                case "1/x": case "∛":
                    applyFunction(cmd);
                    break;

                case "x^y":
                    expression += "^";
                    inputDisplay.setText(expression);
                    break;

                case "%":
                    expression += "%";
                    inputDisplay.setText(expression);
                    break;

                case "π":
                    expression += Math.PI;
                    inputDisplay.setText(expression);
                    break;

                case "+/-":
                    if (!expression.isEmpty()) {
                        if (expression.startsWith("-")) {
                            expression = expression.substring(1);
                        } else {
                            expression = "-" + expression;
                        }
                        inputDisplay.setText(expression);
                    }
                    break;

                case "Ans":
                    expression += lastAnswer;
                    inputDisplay.setText(expression);
                    break;

                default:
                    expression += cmd;
                    inputDisplay.setText(expression);
                    break;
            }
        } catch (Exception ex) {
            resultDisplay.setText("Error");
        }
    }

    private double evaluate(String expr) {
        expr = expr.replace("^", "**");
        expr = expr.replace("%", "*0.01");

        if (expr.contains("+")) {
            String[] parts = expr.split("\\+");
            return Double.parseDouble(parts[0]) + Double.parseDouble(parts[1]);
        } else if (expr.contains("-")) {
            String[] parts = expr.split("(?<=\\d)-");
            if (parts.length == 2)
                return Double.parseDouble(parts[0]) - Double.parseDouble(parts[1]);
        } else if (expr.contains("*")) {
            String[] parts = expr.split("\\*");
            return Double.parseDouble(parts[0]) * Double.parseDouble(parts[1]);
        } else if (expr.contains("/")) {
            String[] parts = expr.split("/");
            return Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
        } else if (expr.contains("**")) {
            String[] parts = expr.split("\\*\\*");
            return Math.pow(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
        }

        return Double.parseDouble(expr);
    }

    private void applyFunction(String func) {
        double val;

        try {
            if (!expression.isEmpty()) {
                val = evaluate(expression);
            } else if (!resultDisplay.getText().isEmpty()) {
                val = Double.parseDouble(resultDisplay.getText());
            } else {
                return;
            }
        } catch (Exception e) {
            return;
        }

        double res = 0;
        try {
            switch (func) {
                case "sin": res = Math.sin(Math.toRadians(val)); break;
                case "cos": res = Math.cos(Math.toRadians(val)); break;
                case "tan": res = Math.tan(Math.toRadians(val)); break;
                case "log": res = Math.log10(val); break;
                case "ln": res = Math.log(val); break;
                case "√": res = Math.sqrt(val); break;
                case "∛": res = Math.cbrt(val); break;
                case "x!":
                    if (val < 0 || val != (int) val) return;
                    res = factorial((int) val); break;
                case "e^x": res = Math.exp(val); break;
                case "1/x":
                    if (val == 0) return;
                    res = 1 / val;
                    break;
            }

            resultDisplay.setText(df.format(res));
            expression = df.format(res);
            inputDisplay.setText(func + " " + df.format(val));
        } catch (Exception e) {
            resultDisplay.setText("Error");
        }
    }

    private double factorial(int n) {
        if (n < 0) return Double.NaN;
        double fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        return fact;
    }

    private String toFraction(double value) {
        BigDecimal bigDecimal = new BigDecimal(value);
        BigInteger numerator = bigDecimal.unscaledValue();
        int scale = bigDecimal.scale();
        BigInteger denominator = BigInteger.TEN.pow(scale);

        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);

        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ScientificCalculator::new);
    }
}
