package Friend;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FriendView extends JFrame {

   private JPanel contentPane;
   private JSplitPane splitPane;
   private JPanel panel;
   private JLabel lb1;
   private JLabel lb2;
   private JLabel lb3;
   private JLabel lb4;
   private JTextField tfName;
   private JTextField tfBirth;
   private JTextField tfPhone;
   private JTextField tfAddr;
   private JButton btnView;
   private JButton btnInsert;
   private JSplitPane splitPane_1;
   private JScrollPane scrollPane;
   private JTextArea taView;
   private JPanel panel_1;
   private JComboBox comSel;
   private JTextField tfSearch;
   private JButton btnSearch;
   private JButton btnUpdate;
   private JButton btnDelete;
   FriendDBA dba;
   
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               FriendView frame = new FriendView();
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
   public FriendView() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 640, 480);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);
      contentPane.add(getSplitPane(), BorderLayout.CENTER);
   }

   private JSplitPane getSplitPane() {
      if (splitPane == null) {
         splitPane = new JSplitPane();
         splitPane.setLeftComponent(getPanel());
         splitPane.setRightComponent(getSplitPane_1());
         splitPane.setDividerLocation(300);
      }
      return splitPane;
   }
   private JPanel getPanel() {
      if (panel == null) {
         panel = new JPanel();
         panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "\uCE5C\uAD6C\uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
         panel.setLayout(null);
         panel.add(getLb1());
         panel.add(getLb2());
         panel.add(getLb3());
         panel.add(getLb4());
         panel.add(getTfName());
         panel.add(getTfBirth());
         panel.add(getTfPhone());
         panel.add(getTfAddr());
         panel.add(getBtnView());
         panel.add(getBtnInsert());
      }
      return panel;
   }
   private JLabel getLb1() {
      if (lb1 == null) {
         lb1 = new JLabel("이름");
         lb1.setBounds(45, 71, 57, 15);
      }
      return lb1;
   }
   private JLabel getLb2() {
      if (lb2 == null) {
         lb2 = new JLabel("생일");
         lb2.setBounds(45, 114, 57, 15);
      }
      return lb2;
   }
   private JLabel getLb3() {
      if (lb3 == null) {
         lb3 = new JLabel("전화번호");
         lb3.setBounds(22, 158, 57, 15);
      }
      return lb3;
   }
   private JLabel getLb4() {
      if (lb4 == null) {
         lb4 = new JLabel("주소");
         lb4.setBounds(45, 196, 41, 15);
      }
      return lb4;
   }
   private JTextField getTfName() {
      if (tfName == null) {
         tfName = new JTextField();
         tfName.setBounds(96, 71, 130, 21);
         tfName.setColumns(10);
      }
      return tfName;
   }
   private JTextField getTfBirth() {
      if (tfBirth == null) {
         tfBirth = new JTextField();
         tfBirth.setBounds(96, 114, 130, 21);
         tfBirth.setColumns(10);
      }
      return tfBirth;
   }
   private JTextField getTfPhone() {
      if (tfPhone == null) {
         tfPhone = new JTextField();
         tfPhone.setBounds(96, 158, 130, 21);
         tfPhone.setColumns(10);
      }
      return tfPhone;
   }
   private JTextField getTfAddr() {
      if (tfAddr == null) {
         tfAddr = new JTextField();
         tfAddr.setBounds(96, 196, 130, 21);
         tfAddr.setColumns(100);
      }
      return tfAddr;
   }
   private JButton getBtnView() {
      if (btnView == null) {
         btnView = new JButton("전체보기");
         btnView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               ArrayList<Friend> arr = dba.friendView();
               for(Friend f:arr) {
                  taView.append("번호 :"+f.getNum()+"\n");
                  taView.append("이름 :"+f.getName()+"\n");
                  taView.append("전화번호 :"+f.getPhone()+"\n\n");
               }
            }
         });
         btnView.setBounds(26, 283, 97, 23);
      }
      return btnView;
   }
   private JButton getBtnInsert() {
      if (btnInsert == null) {
         btnInsert = new JButton("추가");
         btnInsert.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {
            Friend f = new Friend();
            f.setName(tfName.getText());
            f.setBirth(tfBirth.getText());
            f.setPhone(tfPhone.getText());
            f.setAddr(tfAddr.getText());
            dba.friendInsert(f);
               
            }
         });
         btnInsert.setBounds(174, 283, 97, 23);
      }
      return btnInsert;
   }
   private JSplitPane getSplitPane_1() {
      if (splitPane_1 == null) {
         splitPane_1 = new JSplitPane();
         splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
         splitPane_1.setLeftComponent(getScrollPane());
         splitPane_1.setRightComponent(getPanel_1());
         splitPane_1.setDividerLocation(350);
      }
      return splitPane_1;
   }
   private JScrollPane getScrollPane() {
      if (scrollPane == null) {
         scrollPane = new JScrollPane();
         scrollPane.setBorder(new TitledBorder(null, "\uC804\uCCB4\uBCF4\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, null));
         scrollPane.setViewportView(getTaView());
      }
      return scrollPane;
   }
   private JTextArea getTaView() {
      if (taView == null) {
         taView = new JTextArea();
         taView.setBorder(new LineBorder(new Color(128, 128, 128)));
      }
      return taView;
   }
   private JPanel getPanel_1() {
      if (panel_1 == null) {
         panel_1 = new JPanel();
         panel_1.setLayout(null);
         panel_1.add(getComSel());
         panel_1.add(getTfSearch());
         panel_1.add(getBtnSearch());
      }
      return panel_1;
   }
   private JComboBox getComSel() {
      if (comSel == null) {
         comSel = new JComboBox();
         comSel.setModel(new DefaultComboBoxModel(new String[] {"선택하세요", "이름", "주소"}));
         comSel.setBounds(12, 25, 93, 21);
      }
      return comSel;
   }
   private JTextField getTfSearch() {
      if (tfSearch == null) {
         tfSearch = new JTextField();
         tfSearch.setBounds(109, 25, 124, 21);
         tfSearch.setColumns(10);
      }
      return tfSearch;
   }
   private JButton getBtnSearch() {
      if (btnSearch == null) {
         btnSearch = new JButton("찾기");
         btnSearch.addActionListener(new ActionListener() {            
            
            public void actionPerformed(ActionEvent e) {
               taView.setText("");
               String str="";
               if(comSel.getSelectedIndex()==1) {
                  str="name";                  
               }else if(comSel.getSelectedIndex()==2) {
                  str="addr";
               }else {
                  tfSearch.setText("선택오류");
                  return;
               }
               ArrayList<Friend> arr = dba.friendSearch(str, tfSearch.getText());
               for(Friend f:arr) {
                  taView.append("번호 :"+f.getNum()+"\n");
                  taView.append("이름 :"+f.getName()+"\n");
                  taView.append("생일 :"+f.getBirth()+"\n");
                  taView.append("전화번호 :"+f.getPhone()+"\n");
                  taView.append("주소 :"+f.getAddr()+"\n\n");
               }
            }
         });
         btnSearch.setBounds(237, 24, 57, 23);
      }
      return btnSearch;
   }
}
	