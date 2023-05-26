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
        menuPanel.setLayout(new GridLayout(4, 1));

        // Create the buttons for each calculation function
        JButton maxHeightButton = new JButton("Max Height");
        JButton finalVelocityButton = new JButton("Final Velocity");
        JButton displacementButton = new JButton("Displacement");
        JButton angularVelocityButton = new JButton("Angular Velocity");

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

        angularVelocityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Enter the radius:");
                if (input != null) {
                    try {
                        double radius = Double.parseDouble(input);
                        String input2 = JOptionPane.showInputDialog(null, "Enter the linear velocity:");
                        if (input2 != null) {
                            try {
                                double linearVelocity = Double.parseDouble(input2);
                                physicsCalculator = new PhysicsCalculator(resultLabel);
                                physicsCalculator.calculateAngularVelocity(radius, linearVelocity);
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric value.");
                            }
                        }
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
        menuPanel.add(angularVelocityButton);

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
            System.out.println("Software version: Alpha 1.0.3");
            System.out.println("By Francesco Serangeli");
            System.out.println("This software is protected by GPLv3");
        }
    }
}
