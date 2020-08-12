import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Wines
{

	private List<Wine> wineList;

	private List<Wine> testList;
	private List<Wine> teachingList;

	private static Wine maxWineValue;
	private static Wine minWineValue;

	Wines(File file)
	{
		wineList = new LinkedList<>();
		maxWineValue = new Wine(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		minWineValue = new Wine(9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 9999);
		createWineList(file);
		getMaxValueAtribute();
		attributeNormalization();
		testList = new ArrayList<>(wineList);
	}

	private void createWineList(File file)
	{
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		try
		{
			while (br.ready())
			{
				String[] tab = br.readLine().split(",");
				wineList.add(new Wine(Integer.parseInt(tab[0]), Double.parseDouble(tab[1]), Double.parseDouble(tab[2]),
						Double.parseDouble(tab[3]), Double.parseDouble(tab[4]), Double.parseDouble(tab[5]),
						Double.parseDouble(tab[6]), Double.parseDouble(tab[7]), Double.parseDouble(tab[8]),
						Double.parseDouble(tab[9]), Double.parseDouble(tab[10]), Double.parseDouble(tab[11]),
						Double.parseDouble(tab[12]), Double.parseDouble(tab[13])));
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	List<List<Wine>> getRandomDate()
	{
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;

		int whoPrew = 3;

		teachingList = new ArrayList<>();

		int sizeList = testList.size();
		int teachingProcent = 75;

		for (int i = 0; i < 133;)
		{
			int tmp = (int) (Math.random() * testList.size());
			if (testList.get(tmp).getExceptedValue() == 1 && count0 <= 44 && whoPrew == 3)
			{
				teachingList.add(testList.remove(tmp));
				whoPrew = 1;
				i++;
				count0++;
			} else if (testList.get(tmp).getExceptedValue() == 2 && count1 <= 44 && whoPrew == 1)
			{
				teachingList.add(testList.remove(tmp));
				whoPrew = 2;
				i++;
				count1++;
			} else if (testList.get(tmp).getExceptedValue() == 3 && count2 <= 45 && whoPrew == 2)
			{
				teachingList.add(testList.remove(tmp));
				whoPrew = 3;
				i++;
				count2++;
			}

		}

		List<List<Wine>> result = new ArrayList<>();
		result.add(teachingList);
		result.add(testList);
		return result;
	}
	static void attributeNormalizationOneWine(Wine wine)
	{
		wine.setAlcohol((wine.getAlcohol() - minWineValue.getAlcohol())
				/ (maxWineValue.getAlcohol() - minWineValue.getAlcohol()));
		// System.out.println(wine.getAlcohol());
		wine.setMalicAcid((wine.getMalicAcid() - minWineValue.getMalicAcid())
				/ (maxWineValue.getMalicAcid() - minWineValue.getMalicAcid()));
		// System.out.println(wine.getMalicAcid());
		wine.setAsh((wine.getAsh() - minWineValue.getAsh()) 
				/ (maxWineValue.getAsh() - minWineValue.getAsh()));
		// System.out.println(wine.getAsh());
		wine.setAlcalinityOfAsh((wine.getAlcalinityOfAsh() - minWineValue.getAlcalinityOfAsh())
				/ (maxWineValue.getAlcalinityOfAsh() - minWineValue.getAlcalinityOfAsh()));
		// System.out.println(wine.getAlcalinityOfAsh());
		wine.setMagnesium((wine.getMagnesium() - minWineValue.getMagnesium())
				/ (maxWineValue.getMagnesium() - minWineValue.getMagnesium()));
		// System.out.println(wine.getMagnesium());
		wine.setTotalPhenols((wine.getTotalPhenols() - minWineValue.getTotalPhenols())
				/ (maxWineValue.getTotalPhenols() - minWineValue.getTotalPhenols()));
		// System.out.println(wine.getTotalPhenols());
		wine.setFlavanoids((wine.getFlavanoids() - minWineValue.getFlavanoids())
				/ (maxWineValue.getFlavanoids() - minWineValue.getFlavanoids()));
		// System.out.println(wine.getFlavanoids());
		wine.setNonflavanoidPhenols((wine.getNonflavanoidPhenols() - minWineValue.getNonflavanoidPhenols())
				/ (maxWineValue.getNonflavanoidPhenols() - minWineValue.getNonflavanoidPhenols()));
		// System.out.println(wine.getNonflavanoidPhenols());
		wine.setProanthocyanins((wine.getProanthocyanins() - minWineValue.getProanthocyanins())
				/ (maxWineValue.getProanthocyanins() - minWineValue.getProanthocyanins()));
		// System.out.println(wine.getProanthocyanins());
		wine.setColorIntensity((wine.getColorIntensity() - minWineValue.getColorIntensity())
				/ (maxWineValue.getColorIntensity() - minWineValue.getColorIntensity()));
		// System.out.println(wine.getColorIntensity());
		wine.setHue((wine.getHue() - minWineValue.getHue()) / (maxWineValue.getHue() - minWineValue.getHue()));
		// System.out.println(wine.getHue());
		wine.setDilutedWines((wine.getDilutedWines() - minWineValue.getDilutedWines())
				/ (maxWineValue.getDilutedWines() - minWineValue.getDilutedWines()));
		// System.out.println(wine.getDilutedWines());
		wine.setProline((wine.getProline() - minWineValue.getProline())
				/ (maxWineValue.getProline() - minWineValue.getProline()));
		// System.out.println(wine.getProline());
	}
	private void attributeNormalization()
	{
		for (Wine wine : wineList)
		{
			wine.setAlcohol((wine.getAlcohol() - minWineValue.getAlcohol())
					/ (maxWineValue.getAlcohol() - minWineValue.getAlcohol()));
			// System.out.println(wine.getAlcohol());
			wine.setMalicAcid((wine.getMalicAcid() - minWineValue.getMalicAcid())
					/ (maxWineValue.getMalicAcid() - minWineValue.getMalicAcid()));
			// System.out.println(wine.getMalicAcid());
			wine.setAsh((wine.getAsh() - minWineValue.getAsh()) 
					/ (maxWineValue.getAsh() - minWineValue.getAsh()));
			// System.out.println(wine.getAsh());
			wine.setAlcalinityOfAsh((wine.getAlcalinityOfAsh() - minWineValue.getAlcalinityOfAsh())
					/ (maxWineValue.getAlcalinityOfAsh() - minWineValue.getAlcalinityOfAsh()));
			// System.out.println(wine.getAlcalinityOfAsh());
			wine.setMagnesium((wine.getMagnesium() - minWineValue.getMagnesium())
					/ (maxWineValue.getMagnesium() - minWineValue.getMagnesium()));
			// System.out.println(wine.getMagnesium());
			wine.setTotalPhenols((wine.getTotalPhenols() - minWineValue.getTotalPhenols())
					/ (maxWineValue.getTotalPhenols() - minWineValue.getTotalPhenols()));
			// System.out.println(wine.getTotalPhenols());
			wine.setFlavanoids((wine.getFlavanoids() - minWineValue.getFlavanoids())
					/ (maxWineValue.getFlavanoids() - minWineValue.getFlavanoids()));
			// System.out.println(wine.getFlavanoids());
			wine.setNonflavanoidPhenols((wine.getNonflavanoidPhenols() - minWineValue.getNonflavanoidPhenols())
					/ (maxWineValue.getNonflavanoidPhenols() - minWineValue.getNonflavanoidPhenols()));
			// System.out.println(wine.getNonflavanoidPhenols());
			wine.setProanthocyanins((wine.getProanthocyanins() - minWineValue.getProanthocyanins())
					/ (maxWineValue.getProanthocyanins() - minWineValue.getProanthocyanins()));
			// System.out.println(wine.getProanthocyanins());
			wine.setColorIntensity((wine.getColorIntensity() - minWineValue.getColorIntensity())
					/ (maxWineValue.getColorIntensity() - minWineValue.getColorIntensity()));
			// System.out.println(wine.getColorIntensity());
			wine.setHue((wine.getHue() - minWineValue.getHue()) / (maxWineValue.getHue() - minWineValue.getHue()));
			// System.out.println(wine.getHue());
			wine.setDilutedWines((wine.getDilutedWines() - minWineValue.getDilutedWines())
					/ (maxWineValue.getDilutedWines() - minWineValue.getDilutedWines()));
			// System.out.println(wine.getDilutedWines());
			wine.setProline((wine.getProline() - minWineValue.getProline())
					/ (maxWineValue.getProline() - minWineValue.getProline()));
			// System.out.println(wine.getProline());
		}
	}

	private void getMaxValueAtribute()
	{
		for (Wine wine : wineList)
		{
			if (wine.getAlcohol() > maxWineValue.getAlcohol())
				maxWineValue.setAlcohol(wine.getAlcohol());

			if (wine.getAlcohol() < minWineValue.getAlcohol())
				minWineValue.setAlcohol(wine.getAlcohol());
			//
			if (wine.getMalicAcid() > maxWineValue.getMalicAcid())
				maxWineValue.setMalicAcid(wine.getMalicAcid());

			if (wine.getMalicAcid() < minWineValue.getMalicAcid())
				minWineValue.setMalicAcid(wine.getMalicAcid());
			//
			if (wine.getAsh() > maxWineValue.getAsh())
				maxWineValue.setAsh(wine.getAsh());

			if (wine.getAsh() < minWineValue.getAsh())
				minWineValue.setAsh(wine.getAsh());
			//
			if (wine.getAlcalinityOfAsh() > maxWineValue.getAlcalinityOfAsh())
				maxWineValue.setAlcalinityOfAsh(wine.getAlcalinityOfAsh());

			if (wine.getAlcalinityOfAsh() < minWineValue.getAlcalinityOfAsh())
				minWineValue.setAlcalinityOfAsh(wine.getAlcalinityOfAsh());
			//
			if (wine.getMagnesium() > maxWineValue.getMagnesium())
				maxWineValue.setMagnesium(wine.getMagnesium());

			if (wine.getMagnesium() < minWineValue.getMagnesium())
				minWineValue.setMagnesium(wine.getMagnesium());
			//
			if (wine.getFlavanoids() > maxWineValue.getFlavanoids())
				maxWineValue.setFlavanoids(wine.getFlavanoids());

			if (wine.getFlavanoids() < minWineValue.getFlavanoids())
				minWineValue.setFlavanoids(wine.getFlavanoids());
			//
			if (wine.getTotalPhenols() > maxWineValue.getTotalPhenols())
				maxWineValue.setTotalPhenols(wine.getTotalPhenols());

			if (wine.getTotalPhenols() < minWineValue.getTotalPhenols())
				minWineValue.setTotalPhenols(wine.getTotalPhenols());
			//
			if (wine.getNonflavanoidPhenols() > maxWineValue.getNonflavanoidPhenols())
				maxWineValue.setNonflavanoidPhenols(wine.getNonflavanoidPhenols());

			if (wine.getNonflavanoidPhenols() < minWineValue.getNonflavanoidPhenols())
				minWineValue.setNonflavanoidPhenols(wine.getNonflavanoidPhenols());
			//
			if (wine.getProanthocyanins() > maxWineValue.getProanthocyanins())
				maxWineValue.setProanthocyanins(wine.getProanthocyanins());

			if (wine.getProanthocyanins() < minWineValue.getProanthocyanins())
				minWineValue.setProanthocyanins(wine.getProanthocyanins());
			//
			if (wine.getColorIntensity() > maxWineValue.getColorIntensity())
				maxWineValue.setColorIntensity(wine.getColorIntensity());

			if (wine.getColorIntensity() < minWineValue.getColorIntensity())
				minWineValue.setColorIntensity(wine.getColorIntensity());
			//
			if (wine.getHue() > maxWineValue.getHue())
				maxWineValue.setHue(wine.getHue());

			if (wine.getHue() < minWineValue.getHue())
				minWineValue.setHue(wine.getHue());
			//
			if (wine.getDilutedWines() > maxWineValue.getDilutedWines())
				maxWineValue.setDilutedWines(wine.getDilutedWines());

			if (wine.getDilutedWines() < minWineValue.getDilutedWines())
				minWineValue.setDilutedWines(wine.getDilutedWines());
			//
			if (wine.getProline() > maxWineValue.getProline())
				maxWineValue.setProline(wine.getProline());

			if (wine.getProline() < minWineValue.getProline())
				minWineValue.setProline(wine.getProline());
			//
		}
	}

	public Wine getMaxWineValue()
	{
		return maxWineValue;
	}

	@SuppressWarnings("static-access")
	public void setMaxWineValue(Wine maxWineValue)
	{
		this.maxWineValue = maxWineValue;
	}

	private List<Double> getDecisionClassTeaching()
	{

		int ile1Teaching = 0;
		int ile2Teaching = 0;
		int ile3Teaching = 0;
		for (Wine wine : teachingList)
		{
			if (wine.getExceptedValue() == 1)
				ile1Teaching++;
			if (wine.getExceptedValue() == 2)
				ile2Teaching++;
			if (wine.getExceptedValue() == 3)
				ile3Teaching++;
		}
		List<Double> result = new ArrayList<>();
		result.add((double) (ile1Teaching) / teachingList.size());
		result.add((double) (ile2Teaching) / teachingList.size());
		result.add((double) (ile3Teaching) / teachingList.size());
		return result;
	}

	private List<Double> getDecisionClassTest()
	{

		int ile1Test = 0;
		int ile2Test = 0;
		int ile3Test = 0;

		for (Wine wine : testList)
		{
			if (wine.getExceptedValue() == 1)
				ile1Test++;
			if (wine.getExceptedValue() == 2)
				ile2Test++;
			if (wine.getExceptedValue() == 3)
				ile3Test++;
		}

		List<Double> result = new ArrayList<>();
		result.add((double) (ile1Test) / teachingList.size());
		result.add((double) (ile2Test) / teachingList.size());
		result.add((double) (ile3Test) / teachingList.size());
		return result;
	}

	public String getStringDecisionClassTeach()
	{
		List<Double> tmp = getDecisionClassTeaching();
		return "Decision class Teaching:\n\tClass: 1\t" + tmp.get(0) + "\n\tClass: 2\t" + tmp.get(1) + "\n\tClass: 3\t"
				+ tmp.get(2);
	}

	public String getStringDecisionClassTest()
	{
		List<Double> tmp = getDecisionClassTest();
		return "Decision class Testing:\n\tClass: 1\t" + tmp.get(0) + "\n\tClass: 2\t" + tmp.get(1) + "\n\tClass: 3\t"
				+ tmp.get(2);
	}

}