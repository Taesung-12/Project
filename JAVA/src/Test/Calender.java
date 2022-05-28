package Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;

public class Calender extends JFrame implements MouseListener, MouseMotionListener {

	private JPanel contentPane, mainPane;
	private JLabel ExitButton;
	private JPanel TitleBar;
	private int tx, ty;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calender frame = new Calender();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Calender() {
		setTitle("Calender");
		setBounds(100, 100, 450, 319);
		setLocation(240, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setContentPane(contentPane);
		
		mainPane = new GraPanel();
		contentPane.add(mainPane);
		mainPane.setLayout(null);
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPane.setBounds(0, 0, 450, 319);
		
		TitleBar = new JPanel();
		TitleBar.addMouseListener(this);
		TitleBar.addMouseMotionListener(this);
		TitleBar.setLayout(null);
		TitleBar.setBorder(new EmptyBorder(5, 5, 5, 5));
		TitleBar.setBackground(new Color(0,0,0,0));
		TitleBar.setBounds(0, 0, 450, 34);
		TitleBar.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		mainPane.add(TitleBar);
		
		JCalendar calendar = new JCalendar();
		calendar.getMonthChooser().getComboBox().setFont(new Font("맑은 고딕", Font.BOLD, 14));
		calendar.getDayChooser().getDayPanel().setBackground(SystemColor.control);
		calendar.getYearChooser().getSpinner().setFont(new Font("맑은 고딕", Font.BOLD, 14));
		calendar.setSundayForeground(Color.RED);
		calendar.setWeekdayForeground(Color.BLUE);
		calendar.setSize(438, 269);
		calendar.setLocation(6, 44);
		calendar.getDayChooser().setBounds(0, 26, 0, -26);
		calendar.getYearChooser().setBounds(98, 0, -98, 26);
		calendar.getMonthChooser().setBounds(0, 0, 98, 26);
		mainPane.add(calendar);
		
		ExitButton = new JLabel("");
		ExitButton.addMouseListener(this);
		ExitButton.setIcon(new ImageIcon(Calender.class.getResource("/Image/close.png")));
		ExitButton.setFocusable(false);
		ExitButton.setBackground(new Color(135, 206, 250));
		ExitButton.setBounds(410, 5, 31, 23);
		TitleBar.add(ExitButton);
		
	
		setVisible(true);
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
