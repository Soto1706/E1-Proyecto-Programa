import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Examen_1_psa extends JFrame implements ActionListener {
    private JButton[] botonesNumeros;
    private JButton[] botonesHexa;
    private JTextField textField, binField, hexField, maqField, decField;
    private JButton BotonClear, BotonDec, BotonBin, BotonHex, BotonMaq;
    private JLabel Label1, Labeldec, Labelbin, Labelhex, Labelmaq;

    public static void main(String[] args) {
        Examen_1_psa cal = new Examen_1_psa();
        cal.setSize(250, 450);
        cal.createGUI();
        cal.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        Label1 = new JLabel("Ingrese su numero");
        add(Label1);

        textField = new JTextField(20);
        add(textField);

        Labeldec = new JLabel("Numero Decimal");
        add(Labeldec);

        decField = new JTextField(20);
        add(decField);

        Labelbin = new JLabel("Numero Binario");
        add(Labelbin);

        binField = new JTextField(20);
        add(binField);

        Labelhex = new JLabel("Numero Hexadecimal");
        add(Labelhex);

        hexField = new JTextField(20);
        add(hexField);

        Labelmaq = new JLabel("Numero Maquina");
        add(Labelmaq);

        maqField = new JTextField(20);
        add(maqField);

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

        BotonDec = new JButton("Dec a");
        add(BotonDec);
        BotonDec.addActionListener(this);

        BotonBin = new JButton("Bin a");
        add(BotonBin);
        BotonBin.addActionListener(this);

        BotonHex = new JButton("Hex a");
        add(BotonHex);
        BotonHex.addActionListener(this);

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

        if (e.getSource() == BotonDec) {
            int decimal = Integer.parseInt(textField.getText());
            decField.setText(Integer.toString(decimal));
            binField.setText(Integer.toBinaryString(decimal));
            hexField.setText(Integer.toHexString(decimal).toUpperCase());
            String hex = Integer.toHexString(decimal).toUpperCase();
            maqField.setText(invertirCadena(hex));        }

        if (e.getSource() == BotonBin) {
            String binary = textField.getText();
            int decimal = Integer.parseInt(binary, 2);
            decField.setText(String.valueOf(decimal));
            hexField.setText(Integer.toHexString(decimal).toUpperCase());
            String hex = Integer.toHexString(decimal).toUpperCase();
            maqField.setText(invertirCadena(hex)); 
            binField.setText(binary);

        }
        if (e.getSource() == BotonHex) {
            String hex = textField.getText();
            int decimal = Integer.parseInt(hex, 16);
            decField.setText(String.valueOf(decimal));
            binField.setText(Integer.toBinaryString(decimal));
            hexField.setText(hex);
            maqField.setText(invertirCadena(hex));  
        }

        if (e.getSource() == BotonMaq) {
            String maq = textField.getText();
            int decimal = Integer.parseInt(invertirCadena(maq), 16);
            decField.setText(String.valueOf(decimal));
            binField.setText(Integer.toBinaryString(decimal));
            hexField.setText(invertirCadena(maq));
            maqField.setText(maq);
        }
    }
}