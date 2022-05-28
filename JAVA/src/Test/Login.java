package Test;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.SwingConstants;

public class Login extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

	private JPanel SidePane, TitleBar;
	private JTextField IdTextArea;
	private JPasswordField PwTextArea;
	private JButton SignUpButton;
	private JButton LoginButton;
	private JLabel ExitButton;
	private int tx, ty;
	private JPanel LogoPane_1;
	private JLabel LogoLabel;
	private JPanel LogoPane;
	private JLabel PwLabel, IdLabel;


   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Image/IconImg.png")));
		setTitle("Program");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 301, 502);
		setLocation(700,200);
		setResizable(false);
		setUndecorated(true);
		SidePane = new GraPanel();
		
		SidePane.setBackground(new Color(51, 102, 204));
		SidePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(SidePane);
		SidePane.setLayout(null);
		
		LogoPane = new JPanel();
		LogoPane_1 = new JPanel();
		LogoPane_1.setBackground(new Color(0,0,0,0));
		LogoPane_1.setBounds(14, 46, 274, 266);
		SidePane.add(LogoPane_1);
		LogoPane_1.setLayout(null);
		
		LogoLabel = new JLabel("");
		LogoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LogoLabel.setIcon(new ImageIcon(Login.class.getResource("/Image/Logo_1.png")));
		LogoLabel.setBounds(-19, -25, 293, 466);
		LogoLabel.setBackground(new Color(0,0,0,0));
		LogoPane_1.add(LogoLabel);

		TitleBar = new JPanel();
		TitleBar.addMouseMotionListener(this);
		TitleBar.addMouseListener(this);
		TitleBar.setBackground(new Color(0,0,0,0));
		TitleBar.setBounds(0, 0, 301, 35);
		TitleBar.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		SidePane.add(TitleBar);
		TitleBar.setLayout(null);
		
		IdTextArea = new JTextField(10);
		IdTextArea.setBackground(new Color(102, 102, 204));
		IdTextArea.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		IdTextArea.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		IdTextArea.setBounds(59, 362, 130, 26);
		SidePane.add(IdTextArea);
		IdTextArea.setColumns(10);
		
		PwTextArea = new JPasswordField(10);
		PwTextArea.setBackground(new Color(102, 102, 204));
		PwTextArea.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		PwTextArea.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		PwTextArea.setBounds(59, 415, 130, 26);
		SidePane.add(PwTextArea);
		PwTextArea.setColumns(10);
		
		PwLabel = new JLabel("P.W");
		PwLabel.setForeground(Color.WHITE);
		PwLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		PwLabel.setBounds(18, 420, 38, 16);
		SidePane.add(PwLabel);
		
		IdLabel = new JLabel("I. D");
		IdLabel.setForeground(Color.WHITE);
		IdLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		IdLabel.setBounds(18, 367, 26, 16);
		SidePane.add(IdLabel);
		
		SignUpButton = new JButton("Sign Up");
		SignUpButton.setBorderPainted(false);
		SignUpButton.setFont(new Font("굴림", Font.BOLD, 12));
		SignUpButton.setFocusable(false);
		SignUpButton.addActionListener(this);
		
		SignUpButton.setBounds(175, 461, 87, 16);
		SidePane.add(SignUpButton);
		
		LoginButton = new JButton("");
		LoginButton.setBorderPainted(false);
		LoginButton.setIcon(new ImageIcon(Login.class.getResource("/Image/Login.png")));
		LoginButton.setFont(new Font("굴림", Font.BOLD, 12));
		LoginButton.setBounds(205, 352, 83, 99);
		SidePane.add(LoginButton);
		LoginButton.setFocusable(false);
		
		
		ExitButton = new JLabel("");
		ExitButton.setBounds(270, 3, 29, 29);
		TitleBar.add(ExitButton);
		ExitButton.addMouseListener(this);
		ExitButton.setFocusable(false);
		ExitButton.setBackground(new Color(0,0,0,0));
		ExitButton.setIcon(new ImageIcon(Login.class.getResource("/Image/close.png")));
		LoginButton.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == LoginButton) {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.01:1521:XE",
						"aban",
						"1111");
				String sql ="select * from logindata where id= '"+IdTextArea.getText()+"'and password='"+PwTextArea.getText()+"'";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "로그인 성공");
					setVisible(false);
					new TEST();
					
				}else {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 다시 확인하세요");
				}
				
			} catch (Exception e2) {
				System.out.println();
			}
		}
		
		if(obj == SignUpButton) {
			new Terms();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		tx = e.getX();
	    ty = e.getY();
		
		Object obj = e.getSource();
		if(obj == ExitButton) {
			if(JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION) == 0) {
				System.exit(0);
			}
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
