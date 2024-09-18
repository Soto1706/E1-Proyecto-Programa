import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Examen1_2_psa extends JFrame implements ActionListener {
    private JButton[] botonesNumeros;
    private JButton[] botonesHexa;
    private JTextField textField, binField, hexField, maqField, decField;
    private JButton BotonClear, BotonMaq;
    private JLabel Label1, Labelbin;

    public static void main(String[] args) {
        Examen1_2_psa cal = new Examen1_2_psa();
        cal.setSize(900, 200);
        cal.createGUI();
        cal.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        Label1 = new JLabel("Ingrese Numero Maquina");
        add(Label1);

        textField = new JTextField(85);
        add(textField);

        Labelbin = new JLabel("Numero Binario");
        add(Labelbin);

        binField = new JTextField(50);
        add(binField);

        botonesNumeros = new JButton[10];
        for (int i = 0; i < 10; i++) {
            botonesNumeros[i] = new JButton(String.valueOf(i));
            add(botonesNumeros[i]);
            botonesNumeros[i].addActionListener(this);
        }

        botonesHexa = new JButton[6];
        char[] hexChars = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i = 0; i < 6; i++) {
            botonesHexa[i] = new JButton(String.valueOf(hexChars[i]));
            add(botonesHexa[i]);
            botonesHexa[i].addActionListener(this);
        }

        BotonClear = new JButton("Clear");
        add(BotonClear);
        BotonClear.addActionListener(this);

        BotonMaq = new JButton("Maq a");
        add(BotonMaq);
        BotonMaq.addActionListener(this);
    }

    private String invertirCadena(String cadena) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < cadena.length(); i += 2) {
            if (i + 1 < cadena.length()) {
                resultado.insert(0, cadena.substring(i, i + 2));
            } else {
                resultado.insert(0, cadena.charAt(i));
            }
        }
        return resultado.toString();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BotonClear) {
            textField.setText("");
        }
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == botonesNumeros[i]) {
                textField.setText(textField.getText() + i);
                return;
            }
        }
        for (int i = 0; i < 6; i++) {
            if (e.getSource() == botonesHexa[i]) {
                textField.setText(textField.getText() + botonesHexa[i].getText());
                return;
            }
        }

        if (e.getSource() == BotonMaq) {
            String maq = textField.getText();
            if (maq.length() == 4) {
                    String num = invertirCadena(maq);
                    int parsedNum = Integer.parseInt(num, 16);
                    String num1 = Integer.toBinaryString(parsedNum);
                    char firstChar = num1.charAt(0);
                    int firstDigit = Character.getNumericValue(firstChar);
                    char signo = (firstDigit == 0) ? '+' : '-';
                    String extractedDigits = num1.substring(1, 6);
                    int dec = Integer.parseInt(extractedDigits, 2);
                    int num2 = Integer.parseInt("F", 16);
                    int exp = dec - num2;
                    String extractedDigits2 = num1.substring(6);
                    String numdec = signo + "1." + extractedDigits2 + " x 2^" + exp;
                    binField.setText(numdec);
            }
            
            else if(maq.length() == 8){
                    String num = invertirCadena(maq);
                    int parsedNum = Integer.parseInt(num, 16);
                    String num1 = Integer.toBinaryString(parsedNum);
                    char firstChar = num1.charAt(0);
                    int firstDigit = Character.getNumericValue(firstChar);
                    char signo = (firstDigit == 0) ? '-' : '+';
                    String extractedDigits = num1.substring(0, 8);
                    int dec = Integer.parseInt(extractedDigits, 2);
                    int num2 = Integer.parseInt("7F", 16);
                    int exp = dec - num2;
                    String extractedDigits2 = num1.substring(8);
                    String numdec = signo + "1." + extractedDigits2 + " x 2^" + exp;
                    binField.setText(numdec);
            }
            else if(maq.length() == 16){
                String num = invertirCadena(maq);
                long parsedNum = Long.parseLong(num, 16);
                String num1 = Long.toBinaryString(parsedNum);
                char firstChar = num1.charAt(0);
                int firstDigit = Character.getNumericValue(firstChar);
                char signo = (firstDigit == 0) ? '-' : '+';
                String extractedDigits = num1.substring(0, 11);
                int dec = Integer.parseInt(extractedDigits, 2);
                int num2 = Integer.parseInt("3FF", 16);
                int exp = dec - num2;
                String extractedDigits2 = num1.substring(11);
                String numdec = signo + "1." + extractedDigits2 + " x 2^" + exp;
                binField.setText(numdec);
            }
        }
    }
}
