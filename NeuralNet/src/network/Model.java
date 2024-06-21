public class Model {
    int numLayers;
    Layer[] layers;
    int inputSize;
    public Model(int inputSize, int numLayers) {
        this.numLayers = numLayers;
        this.inputSize = inputSize;
        this.layers = new Layer[numLayers];

    }
}