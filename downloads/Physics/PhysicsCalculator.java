package Physics;

import javax.swing.JLabel;

class PhysicsCalculator {
    private JLabel resultLabel;

    public PhysicsCalculator(JLabel resultLabel) {
        this.resultLabel = resultLabel;
    }

    public void calculateMaxHeightParabolic(double initialSpeed) {
        double T = (2 * initialSpeed) / 9.8;
        double hmax = 0.5 * (9.8 * T * T) + (initialSpeed * T);
        resultLabel.setText("Maximum Height: " + String.format("%.2f", hmax) + " meters");
    }

    public void calculateFinalVelocity(double initialVelocity) {
        double acceleration = 9.8; // Assuming constant acceleration of gravity
        double time = 1.0; // You can change this value as needed
        double finalVelocity = initialVelocity + (acceleration * time);
        resultLabel.setText("Final Velocity: " + String.format("%.2f", finalVelocity) + " meters per second");
    }

    public void calculateDisplacement(double initialVelocity) {
        double acceleration = 9.8; // Assuming constant acceleration of gravity
        double time = 1.0; // You can change this value as needed
        double displacement = initialVelocity * time + 0.5 * acceleration * time * time;
        resultLabel.setText("Displacement: " + String.format("%.2f", displacement) + " meters");
    }

    public void calculateAngularVelocity(double radius, double linearVelocity) {
        double angularVelocity = linearVelocity / radius;
        resultLabel.setText("Angular Velocity: " + String.format("%.2f", angularVelocity) + " radians per second");
    }

    public void calculateCentripetalAcceleration(double radius, double linearVelocity) {
        double centripetalAcceleration = (linearVelocity * linearVelocity) / radius;
        resultLabel.setText("Centripetal Acceleration: " + String.format("%.2f", centripetalAcceleration)
                + " meters per second squared");
    }

    public void calculatePeriod(double angularVelocity) {
        double period = 2 * Math.PI / angularVelocity;
        resultLabel.setText("Period: " + String.format("%.2f", period) + " seconds");
    }
}
