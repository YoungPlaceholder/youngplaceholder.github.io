package phisics;

import javax.swing.*;

public class Main {
    private JFrame frame;
    private static JLabel resultLabel;

    public static void main(String[] args) {
        System.out.println(
                "Hello People welcome to this software, if you are seeing this message it means that the program has started correctly\n\nPlease if you are seeing this message and you aren't trying to debug this software just ignore this window, otherwise on this page you will find all the debug messages you'll need.\n\n");

        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
            main.createAndShowGUI();
        });
        exitMsg(1220);
    }

    public void createAndShowGUI() {
        // Create the frame
        frame = new JFrame("Physics Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Create and add the result label
        resultLabel = new JLabel();
        resultLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        frame.add(resultLabel);

        // Create and add the calculate button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
        calculateButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(null, "Enter a value:");
            if (input != null) {
                int value = Integer.parseInt(input);
                MaxHeightParabolic(value);
            }
        });
        frame.add(calculateButton);

        // Show the frame
        frame.setVisible(true);
    }

    public static void MaxHeightParabolic(int speedInitials) {
        double T = (2 * speedInitials) / 9.8;
        double hmax = 0.5 * (9.8 * T * T) + (speedInitials * T);
        System.out.println("Calculation Result:");
        System.out.println("-----------------------------");
        System.out.printf("Maximum Height:\t%.2f meters%n", hmax);
        System.out.println("-----------------------------");
        resultLabel.setText("Maximum Height: " + String.format("%.2f", hmax) + " meters");
    }

    public static void exitMsg(int pswd) {
        if (pswd != 1220) {
            System.out.println("\n\n\n");
            System.out.println("You are not authorized to use this function");
        } else {
            System.out.println("\n\n\n");
            System.out.println("Software version: Alfa 1.0.1");
            System.out.println("By Francesco Serangeli");
            System.out.println("This software is protected by GPLv3");
        }
    }
}
