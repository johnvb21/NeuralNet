/**
 * The Layer class represents a single layer in a neural network.
 * It contains the number of units (neurons) in the layer, the activation function used,
 * and an array of Neuron objects.
 */
public class Layer {
    int numUnits;
    String activation;
    Neuron[] neurons;

    /**
     * Constructs a Layer object with the specified number of units and activation function.
     * Initializes an array of Neuron objects of the specified size.
     *
     * @param numUnits the number of units (neurons) in the layer
     * @param activation the activation function used in the layer
     */
    public Layer(int numUnits, String activation) {
        this.numUnits = numUnits;
        this.activation = activation;
        this.neurons = new Neuron[numUnits];
    }

    /**
     * Computes the output of the layer given the input values.
     * For each neuron in the layer, it calculates the output and applies the activation function.
     * If the activation function is "softmax", it applies the softmax function to the outputs.
     *
     * @param inputs the input values to the layer
     * @return the output values after applying the activation function
     */
    public double[] computeLayer(double[] inputs) {
        double output = 0;
        double[] computedLayer = new double[numUnits];
        for (int i = 0; i < numUnits; i++) {
            output = neurons[i].calculateOutput(inputs);
            computedLayer[i] = output;
            System.out.println(computedLayer[i]);
        }

        System.out.println("BREAK");
        if (activation.equals("softmax")) {
            computedLayer = softmax(computedLayer);
        }
        return computedLayer;
    }

    /**
     * Applies the softmax activation function to the computed layer outputs.
     * The softmax function converts the outputs into probabilities that sum to 1.
     *
     * @param computedLayer the computed outputs of the layer
     * @return the softmax-activated output values
     */
    private double[] softmax(double[] computedLayer) {
        double[] expValues = new double[computedLayer.length];
        double sumExpValues = 0.0;

        for (int i = 0; i < computedLayer.length; i++) {
            expValues[i] = Math.exp(computedLayer[i]);
            sumExpValues += expValues[i];
        }

        double[] softmaxValues = new double[computedLayer.length];
        for (int i = 0; i < computedLayer.length; i++) {
            softmaxValues[i] = expValues[i] / sumExpValues;
        }

        return softmaxValues;
    }
}
