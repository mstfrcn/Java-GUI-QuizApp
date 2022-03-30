package QuizApp;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class fonksiyonlar {
	Sorular sorular = new Sorular();

	public void soruYazdir(int soruSayisi, JLabel text) {
		text.setText(sorular.sorular[soruSayisi]);
	}

	public void sikYazdir(int soruSayisi, JRadioButton[] bg) {
		for (int i = 0; i < 4; i++) {
			bg[i].setText(sorular.siklar[i + (soruSayisi * 4)]);
		}
	}

	public void kontrolEt(int soruSayisi, JRadioButton[] bg, JButton buton) {
		if (bg[sorular.cevaplar[soruSayisi]].isSelected()) {
			buton.setText("Dogru");
			buton.setBackground(Color.GREEN);
		}
		else {
			buton.setText("Yanlis");
			buton.setBackground(Color.RED);
		}
	}
	
	public void butonSifirla(JButton buton) {
		buton.setText("Kontrol Et");
		buton.setBackground(new Color(240,240,240));
		
	}
}
