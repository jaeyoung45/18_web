package chap09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class ScrollTest extends JFrame implements AdjustmentListener{
	private JPanel p, p1;
	private JScrollBar sbr, sbg, sbb;
	
	public ScrollTest() {
		super("스크롤바 연습");
		setLayout(new BorderLayout());
		p = new JPanel();
		sbr = new JScrollBar(JScrollBar.HORIZONTAL, 0,1,0,255); //가로스크롤바
		sbg = new JScrollBar(JScrollBar.HORIZONTAL, 150,1,0,255); 
		sbb = new JScrollBar(JScrollBar.HORIZONTAL, 50,1,0,255);
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(3,1));
		p1.add(sbr);
		p1.add(sbg);
		p1.add(sbb);
		sbr.addAdjustmentListener(this);
		sbg.addAdjustmentListener(this);
		sbb.addAdjustmentListener(this);
		add(BorderLayout.NORTH,p1);
		add(BorderLayout.CENTER,p);
		
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ScrollTest();
	}
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		Color bg = new Color(sbr.getValue(),sbg.getValue(),sbb.getValue());
		p.setBackground(bg);
		
	}

}
