package com.gdu.quanlytuyensinh.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.gdu.quanlytuyensinh.controller.Controller;
import com.gdu.quanlytuyensinh.entity.Scores;
import com.gdu.quanlytuyensinh.entity.Student;
import com.gdu.quanlytuyensinh.model.Model;

import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTable tableAllStudent;
	private JTextField textFindStudent;

	
	public JTable getTableAllStudent() {
		return tableAllStudent;
	}

	public void setTableAllStudent(JTable tableAllStudent) {
		this.tableAllStudent = tableAllStudent;
	}

	/**
	 * Launch the application.
	 */
	public static void createHomeView()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setBackground(Color.WHITE);
		Controller controller = new Controller();
		Model model = new Model();
		List<Student> listStudent = model.getAllStudent();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 338);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(103, 46, 523, 208);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 94, 307, 114);
		panel.add(scrollPane);
		
		tableAllStudent = new JTable();
		tableAllStudent.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"H\u1ECD t\u00EAn", "L\u1EDBp"
			}
		));
		tableAllStudent.getColumnModel().getColumn(0).setPreferredWidth(129);
		scrollPane.setViewportView(tableAllStudent);
		DefaultTableModel defaultTableModel = (DefaultTableModel)tableAllStudent.getModel();
		Object rowData[] = new Object[2];
		for(Student s: listStudent)
		{
			rowData[0] = s.getFull_name();
			rowData[1] = s.getStudent_class().getClass_name();
			defaultTableModel.addRow(rowData);
		}
		textFindStudent = new JTextField();
		textFindStudent.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//filter
				String text = textFindStudent.getText();
				TableRowSorter<DefaultTableModel> rowSorter= new TableRowSorter<DefaultTableModel>(defaultTableModel);
				tableAllStudent.setRowSorter(rowSorter);
				rowSorter.setRowFilter(RowFilter.regexFilter(text));
				//JOptionPane.showMessageDialog(getParent(), "ok");
			}
		});
		textFindStudent.setBounds(125, 51, 307, 19);
		panel.add(textFindStudent);
		textFindStudent.setColumns(10);
	}
}
