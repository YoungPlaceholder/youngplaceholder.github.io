package Physics;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JFrame frame;
    private JLabel resultLabel; // Moved the declaration to the class level
    private PhysicsCalculator physicsCalculator;

    public static void main(String[] args) {
        System.out.println("Hello People, welcome to this software...");
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
            main.createAndShowGUI();
        });
    }

    public void createAndShowGUI() {
        // Create the frame
        frame = new JFrame("Physics Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        // Create the result label panel
        JPanel resultPanel = new JPanel();
        resultLabel = new JLabel();
        resultLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        resultPanel.add(resultLabel);
        frame.add(resultPanel, BorderLayout.CENTER);

        // Create the menu panel
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(3, 1));

        // Create the buttons for each calculation function
        JButton maxHeightButton = new JButton("Max Height");
        JButton finalVelocityButton = new JButton("Final Velocity");
        JButton displacementButton = new JButton("Displacement");

        // Add ActionListener to each button
        maxHeightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Enter the initial speed:");
                if (input != null) {
                    try {
                        double initialSpeed = Double.parseDouble(input);
                        physicsCalculator = new PhysicsCalculator(resultLabel);
                        physicsCalculator.calculateMaxHeightParabolic(initialSpeed);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric value.");
                    }
                }
            }
        });

        finalVelocityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Enter the initial velocity:");
                if (input != null) {
                    try {
                        double initialVelocity = Double.parseDouble(input);
                        physicsCalculator = new PhysicsCalculator(resultLabel);
                        physicsCalculator.calculateFinalVelocity(initialVelocity);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric value.");
                    }
                }
            }
        });

        displacementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Enter the initial velocity:");
                if (input != null) {
                    try {
                        double initialVelocity = Double.parseDouble(input);
                        physicsCalculator = new PhysicsCalculator(resultLabel);
                        physicsCalculator.calculateDisplacement(initialVelocity);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric value.");
                    }
                }
            }
        });

        // Add buttons to the menu panel
        menuPanel.add(maxHeightButton);
        menuPanel.add(finalVelocityButton);
        menuPanel.add(displacementButton);

        // Add the menu panel to the frame
        frame.add(menuPanel, BorderLayout.WEST);

        // Show the frame
        frame.setVisible(true);
    }

    public static void exitMsg(int pswd) {
        if (pswd != 1220) {
            System.out.println("\n\n\n");
            System.out.println("You are not authorized to use this function");
        } else {
            System.out.println("\n\n\n");
            System.out.println("Software version: Alpha 1.0.1");
            System.out.println("By Francesco Serangeli");
            System.out.println("This software is protected by GPLv3");
        }
    }
}

class PhysicsCalculator {
    private JLabel resultLabel; // Add a field for resultLabel

    public PhysicsCalculator(JLabel resultLabel) {
        this.resultLabel = resultLabel;
    }

    public void calculateMaxHeightParabolic(double initialSpeed) {
        double T = (2 * initialSpeed) / 9.8;
        double hmax = 0.5 * (9.8 * T * T) + (initialSpeed * T);
        System.out.println("Calculation Result:");
        System.out.println("-----------------------------");
        System.out.printf("Maximum Height:\t%.2f meters%n", hmax);
        System.out.println("-----------------------------");
        resultLabel.setText("Maximum Height: " + String.format("%.2f", hmax) + " meters");
    }

    public void calculateFinalVelocity(double initialVelocity) {
        double acceleration = 9.8; // Assuming constant acceleration of gravity
        double time = 1.0; // You can change this value as needed
        double finalVelocity = initialVelocity + (acceleration * time);
        System.out.println("Calculation Result:");
        System.out.println("-----------------------------");
        System.out.printf("Final Velocity:\t%.2f meters per second%n", finalVelocity);
        System.out.println("-----------------------------");
        resultLabel.setText("Final Velocity: " + String.format("%.2f", finalVelocity) + " meters per second");
    }

    public void calculateDisplacement(double initialVelocity) {
        double acceleration = 9.8; // Assuming constant acceleration of gravity
        double time = 1.0; // You can change this value as needed
        double displacement = initialVelocity * time + 0.5 * acceleration * time * time;
        System.out.println("Calculation Result:");
        System.out.println("-----------------------------");
        System.out.printf("Displacement:\t%.2f meters%n", displacement);
        System.out.println("-----------------------------");
        resultLabel.setText("Displacement: " + String.format("%.2f", displacement) + " meters");
    }
}
