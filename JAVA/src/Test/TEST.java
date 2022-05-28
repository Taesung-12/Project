package Test;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class TEST extends JFrame implements MouseListener, MouseMotionListener, ActionListener {

	static JPanel MainPane;
	private JPanel contentPane, TitlePane;
	private JButton Menu1, Menu2, Menu3, Menu4;
	private JButton CalenderButton, InfoButton, MailButton, BrowseButton;
	private JLabel ExitButton;
	private JPanel Pane0, Pane1, Pane2, Pane3;
	private JLabel AccountLabel, SearchLabel, MailLabel, CalenderLabel;
	private int tx, ty;
	private JLabel a1,b1,c1,d1,e1,f1,g1,h1;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					TEST frame = new TEST();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void Switch_screen(JPanel p) {
		MainPane.removeAll();
		MainPane.add(p);
		MainPane.repaint();
		MainPane.revalidate();
	}

	public TEST() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TEST.class.getResource("/Image/IconImg.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 574);
		setLocation(400,200);
		setResizable(false);
		setUndecorated(true);
		contentPane = new GraPanel();
		contentPane.setBackground(new Color(51, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setVisible(true);
		
		MainPane = new JPanel();
		MainPane.setBackground(Color.WHITE);
		MainPane.setBounds(170, 29, 695, 545);
		contentPane.add(MainPane);
		MainPane.setLayout(null);
		
		Pane0 = new JPanel();
		Pane0.setBounds(0, 0, 694, 545);
		MainPane.add(Pane0);
		Pane0.setLayout(null);
		Pane0.setBackground(Color.WHITE);
		
		a1 = new JLabel("");
		a1.addMouseListener(this);
		a1.setIcon(new ImageIcon(TEST.class.getResource("/Image/a1.png")));
		a1.setBounds(35, 36, 130, 170);
		Pane0.add(a1);
		
		b1 = new JLabel("");
		b1.addMouseListener(this);
		b1.setIcon(new ImageIcon(TEST.class.getResource("/Image/b1.png")));
		b1.setBounds(196, 36, 130, 170);
		Pane0.add(b1);
		
		c1 = new JLabel("");
		c1.addMouseListener(this);
		c1.setIcon(new ImageIcon(TEST.class.getResource("/Image/c1.png")));
		c1.setBounds(370, 36, 130, 170);
		Pane0.add(c1);
		
		d1 = new JLabel("");
		d1.addMouseListener(this);
		d1.setIcon(new ImageIcon(TEST.class.getResource("/Image/d1.png")));
		d1.setBounds(532, 36, 130, 170);
		Pane0.add(d1);
		
		e1 = new JLabel("");
		e1.addMouseListener(this);
		e1.setIcon(new ImageIcon(TEST.class.getResource("/Image/e1.png")));
		e1.setBounds(35, 330, 130, 170);
		Pane0.add(e1);
		
		f1 = new JLabel("");
		f1.addMouseListener(this);
		f1.setIcon(new ImageIcon(TEST.class.getResource("/Image/f1.png")));
		f1.setBounds(196, 330, 130, 170);
		Pane0.add(f1);
		
		g1 = new JLabel("");
		g1.addMouseListener(this);
		g1.setIcon(new ImageIcon(TEST.class.getResource("/Image/g1.png")));
		g1.setBounds(370, 330, 130, 170);
		Pane0.add(g1);
		
		h1 = new JLabel("");
		h1.addMouseListener(this);
		h1.setIcon(new ImageIcon(TEST.class.getResource("/Image/h1.png")));
		h1.setBounds(532, 330, 130, 170);
		Pane0.add(h1);
		
		lblNewLabel = new JLabel("원하시는 병원 진료과를 선택해주세요.");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		lblNewLabel.setBounds(148, 240, 423, 44);
		Pane0.add(lblNewLabel);
		
		Pane1 = new JPanel();
		Pane1.setLayout(null);
		Pane1.setBackground(Color.GREEN);
		Pane1.setBounds(0, 0, 694, 545);
		MainPane.add(Pane1);
		
		// 여기서부터 '병원 리스트' Panel 단
/*		ImageIcon backgroundicon = new ImageIcon(TEST.class.getResource("/image/listback.png"));
		JLabel BackgroundimgLabel = new JLabel();
		BackgroundimgLabel.setIcon(backgroundicon);
		BackgroundimgLabel.setBounds(0,0,694,545);
		BackgroundimgLabel.setHorizontalAlignment(JLabel.CENTER);
		Pane1.add(BackgroundimgLabel);
		//BackgroundimgLabel.setComponentZOrder(BackgroundimgLabel, 1);
		*/
		
		
		ImageIcon icon = new ImageIcon(TEST.class.getResource("/image/listpic.png"));
		JLabel ListimgLabel = new JLabel();
		ListimgLabel.setIcon(icon);
		ListimgLabel.setBounds(230,20,50,60);
		ListimgLabel.setHorizontalAlignment(JLabel.CENTER);
		Pane1.add(ListimgLabel);
		
		JLabel listlabel0 = new JLabel("병원 리스트");
		listlabel0.setFont(new Font("맑은고딕", Font.BOLD, 30));
		listlabel0.setBounds(287, 30, 200, 30);
		Pane1.add(listlabel0);
		
		
		
		// 리스트 첫번째 병원
		JPanel Panel1 = new JPanel();
		Panel1.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		Panel1.setBounds(147, 100, 400, 50);
		
		JLabel listlabel1 = new JLabel("병원1");
		listlabel1.setBorder(BorderFactory.createEmptyBorder(0,20,0,10));
		listlabel1.setPreferredSize(new Dimension(300,50));
		Panel1.add(listlabel1);
		
		JButton listbtn1 = new JButton("병원쓰");
		listbtn1.setAlignmentX(RIGHT_ALIGNMENT);
		Panel1.add(listbtn1);
		
		// 리스트 두번째 병원
		JPanel Panel2 = new JPanel();
		Panel2.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		Panel2.setBounds(147, 170, 400, 50);
		
		JLabel listlabel2 = new JLabel("병원2");
		listlabel2.setBorder(BorderFactory.createEmptyBorder(0,20,0,10));
		listlabel2.setPreferredSize(new Dimension(300,50));
		Panel2.add(listlabel2);
		
		JButton listbtn2 = new JButton("병원쓰");
		listbtn2.setAlignmentX(RIGHT_ALIGNMENT);
		Panel2.add(listbtn2);
		
		// 리스트 세번째 병원
		JPanel Panel3 = new JPanel();
		Panel3.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		Panel3.setBounds(147, 240, 400, 50);
		
		JLabel listlabel3 = new JLabel("병원3");
		listlabel3.setBorder(BorderFactory.createEmptyBorder(0,20,0,10));
		listlabel3.setPreferredSize(new Dimension(300,50));
		Panel3.add(listlabel3);
		
		JButton listbtn3 = new JButton("병원쓰");
		listbtn3.setAlignmentX(RIGHT_ALIGNMENT);
		Panel3.add(listbtn3);
		
		// 리스트 세번째 병원
		JPanel Panel4 = new JPanel();
		Panel4.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		Panel4.setBounds(147, 310, 400, 50);
		
		JLabel listlabel4 = new JLabel("병원4");
		listlabel4.setBorder(BorderFactory.createEmptyBorder(0,20,0,10));
		listlabel4.setPreferredSize(new Dimension(300,50));
		Panel4.add(listlabel4);
		
		JButton listbtn4 = new JButton("병원쓰");
		listbtn4.setAlignmentX(RIGHT_ALIGNMENT);
		Panel4.add(listbtn4);
		
		// 리스트 다섯번째 병원
		JPanel Panel5 = new JPanel();
		Panel5.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		Panel5.setBounds(147, 380, 400, 50);
		
		JLabel listlabel5 = new JLabel("병원5");
		listlabel5.setBorder(BorderFactory.createEmptyBorder(0,20,0,10));
		listlabel5.setPreferredSize(new Dimension(300,50));
		Panel5.add(listlabel5);
		
		JButton listbtn5 = new JButton("병원쓰");
		listbtn5.setAlignmentX(RIGHT_ALIGNMENT);
		Panel5.add(listbtn5);
		
		// 리스트 여섯번째 병원
		JPanel Panel6 = new JPanel();
		Panel6.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		Panel6.setBounds(147, 450, 400, 50);
		
		JLabel listlabel6 = new JLabel("병원6");
		listlabel6.setBorder(BorderFactory.createEmptyBorder(0,20,0,10));
		listlabel6.setPreferredSize(new Dimension(300,50));
		Panel6.add(listlabel6);
		
		JButton listbtn6 = new JButton("병원쓰");
		listbtn6.setAlignmentX(RIGHT_ALIGNMENT);
		Panel6.add(listbtn6);
		
		
		
		
		
		Pane1.add(Panel1);
		Pane1.add(Panel2);
		Pane1.add(Panel3);
		Pane1.add(Panel4);
		Pane1.add(Panel5);
		Pane1.add(Panel6);
		
		// 여기까지 '병원 리스트' 단
		
		
		Pane2 = new JPanel();
		Pane2.setLayout(null);
		Pane2.setBackground(Color.MAGENTA);
		Pane2.setBounds(0, 0, 694, 545);
		MainPane.add(Pane2);
		
		Pane3 = new JPanel();
		Pane3.setLayout(null);
		Pane3.setBackground(Color.CYAN);
		Pane3.setBounds(0, 0, 694, 545);
		MainPane.add(Pane3);
		
		JPanel SideMenuPane = new GraPanel();
		SideMenuPane.setBounds(0, 0, 170, 574);
		contentPane.add(SideMenuPane);
		SideMenuPane.setBackground(new Color(135, 206, 250));
		SideMenuPane.setLayout(null);
		
		InfoButton = new JButton("                     ");
		InfoButton.addActionListener(this);
		InfoButton.setBackground(new Color(135, 206, 250));
		InfoButton.setIcon(new ImageIcon(TEST.class.getResource("/Image/info.png")));
		InfoButton.setBounds(0, 110, 170, 40);
		InfoButton.setBorderPainted(false);
		InfoButton.setContentAreaFilled(false);
		InfoButton.setFocusPainted(false);
		SideMenuPane.add(InfoButton);
		
		
		MailButton = new JButton("                     ");
		MailButton.addActionListener(this);
		MailButton.setBackground(new Color(135, 206, 250));
		MailButton.setIcon(new ImageIcon(TEST.class.getResource("/Image/gmail.png")));
		MailButton.setBounds(0, 190, 170, 39);
		MailButton.setBorderPainted(false);
		MailButton.setFocusPainted(false);
		MailButton.setContentAreaFilled(false);
		SideMenuPane.add(MailButton);
		
		BrowseButton = new JButton("                     ");
		BrowseButton.addActionListener(this);
		BrowseButton.setBackground(new Color(135, 206, 250));
		BrowseButton.setIcon(new ImageIcon(TEST.class.getResource("/Image/internet.png")));
		BrowseButton.setBounds(0, 150, 170, 40);
		BrowseButton.setFocusPainted(false);
		BrowseButton.setBorderPainted(false);
		BrowseButton.setContentAreaFilled(false);
		SideMenuPane.add(BrowseButton);
		
		CalenderButton = new JButton("                     ");
		CalenderButton.addActionListener(this);
		CalenderButton.setBackground(new Color(135, 206, 250));
		CalenderButton.setIcon(new ImageIcon(TEST.class.getResource("/Image/calender.png")));
		CalenderButton.setBounds(0, 230, 170, 39);
		CalenderButton.setBorderPainted(false);
		CalenderButton.setContentAreaFilled(false);
		CalenderButton.setFocusPainted(false);
		SideMenuPane.add(CalenderButton);
		
		AccountLabel = new JLabel("ACCOUNT");
		AccountLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		AccountLabel.setForeground(Color.WHITE);
		AccountLabel.setBounds(75, 110, 90, 40);
		SideMenuPane.add(AccountLabel);
		
		SearchLabel = new JLabel("SEARCH");
		SearchLabel.setForeground(Color.WHITE);
		SearchLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		SearchLabel.setBounds(75, 150, 90, 40);
		SideMenuPane.add(SearchLabel);
		
		MailLabel = new JLabel("MAIL");
		MailLabel.setForeground(Color.WHITE);
		MailLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		MailLabel.setBounds(75, 190, 90, 40);
		SideMenuPane.add(MailLabel);
		
		CalenderLabel = new JLabel("CALENDER");
		CalenderLabel.setForeground(Color.WHITE);
		CalenderLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		CalenderLabel.setBounds(75, 230, 90, 40);
		SideMenuPane.add(CalenderLabel);
		
		Menu1 = new JButton();
		Menu1.setHorizontalAlignment(SwingConstants.RIGHT);
		Menu1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Menu1.setText("HOME");
		Menu1.setForeground(Color.BLACK);
		Menu1.setBounds(15, 315, 156, 40);
		SideMenuPane.add(Menu1);
		Menu1.setBackground(Color.WHITE);
		Menu1.setBorderPainted(false);
		Menu1.setLayout(null);
		
		Menu2 = new JButton();
		Menu2.setForeground(Color.WHITE);
		Menu2.setFont(new Font("굴림", Font.BOLD, 16));
		Menu2.setHorizontalAlignment(SwingConstants.RIGHT);
		Menu2.setText("병원 리스트");
		Menu2.setBounds(35, 375, 135, 40);
		SideMenuPane.add(Menu2);
		Menu2.setBackground(new Color(0,0,0,0));
		Menu2.setBorderPainted(false);
		Menu2.setContentAreaFilled(false);
		Menu2.setFocusPainted(false);
		Menu2.setLayout(null);
		
		Menu3 = new JButton();
		Menu3.setText("병원 정보");
		Menu3.setForeground(Color.WHITE);
		Menu3.setFont(new Font("굴림", Font.BOLD, 16));
		Menu3.setHorizontalAlignment(SwingConstants.RIGHT);
		Menu3.setBounds(35, 420, 135, 40);
		SideMenuPane.add(Menu3);
		Menu3.setBackground(new Color(0,0,0,0));
		Menu3.setBorderPainted(false);
		Menu3.setContentAreaFilled(false);
		Menu3.setFocusPainted(false);
		Menu3.setLayout(null);
		
		Menu4 = new JButton();
		Menu4.setForeground(Color.WHITE);
		Menu4.setFont(new Font("굴림", Font.BOLD, 16));
		Menu4.setHorizontalAlignment(SwingConstants.RIGHT);
		Menu4.setText("병원비 조회");
		Menu4.setBounds(35, 465, 135, 40);
		SideMenuPane.add(Menu4);
		Menu4.setBackground(new Color(0,0,0,0));
		Menu4.setBorderPainted(false);
		Menu4.setContentAreaFilled(false);
		Menu4.setFocusPainted(false);
		Menu4.setLayout(null);
		
		JLabel Logo = new JLabel("");
		Logo.setHorizontalAlignment(SwingConstants.CENTER);
		Logo.setIcon(new ImageIcon(TEST.class.getResource("/Image/Logo_B.png")));
		Logo.setBounds(0, 10, 170, 101);
		SideMenuPane.add(Logo);
		Menu4.addMouseListener(this);
		Menu3.addMouseListener(this);
		Menu2.addMouseListener(this);
		Menu1.addMouseListener(this);
		
		TitlePane = new JPanel();
		TitlePane.addMouseListener(this);
		TitlePane.addMouseMotionListener(this);
		TitlePane.setLayout(null);
		TitlePane.setBackground(new Color(0, 0, 0, 0));
		TitlePane.setBounds(0, 0, 865, 28);
		contentPane.add(TitlePane);
		
		ExitButton = new JLabel("");
		ExitButton.setHorizontalAlignment(SwingConstants.CENTER);
		ExitButton.setBounds(830, 0, 30, 30);
		TitlePane.add(ExitButton);
		ExitButton.addMouseListener(this);
		ExitButton.setIcon(new ImageIcon(TEST.class.getResource("/Image/close.png")));
		ExitButton.setBackground(new Color(0,0,0,0));
	
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
		if(obj == Menu1) {
			Menu1.setBackground(Color.WHITE);
			Menu1.setContentAreaFilled(true);
			Menu1.setForeground(Color.BLACK);
			Menu2.setForeground(Color.WHITE);
			Menu2.setBorderPainted(false);
			Menu2.setContentAreaFilled(false);
			Menu2.setFocusPainted(false);
			Menu3.setBorderPainted(false);
			Menu3.setContentAreaFilled(false);
			Menu3.setFocusPainted(false);
			Menu3.setForeground(Color.WHITE);
			Menu4.setForeground(Color.WHITE);
			Menu4.setBorderPainted(false);
			Menu4.setContentAreaFilled(false);
			Menu4.setFocusPainted(false);
			Switch_screen(Pane0);
			
		}else if(obj == Menu2) {
			Menu2.setBackground(Color.WHITE);
			Menu2.setContentAreaFilled(true);
			Menu2.setForeground(Color.BLACK);
			Menu4.setFocusPainted(false);
			Menu1.setForeground(Color.WHITE);
			Menu1.setBorderPainted(false);
			Menu1.setContentAreaFilled(false);
			Menu1.setFocusPainted(false);
			Menu3.setForeground(Color.WHITE);
			Menu3.setBorderPainted(false);
			Menu3.setContentAreaFilled(false);
			Menu3.setFocusPainted(false);
			Menu4.setForeground(Color.WHITE);
			Menu4.setBorderPainted(false);
			Menu4.setContentAreaFilled(false);
			Switch_screen(Pane1);
			
		}else if(obj == Menu3) {
			Menu3.setBackground(Color.WHITE);
			Menu3.setContentAreaFilled(true);
			Menu3.setForeground(Color.BLACK);
			Menu1.setForeground(Color.WHITE);
			Menu1.setBorderPainted(false);
			Menu1.setContentAreaFilled(false);
			Menu1.setFocusPainted(false);
			Menu2.setForeground(Color.WHITE);
			Menu2.setBorderPainted(false);
			Menu2.setContentAreaFilled(false);
			Menu2.setFocusPainted(false);
			Menu4.setForeground(Color.WHITE);
			Menu4.setBorderPainted(false);
			Menu4.setContentAreaFilled(false);
			Menu4.setFocusPainted(false);
			Switch_screen(Pane2);
			
		}else if(obj == Menu4) {
			Menu4.setBackground(Color.WHITE);
			Menu4.setContentAreaFilled(true);
			Menu4.setForeground(Color.BLACK);
			Menu1.setForeground(Color.WHITE);
			Menu1.setBorderPainted(false);
			Menu1.setContentAreaFilled(false);
			Menu1.setFocusPainted(false);
			Menu2.setForeground(Color.WHITE);
			Menu2.setBorderPainted(false);
			Menu2.setContentAreaFilled(false);
			Menu2.setFocusPainted(false);
			Menu3.setForeground(Color.WHITE);
			Menu3.setBorderPainted(false);
			Menu3.setContentAreaFilled(false);
			Menu3.setFocusPainted(false);
			Switch_screen(Pane3);
			
		}else if(obj == ExitButton) {
			if(JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION) == 0) {
				System.exit(0);
			}
		}else if(obj == a1) {
			a1.setIcon(new ImageIcon(TEST.class.getResource("/Image/a2.png")));
		}else if(obj == b1) {
			b1.setIcon(new ImageIcon(TEST.class.getResource("/Image/b2.png")));
		}else if(obj == c1) {
			c1.setIcon(new ImageIcon(TEST.class.getResource("/Image/c2.png")));
		}else if(obj == d1) {
			d1.setIcon(new ImageIcon(TEST.class.getResource("/Image/d2.png")));
		}else if(obj == e1) {
			e1.setIcon(new ImageIcon(TEST.class.getResource("/Image/e2.png")));
		}else if(obj == f1) {
			f1.setIcon(new ImageIcon(TEST.class.getResource("/Image/f2.png")));
		}else if(obj == g1) {
			g1.setIcon(new ImageIcon(TEST.class.getResource("/Image/g2.png")));
		}else if(obj == h1) {
			h1.setIcon(new ImageIcon(TEST.class.getResource("/Image/h2.png")));
		}
			
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == a1) {
			a1.setIcon(new ImageIcon(TEST.class.getResource("/Image/a1.png")));
		}else if(obj == b1) {
			b1.setIcon(new ImageIcon(TEST.class.getResource("/Image/b1.png")));
		}else if(obj == c1) {
			c1.setIcon(new ImageIcon(TEST.class.getResource("/Image/c1.png")));
		}else if(obj == d1) {
			d1.setIcon(new ImageIcon(TEST.class.getResource("/Image/d1.png")));
		}else if(obj == e1) {
			e1.setIcon(new ImageIcon(TEST.class.getResource("/Image/e1.png")));
		}else if(obj == f1) {
			f1.setIcon(new ImageIcon(TEST.class.getResource("/Image/f1.png")));
		}else if(obj == g1) {
			g1.setIcon(new ImageIcon(TEST.class.getResource("/Image/g1.png")));
		}else if(obj == h1) {
			h1.setIcon(new ImageIcon(TEST.class.getResource("/Image/h1.png")));
		}
		
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == InfoButton) {
			Info frame = new Info();
		}else if(obj == MailButton) {
			try {
				Desktop.getDesktop().browse(new URL("https://mail.google.com/").toURI());
			}catch(Exception evt) {
				return;
			}
		}else if(obj == BrowseButton) {
			try {
				Desktop.getDesktop().browse(new URL("http://www.google.com").toURI());
			}catch(Exception evt) {
				return;
			}
		}else if(obj == CalenderButton) {
			Calender cal = new Calender();
		}
			
		
	}
}
