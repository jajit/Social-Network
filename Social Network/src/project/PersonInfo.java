package project;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Button;

public class PersonInfo {

	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldSurnames;
	private JTextField textFieldBirthdate;
	private JTextField textFieldBirthplace;
	private JTextField textFieldHome;
	private JTextField textFieldStudy;
	private JTextField textFieldGender;
	private JTextField textFieldWork;
	private JTextField textFieldGroup;
	private JTextField textFieldId;

	/**
	 * Launch the application.
	 */
	public static void main(Person P) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonInfo window = new PersonInfo(P);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PersonInfo(Person P) {
		initialize(P);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Person P) {
		frame = new JFrame();
		frame.setTitle(P.getIdentifier());
		frame.setBounds(100, 100, 750, 250);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 734, 211);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 10, 46, 14);
		panel.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setText(P.getName());
		textFieldName.setBorder(null);
		textFieldName.setEditable(false);
		textFieldName.setBounds(98, 7, 191, 20);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblSurnames = new JLabel("Surnames:");
		lblSurnames.setBounds(10, 40, 86, 14);
		panel.add(lblSurnames);
		
		textFieldSurnames = new JTextField();
		textFieldSurnames.setText(P.getSurnames());
		textFieldSurnames.setBorder(null);
		textFieldSurnames.setEditable(false);
		textFieldSurnames.setColumns(10);
		textFieldSurnames.setBounds(99, 37, 191, 20);
		panel.add(textFieldSurnames);
		
		JLabel lblBirthdate = new JLabel("Birthdate:");
		lblBirthdate.setBounds(10, 70, 97, 14);
		panel.add(lblBirthdate);
		
		textFieldBirthdate = new JTextField();
		textFieldBirthdate.setText(P.getBirthdate());
		textFieldBirthdate.setBorder(null);
		textFieldBirthdate.setEditable(false);
		textFieldBirthdate.setColumns(10);
		textFieldBirthdate.setBounds(99, 67, 191, 20);
		panel.add(textFieldBirthdate);
		
		JLabel lblBirthplace = new JLabel("Birthplace:");
		lblBirthplace.setBounds(10, 100, 69, 14);
		panel.add(lblBirthplace);
		
		textFieldBirthplace = new JTextField();
		textFieldBirthplace.setText(P.getBirthplace());
		textFieldBirthplace.setBorder(null);
		textFieldBirthplace.setEditable(false);
		textFieldBirthplace.setColumns(10);
		textFieldBirthplace.setBounds(99, 97, 191, 20);
		panel.add(textFieldBirthplace);
		
		JLabel lblHome = new JLabel("Home:");
		lblHome.setBounds(10, 130, 46, 14);
		panel.add(lblHome);
		
		textFieldHome = new JTextField();
		textFieldHome.setText(P.getHome());
		textFieldHome.setBorder(null);
		textFieldHome.setEditable(false);
		textFieldHome.setColumns(10);
		textFieldHome.setBounds(99, 127, 191, 20);
		panel.add(textFieldHome);
		
		JLabel lblStudied = new JLabel("Studied at:");
		lblStudied.setBounds(10, 160, 69, 14);
		panel.add(lblStudied);
		
		textFieldStudy = new JTextField();
		textFieldStudy.setText(P.getStudiedAt());
		textFieldStudy.setBorder(null);
		textFieldStudy.setEditable(false);
		textFieldStudy.setColumns(10);
		textFieldStudy.setBounds(98, 157, 348, 20);
		panel.add(textFieldStudy);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(300, 10, 46, 14);
		panel.add(lblGender);
		
		textFieldGender = new JTextField();
		textFieldGender.setText(P.getGender());
		textFieldGender.setBorder(null);
		textFieldGender.setEditable(false);
		textFieldGender.setColumns(10);
		textFieldGender.setBounds(406, 7, 86, 20);
		panel.add(textFieldGender);
		
		JLabel lblWork = new JLabel("Worked at:");
		lblWork.setBounds(300, 40, 69, 14);
		panel.add(lblWork);
		
		textFieldWork = new JTextField();
		textFieldWork.setText(P.getWorkedAt());
		textFieldWork.setBorder(null);
		textFieldWork.setEditable(false);
		textFieldWork.setColumns(10);
		textFieldWork.setBounds(406, 37, 318, 20);
		panel.add(textFieldWork);
		
		JLabel lblFilms = new JLabel("Favourite movies:");
		lblFilms.setBounds(300, 70, 122, 14);
		panel.add(lblFilms);
		
		JTextPane textPaneFilms = new JTextPane();
		textPaneFilms.setText(P.getMovies());
		textPaneFilms.setBackground(SystemColor.control);
		textPaneFilms.setEditable(false);
		textPaneFilms.setBounds(406, 66, 318, 48);
		panel.add(textPaneFilms);
		
		JLabel lblGroup = new JLabel("Group code:");
		lblGroup.setBounds(546, 130, 69, 14);
		panel.add(lblGroup);
		
		textFieldGroup = new JTextField();
		textFieldGroup.setText(P.getGroupCode());
		textFieldGroup.setBorder(null);
		textFieldGroup.setEditable(false);
		textFieldGroup.setColumns(10);
		textFieldGroup.setBounds(625, 127, 86, 20);
		panel.add(textFieldGroup);
		
		JLabel lblId = new JLabel("Identifier:");
		lblId.setBounds(300, 130, 80, 14);
		panel.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setText(P.getIdentifier());
		textFieldId.setBorder(null);
		textFieldId.setEditable(false);
		textFieldId.setColumns(10);
		textFieldId.setBounds(369, 127, 86, 20);
		panel.add(textFieldId);
	}
}
