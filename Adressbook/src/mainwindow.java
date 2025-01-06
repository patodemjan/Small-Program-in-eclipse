import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainwindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField birthyear;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainwindow frame = new mainwindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainwindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Frist name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 96, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblLastname = new JLabel("Lastname:");
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastname.setBounds(10, 45, 96, 23);
		contentPane.add(lblLastname);
		
		JLabel lblYearOfBirth = new JLabel("Year of birth:");
		lblYearOfBirth.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblYearOfBirth.setBounds(10, 79, 96, 23);
		contentPane.add(lblYearOfBirth);
		
		firstname = new JTextField();
		firstname.setBounds(116, 13, 275, 23);
		contentPane.add(firstname);
		firstname.setColumns(10);
		
		lastname = new JTextField();
		lastname.setColumns(10);
		lastname.setBounds(116, 47, 275, 23);
		contentPane.add(lastname);
		
		birthyear = new JTextField();
		birthyear.setColumns(10);
		birthyear.setBounds(116, 79, 275, 23);
		contentPane.add(birthyear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 113, 536, 272);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model=new DefaultTableModel();
		Object [] column= {"first name", "last name", "year"};
		Object [] row= new Object[3];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		//add new name to table 
		
		JButton add = new JButton("add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row[0]=firstname.getText();
				row[1]=lastname.getText();
				row[2]=birthyear.getText();
				model.addRow(row);
			}
		});
		
		//////////////////////////
		
		add.setBounds(401, 13, 133, 21);
		contentPane.add(add);
		
		// delete selected row from table
		
		JButton delete = new JButton("delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				model.removeRow(i);
			}
		});
		delete.setBounds(401, 47, 133, 21);
		contentPane.add(delete);
		/////////////////////////////
		
		
		// clean textfields 
		
		JButton clean = new JButton("clean");
		clean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			firstname.setText("");	
			lastname.setText("");	
			birthyear.setText("");	
			}
		});
		clean.setBounds(401, 81, 133, 21);
		contentPane.add(clean);
		
		/////////////////// 
		
		// exit the program
		
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		exit.setBounds(413, 401, 133, 21);
		contentPane.add(exit);
		
		//////////////////
	}
}
