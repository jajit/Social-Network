package project;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main {

	private JFrame frame;
	private JTextField searchBar;
	private PersonList people = new PersonList();
	private FriendList friends = new FriendList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		try {
			friends.initFriends();
			people.initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("InsertName"); // Network's name
		frame.setBounds(100, 100, 720, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 704, 442);
		frame.getContentPane().add(tabbedPane);

		/**
		 * Home tab
		 */
		final JPanel Home = new JPanel();
		tabbedPane.addTab("Home", null, Home, null);
		Home.setLayout(null);

		JFormattedTextField networkName = new JFormattedTextField();
		networkName.setEditable(false);
		networkName.setFont(new Font("Stencil", Font.BOLD, 30));
		networkName.setHorizontalAlignment(SwingConstants.CENTER);
		networkName.setText("Insert Name"); // Network's name
		networkName.setBounds(119, 11, 465, 87);
		Home.add(networkName);

		/**
		 * Names
		 */
		Label name1 = new Label("Andrea L\u00F3pez Figueroa");
		name1.setFont(new Font("Arial Black", Font.PLAIN, 17));
		name1.setBounds(471, 326, 205, 22);
		Home.add(name1);

		Label name2 = new Label("Andrea L\u00F3pez Rodr\u00EDguez");
		name2.setFont(new Font("Arial Black", Font.PLAIN, 17));
		name2.setBounds(471, 354, 218, 22);
		Home.add(name2);

		Label name3 = new Label("Ruben Naranjo de las Heras");
		name3.setFont(new Font("Arial Black", Font.PLAIN, 17));
		name3.setBounds(471, 382, 218, 22);
		Home.add(name3);

		/**
		 * People tab
		 */
		final JPanel People = new JPanel();
		tabbedPane.addTab("People", null, People, null);

		/**
		 * Search bar
		 */
		searchBar = new JTextField();
		searchBar.setBounds(79, 11, 263, 20);
		searchBar.setText("Write the identifier here...");
		searchBar.setToolTipText("");
		searchBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchBar.setText("");
				searchBar.setForeground(Color.BLACK);
				searchBar.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
			}
		});

		People.setLayout(null);
		searchBar.setForeground(Color.GRAY);
		searchBar.setFont(new Font("Lucida Sans", Font.ITALIC, 11));
		People.add(searchBar);
		searchBar.setColumns(10);

		JLabel searchText = new JLabel("Search:");
		searchText.setBounds(10, 14, 46, 14);
		People.add(searchText);

		/**
		 * People list
		 */
		JScrollPane peopleList = new JScrollPane();
		peopleList.setBounds(27, 60, 629, 321);
		People.add(peopleList);

		DefaultListModel<String> listModel = new DefaultListModel<String>();
		/* Populate the list here */
		listModel = people.populate();
		final JList<String> list = new JList<String>(listModel);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (!list.getValueIsAdjusting()) {
					PersonInfo.main(people.find(list.getSelectedIndex()));
				}
			}
		});
		peopleList.setViewportView(list);

		/**
		 * Add People button
		 */
		Button addPeople = new Button("Add people");
		addPeople.setBounds(455, 11, 114, 22);
		addPeople.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int choice = chooser.showOpenDialog(addPeople);
				if (choice != JFileChooser.APPROVE_OPTION)
					return;
				File chosenFile = chooser.getSelectedFile();
				try {
					people.updateList(chosenFile);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				listModel = people.populate();
				final JList<String> list = new JList<String>(listModel);
				list.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
						if (!list.getValueIsAdjusting()) {
							PersonInfo.main(people.find(list.getSelectedIndex()));
						}
					}
				});
				peopleList.setViewportView(list);
			}
		});
		People.add(addPeople);

		Button addFriends = new Button("Add relationships");
		addFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				int choice = chooser.showOpenDialog(addPeople);
				if (choice != JFileChooser.APPROVE_OPTION)
					return;
				File chosenFile = chooser.getSelectedFile();
				try {
					friends.updateFriends(chosenFile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		addFriends.setActionCommand("");
		addFriends.setBounds(575, 11, 114, 22);
		People.add(addFriends);

		/**
		 * Help tab
		 */
		final JPanel Help = new JPanel();
		tabbedPane.addTab("Help", null, Help, null);
		Help.setLayout(null);

		JLabel howToAddQ = new JLabel("How to add people to the network?");
		howToAddQ.setFont(new Font("Tahoma", Font.BOLD, 11));
		howToAddQ.setBounds(49, 43, 222, 14);
		Help.add(howToAddQ);

		JTextPane howToAddA = new JTextPane();
		howToAddA.setEditable(false);
		howToAddA.setBackground(UIManager.getColor("Button.background"));
		howToAddA.setText("Go to the tab \"People\" and press the \"Add people button\"."
				+ "Then select the file from which people is going to be added.");
		howToAddA.setBounds(49, 68, 640, 55);
		Help.add(howToAddA);
		People.setVisible(false);

	}

}
