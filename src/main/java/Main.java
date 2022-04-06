import org.neuroph.core.Layer;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.Neuron;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.util.ConnectionFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        int inputCount = 12;
        int outputCount = 6;
        Layer inputLayer = createLayer(inputCount);
        Layer firstHiddenLayer = createLayer(inputCount * 2);
        Layer secondHiddenLayer = createLayer(inputCount * 2);
        Layer outputLayer = createLayer(outputCount);
        NeuralNetwork<BackPropagation> network = new NeuralNetwork<>();
        network.addLayer(0, inputLayer);
        network.addLayer(1, firstHiddenLayer);
        ConnectionFactory.fullConnect(network.getLayerAt(0), network.getLayerAt(1));
        network.addLayer(2, secondHiddenLayer);
        ConnectionFactory.fullConnect(network.getLayerAt(1), network.getLayerAt(2));
        network.addLayer(3, outputLayer);
        ConnectionFactory.fullConnect(network.getLayerAt(2), network.getLayerAt(3));
        ConnectionFactory.fullConnect(network.getLayerAt(0),
                network.getLayerAt(network.getLayersCount()-1), false);
        network.setInputNeurons(inputLayer.getNeurons());
        network.setOutputNeurons(outputLayer.getNeurons());

        DataSet dataSet = new DataSet(inputCount, outputCount);
        List<String> dataRow = Files.readAllLines(Paths.get(args[0]));
    }

    private static Layer createLayer(int count) {
        Layer layer = new Layer();
        for (int i = 0; i < count; i++) {
            layer.addNeuron(new Neuron());
        }
        return layer;
    }

  /*  private static DataSetRow createRow(String data) {
        List<String> splitData = Arrays.asList(data.split(","));

        DataSetRow dataSetRow = new DataSetRow((Arr)splitData.subList(0, splitData.size() - 1), splitData.subList(splitData.size() - 1, splitData.size()));
    }*/
}
