package Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;

public class Info extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

	private JPanel contentPane, TitlePane;
	private JTextArea txtrTest;
	private JTextArea txtrTest_1;
	private JTextArea txtrTest_2;
	private JLabel ExitButton;
	private int tx, ty;
	private JPanel MainPane;
	private JLabel TitleLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Info frame = new Info();
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
	public Info() {
		setBounds(100, 100, 301, 370);
		setLocation(390,200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setUndecorated(true);
		contentPane.setLayout(null);
		setVisible(true);
		
		MainPane = new GraPanel();
		MainPane.setLayout(null);
		MainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		MainPane.setBackground(new Color(30, 144, 255));
		MainPane.setBounds(0, 0, 301, 370);
		contentPane.add(MainPane);
		
		TitlePane = new JPanel();
		TitlePane.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		TitlePane.addMouseListener(this);
		TitlePane.addMouseMotionListener(this);
		TitlePane.setLayout(null);
		TitlePane.setBackground(new Color(0,0,0,0));
		TitlePane.setBounds(0, 0, 301, 58);
		MainPane.add(TitlePane);
		
		TitleLabel = new JLabel("내 정보");
		TitleLabel.setForeground(new Color(255, 255, 255));
		TitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		TitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 26));
		TitleLabel.setBounds(20, 6, 162, 46);
		TitlePane.add(TitleLabel);
		
		ExitButton = new JLabel("");
		ExitButton.addMouseListener(this);
		ExitButton.setIcon(new ImageIcon(Info.class.getResource("/Image/close.png")));
		ExitButton.setFocusable(false);
		ExitButton.setBackground(new Color(135, 206, 250));
		ExitButton.setBounds(258, 6, 31, 23);
		TitlePane.add(ExitButton);
		
		txtrTest = new JTextArea();
		txtrTest.setForeground(new Color(255, 255, 255));
		txtrTest.setText("TEST");
		txtrTest.setEditable(false);
		txtrTest.setToolTipText("ID");
		txtrTest.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		txtrTest.setColumns(10);
		txtrTest.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		txtrTest.setBackground(new Color(0,0,0,0));
		txtrTest.setBounds(121, 84, 130, 26);
		MainPane.add(txtrTest);
		
		txtrTest_1 = new JTextArea();
		txtrTest_1.setForeground(new Color(255, 255, 255));
		txtrTest_1.setFont(new Font("Dialog", Font.BOLD, 15));
		txtrTest_1.setText("TEST");
		txtrTest_1.setEditable(false);
		txtrTest_1.setToolTipText("ID");
		txtrTest_1.setColumns(10);
		txtrTest_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		txtrTest_1.setBackground(new Color(0,0,0,0));
		txtrTest_1.setBounds(121, 140, 130, 26);
		MainPane.add(txtrTest_1);
		
		txtrTest_2 = new JTextArea();
		txtrTest_2.setForeground(new Color(255, 255, 255));
		txtrTest_2.setText("TEST");
		txtrTest_2.setEditable(false);
		txtrTest_2.setToolTipText("TEL");
		txtrTest_2.setFont(new Font("Dialog", Font.BOLD, 15));
		txtrTest_2.setColumns(10);
		txtrTest_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		txtrTest_2.setBackground(new Color(0,0,0,0));
		txtrTest_2.setBounds(121, 208, 130, 26);
		MainPane.add(txtrTest_2);
		
		JLabel IdLabel = new JLabel("*아이디");
		IdLabel.setForeground(new Color(255, 255, 255));
		IdLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		IdLabel.setBounds(21, 141, 88, 16);
		MainPane.add(IdLabel);
		
		JLabel TelLabel = new JLabel("*전화번호");
		TelLabel.setForeground(new Color(255, 255, 255));
		TelLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		TelLabel.setBounds(21, 208, 88, 16);
		MainPane.add(TelLabel);
		
		JRadioButton man = new JRadioButton("");
		man.setEnabled(false);
		man.setHorizontalAlignment(SwingConstants.CENTER);
		man.setFont(new Font("Dialog", Font.BOLD, 14));
		man.setFocusable(false);
		man.setBackground(new Color(0,0,0,0));
		man.setBounds(179, 271, 27, 23);
		MainPane.add(man);
		
		JRadioButton wo = new JRadioButton("");
		wo.setEnabled(false);
		wo.setHorizontalAlignment(SwingConstants.CENTER);
		wo.setFont(new Font("Dialog", Font.BOLD, 14));
		wo.setFocusable(false);
		wo.setBackground(new Color(0,0,0,0));
		wo.setBounds(179, 300, 27, 23);
		MainPane.add(wo);
		
		JLabel NameLabel = new JLabel("* 성함");
		NameLabel.setForeground(new Color(255, 255, 255));
		NameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		NameLabel.setBounds(21, 87, 88, 16);
		MainPane.add(NameLabel);
		
		JLabel SexLabel = new JLabel("*성별");
		SexLabel.setForeground(new Color(255, 255, 255));
		SexLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		SexLabel.setBounds(31, 278, 59, 16);
		MainPane.add(SexLabel);
		
		JLabel Sex_man = new JLabel("남성");
		Sex_man.setForeground(new Color(255, 255, 255));
		Sex_man.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		Sex_man.setBounds(122, 271, 45, 16);
		MainPane.add(Sex_man);
		
		JLabel Sex_wo = new JLabel("여성");
		Sex_wo.setForeground(new Color(255, 255, 255));
		Sex_wo.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		Sex_wo.setBounds(122, 301, 45, 16);
		MainPane.add(Sex_wo);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		setLocation(e.getXOnScreen() -tx, e.getYOnScreen() -ty);		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == ExitButton) {
			dispose();
		}
		tx = e.getX();
		ty = e.getY();		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
