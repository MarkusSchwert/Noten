import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MarkGui extends JFrame {
	public JLabel lblname, lblects, lblmark, lblweight, lblaverage;
	public JTextField name, ects, mark;
	public JCheckBox weight;
	public JButton btnAdd;
	public String average;
	

	private class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			double chmark = 0;
			int chects = 0;
			String chname = "";
			boolean chweight;
			Mark inputValidator = new Mark();
			inputValidator.validateInput();
			
			chweight = weight.isSelected();
			
			if(!mark.getText().isEmpty()){
				try {
					chmark = (double)Double.parseDouble(mark.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Geben Sie eine Zahl als Note ein", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Geben Sie eine Note ein", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
			if(!ects.getText().isEmpty()){
				try {
					chmark = (int)Integer.parseInt(ects.getText());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Das ist keine Zahl", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Geben Sie einen Zahlenwert ein", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
			if(name.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Geben Sie einen Veranstaltungsnamen ein", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else{
				chname = name.getText();
			}
			
			Mark newEntry = new Mark(chmark, chects, chname, chweight);
			Mark.NOTENLISTE.add(newEntry);
			average = "" + Mark.comuteMark();
			lblaverage.setText(average);
			Mark.printList();
		}

	}

	public MarkGui() {
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(500, 300);
		setTitle("Notenschnittberechnung");

		lblname = new JLabel("Veranstaltungsname");
		lblname.setBounds(10, 10, 150, 20);
		add(lblname);

		name = new JTextField();
		name.setBounds(10, 30, 80, 20);
		add(name);

		lblects = new JLabel("ECTS- Punkte");
		lblects.setBounds(10, 60, 150, 20);
		add(lblects);

		ects = new JTextField();
		ects.setBounds(10, 80, 80, 20);
		add(ects);

		lblmark = new JLabel("Endnote");
		lblmark.setBounds(10, 110, 150, 20);
		add(lblmark);

		mark = new JTextField();
		mark.setBounds(10, 130, 80, 20);
		add(mark);

		lblweight = new JLabel("Halbe Gewichtung");
		lblweight.setBounds(10, 160, 150, 20);
		add(lblweight);

		weight = new JCheckBox();
		weight.setBounds(10, 180, 20, 20);
		add(weight);

		btnAdd = new JButton("Hinzufügen");
		btnAdd.setBounds(10, 220, 150, 20);
		btnAdd.addActionListener(new MyActionListener());
		add(btnAdd);

		lblaverage = new JLabel(average);
		lblaverage.setBounds(400, 180, 50, 50);
		add(lblaverage);

		repaint();
	}

}
