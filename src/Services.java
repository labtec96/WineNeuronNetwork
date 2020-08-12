
import java.util.Random;

public class Services
{
	static double generateBetween(int min, int max)
	{
		return min + (max - (min)) * new Random().nextDouble();
	}

	static double SigmoidalUnipolar(double net)
	{
		return 1 / (1 + Math.pow(Math.E, -net));
	}

	static double net(double[] weights, double[] inputSignals, double b)
	{
		double net = 0;
		for (int i = 0; i < weights.length; i++)
		{
			net += inputSignals[i] * weights[i];
		}
		net += b;
		return net;
	}

	static void weightUpdateFirstLayer(Neuron[] n, double learningRatio, double[] patterns,
									   double[] mistakesFirstLayer)
	{
		double[] weightsNew = null;
		for (int i = 0; i < n.length; i++)
		{
			weightsNew = new double[n[i].getWeights().length];
			double bNew = 0;
			for (int j = 0; j < n[i].getWeights().length; j++)
			{
				weightsNew[j] = n[i].getWeights()[j] + learningRatio * (mistakesFirstLayer[i] * patterns[j]);
			}
			bNew = n[i].getB() + learningRatio * mistakesFirstLayer[i];
			n[i].setWeights(weightsNew);
			n[i].setB(bNew);
		}
	}

	static double[] mistakesOutLayer(double[] vectorFromLayer, double[] expected)
	{
		double[] result = new double[vectorFromLayer.length];
		for (int i = 0; i < expected.length; i++)
		{
			result[i] = vectorFromLayer[i] * (1 - vectorFromLayer[i]) * (expected[i] - vectorFromLayer[i]);
		}
		return result;
	}

	static double[] mistakesHiddenLayer(double[] vectorFromLayer, Neuron[] neuronsLayer2,
										double[] mistakesFromSecondLayer)
	{
		double[] result = new double[vectorFromLayer.length];
		for (int i = 0; i < vectorFromLayer.length; i++)
		{
			double sum = 0;
			for (int j = 0; j < mistakesFromSecondLayer.length; j++)
			{
				sum += mistakesFromSecondLayer[j] * neuronsLayer2[j].weights[i];
				// System.out.println(sum);
			}
			// System.out.println(sum);
			result[i] = vectorFromLayer[i] * (1 - vectorFromLayer[i]) * sum;
		}
		return result;
	}

	public static double[] checkYourValueForLayer(double[] inputValues, Neuron[] neurons)
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
	
}
