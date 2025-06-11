package calculator;

import javax.swing.*;
import java.awt.event.*;

public class Calculator {
    public static void main(String[] args) {
        // Create main window / Ana pencereyi oluştur
        JFrame frame = new JFrame("Calculator"); // Hesap Makinesi
        frame.setSize(300, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

        // Create display field / Ekran
        JTextField display = new JTextField();
        display.setBounds(20, 20, 240, 40);
        frame.add(display);

        // Create button  1 Butonu
        JButton button1 = new JButton("1");
        button1.setBounds(20, 80, 50, 40);
        frame.add(button1);

        // Create button  2 Butonu
        JButton button2 = new JButton("2");
        button2.setBounds(20, 130, 50, 40);
        frame.add(button2);

        // Create button  3 Butonu
        JButton button3 = new JButton("3");
        button3.setBounds(80, 130, 50, 40);
        frame.add(button3);

        JButton button4 = new JButton("4");
        button4.setBounds(140, 130, 50, 40);
        frame.add(button4);

        JButton button5 = new JButton("5");
        button5.setBounds(20, 180, 50, 40);
        frame.add(button5);

        JButton button6 = new JButton("6");
        button6.setBounds(80, 180, 50, 40);
        frame.add(button6);

        JButton button7 = new JButton("7");
        button7.setBounds(140, 180, 50, 40);
        frame.add(button7);

        JButton button8 = new JButton("8");
        button8.setBounds(20, 230, 50, 40);
        frame.add(button8);

        JButton button9 = new JButton("9");
        button9.setBounds(80, 230, 50, 40);
        frame.add(button9);

        JButton button0 = new JButton("0");
        button0.setBounds(140, 230, 50, 40);
        frame.add(button0);


        // Create plus button  + Butonu
        JButton buttonPlus = new JButton("+");
        buttonPlus.setBounds(80, 80, 50, 40);
        frame.add(buttonPlus);

        // Create plus button  - Butonu
        JButton buttonMinus = new JButton("-");
        buttonMinus.setBounds(200, 80, 50, 40);
        frame.add(buttonMinus);

        // Create plus button  * Butonu
        JButton buttonMultiply = new JButton("*");
        buttonMultiply.setBounds(200, 130, 50, 40);
        frame.add(buttonMultiply);

        // Create plus button  / Butonu
        JButton buttonDivide = new JButton("/");
        buttonDivide.setBounds(200, 180, 50, 40);
        frame.add(buttonDivide);

        // Create equals button  = Butonu

        JButton buttonClear = new JButton("C");
        buttonClear.setBounds(200, 230, 50, 40);
        frame.add(buttonClear);

        JButton buttonEqual = new JButton("=");
        buttonEqual.setBounds(140, 80, 50, 40);
        frame.add(buttonEqual);

        // Add action listeners / Butonlara işlev ekle
        // Rakam butonlarına işlev ekle / Ereignisse für Zahlentasten hinzufügen
        button0.addActionListener(e -> display.setText(display.getText() + "0"));
        button1.addActionListener(e -> display.setText(display.getText() + "1"));
        button2.addActionListener(e -> display.setText(display.getText() + "2"));
        button3.addActionListener(e -> display.setText(display.getText() + "3"));
        button4.addActionListener(e -> display.setText(display.getText() + "4"));
        button5.addActionListener(e -> display.setText(display.getText() + "5"));
        button6.addActionListener(e -> display.setText(display.getText() + "6"));
        button7.addActionListener(e -> display.setText(display.getText() + "7"));
        button8.addActionListener(e -> display.setText(display.getText() + "8"));
        button9.addActionListener(e -> display.setText(display.getText() + "9"));
        buttonClear.addActionListener(e -> display.setText(""));
// C butonuna basınca ekranı temizler / Beim Drücken von "C" wird das Display geleert

//        button1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                // Butona basınca ekrana "1" ekle
//                // Wenn auf die Taste "1" geklickt wird, füge "1" zum Textfeld hinzu
//                display.setText(display.getText() + "1");
//            }
//        });

        buttonPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // "+" işaretini ekle
                // "+" Zeichen hinzufügen
                display.setText(display.getText() + "+");
            }
        });

        buttonEqual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = display.getText(); // Ekrandaki yazıyı al
                // Get the current input from the display field

                try {
                    if (input.contains("+")) {
                        String[] parts = input.split("\\+");
                        int result = Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
                        display.setText(String.valueOf(result));
                    } else if (input.contains("-")) {
                        String[] parts = input.split("-");
                        int result = Integer.parseInt(parts[0]) - Integer.parseInt(parts[1]);
                        display.setText(String.valueOf(result));
                    } else if (input.contains("*")) {
                        String[] parts = input.split("\\*");
                        int result = Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]);
                        display.setText(String.valueOf(result));
                    } else if (input.contains("/")) {
                        String[] parts = input.split("/");
                        int num1 = Integer.parseInt(parts[0]);
                        int num2 = Integer.parseInt(parts[1]);

                        if (num2 == 0) {
                            display.setText("Error: /0"); // Sıfıra bölme hatası
                        } else {
                            int result = num1 / num2;
                            display.setText(String.valueOf(result));
                        }
                    } else {
                        display.setText("Invalid"); // Geçersiz giriş
                    }

                } catch (Exception ex) {
                    display.setText("Error");
                }
            }
        });

        // İşlem butonlarına işlev ekle / Ereignisse für Operatorentasten hinzufügen
        buttonMinus.addActionListener(e -> display.setText(display.getText() + "-"));
        buttonMultiply.addActionListener(e -> display.setText(display.getText() + "*"));
        buttonDivide.addActionListener(e -> display.setText(display.getText() + "/"));

        display.setBackground(new java.awt.Color(240, 248, 255)); // Ekran rengi
        buttonEqual.setBackground(new java.awt.Color(144, 238, 144)); // = tuşu yeşil
        display.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 20));



    }
}
