
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

class Network
{
	// private Neuron[] neuronsLayer1 = new Neuron[13];
	// private Neuron[] neuronsLayer2 = new Neuron[6];
	private List<Neuron[]> listLayers;
	private int[] numberOfLayers;
	private double learningRatio;
	private int learningSteps;
	private File file;
	private List<Wine> teachingData;
	private List<Wine> testData;

	Network(int[] numberOfLayers, double learningRatio, File file, int learningSteps)
	{
		this.numberOfLayers = numberOfLayers;
		this.learningRatio = learningRatio;
		this.file = file;
		this.learningSteps = learningSteps;

		listLayers = addNeuronsToLayers(numberOfLayers);
		listLayers.add(addLastLayer(numberOfLayers[numberOfLayers.length - 1], 3));

		Wines wines = new Wines(file);
		List<List<Wine>> data = wines.getRandomDate();
		teachingData = data.get(0);
		testData = data.get(1);
	}

	private ArrayList<Neuron[]> addNeuronsToFirstLayer(int[] layersFun, int amountWeights)
	{
		Neuron[] tmp = new Neuron[layersFun[0]];
		ArrayList<Neuron[]> listLayersFun = new ArrayList<Neuron[]>();
		for (int i = 0; i < tmp.length; i++)
		{
			tmp[i] = new Neuron(amountWeights);
		}
		listLayersFun.add(tmp);
		return listLayersFun;
	}

	private ArrayList<Neuron[]> addNeuronsToLayers(int[] layersFun)
	{
		ArrayList<Neuron[]> listLayersFun = new ArrayList<Neuron[]>();
		for (int i = 0; i < layersFun.length; i++)
		{
			if (i == 0)
			{
				listLayersFun = addNeuronsToFirstLayer(layersFun, 13);
			} else
			{
				Neuron[] tmp = new Neuron[layersFun[i]];
				for (int j = 0; j < tmp.length; j++)
				{
					tmp[j] = new Neuron(layersFun[i - 1]);
				}
				listLayersFun.add(tmp);
			}
		}
		return listLayersFun;
	}

	private Neuron[] addLastLayer(int amountWeights, int amountNeurons)
	{
		System.out.println(amountWeights);
		Neuron[] tmp = new Neuron[amountNeurons];
		for (int j = 0; j < amountNeurons; j++)
		{
			tmp[j] = new Neuron(amountWeights);
		}
		return tmp;
	}

	void startTeaching()
	{
		for (int l = 0; l < learningSteps; l++)
		{
			for (Wine teachingDatum : teachingData) {

				List<double[]> netsFromLayers = new ArrayList<>(); //
				//System.out.println(teachingData.get(i));
				netsFromLayers.add(checkYourValueForLayer(teachingDatum.getAtributes(), listLayers.get(0)));
				for (int j = 1; j < numberOfLayers.length + 1; j++) {
					netsFromLayers.add(checkYourValueForLayer(netsFromLayers.get(j - 1), listLayers.get(j)));
				}
				List<double[]> mistakesFromLayers = new ArrayList<>();
				mistakesFromLayers.add(Services.mistakesOutLayer(netsFromLayers.get(netsFromLayers.size() - 1),
						teachingDatum.getExceptedValueTmp())); //
				int tmp = 0;
				for (int j = listLayers.size() - 2; j >= 0; j--) {
					mistakesFromLayers.add(Services.mistakesHiddenLayer(netsFromLayers.get(j), listLayers.get(j + 1),
							mistakesFromLayers.get(tmp)));
					tmp++;
				}
				tmp = 0;
				for (int j = listLayers.size() - 1; j > 0; j--) {
					Services.weightUpdateFirstLayer(listLayers.get(j), learningRatio, netsFromLayers.get(j - 1),
							mistakesFromLayers.get(tmp));
					tmp++;
				}
				Services.weightUpdateFirstLayer(listLayers.get(0), learningRatio, teachingDatum.getAtributes(),
						mistakesFromLayers.get(mistakesFromLayers.size() - 1));
			}
		}

	}


	private double[] checkYourValueForLayer(double[] inputValues, Neuron[] neurons)
	{
		double[] answer = new double[neurons.length];
		for (int i = 0; i < neurons.length; i++)
		{
			double net = Services.net(neurons[i].getWeights(), inputValues, neurons[i].getB());
			double y = Services.SigmoidalUnipolar(net);
			answer[i] = y;
		}
		return answer;
	}

	Integer checkYourValue(double[] ds)
	{
		double[] lastVector = checkYourValueForLayer(ds, listLayers.get(0));
		for (int i = 1; i < listLayers.size(); i++)
		{
			lastVector = checkYourValueForLayer(lastVector, listLayers.get(i));
		}
		int answer = 0;
		double maxValue = 0;
		for (int j = 0; j < lastVector.length; j++)
		{
			if (maxValue < lastVector[j])
			{
				maxValue = lastVector[j];
				answer = j + 1;
			}
		}
		return answer;
	}

	String checkForTest(JTextArea display)
	{
		int correct = 0;
		for (Wine testDatum : testData) {
			Integer result = checkYourValue(testDatum.getAtributes());
			display.append("Expected value " + testDatum.getExceptedValue() + " network answer " + result + "\n");
			if (testDatum.getExceptedValue() == result)
				correct++;
		}
		display.append("Network efficiency " +String.format("%.1f", ((double) correct / testData.size()) *100)+ "%"+ "\n");
		return "dd";
	}

}
