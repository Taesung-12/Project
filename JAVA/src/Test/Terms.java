package Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.SystemColor;

public class Terms extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

	private JPanel contentPane, TitlePane;
	private JTextField textArea1;
	private JTextField textArea2;
	private JCheckBox CheckBox1, CheckBox2;
	private JButton NextButton;
	private JLabel ExitButton;
	private int tx, ty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Terms frame = new Terms();
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
	public Terms() {
		setBounds(100, 100, 301, 502);
		setLocation(1050,200);
		setResizable(false);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel MainPane = new JPanel();
		MainPane.setBounds(0, 0, 301, 502);
		MainPane.setLayout(null);
		MainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		MainPane.setBackground(SystemColor.control);
		contentPane.add(MainPane);
		
		TitlePane = new GraPanel();
		TitlePane.addMouseListener(this);
		TitlePane.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.GRAY));
		TitlePane.addMouseMotionListener(this);
		TitlePane.setLayout(null);
		TitlePane.setBackground(new Color(0,0,0,0));
		TitlePane.setBounds(0, 0, 301, 58);
		MainPane.add(TitlePane);
		
		JLabel TitleLabel = new JLabel("이 용 약 관");
		TitleLabel.setForeground(new Color(255, 255, 255));
		TitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		TitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 26));
		TitleLabel.setBounds(20, 6, 162, 46);
		TitlePane.add(TitleLabel);
		
		ExitButton = new JLabel("");
		ExitButton.addMouseListener(this);
		ExitButton.setIcon(new ImageIcon(Terms.class.getResource("/Image/close.png")));
		ExitButton.setFocusable(false);
		ExitButton.setBackground(new Color(0,0,0,0));
		ExitButton.setBounds(262, 6, 31, 23);
		TitlePane.add(ExitButton);
		
		JLabel IdLabel = new JLabel("* 개인정보 수집 및 이용 동의");
		IdLabel.setForeground(Color.DARK_GRAY);
		IdLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		IdLabel.setBounds(12, 256, 198, 16);
		MainPane.add(IdLabel);
		
		NextButton = new JButton("  다음 단계");
		NextButton.setEnabled(false);
		NextButton.setBorderPainted(false);
		NextButton.addActionListener(this);
		NextButton.setForeground(Color.WHITE);
		NextButton.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		NextButton.setFocusable(false);
		NextButton.setBackground(SystemColor.scrollbar);
		NextButton.setBounds(12, 461, 277, 31);
		MainPane.add(NextButton);
		
		JLabel NameLabel = new JLabel("* 이용약관 동의 ");
		NameLabel.setForeground(Color.DARK_GRAY);
		NameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		NameLabel.setBounds(10, 66, 112, 16);
		MainPane.add(NameLabel);
		
		JLabel NameLabel_1 = new JLabel("(필수)");
		NameLabel_1.setForeground(Color.RED);
		NameLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		NameLabel_1.setBounds(110, 66, 49, 16);
		MainPane.add(NameLabel_1);
		
		JLabel NameLabel_1_1 = new JLabel("(필수)");
		NameLabel_1_1.setForeground(Color.RED);
		NameLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		NameLabel_1_1.setBounds(190, 256, 49, 16);
		MainPane.add(NameLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 94, 279, 152);
		MainPane.add(scrollPane);
		
		JTextArea textArea1 = new JTextArea();
		textArea1.setEditable(false);
		scrollPane.setViewportView(textArea1);
		textArea1.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 282, 279, 169);
		MainPane.add(scrollPane_1);
		
		JTextArea textArea2 = new JTextArea();
		textArea2.setEditable(false);
		scrollPane_1.setViewportView(textArea2);
		textArea2.setColumns(10);
		
		CheckBox1 = new JCheckBox("동의");
		CheckBox1.setFocusable(false);
		CheckBox1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		CheckBox1.setBackground(SystemColor.control);
		CheckBox1.addActionListener(this);
		CheckBox1.setBounds(238, 64, 60, 23);
		MainPane.add(CheckBox1);
		
		CheckBox2 = new JCheckBox("동의");
		CheckBox2.setFocusable(false);
		CheckBox2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		CheckBox2.setBackground(SystemColor.control);
		CheckBox2.addActionListener(this);
		CheckBox2.setBounds(238, 253, 60, 23);
		MainPane.add(CheckBox2);
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(CheckBox1.isSelected() && CheckBox2.isSelected()) {
			NextButton.setEnabled(true);
			NextButton.setBackground(new Color(51, 102, 204));
			NextButton.setBorderPainted(true);
		}else {
			NextButton.setEnabled(false);
			NextButton.setBackground(SystemColor.scrollbar);
		}
		
		Object obj = e.getSource();
		if(obj == NextButton) {
			new Reg();
			Terms.this.dispose();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();
		tx = e.getX();
		ty = e.getY();
		
		if(obj == ExitButton) {
			Terms.this.dispose();		
		}
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

	@Override
	public void mouseDragged(MouseEvent e) {
		setLocation(e.getXOnScreen() -tx, e.getYOnScreen() -ty);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
