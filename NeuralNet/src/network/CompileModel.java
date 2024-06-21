/**
 * The CompileModel class is responsible for compiling a neural network model
 * by initializing its layers and neurons. It uses information from a Model object
 * to set up the network structure.
 */
public class CompileModel {
    int inputSize;
    int numLayers;
    Layer[] layers;

    /**
     * Constructs a CompileModel object using the specified Model object.
     * It initializes the input size, number of layers, and layers of the network.
     *
     * @param model the Model object containing the structure of the neural network
     */
    public CompileModel(Model model) {
        this.inputSize = model.inputSize;
        this.numLayers = model.numLayers;
        this.layers = model.layers;
        layers[0] = initialize_layer(inputSize, layers[0]); // Initialize the first layer with the input size
        for (int i = 1; i < numLayers; i++) {
            layers[i] = initialize_layer(layers[i - 1].numUnits, layers[i]); // Initialize subsequent layers
        }
    }

    /**
     * Initializes a layer by setting up its neurons with the given input size.
     * Each neuron in the layer is created with weights and bias.
     *
     * @param inputSize the size of the input to the layer
     * @param layer the layer to be initialized
     * @return the initialized layer
     */
    public Layer initialize_layer(int inputSize, Layer layer) {
        for (int i = 0; i < layer.numUnits; i++) {
            layer.neurons[i] = new Neuron(inputSize, layer.activation);
            // Sets the neurons for the layer to expect the specified input size
        }
        return layer;
    }

    /**
     * Prints the statistics of the model, including the number of layers, input size,
     * and details of each layer such as the number of units and activation function.
     */
    public void model_stats() {
        System.out.println("Number of Layers: " + numLayers);
        System.out.println("Input Size: " + inputSize);
        for (int i = 0; i < numLayers; i++) {
            int units = layers[i].numUnits;
            String activation = layers[i].activation;
            System.out.println("Layer " + i + ": " + units + " units, activation is " + activation);
            print_neurons(layers[i]); // Print details of the neurons in the layer
        }
    }

    /**
     * Prints the details of the neurons in a given layer, including their weights and biases.
     *
     * @param layer the layer whose neurons' details are to be printed
     */
    public void print_neurons(Layer layer) {
        Neuron[] neurons = layer.neurons;
        System.out.println("Weights:");
        for (int i = 0; i < layer.numUnits; i++) {
            System.out.print("[");
            for (int j = 0; j < neurons[i].previousLayerNum; j++) {
                System.out.print(neurons[i].weights[j]);
                if (j < neurons[i].previousLayerNum - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        for (int i = 0; i < layer.numUnits; i++) {
            System.out.println("Bias: " + neurons[i].bias);
        }
    }
}
