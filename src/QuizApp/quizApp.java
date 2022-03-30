package QuizApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class quizApp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quizApp frame = new quizApp();
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
	JRadioButton[] rb = new JRadioButton[4];
	ButtonGroup bg = new ButtonGroup();
	Sorular sorular = new Sorular();
	fonksiyonlar fonksiyonlar = new fonksiyonlar();
	public int soruSayisi=0;
	
	public quizApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 501);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(41, 32, 620, 153);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSoruAlani = new JLabel("New label");
		lblSoruAlani.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSoruAlani.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoruAlani.setBounds(10, 11, 600, 131);
		panel.add(lblSoruAlani);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(41, 212, 620, 184);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.setBounds(51, 407, 99, 32);
		contentPane.add(btnGeri);
		
		JButton btnIleri = new JButton("Ileri");
		btnIleri.setBounds(550, 407, 99, 32);
		contentPane.add(btnIleri);
		
		JButton btnKontrol = new JButton("Kontrol");
		btnKontrol.setBounds(302, 407, 99, 32);
		contentPane.add(btnKontrol);
		// Radio Butonlari Olusturma
		int konum = 10;
		for(int i=0; i<4; i++) {
			rb[i] = new JRadioButton("New radio button");
			rb[i].setFont(new Font("Tahoma", Font.PLAIN, 15));
			rb[i].setBounds(6,10+konum, 608, 23);
			konum+=40;
			panel_1.add(rb[i]);
			bg.add(rb[i]);
		}
		// SIKLARI ILK YAZDIRMA
		fonksiyonlar.sikYazdir(soruSayisi, rb);
		// SORUYU ILK YAZDIRMA
		fonksiyonlar.soruYazdir(0, lblSoruAlani);
		// ILEERI BUTONU EVENTI
		btnIleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(soruSayisi < sorular.sorular.length-1) {
					soruSayisi += 1;
				}
				fonksiyonlar.soruYazdir(soruSayisi, lblSoruAlani);
				fonksiyonlar.sikYazdir(soruSayisi, rb);
				fonksiyonlar.butonSifirla(btnKontrol);
			}
		});
		// GERI BUTONU EVENTI
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(soruSayisi > 0) {
					soruSayisi -= 1;
				}
				fonksiyonlar.soruYazdir(soruSayisi, lblSoruAlani);
				fonksiyonlar.sikYazdir(soruSayisi, rb);
				fonksiyonlar.butonSifirla(btnKontrol);
			}
		});
		
		// KONTROL BUTONU EVENTI
		btnKontrol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fonksiyonlar.kontrolEt(soruSayisi, rb, btnKontrol);
				
			}
		});
		
		
		
	}
}
