/**
 * The Activations class provides methods to apply various activation functions
 * commonly used in neural networks. These functions include Sigmoid, ReLU, and Tanh.
 */
public class Activations {

    /**
     * Applies the Sigmoid activation function to the given value.
     * The Sigmoid function is defined as 1 / (1 + e^(-value)).
     *
     * @param value the input value to the activation function
     * @return the output of the Sigmoid function
     */
    public static double Sigmoid(double value) {
        double d = 1 + Math.exp(-value);
        return (1 / d);
    }

    /**
     * Applies the ReLU (Rectified Linear Unit) activation function to the given value.
     * The ReLU function returns the input value if it is greater than zero, otherwise it returns zero.
     *
     * @param value the input value to the activation function
     * @return the output of the ReLU function
     */
    public static double Relu(double value) {
        if (value > 0) {
            return value;
        } else {
            return 0;
        }
    }

    /**
     * Applies the Tanh (hyperbolic tangent) activation function to the given value.
     * The Tanh function is defined as (e^(value) - e^(-value)) / (e^(value) + e^(-value)),
     * and can be computed using Math.tanh.
     *
     * @param value the input value to the activation function
     * @return the output of the Tanh function
     */
    public static double Tanh(double value) {
        return Math.tanh(value);
    }
}
