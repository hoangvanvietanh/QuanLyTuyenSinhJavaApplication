package com.gdu.quanlytuyensinh.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.gdu.quanlytuyensinh.controller.Controller;
import com.gdu.quanlytuyensinh.entity.Student;
import com.gdu.quanlytuyensinh.entity.StudentClass;
import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class AddStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textHoTen;
	private JTextField textNoiSinh;
	private JTextField textCMND;
	private JTextField textDiaChi;
	private JTextField textNgayDangKy;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public void createFormAddStudent()
	{
		try {
			AddStudent frame = new AddStudent();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	/**
	 * Create the frame.
	 */
	public AddStudent() {
		Date dateNow = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 399);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(12, 0, 445, 359);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JDateChooser txtDateChoseNgaySinh = new JDateChooser();
		txtDateChoseNgaySinh.setDateFormatString("dd/MM/yyyy");;
		txtDateChoseNgaySinh.setDate(dateNow);
		txtDateChoseNgaySinh.setBounds(120, 82, 255, 22);
		panel_1.add(txtDateChoseNgaySinh);
		
		JLabel lblTitle = new JLabel("Thông tin sinh viên");
		lblTitle.setBounds(165, 12, 144, 32);
		panel_1.add(lblTitle);
		
		JLabel lblHoTen = new JLabel("Họ tên");
		lblHoTen.setBounds(12, 58, 66, 15);
		panel_1.add(lblHoTen);
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setBounds(12, 89, 82, 15);
		panel_1.add(lblNgaySinh);
		
		JLabel lblNoiSinh = new JLabel("Nơi sinh");
		lblNoiSinh.setBounds(12, 144, 66, 15);
		panel_1.add(lblNoiSinh);
		
		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setBounds(12, 196, 66, 15);
		panel_1.add(lblCmnd);
		
		JLabel lblNganhHoc = new JLabel("Ngành học");
		lblNganhHoc.setBounds(12, 223, 82, 15);
		panel_1.add(lblNganhHoc);
		
		textHoTen = new JTextField();
		textHoTen.setBounds(120, 56, 255, 19);
		panel_1.add(textHoTen);
		textHoTen.setColumns(10);
		
		textNoiSinh = new JTextField();
		textNoiSinh.setBounds(120, 140, 255, 19);
		panel_1.add(textNoiSinh);
		textNoiSinh.setColumns(10);
		
		textCMND = new JTextField();
		textCMND.setBounds(120, 188, 255, 19);
		panel_1.add(textCMND);
		textCMND.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(386, 42, -308, 2);
		panel_1.add(separator);
		
		JLabel lblGioTinh = new JLabel("Giới tính");
		lblGioTinh.setBounds(12, 168, 66, 15);
		panel_1.add(lblGioTinh);
		
		JRadioButton rdbtnNam = new JRadioButton("Nam");
		buttonGroup.add(rdbtnNam);
		rdbtnNam.setSelected(true);
		rdbtnNam.setBounds(120, 162, 138, 23);
		panel_1.add(rdbtnNam);
		
		JRadioButton rdbtnNu = new JRadioButton("Nữ");
		buttonGroup.add(rdbtnNu);
		rdbtnNu.setBounds(262, 162, 113, 24);
		panel_1.add(rdbtnNu);
		
		JComboBox cbNganhHoc = new JComboBox();
		cbNganhHoc.setModel(new DefaultComboBoxModel(new String[] {"Công nghệ thông tin", "Quản trị kinh doanh", "Ngôn ngữ Anh", "Ngôn ngữ Nhật"}));
		cbNganhHoc.setBounds(120, 216, 255, 24);
		panel_1.add(cbNganhHoc);
		
		JLabel lblChuyenNganh = new JLabel("Chuyên ngành");
		lblChuyenNganh.setBounds(12, 254, 105, 15);
		panel_1.add(lblChuyenNganh);
		
		JComboBox cbChuyenNganh = new JComboBox();
		cbChuyenNganh.setModel(new DefaultComboBoxModel(new String[] {"Kỹ thuật phần mềm", "Mạng máy tính"}));
		cbChuyenNganh.setBounds(120, 249, 255, 24);
		panel_1.add(cbChuyenNganh);
		
		JButton btnDongY = new JButton("Đồng ý");
		btnDongY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
					Student student = new Student();
					student.setFull_name(textHoTen.getText());
					student.setAddress(textDiaChi.getText());
					
					student.setDate_of_birth(dateFormat.format(txtDateChoseNgaySinh.getDate()));
					
					student.setIdentity_card_number(textCMND.getText());
					student.setPassword(textCMND.getText());
					student.setPlace_of_birth(textNoiSinh.getText());
					if(rdbtnNam.isSelected())
					{
						student.setSex("Nam");
					}
					else
					{
						student.setSex("Nữ");
					}
					StudentClass studentClass = new StudentClass();
					studentClass.setFaculty(cbNganhHoc.getSelectedItem().toString());
					studentClass.setMajor(cbChuyenNganh.getSelectedItem().toString());
					student.setStudent_class(studentClass);
					student.setStatus("Đăng ký");
					
				    
					student.setRegistration_date(textNgayDangKy.getText());
					Controller controller = new Controller();
					controller.insertStudent(student);
					JOptionPane.showMessageDialog(getParent(), dateFormat.format(txtDateChoseNgaySinh.getDate()));
				
			}
		});
		btnDongY.setBounds(49, 322, 114, 25);
		panel_1.add(btnDongY);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		btnHuy.setBounds(261, 322, 114, 25);
		panel_1.add(btnHuy);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setBounds(12, 111, 66, 15);
		panel_1.add(lblDiaChi);
		
		textDiaChi = new JTextField();
		textDiaChi.setBounds(120, 109, 255, 19);
		panel_1.add(textDiaChi);
		textDiaChi.setColumns(10);
		
		JLabel lblNgayDangKy = new JLabel("Ngày đăng ký");
		lblNgayDangKy.setBounds(12, 281, 105, 15);
		panel_1.add(lblNgayDangKy);
		
		textNgayDangKy = new JTextField();
		textNgayDangKy.setEditable(false);
		textNgayDangKy.setBounds(120, 279, 255, 19);
		panel_1.add(textNgayDangKy);
	    textNgayDangKy.setText(dateFormat.format(dateNow));
		textNgayDangKy.setColumns(10);
	}
}
