package Test;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.SystemColor;

public class Reg extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

	private JPanel TitlePane, MainPane;
	private JTextField IdField;
	private JPasswordField Pw1Field;
	private JPasswordField Pw2Field;
	private JTextField TelField;
	private JTextField NameField;
	private JButton SignUpButton;
	private JButton PwCheckButton;
	private JButton IdCheckButton;
	private ResultSet rs;
	private Connection conn;
	private Statement stmt;
	private String sqlInsert;
	private String sql;
	private String username,id,pw,callnum, gender;

	private int state = 0;
	private ButtonGroup g;
	private JRadioButton man;
	private JRadioButton wo;
	private JLabel ExitButton;
	private int tx, ty;
	private JPanel Pane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reg frame = new Reg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Reg() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reg.class.getResource("/Image/IconImg.png")));
		setTitle("Program");
		setBounds(100, 100, 301, 502);
		setLocation(1050,200);
		setResizable(false);
		setUndecorated(true);
		MainPane = new JPanel();
		MainPane.setBackground(new Color(51, 102, 204));
		MainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MainPane);
		MainPane.setLayout(null);
		setVisible(true);
		
		g = new ButtonGroup();
		
		Pane = new JPanel();
		Pane.setBackground(SystemColor.control);
		Pane.setBounds(0, 0, 301, 502);
		MainPane.add(Pane);
		Pane.setLayout(null);
		
		TitlePane = new GraPanel();
		TitlePane.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.GRAY));
		TitlePane.setBounds(0, 0, 301, 58);
		Pane.add(TitlePane);
		TitlePane.addMouseListener(this);
		TitlePane.addMouseMotionListener(this);
		TitlePane.setBackground(new Color(0,0,0,0));
		TitlePane.setLayout(null);
		
		JLabel TitleLabel = new JLabel("회 원 가 입");
		TitleLabel.setForeground(SystemColor.inactiveCaptionBorder);
		TitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
		TitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 26));
		TitleLabel.setBounds(20, 6, 162, 46);
		TitlePane.add(TitleLabel);
		
		ExitButton = new JLabel("");
		ExitButton.addMouseListener(this);
		ExitButton.setIcon(new ImageIcon(Reg.class.getResource("/Image/close.png")));
		ExitButton.setFocusable(false);
		ExitButton.setBackground(new Color(135, 206, 250));
		ExitButton.setBounds(260, 6, 31, 23);
		TitlePane.add(ExitButton);
		
		NameField = new JTextField(20); // 이름
		NameField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(64,64,64)));
		NameField.setBounds(12, 87, 130, 26);
		Pane.add(NameField);
		NameField.setBackground(SystemColor.control);
		NameField.setToolTipText("ID");
		NameField.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		NameField.setColumns(10);
		
		IdField = new JTextField(20); // ID 입력
		IdField.setFont(new Font("Dialog", Font.PLAIN, 15));
		IdField.setBounds(12, 150, 130, 26);
		Pane.add(IdField);
		IdField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(64,64,64)));
		IdField.setBackground(SystemColor.control);
		IdField.setToolTipText("ID");
		IdField.setColumns(10);
		
		Pw1Field = new JPasswordField(20); // PW 입력
		Pw1Field.setBounds(12, 210, 130, 26);
		Pane.add(Pw1Field);
		Pw1Field.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(64,64,64)));
		Pw1Field.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		Pw1Field.setBackground(SystemColor.control);
		Pw1Field.setToolTipText("PW 1");
		Pw1Field.setColumns(10);
		
		Pw2Field = new JPasswordField(20); //PW 확인
		Pw2Field.setBounds(12, 270, 130, 26);
		Pane.add(Pw2Field);
		Pw2Field.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(64,64,64)));
		Pw2Field.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		Pw2Field.setBackground(SystemColor.control);
		Pw2Field.setToolTipText("PW 2");
		Pw2Field.setColumns(10);
		
		TelField = new JTextField(20);  //전화번호
		TelField.setBounds(12, 330, 130, 26);
		Pane.add(TelField);
		TelField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(64,64,64)));
		TelField.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		TelField.setBackground(SystemColor.control);
		TelField.setToolTipText("TEL");
		TelField.setColumns(10);
		
		JLabel IdLabel = new JLabel("*아이디 입력");
		IdLabel.setForeground(SystemColor.desktop);
		IdLabel.setBounds(12, 130, 88, 16);
		Pane.add(IdLabel);
		IdLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
				
		JLabel Pw_1_Label = new JLabel("*비밀번호 입력");
		Pw_1_Label.setForeground(SystemColor.desktop);
		Pw_1_Label.setBounds(10, 190, 110, 16);
		Pane.add(Pw_1_Label);
		Pw_1_Label.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		
		JLabel Pw_2_Label = new JLabel("*비밀번호 재입력");
		Pw_2_Label.setForeground(SystemColor.desktop);
		Pw_2_Label.setBounds(12, 250, 112, 16);
		Pane.add(Pw_2_Label);
		Pw_2_Label.setFont(new Font("맑은 고딕", Font.BOLD, 14));
				
		IdCheckButton = new JButton("중복 확인");
		IdCheckButton.setBounds(154, 150, 98, 26);
		Pane.add(IdCheckButton);
		IdCheckButton.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		IdCheckButton.setBackground(new Color(240, 248, 255));
		IdCheckButton.setFocusable(false);
				
		PwCheckButton = new JButton("비밀번호 확인");
		PwCheckButton.setBounds(154, 270, 132, 26);
		Pane.add(PwCheckButton);
		PwCheckButton.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		PwCheckButton.setBackground(new Color(240, 252, 255));
		PwCheckButton.setFocusable(false);
				

		JLabel TelLabel = new JLabel("*전화번호 입력");
		TelLabel.setForeground(SystemColor.desktop);
		TelLabel.setBounds(10, 310, 132, 16);
		Pane.add(TelLabel);
		TelLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		man = new JRadioButton("남성");
		man.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(64,64,64)));
		man.setBounds(150, 88, 62, 23);
		Pane.add(man);
		man.setBackground(SystemColor.control);
		man.setFocusable(false);
		man.setHorizontalAlignment(SwingConstants.CENTER);
		man.setFont(new Font("맑은 고딕", Font.BOLD, 14));
				
		man.addActionListener(this);
				
		g.add(man);
		
		wo = new JRadioButton("여성");
		wo.setBounds(216, 88, 62, 23);
		Pane.add(wo);
		wo.setBackground(SystemColor.control);
		wo.setFocusable(false);
		wo.setHorizontalAlignment(SwingConstants.CENTER);
		wo.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		wo.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(64,64,64)));
		
		wo.addActionListener(this);
		g.add(wo);
				
		SignUpButton = new JButton("     회원가입");
		SignUpButton.setBounds(12, 434, 277, 43);
		Pane.add(SignUpButton);
		SignUpButton.setForeground(Color.WHITE);
		SignUpButton.setBackground(new Color(51, 102, 204));
		SignUpButton.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		SignUpButton.setFocusable(false);
				
		JLabel NameLabel = new JLabel("* 성함 입력");
		NameLabel.setForeground(SystemColor.desktop);
		NameLabel.setBounds(10, 68, 88, 16);
		Pane.add(NameLabel);
		NameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		SignUpButton.addActionListener(this);
		PwCheckButton.addActionListener(this);
		IdCheckButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		// 회원가입 버튼
		if(obj == SignUpButton) {
			
			callnum = TelField.getText();
			Reg reg = new Reg();
			reg.dispose();
			
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.01:1521:XE",
						"aban",
						"1111");
				stmt = conn.createStatement();

				sqlInsert = "insert into logindata (id, username, password, callnum, gender)" + "values('" + id + "','" + username + "','" + pw+"','"+ callnum + "','" + gender + "')";	
				stmt.executeUpdate(sqlInsert);
				
				sql ="select * from logindata"; 
				
			    rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "회원가입 성공");
					new Login();
					setVisible(false);
					}
				conn.close();
			} 
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
		}
		
		// 아이디 중복확인 버튼
		if(obj == IdCheckButton) {
			id = IdField.getText();		
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				conn= DriverManager.getConnection("jdbc:oracle:thin:@127.0.01:1521:XE",
						"aban",
						"1111");
				sql ="select *from logindata where id=?";
				
				stmt = conn.prepareStatement(sql);
				stmt.setNString(1,id);
				rs = stmt.executeQuery();
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다.");
					state = 0;
				}else {
					JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
					state = 1;
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		// 비밀번호 재확인
				if(obj == PwCheckButton) {
					if((Pw1Field.getText()).equals(Pw2Field.getText())) {
						if(!((Pw1Field.getText().equals("")) || (Pw2Field.getText().equals("")))) {
							if(!(Pw1Field.getText().length()< 8 )) {
						JOptionPane.showMessageDialog(null,"비밀번호가 일치합니다.");
					
						if((man.isSelected()|| wo.isSelected()) && (state == 1)) {
						SignUpButton.setEnabled(true);
						}else if(state == 0) {
							JOptionPane.showMessageDialog(null, "아이디가 중복됩니다. 다시 확인하세요");
						}
						}
							else if(Pw1Field.getText().length() < 8 || Pw2Field.getText().length() < 8 ) {
							JOptionPane.showMessageDialog(null,"비밀번호를 8자 이상 입력해야됩니다.");
						}	
						
						 }
					}
					
					else if(!(Pw1Field.getText()).equals(Pw2Field.getText()))
					{
						JOptionPane.showMessageDialog(null,"비밀번호를 다시 확인해주세요");
					}
					  username = NameField.getText();
					  id = IdField.getText();
					  pw = Pw1Field.getText();
				}
		// 성별 체크
				if(obj == man) {
					gender = "남성";
				
				}else {
					gender ="여성";
				}
		

		
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
			Reg.this.dispose();
			new Terms();
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
