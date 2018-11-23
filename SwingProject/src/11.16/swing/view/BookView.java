package swing.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import swing.model.BookBean;
import swing.model.BookDBA;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

public class BookView extends JFrame {
   BookDBA dba = new BookDBA();
   ArrayList<BookBean> arr;
   private JPanel contentPane;
   private JSplitPane splitPane;
   private JSplitPane splitPane_1;
   private JSplitPane splitPane_2;
   private JPanel panel;
   private JLabel label;
   private JLabel label_1;
   private JLabel lblNewLabel;
   private JLabel lblNewLabel_1;
   private JLabel lblNewLabel_2;
   private JLabel lblNewLabel_3;
   private JTextField tfTitle;
   private JTextField tfWriter;
   private JTextField tfIndate;
   private JTextField tfOutdate;
   private JTextField tfGubun;
   private JTextField tfPrice;
   private JTextField tfNum;
   private JScrollPane scrollPane;
   private JTable table;
   private JButton btnInsert;
   private JSplitPane splitPane_3;
   private JPanel panel_1;
   private JButton btnView;
   private JButton bookDelete;
   private JButton bookUpdate;
   private JTextArea taView;
   private int row;
   DecimalFormat df = new DecimalFormat("###,###");
   
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               BookView frame = new BookView();
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
   public BookView() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 580, 540);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);
      contentPane.add(getSplitPane(), BorderLayout.CENTER);
      String[] cols= {"TITLE", "WRITER","OUTDATE","PRICE"};
      DefaultTableModel dt = new DefaultTableModel(cols, 0);
      table.setModel(dt);
   }

   private JSplitPane getSplitPane() {
      if (splitPane == null) {
         splitPane = new JSplitPane();
         splitPane.setLeftComponent(getSplitPane_1());
         splitPane.setRightComponent(getSplitPane_3());
         splitPane.setDividerLocation(270);
      }
      return splitPane;
   }
   private JSplitPane getSplitPane_1() {
      if (splitPane_1 == null) {
         splitPane_1 = new JSplitPane();
         splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
         splitPane_1.setRightComponent(getSplitPane_2());
         splitPane_1.setLeftComponent(getScrollPane());
         splitPane_1.setDividerLocation(150);
      }
      return splitPane_1;
   }
   private JSplitPane getSplitPane_2() {
      if (splitPane_2 == null) {
         splitPane_2 = new JSplitPane();
         splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
         splitPane_2.setLeftComponent(getPanel());
         splitPane_2.setRightComponent(getBtnInsert());
         splitPane_2.setDividerLocation(290);
      }
      return splitPane_2;
   }
   private JPanel getPanel() {
      if (panel == null) {
         panel = new JPanel();
         panel.setLayout(null);
         panel.add(getLabel());
         panel.add(getLabel_1());
         panel.add(getLblNewLabel());
         panel.add(getLblNewLabel_1());
         panel.add(getLblNewLabel_2());
         panel.add(getLblNewLabel_3());
         panel.add(getTfTitle());
         panel.add(getTfWriter());
         panel.add(getTfIndate());
         panel.add(getTfOutdate());
         panel.add(getTfGubun());
         panel.add(getTfPrice());
      }
      return panel;
   }
   private JLabel getLabel() {
      if (label == null) {
         label = new JLabel("\uC81C\uBAA9");
         label.setHorizontalAlignment(SwingConstants.RIGHT);
         label.setBounds(31, 29, 57, 15);
      }
      return label;
   }
   private JLabel getLabel_1() {
      if (label_1 == null) {
         label_1 = new JLabel("\uC800\uC790");
         label_1.setHorizontalAlignment(SwingConstants.RIGHT);
         label_1.setBounds(31, 73, 57, 15);
      }
      return label_1;
   }
   private JLabel getLblNewLabel() {
      if (lblNewLabel == null) {
         lblNewLabel = new JLabel("\uC785\uACE0\uB0A0\uC9DC");
         lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel.setBounds(31, 117, 57, 15);
      }
      return lblNewLabel;
   }
   private JLabel getLblNewLabel_1() {
      if (lblNewLabel_1 == null) {
         lblNewLabel_1 = new JLabel("\uCD9C\uACE0\uB0A0\uC9DC");
         lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_1.setBounds(31, 161, 57, 15);
      }
      return lblNewLabel_1;
   }
   private JLabel getLblNewLabel_2() {
      if (lblNewLabel_2 == null) {
         lblNewLabel_2 = new JLabel("\uCC45\uBD84\uB958");
         lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_2.setBounds(31, 205, 57, 15);
      }
      return lblNewLabel_2;
   }
   private JLabel getLblNewLabel_3() {
      if (lblNewLabel_3 == null) {
         lblNewLabel_3 = new JLabel("\uAC00\uACA9");
         lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_3.setBounds(31, 249, 57, 15);
      }
      return lblNewLabel_3;
   }
   private JTextField getTfTitle() {
      if (tfTitle == null) {
         tfTitle = new JTextField();
         tfTitle.setBounds(108, 26, 116, 21);
         tfTitle.setColumns(10);
      }
      return tfTitle;
   }
   private JTextField getTfWriter() {
      if (tfWriter == null) {
         tfWriter = new JTextField();
         tfWriter.setBounds(108, 70, 116, 21);
         tfWriter.setColumns(10);
      }
      return tfWriter;
   }
   private JTextField getTfIndate() {
      if (tfIndate == null) {
         tfIndate = new JTextField();
         tfIndate.setBounds(108, 114, 116, 21);
         tfIndate.setColumns(10);
      }
      return tfIndate;
   }
   private JTextField getTfOutdate() {
      if (tfOutdate == null) {
         tfOutdate = new JTextField();
         tfOutdate.setBounds(108, 158, 116, 21);
         tfOutdate.setColumns(10);
      }
      return tfOutdate;
   }
   private JTextField getTfGubun() {
      if (tfGubun == null) {
         tfGubun = new JTextField();
         tfGubun.setBounds(108, 202, 116, 21);
         tfGubun.setColumns(10);
      }
      return tfGubun;
   }
   private JTextField getTfPrice() {
      if (tfPrice == null) {
         tfPrice = new JTextField();
         tfPrice.setBounds(108, 246, 116, 21);
         tfPrice.setColumns(10);
      }
      return tfPrice;
   }
   private JScrollPane getScrollPane() {
      if (scrollPane == null) {
         scrollPane = new JScrollPane();
         scrollPane.setViewportView(getTable());
      }
      return scrollPane;
   }
   private JTable getTable() {
      if (table == null) {
         table = new JTable();
         table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               int i=table.getSelectedRow();
               taView.append("번호 :"+arr.get(i).getNum()+"\n");
               taView.append("제목 :"+arr.get(i).getTitle()+"\n");
               taView.append("저자 :"+arr.get(i).getWriter()+"\n");
               taView.append("입고일 :"+arr.get(i).getIndate()+"\n");
               taView.append("출고일 :"+arr.get(i).getOutdate()+"\n");
               taView.append("구분 :"+arr.get(i).getGubun()+"\n");
               taView.append("가격 :"+df.format(arr.get(i).getPrice())+"\n\n");
               
               tfWriter.setText(arr.get(i).getWriter());
               tfTitle.setText(arr.get(i).getTitle());
               tfIndate.setText(arr.get(i).getIndate());
               tfOutdate.setText(arr.get(i).getOutdate());
               tfGubun.setText(arr.get(i).getGubun());
               tfPrice.setText(df.format(arr.get(i).getPrice())+"");               
               row=arr.get(i).getNum();
            }
         });
      }
      return table;
   }
   private JButton getBtnInsert() {
      if (btnInsert == null) {
         btnInsert = new JButton("입력하기");
         btnInsert.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {               
               BookBean b = new BookBean();
               b.setTitle(tfTitle.getText());
               b.setWriter(tfWriter.getText());
               b.setIndate(tfIndate.getText());
               b.setOutdate(tfOutdate.getText());
               b.setGubun(tfGubun.getText());               
               b.setPrice(Integer.parseInt(tfPrice.getText()));
               dba.bookInsert(b);
               btnView.doClick();
            }
         });         
      }
      return btnInsert;
   }
   private JSplitPane getSplitPane_3() {
      if (splitPane_3 == null) {
         splitPane_3 = new JSplitPane();
         splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
         splitPane_3.setRightComponent(getPanel_1());
         splitPane_3.setLeftComponent(getTaView());
         splitPane_3.setDividerLocation(420);
      }
      return splitPane_3;
   }
   private JPanel getPanel_1() {
      if (panel_1 == null) {
         panel_1 = new JPanel();
         panel_1.setLayout(null);
         panel_1.add(getBtnView());
         panel_1.add(getBookDelete());
         panel_1.add(getBookUpdate());
      }
      return panel_1;
   }
   private JButton getBtnView() {
      if (btnView == null) {
         btnView = new JButton("보기");
         btnView.addActionListener(new ActionListener() {               
            public void actionPerformed(ActionEvent e) {
            arr = dba.bookView();
//                  for(BookBean b:arr) {
//                     taView.append("번호 :"+b.getNum()+"\n");
//                     taView.append("제목 :"+b.getTitle()+"\n");
//                     taView.append("저자 :"+b.getWriter()+"\n");
//                     taView.append("입고날짜 :"+b.getIndate()+"\n");
//                     taView.append("출고날짜 :"+b.getOutdate()+"\n");
//                     taView.append("책분류 :"+b.getGubun()+"\n");
//                     taView.append("가격 :"+b.getPrice()+"\n\n");
//                  }
                  String[] cols = {"TITLE", "WRITER", "OUTDATE", "PRICE"};
                  DefaultTableModel dt = new DefaultTableModel(cols,arr.size());
                  table.setModel(dt);
                  for(int i=0; i<arr.size(); i++) {
                     dt.setValueAt(arr.get(i).getTitle(),i, 0);
                     dt.setValueAt(arr.get(i).getWriter(),i, 1);
                     dt.setValueAt(arr.get(i).getOutdate(),i, 2);
                     dt.setValueAt(arr.get(i).getPrice(),i, 3);
                  }
               
            }
         });
         btnView.setBounds(16, 30, 70, 23);
      }
      return btnView;
   }
   private JButton getBookDelete() {
      if (bookDelete == null) {
         bookDelete = new JButton("삭제");
         bookDelete.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {
               int result = JOptionPane.showConfirmDialog(null, "삭제할까요?", "Confirm", JOptionPane.YES_NO_OPTION);
                  if((result==JOptionPane.YES_OPTION)) {//삭제                     
                     dba.bookDelete(row);
                     btnView.doClick(); 
                     
                  }                           
            }
         });
         bookDelete.setBounds(102, 30, 70, 23);
      }
      return bookDelete;
   }
   private JButton getBookUpdate() {
      if (bookUpdate == null) {
         bookUpdate = new JButton("수정");
         bookUpdate.addActionListener(new ActionListener() {                     
            public void actionPerformed(ActionEvent e) {
               BookBean b = new BookBean();
               b.setNum(row);//전역 사용한 변수
               b.setTitle(tfTitle.getText());
               b.setWriter(tfWriter.getText());
               b.setIndate(tfIndate.getText());
               b.setOutdate(tfOutdate.getText());
               b.setGubun(tfGubun.getText());
               b.setPrice(Integer.parseInt(tfPrice.getText()));
               dba.bookUpdate(b);
               
            }
         });
         bookUpdate.setBounds(188, 30, 70, 23);
      }
      return bookUpdate;
   }
   private JTextArea getTaView() {
      if (taView == null) {
         taView = new JTextArea();
      }
      return taView;
   }
}