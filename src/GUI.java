import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.Component;
import java.awt.Color;

public class GUI extends JFrame
{

	private ImagePanel contentPane;
	private JTextField textFieldNonflavanoid;
	private JTextField textFieldFlavanoids;
	private JTextField textFieldPhenols;
	private JTextField textFieldMagnesium;
	private JTextField textFieldAlcalinityAsh;
	private JTextField textFieldAsh;
	private JTextField textFieldAlcohol;
	private JTextField textFieldAcid;
	private JTextField textFieldProline;
	private JTextField textFieldOD280;
	private JTextField textFieldHue;
	private JTextField textFieldColor;
	private JTextField textFieldProanthocyanins;
	private JTextField textFieldLayers;
	private JButton btnStartTeaching;
	private JButton btnCheckEfficiency;
	private JButton btnCheckYoursValue;
	private JLabel lblLayers;
	private JLabel lblRatio;
	private JTextField textFieldRatio;
	private JLabel lblParametrs;
	private JTextField textFieldPath;
	private JButton btnOpenFile;
	private JTextField textFieldSteps;
	private JScrollPane scroll;
	private JTextArea display;
	private JButton btnCheckYoursValueLine;
	Network network;
	File file;
	private JTextField textFieldLineValues;

	public GUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 587);
		contentPane = new ImagePanel(new ImageIcon("images/image.jpeg").getImage());
		contentPane.setBackground(new Color(255, 127, 80));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMalicAcid = new JLabel("Malic acid");
		lblMalicAcid.setForeground(new Color(255, 255, 255));
		lblMalicAcid.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMalicAcid.setBounds(10, 70, 73, 14);
		contentPane.add(lblMalicAcid);

		JLabel lblAsh = new JLabel("Ash");
		lblAsh.setForeground(new Color(255, 255, 255));
		lblAsh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAsh.setBounds(10, 95, 42, 14);
		contentPane.add(lblAsh);

		JLabel lblAlcali = new JLabel("Alcalinity of ash");
		lblAlcali.setForeground(new Color(255, 255, 255));
		lblAlcali.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAlcali.setBounds(10, 120, 124, 14);
		contentPane.add(lblAlcali);

		JLabel lblMagnesium = new JLabel("Magnesium");
		lblMagnesium.setForeground(new Color(255, 255, 255));
		lblMagnesium.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMagnesium.setBounds(10, 145, 124, 14);
		contentPane.add(lblMagnesium);

		JLabel lblAlkohol = new JLabel("Alkohol");
		lblAlkohol.setForeground(new Color(255, 255, 255));
		lblAlkohol.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAlkohol.setBounds(10, 45, 60, 14);
		contentPane.add(lblAlkohol);

		JLabel lblTotalPhenols = new JLabel("Total phenols");
		lblTotalPhenols.setForeground(new Color(255, 255, 255));
		lblTotalPhenols.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalPhenols.setBounds(10, 170, 86, 14);
		contentPane.add(lblTotalPhenols);

		JLabel lblFlavanoids = new JLabel("Flavanoids");
		lblFlavanoids.setForeground(new Color(255, 255, 255));
		lblFlavanoids.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFlavanoids.setBounds(10, 195, 73, 14);
		contentPane.add(lblFlavanoids);

		JLabel lblNonflavanoidPhenols = new JLabel("Nonflavanoid phenols");
		lblNonflavanoidPhenols.setForeground(new Color(255, 255, 255));
		lblNonflavanoidPhenols.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNonflavanoidPhenols.setBounds(10, 220, 148, 14);
		contentPane.add(lblNonflavanoidPhenols);

		JLabel lblProanthocyanins = new JLabel("Proanthocyanins");
		lblProanthocyanins.setForeground(new Color(255, 255, 255));
		lblProanthocyanins.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProanthocyanins.setBounds(10, 245, 111, 14);
		contentPane.add(lblProanthocyanins);

		JLabel lblColorIntensity = new JLabel("Color intensity");
		lblColorIntensity.setForeground(new Color(255, 255, 255));
		lblColorIntensity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblColorIntensity.setBounds(10, 270, 104, 14);
		contentPane.add(lblColorIntensity);

		JLabel lblHue = new JLabel("Hue");
		lblHue.setForeground(new Color(255, 255, 255));
		lblHue.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHue.setBounds(10, 295, 36, 14);
		contentPane.add(lblHue);

		JLabel lblOdodOfDiluted = new JLabel("OD280/OD315");
		lblOdodOfDiluted.setForeground(new Color(255, 255, 255));
		lblOdodOfDiluted.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOdodOfDiluted.setBounds(10, 320, 96, 14);
		contentPane.add(lblOdodOfDiluted);

		JLabel lblProline = new JLabel("Proline");
		lblProline.setForeground(new Color(255, 255, 255));
		lblProline.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProline.setBounds(10, 345, 60, 14);
		contentPane.add(lblProline);

		JLabel lblLearingSteps = new JLabel("Learing steps");
		lblLearingSteps.setForeground(new Color(255, 255, 255));
		lblLearingSteps.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLearingSteps.setBounds(278, 120, 86, 14);
		contentPane.add(lblLearingSteps);

		btnStartTeaching = new JButton("Start teaching");
		btnStartTeaching.setEnabled(false);
		btnStartTeaching.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					String[] layers = textFieldLayers.getText().split(",");
					int[] layersInt = new int[layers.length];
					for (int i = 0; i < layers.length; i++)
					{
						layersInt[i] = Integer.parseInt(layers[i]);
					}
					double ratio = Double.parseDouble(textFieldRatio.getText());
					Integer learningSteps = Integer.parseInt(textFieldSteps.getText());
					textFieldAlcohol.setEditable(true);
					textFieldAcid.setEditable(true);
					textFieldAsh.setEditable(true);
					textFieldAlcalinityAsh.setEditable(true);
					textFieldMagnesium.setEditable(true);
					textFieldPhenols.setEditable(true);
					textFieldFlavanoids.setEditable(true);
					textFieldNonflavanoid.setEditable(true);
					textFieldProanthocyanins.setEditable(true);
					textFieldColor.setEditable(true);
					textFieldHue.setEditable(true);
					textFieldOD280.setEditable(true);
					textFieldProline.setEditable(true);
					btnCheckYoursValue.setEnabled(true);
					btnCheckEfficiency.setEnabled(true);
					btnCheckYoursValueLine.setEnabled(true);
					network = new Network(layersInt, ratio, file, learningSteps);
					network.startTeaching();
				} catch (NumberFormatException e)
				{
					JOptionPane.showMessageDialog(contentPane, "Wrong parameter format", "Wrong",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnStartTeaching.setBounds(245, 159, 166, 39);
		contentPane.add(btnStartTeaching);

		btnCheckEfficiency = new JButton("Check for test");
		btnCheckEfficiency.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				network.checkForTest(display);
			}
		});
		btnCheckEfficiency.setEnabled(false);
		btnCheckEfficiency.setBounds(245, 209, 166, 39);
		contentPane.add(btnCheckEfficiency);

		btnCheckYoursValue = new JButton("Check yours value");
		btnCheckYoursValue.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Wine wineToTest = new Wine();
					wineToTest.setAlcohol(Double.parseDouble(textFieldAlcohol.getText()));
					wineToTest.setMalicAcid(Double.parseDouble(textFieldAcid.getText()));
					wineToTest.setAsh(Double.parseDouble(textFieldAsh.getText()));
					wineToTest.setAlcalinityOfAsh(Double.parseDouble(textFieldAlcalinityAsh.getText()));
					wineToTest.setMagnesium(Double.parseDouble(textFieldMagnesium.getText()));
					wineToTest.setTotalPhenols(Double.parseDouble(textFieldPhenols.getText()));
					wineToTest.setFlavanoids(Double.parseDouble(textFieldFlavanoids.getText()));
					wineToTest.setNonflavanoidPhenols(Double.parseDouble(textFieldNonflavanoid.getText()));
					wineToTest.setProanthocyanins(Double.parseDouble(textFieldProanthocyanins.getText()));
					wineToTest.setColorIntensity(Double.parseDouble(textFieldColor.getText()));
					wineToTest.setHue(Double.parseDouble(textFieldHue.getText()));
					wineToTest.setDilutedWines(Double.parseDouble(textFieldOD280.getText()));
					wineToTest.setProline(Double.parseDouble(textFieldProline.getText()));
					Wines.attributeNormalizationOneWine(wineToTest);
					int result = network.checkYourValue(wineToTest.getAtributes()); 
					display.append("Network answer " + result + "\n");
				} catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(contentPane, "Wrong number format", "Wrong",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnCheckYoursValue.setEnabled(false);
		btnCheckYoursValue.setBounds(245, 259, 166, 39);
		contentPane.add(btnCheckYoursValue);

		textFieldNonflavanoid = new JTextField();
		textFieldNonflavanoid.setEditable(false);
		textFieldNonflavanoid.setBounds(149, 218, 86, 20);
		contentPane.add(textFieldNonflavanoid);
		textFieldNonflavanoid.setColumns(10);

		textFieldFlavanoids = new JTextField();
		textFieldFlavanoids.setEditable(false);
		textFieldFlavanoids.setColumns(10);
		textFieldFlavanoids.setBounds(149, 193, 86, 20);
		contentPane.add(textFieldFlavanoids);

		textFieldPhenols = new JTextField();
		textFieldPhenols.setEditable(false);
		textFieldPhenols.setColumns(10);
		textFieldPhenols.setBounds(149, 168, 86, 20);
		contentPane.add(textFieldPhenols);

		textFieldMagnesium = new JTextField();
		textFieldMagnesium.setEditable(false);
		textFieldMagnesium.setColumns(10);
		textFieldMagnesium.setBounds(149, 143, 86, 20);
		contentPane.add(textFieldMagnesium);

		textFieldAlcalinityAsh = new JTextField();
		textFieldAlcalinityAsh.setEditable(false);
		textFieldAlcalinityAsh.setColumns(10);
		textFieldAlcalinityAsh.setBounds(149, 118, 86, 20);
		contentPane.add(textFieldAlcalinityAsh);

		textFieldAsh = new JTextField();
		textFieldAsh.setEditable(false);
		textFieldAsh.setColumns(10);
		textFieldAsh.setBounds(149, 93, 86, 20);
		contentPane.add(textFieldAsh);

		textFieldAlcohol = new JTextField();
		textFieldAlcohol.setEditable(false);
		textFieldAlcohol.setColumns(10);
		textFieldAlcohol.setBounds(149, 43, 86, 20);
		contentPane.add(textFieldAlcohol);

		textFieldAcid = new JTextField();
		textFieldAcid.setEditable(false);
		textFieldAcid.setColumns(10);
		textFieldAcid.setBounds(149, 68, 86, 20);
		contentPane.add(textFieldAcid);

		textFieldProline = new JTextField();
		textFieldProline.setEditable(false);
		textFieldProline.setColumns(10);
		textFieldProline.setBounds(149, 343, 86, 20);
		contentPane.add(textFieldProline);

		textFieldOD280 = new JTextField();
		textFieldOD280.setEditable(false);
		textFieldOD280.setColumns(10);
		textFieldOD280.setBounds(149, 318, 86, 20);
		contentPane.add(textFieldOD280);

		textFieldHue = new JTextField();
		textFieldHue.setEditable(false);
		textFieldHue.setColumns(10);
		textFieldHue.setBounds(149, 293, 86, 20);
		contentPane.add(textFieldHue);

		textFieldColor = new JTextField();
		textFieldColor.setEditable(false);
		textFieldColor.setColumns(10);
		textFieldColor.setBounds(149, 268, 86, 20);
		contentPane.add(textFieldColor);

		textFieldProanthocyanins = new JTextField();
		textFieldProanthocyanins.setEditable(false);
		textFieldProanthocyanins.setColumns(10);
		textFieldProanthocyanins.setBounds(149, 245, 86, 20);
		contentPane.add(textFieldProanthocyanins);

		textFieldLayers = new JTextField();
		textFieldLayers.setEditable(false);
		textFieldLayers.setBounds(359, 68, 52, 20);
		contentPane.add(textFieldLayers);
		textFieldLayers.setColumns(10);

		lblParametrs = new JLabel("Parametrs");
		lblParametrs.setForeground(new Color(255, 255, 255));
		lblParametrs.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblParametrs.setBounds(283, 44, 96, 14);
		contentPane.add(lblParametrs);

		lblLayers = new JLabel("Layers");
		lblLayers.setForeground(new Color(255, 255, 255));
		lblLayers.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLayers.setBounds(278, 70, 60, 14);
		contentPane.add(lblLayers);

		lblRatio = new JLabel("Ratio");
		lblRatio.setForeground(new Color(255, 255, 255));
		lblRatio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRatio.setBounds(278, 95, 60, 14);
		contentPane.add(lblRatio);

		textFieldSteps = new JTextField();
		textFieldSteps.setEditable(false);
		textFieldSteps.setColumns(10);
		textFieldSteps.setBounds(359, 118, 52, 20);
		contentPane.add(textFieldSteps);

		textFieldRatio = new JTextField();
		textFieldRatio.setEditable(false);
		textFieldRatio.setColumns(10);
		textFieldRatio.setBounds(359, 93, 52, 20);
		contentPane.add(textFieldRatio);

		textFieldPath = new JTextField();
		textFieldPath.setEditable(false);
		textFieldPath.setBounds(97, 12, 314, 20);
		contentPane.add(textFieldPath);
		textFieldPath.setColumns(10);

		btnOpenFile = new JButton("Open File");
		btnOpenFile.addActionListener(new ActionListener()
		{

	public void actionPerformed(ActionEvent arg0)
			{
				JFileChooser chooser = new JFileChooser();
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				{
					file = chooser.getSelectedFile();
					String fileName = file.getAbsolutePath();
					textFieldPath.setText(fileName);
					textFieldLayers.setEditable(true);
					textFieldRatio.setEditable(true);
					textFieldSteps.setEditable(true);
					btnStartTeaching.setEnabled(true);
				} else
				{
					JOptionPane.showMessageDialog(contentPane, "No selection", "Wrong", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnOpenFile.setBounds(7, 11, 89, 23);
		contentPane.add(btnOpenFile);

		textFieldLineValues = new JTextField();
		textFieldLineValues.setBounds(10, 370, 401, 20);
		contentPane.add(textFieldLineValues);
		textFieldLineValues.setColumns(10);

		display = new JTextArea(2, 6);
		display.setEditable(false);

		JLabel lblInfo = new JLabel("Info");
		lblInfo.setForeground(new Color(0, 0, 0));
		lblInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInfo.setBounds(10, 396, 60, 14);
		contentPane.add(lblInfo);

		JScrollPane scrollPane = new JScrollPane(display);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 421, 401, 116);
		contentPane.add(scrollPane);

		btnCheckYoursValueLine = new JButton("Check yours value line");
		btnCheckYoursValueLine.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
				double[] data = Arrays.stream(textFieldLineValues.getText().split(","))
						.mapToDouble(Double::parseDouble).toArray();
				Wine wineToTest = new Wine((int)data[0], data[1], data[2],
						data[3], data[4], data[5],
						data[6], data[7], data[8],
						data[9], data[10], data[11],
						data[12], data[13]);
				Wines.attributeNormalizationOneWine(wineToTest);
				Integer result = network.checkYourValue(wineToTest.getAtributes());
				display.append("Expected value " + wineToTest.getExceptedValue() + " network answer " + result + "\n");
			}
		});
		btnCheckYoursValueLine.setEnabled(false);
		btnCheckYoursValueLine.setBounds(245, 309, 166, 39);
		contentPane.add(btnCheckYoursValueLine);

		//
		display.append("Start" + "\n");
	}
}
