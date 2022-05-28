package Test;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Page2 extends JFrame implements MouseListener, MouseMotionListener {

	private JPanel contentPane, TitlePane;
	private JButton ExitButton;
	private int tx, ty;
	
	static JPanel MainPane;
	JPanel Pane0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page2 frame = new Page2();
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

	public Page2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TEST.class.getResource("/Image/IconImg.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 574);
		setLocation(600,200);
		setResizable(false);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setVisible(true);
		
		JPanel MenuPane = new JPanel();
		MenuPane.setBackground(new Color(135, 206, 250));
		MenuPane.setBounds(0, 29, 571, 51);
		contentPane.add(MenuPane);
		MenuPane.setLayout(null);
		
		MainPane = new JPanel();
		MainPane.setBackground(UIManager.getColor("Button.background"));
		MainPane.setBounds(0, 81, 571, 493);
		contentPane.add(MainPane);
		MainPane.setLayout(null);
		
		Pane0 = new JPanel();
		Pane0.setBounds(6, 6, 559, 481);
		MainPane.add(Pane0);
		Pane0.setLayout(null);
		Pane0.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(57, 92, 61, 16);
		Pane0.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("전문의");
		lblNewLabel_1.setIcon(new ImageIcon(Page2.class.getResource("/Image/Doc.png")));
		lblNewLabel_1.setBounds(21, 6, 115, 58);
		Pane0.add(lblNewLabel_1);
		
		JLabel lblTel = new JLabel("TEL");
		lblTel.setIcon(new ImageIcon(Page2.class.getResource("/Image/Tel.png")));
		lblTel.setBounds(21, 160, 115, 44);
		Pane0.add(lblTel);
		
		JLabel lblNewLabel_3 = new JLabel(" Address");
		lblNewLabel_3.setIcon(new ImageIcon(Page2.class.getResource("/Image/locations.png")));
		lblNewLabel_3.setBounds(21, 216, 115, 44);
		Pane0.add(lblNewLabel_3);
		
		JPanel Pane0_1 = new JPanel();
		Pane0_1.setLayout(null);
		Pane0_1.setBackground(SystemColor.controlHighlight);
		Pane0_1.setBounds(21, 262, 514, 213);
		Pane0.add(Pane0_1);
		
		TitlePane = new JPanel();
		TitlePane.addMouseListener(this);
		TitlePane.addMouseMotionListener(this);
		TitlePane.setLayout(null);
		TitlePane.setBackground(new Color(100, 149, 237));
		TitlePane.setBounds(0, 0, 571, 29);
		contentPane.add(TitlePane);
		
		ExitButton = new JButton("");
		ExitButton.setBounds(523, 6, 31, 23);
		TitlePane.add(ExitButton);
		ExitButton.addMouseListener(this);
		ExitButton.setIcon(new ImageIcon(TEST.class.getResource("/Image/close.png")));
		ExitButton.setFocusable(false);
		ExitButton.setBorderPainted(false);
		ExitButton.setBackground(new Color(100, 149, 237));
	
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
