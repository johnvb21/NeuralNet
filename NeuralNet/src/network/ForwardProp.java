import java.util.Arrays;

/**
 * The ForwardProp class handles the forward propagation process for a compiled neural network model.
 * It takes a CompileModel object and provides a method to propagate input values through the model layers.
 */
public class ForwardProp {
    private CompileModel model;

    /**
     * Constructs a ForwardProp object with the specified compiled model.
     *
     * @param model the compiled neural network model to be used for forward propagation
     */
    public ForwardProp(CompileModel model) {
        this.model = model;
    }

    /**
     * Propagates the input values through the layers of the model.
     * It sequentially computes the output for each layer using the output of the previous layer as input.
     *
     * @param inputs the input values to be propagated through the model
     * @return the final output values after propagation through all layers
     */
    public double[] propagateInputs(double[] inputs) {
        double[] computedLayer;
        System.out.println(Arrays.toString(inputs)); // Print the input values
        computedLayer = model.layers[0].computeLayer(inputs); // Compute the output for the first layer
        for (int i = 1; i < model.numLayers; i++) {
            computedLayer = model.layers[i].computeLayer(computedLayer); // Compute the output for subsequent layers
        }
        return computedLayer; // Return the final output values
    }
}
