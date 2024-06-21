import java.util.InputMismatchException;

public class CostFunctions {
    public static double MeanSquaredError(double[] predictions, double[] true_values) {
        if (predictions.length != true_values.length) {
            throw new InputMismatchException("The shapes of predictions and true values do not match");
        }
        double loss = 0.0;
        double total_cost = 0.0;
        int num_training_examples = predictions.length;
        for (int i = 0; i  < predictions.length; i++) {
            loss = predictions[i] - true_values[i];
            total_cost += Math.pow(loss, 2);
        }
        total_cost = total_cost / num_training_examples;
        
        return total_cost;     
    }
    public static double MeanSquaredErrorDerivative() {

    }

}
