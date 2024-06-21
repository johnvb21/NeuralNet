/**
 * The Neuron class represents a single neuron in a neural network.
 * It contains the weights, bias, activation function, and methods to
 * initialize and calculate the neuron's output.
 */
public class Neuron {
    double[] weights;
    double bias = 0.0;
    int previousLayerNum;
    String activation;

    /**
     * Constructs a Neuron object with the specified number of inputs from the previous layer
     * and the specified activation function. Initializes the weights and bias randomly.
     *
     * @param previous the number of inputs from the previous layer
     * @param activation the activation function used by the neuron
     */
    public Neuron(int previous, String activation) {
        this.previousLayerNum = previous;
        this.weights = new double[previous];
        this.activation = activation;
        randomizeNeuron();
    }

    /**
     * Randomizes the neuron's weights and bias. Each weight is set to a random value
     * between -1 and 1, and the bias is also set to a random value between -1 and 1.
     */
    public void randomizeNeuron() {
        for (int i = 0; i < previousLayerNum; i++) {
            double weight = (double) Math.random() * 2 - 1;
            weights[i] = weight;
        }
        bias = (double) Math.random() * 2 - 1;
    }

    /**
     * Returns the weights of the neuron.
     *
     * @return an array of weights
     */
    public double[] get_weights() {
        return this.weights;
    }

    /**
     * Returns the bias of the neuron.
     *
     * @return the bias value
     */
    public double get_bias(){
        return this.bias;
    }

    /**
     * Calculates the output of the neuron given the input values.
     * It computes the dot product of the input array with the weights,
     * adds the bias, and then applies the activation function.
     *
     * @param inputs the input values to the neuron
     * @return the output of the neuron after applying the activation function
     */
    public double calculateOutput(double[] inputs) {
        double output = 0;
        // Dot product the input array with the weights for the neuron
        if (inputs.length != weights.length) {
            throw new IllegalArgumentException("Error: Shape mismatch");
        }
        for (int i = 0; i < inputs.length; i++) {
            output += (inputs[i] * weights[i]);
        }
        output += bias;
        output = applyActivation(output);
        return output;
    }

    /**
     * Applies the activation function to the given value.
     * Supported activation functions are ReLU, Sigmoid, Tanh, and Softmax.
     *
     * @param value the value to which the activation function is applied
     * @return the value after applying the activation function
     */
    public double applyActivation(double value) {
        double output = 0;
        switch (activation.toLowerCase()) {
            case "relu":
                output = Activations.Relu(value);
                break;
            case "sigmoid":
                output = Activations.Sigmoid(value);
                break;
            case "tanh":
                output = Activations.Tanh(value);
                break;
            case "softmax":
                output = value; // Softmax is typically applied to a layer's output, not a single neuron
                break;
            default:
                throw new IllegalArgumentException("Unsupported Activation function: " + activation);
        }
        return output;
    }
}
