package chap09;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Memo extends JFrame{
	private JTextArea ta;
	private String fileName;
	public Memo(String title) {
		setTitle(title);
		JMenu mfile = new JMenu("파일");
		
		JMenuItem mOpen = new JMenuItem("열기");
		JMenuItem mNew = new JMenuItem("새파일");
		JMenuItem mSave = new JMenuItem("저장");
		JMenuItem mSaveAs = new JMenuItem("다른 이름으로 저장");
		JMenuItem mExit = new JMenuItem("끝내기");
		
		mfile.add(mNew);	
		mfile.add(mOpen);
		mfile.add(mSave);
		mfile.add(mSaveAs);
		mfile.addSeparator();
		mfile.add(mExit);
		
		JMenuBar mb = new JMenuBar();
		mb.add(mfile);
		
		setJMenuBar(mb);
		ta = new JTextArea();
		JScrollPane jsp = new JScrollPane(ta);
		add(jsp);
		//새파일
		mNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				setTitle("제목 없음");
			}
		});
		//열기
		mOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				//int a= fc.showOpenDialog(Memo.this);
				//if(a==1) return;
				if(fc.showOpenDialog(Memo.this)==JFileChooser.CANCEL_OPTION)
					return;
				File f = fc.getSelectedFile();
				fileName = f.getPath();
				setTitle(f.getName());
				//System.out.println("getPath :" +f.getPath());
				//System.out.println("getName :" +f.getName());
				fileRead(fileName);
				
			}
			
		});
		//저장
		mSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getTitle().equals("제목 없음")) { //새 파일
//					JFileChooser fc = new JFileChooser();
//					if(fc.showSaveDialog(Memo.this) == JFileChooser.CANCEL_OPTION)
//						return;
//					File f = fc.getSelectedFile();
//					fileName = f.getPath();
//					setTitle(f.getName());
//					fileSave(fileName);
					mSaveAs.doClick();
				}else {
					fileSave(fileName);
				}
				
			}
		});
		//다른 이름으로 저장
		mSaveAs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				/*int a = fc.showSaveDialog(Memo.this);
				 * if(a==1) return; */
				if(fc.showSaveDialog(Memo.this)==JFileChooser.CANCEL_OPTION)return;
				File f = fc.getSelectedFile();
				fileName = f.getPath();
				System.out.println("저장파일 :" +fileName);
				setTitle(f.getName());
				fileSave(fileName);
				
			}
		});
		//끝내기
		mExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		setSize(500, 400);
		setVisible(true);	
	}
	//파일 읽기 메소드
	private void fileRead(String fileName) {
		try {
		FileReader fr = new FileReader(fileName);
		StringWriter sw = new StringWriter();
		while(true) {
			int ch = fr.read();
			if(ch==-1) break;
			sw.write(ch);
		}
		sw.close();
		ta.setText(sw.toString());
	} catch (FileNotFoundException e) {	
		e.printStackTrace();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	//파일로 저장
	private void fileSave(String fileName) {
		try {
			PrintStream ps = new PrintStream(fileName);
			ps.println(ta.getText());
			ps.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Memo("제목 없음");

	}

}
