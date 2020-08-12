

public class Neuron
{
	private double b = Services.generateBetween(-1, 1);
	double[] weights;
	public Neuron()
	{
		weights = new double[3];
	}
	Neuron(int amountOfWeights)
	{
		initializationWeights(amountOfWeights);
	}

	private void initializationWeights(int amount)
	{
		weights = new double[amount];
		for (int i = 0; i < weights.length; i++)
		{
			weights[i] = Services.generateBetween(-1, 1);
		}
	}

	@Override
	public String toString()
	{
		String toString = "";
		for (int i = 0; i < weights.length; i++)
		{
			toString += "w" + (i + 1) + " " + weights[i] + "\n";
		}
		toString += "b " + b;
		return toString;
	}

	synchronized void setB(double b)
	{
		this.b = b;
	}

	synchronized double getB()
	{
		return b;
	}

	synchronized double[] getWeights()
	{
		return weights;
	}

	synchronized void setWeights(double[] weights)
	{
		this.weights = weights;
	}
}
