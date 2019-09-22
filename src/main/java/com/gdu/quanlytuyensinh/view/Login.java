package com.gdu.quanlytuyensinh.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textMaSo;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void createFormLogin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setLocationRelativeTo(null);
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
	public Login() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 325);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelLeft = new JPanel() {
			ImageIcon icon = new ImageIcon("../QuanLyTuyenSinhJavaApplication/images/logo-dai-hoc-gia-dinh.png");
			public void paintComponent(Graphics g){ 
		        Dimension d = getSize(); 
		        g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);         
		        setOpaque(false);         
		        super.paintComponent(g);
			}
		};
		panelLeft.setBackground(new Color(30, 144, 255));
		panelLeft.setBounds(0, 0, 309, 297);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);

		JPanel panelRight = new JPanel();
		panelRight.setBackground(Color.WHITE);
		panelRight.setBounds(309, 0, 260, 285);
		contentPane.add(panelRight);
		panelRight.setLayout(null);

		textMaSo = new JTextField();
		textMaSo.setText("Nhập mã số");
		textMaSo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textMaSo.getText().equals("Nhập mã số"))
				textMaSo.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textMaSo.getText().length() == 0) {
					textMaSo.setText("Nhập mã số");
				}
			}
		});
		textMaSo.setHorizontalAlignment(SwingConstants.CENTER);
		textMaSo.setToolTipText("Nhập mã số");
		textMaSo.setFont(new Font("Dialog", Font.PLAIN, 13));
		textMaSo.setBounds(12, 70, 236, 28);
		panelRight.add(textMaSo);
		textMaSo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 51, 255)));
		textMaSo.setColumns(10);

		JLabel lblngNhp = new JLabel("Đăng nhập");
		lblngNhp.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblngNhp.setBounds(61, 12, 162, 28);
		panelRight.add(lblngNhp);

		txtPass = new JPasswordField("Nhập password");
		txtPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtPass.getText().length() == 0) {
					txtPass.setText("Nhập password");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if(txtPass.getText().equals("Nhập password"))
					txtPass.setText("");
			}
		});
		txtPass.setHorizontalAlignment(SwingConstants.CENTER);
		txtPass.setBounds(12, 149, 236, 28);
		txtPass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 51, 255)));
		panelRight.add(txtPass);
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textMaSo.getText().equals("Nhập mã số"))
				{
					JOptionPane.showMessageDialog(getParent(), "Vui lòng nhập mã số");
				}
				else if(new String(txtPass.getPassword()).equals("Nhập password"))
				{
					JOptionPane.showMessageDialog(getParent(), "Vui lòng nhập passworld");
				}
				else
				{
					JOptionPane.showMessageDialog(getParent(), txtPass.getPassword());
					String pass = new String(txtPass.getPassword());
				}
			}
		});
		Border emptyBorder = BorderFactory.createEmptyBorder();
		btnDangNhap.setBorder(emptyBorder);
		btnDangNhap.setBackground(new Color(0, 204, 255));
		btnDangNhap.setBounds(12, 224, 114, 25);
		panelRight.add(btnDangNhap);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.setBorder(emptyBorder);
		btnThoat.setBackground(new Color(0, 204, 255));
		btnThoat.setBounds(138, 224, 114, 25);
		panelRight.add(btnThoat);
		
		
	}
}
