import java.util.Arrays;

public class Wine {

	private int exceptedValue;
	private double[] exceptedValueTmp;

	private double alcohol;
	private double malicAcid;
	private double ash;
	private double alcalinityOfAsh;
	private double magnesium;
	private double totalPhenols;
	private double flavanoids;
	private double nonflavanoidPhenols;
	private double proanthocyanins;
	private double colorIntensity;
	private double hue;
	private double dilutedWines;
	private double proline;

	Wine() {
	}

	Wine(int exceptedValue, double alcohol, double malicAcid, double ash, double alcalinityOfAsh,
		 double magnesium, double totalPhenols, double flavanoids, double nonflavanoidPhenols,
		 double proanthocyanins, double colorIntensity, double hue, double dilutedWines, double proline) {
		super();
		this.exceptedValue = exceptedValue;
		this.alcohol = alcohol;
		this.malicAcid = malicAcid;
		this.ash = ash;
		this.alcalinityOfAsh = alcalinityOfAsh;
		this.magnesium = magnesium;
		this.totalPhenols = totalPhenols;
		this.flavanoids = flavanoids;
		this.nonflavanoidPhenols = nonflavanoidPhenols;
		this.proanthocyanins = proanthocyanins;
		this.colorIntensity = colorIntensity;
		this.hue = hue;
		this.dilutedWines = dilutedWines;
		this.proline = proline;
		if (exceptedValue == 1)
			exceptedValueTmp = new double[] { 1, 0, 0 };
		else if (exceptedValue == 2)
			exceptedValueTmp = new double[] { 0, 1, 0 };
		else
			exceptedValueTmp = new double[] { 0, 0, 1 };

	}

	double[] getAtributes() {
		return new double[]{ alcohol, malicAcid, ash, alcalinityOfAsh, magnesium, totalPhenols, flavanoids,
				nonflavanoidPhenols, proanthocyanins, colorIntensity, hue, dilutedWines, proline };
	}

	int getExceptedValue() {
		return exceptedValue;
	}

	double[] getExceptedValueTmp() {
		return exceptedValueTmp;
	}

	public void setExceptedValueTmp(double[] exceptedValue) {
		this.exceptedValueTmp = exceptedValue;
	}

	public void setExceptedValue(int exceptedValue) {
		this.exceptedValue = exceptedValue;
	}

	double getAlcohol() {
		return alcohol;
	}

	void setAlcohol(double alcohol) {
		this.alcohol = alcohol;
	}

	double getMalicAcid() {
		return malicAcid;
	}

	void setMalicAcid(double malicAcid) {
		this.malicAcid = malicAcid;
	}

	double getAsh() {
		return ash;
	}

	void setAsh(double ash) {
		this.ash = ash;
	}

	double getAlcalinityOfAsh() {
		return alcalinityOfAsh;
	}

	void setAlcalinityOfAsh(double alcalinityOfAsh) {
		this.alcalinityOfAsh = alcalinityOfAsh;
	}

	double getMagnesium() {
		return magnesium;
	}

	void setMagnesium(double magnesium) {
		this.magnesium = magnesium;
	}

	double getTotalPhenols() {
		return totalPhenols;
	}

	void setTotalPhenols(double totalPhenols) {
		this.totalPhenols = totalPhenols;
	}

	double getFlavanoids() {
		return flavanoids;
	}

	void setFlavanoids(double flavanoids) {
		this.flavanoids = flavanoids;
	}

	double getNonflavanoidPhenols() {
		return nonflavanoidPhenols;
	}

	void setNonflavanoidPhenols(double nonflavanoidPhenols) {
		this.nonflavanoidPhenols = nonflavanoidPhenols;
	}

	double getProanthocyanins() {
		return proanthocyanins;
	}

	void setProanthocyanins(double proanthocyanins) {
		this.proanthocyanins = proanthocyanins;
	}

	double getColorIntensity() {
		return colorIntensity;
	}

	void setColorIntensity(double colorIntensity) {
		this.colorIntensity = colorIntensity;
	}

	double getHue() {
		return hue;
	}

	void setHue(double hue) {
		this.hue = hue;
	}

	double getDilutedWines() {
		return dilutedWines;
	}

	void setDilutedWines(double dilutedWines) {
		this.dilutedWines = dilutedWines;
	}

	double getProline() {
		return proline;
	}

	void setProline(double proline) {
		this.proline = proline;
	}
	@Override
	public String toString()
	{
		return "Wine [exceptedValue=" + exceptedValue + ", exceptedValueTmp=" + Arrays.toString(exceptedValueTmp)
				+ ", alcohol=" + alcohol + ", malicAcid=" + malicAcid + ", ash=" + ash + ", alcalinityOfAsh="
				+ alcalinityOfAsh + ", magnesium=" + magnesium + ", totalPhenols=" + totalPhenols + ", flavanoids="
				+ flavanoids + ", nonflavanoidPhenols=" + nonflavanoidPhenols + ", proanthocyanins=" + proanthocyanins
				+ ", colorIntensity=" + colorIntensity + ", hue=" + hue + ", dilutedWines=" + dilutedWines
				+ ", proline=" + proline + "]";
	}

}
