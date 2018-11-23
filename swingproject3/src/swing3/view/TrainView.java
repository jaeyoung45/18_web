package swing3.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import swing3.model.TrainBean;
import swing3.model.TrainDBA;
import swing3.model.TrainBean;
import swing3.model.TrainDBA;

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

public class TrainView extends JFrame {
   TrainDBA dba = new TrainDBA();
   ArrayList<TrainBean> arr;
   private JPanel contentPane;
   private JSplitPane splitPane;
   private JSplitPane splitPane_1;
   private JSplitPane splitPane_2;
   private JPanel panel;
   private JLabel label;
   private JLabel label_1;
   private JLabel lblNewLabel;
   private JLabel lblNewLabel_1;
   private JTextField tfDepart;
   private JTextField tfArrival;
   private JTextField tfPerson;
   private JTextField tfTraintype;
   private JTextField tfNum;
   private JScrollPane scrollPane;
   private JTable table;
   private JButton btnInsert;
   private JSplitPane splitPane_3;
   private JPanel panel_1;
   private JButton TrainView;
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
              TrainView frame = new TrainView();
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
   public TrainView() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 580, 540);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);
      contentPane.add(getSplitPane(), BorderLayout.CENTER);
      String[] cols= {"DEPART", "ARRIVAL", "PERSON", "TRAINTYPE"};
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
         panel.add(getTfDepart());
         panel.add(getTfArrival());
         panel.add(getTfPerson());
         panel.add(getTfTraintype());
      }
      return panel;
   }
   private JLabel getLabel() {
      if (label == null) {
         label = new JLabel("출발역");
         label.setHorizontalAlignment(SwingConstants.RIGHT);
         label.setBounds(31, 29, 57, 15);
      }
      return label;
   }
   private JLabel getLabel_1() {
      if (label_1 == null) {
         label_1 = new JLabel("도착역");
         label_1.setHorizontalAlignment(SwingConstants.RIGHT);
         label_1.setBounds(31, 73, 57, 15);
      }
      return label_1;
   }
   private JLabel getLblNewLabel() {
      if (lblNewLabel == null) {
         lblNewLabel = new JLabel("인원");
         lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel.setBounds(31, 117, 57, 15);
      }
      return lblNewLabel;
   }
   private JLabel getLblNewLabel_1() {
      if (lblNewLabel_1 == null) {
         lblNewLabel_1 = new JLabel("열차종류");
         lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
         lblNewLabel_1.setBounds(31, 161, 57, 15);
      }
      return lblNewLabel_1;
   }
   private JTextField getTfDepart() {
      if (tfDepart == null) {
         tfDepart = new JTextField();
         tfDepart.setBounds(108, 26, 116, 21);
         tfDepart.setColumns(10);
      }
      return tfDepart;
   }
   private JTextField getTfArrival() {
      if (tfArrival == null) {
         tfArrival = new JTextField();
         tfArrival.setBounds(108, 70, 116, 21);
         tfArrival.setColumns(10);
      }
      return tfArrival;
   }
   private JTextField getTfPerson() {
      if (tfPerson == null) {
         tfPerson = new JTextField();
         tfPerson.setBounds(108, 114, 116, 21);
         tfPerson.setColumns(10);
      }
      return tfPerson;
   }
   private JTextField getTfTraintype() {
      if (tfTraintype == null) {
         tfTraintype = new JTextField();
         tfTraintype.setBounds(108, 158, 116, 21);
         tfTraintype.setColumns(10);
      }
      return tfTraintype;
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
               taView.append("출발역 :"+arr.get(i).getDepart()+"\n");
               taView.append("도착역 :"+arr.get(i).getArrival()+"\n");
               taView.append("인원 :"+arr.get(i).getPerson()+"\n");
               taView.append("열차종류 :"+arr.get(i).getTraintype()+"\n");
             
               
               tfDepart.setText(arr.get(i).getDepart());
               tfArrival.setText(arr.get(i).getArrival());
               tfPerson.setText(arr.get(i).getPerson());
               tfTraintype.setText(arr.get(i).getTraintype());           
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
               TrainBean b = new TrainBean();
               b.setDepart(tfDepart.getText());
               b.setArrival(tfArrival.getText());
               b.setPerson((tfPerson.getText()));
               b.setTraintype(tfTraintype.getText());
               dba.trainInsert(t);
               TrainView.doClick();
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
         panel_1.add(getTrainView());
         panel_1.add(getBookDelete());
         panel_1.add(getBookUpdate());
      }
      return panel_1;
   }
   private JButton getTrainView() {
      if (TrainView == null) {
         TrainView = new JButton("보기");
         TrainView.addActionListener(new ActionListener() {               
            public void actionPerformed(ActionEvent e) {
            arr = dba.bookView();
                  String[] cols = {"DEPART", "ARRIVAL", "PERSON", "TRAINTYPE"};
                  DefaultTableModel dt = new DefaultTableModel(cols,arr.size());
                  table.setModel(dt);
                  for(int i=0; i<arr.size(); i++) {
                     dt.setValueAt(arr.get(i).getDepart(),i, 0);
                     dt.setValueAt(arr.get(i).getArrival(),i, 1);
                     dt.setValueAt(arr.get(i).getPerson(),i, 2);
                     dt.setValueAt(arr.get(i).getTraintype(),i, 3);
                  }
               
            }
         });
         TrainView.setBounds(16, 30, 70, 23);
      }
      return TrainView;
   }
   private JButton getBookDelete() {
      if (bookDelete == null) {
         bookDelete = new JButton("삭제");
         bookDelete.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {
               int result = JOptionPane.showConfirmDialog(null, "삭제할까요?", "Confirm", JOptionPane.YES_NO_OPTION);
                  if((result==JOptionPane.YES_OPTION)) {//삭제                     
                     dba.Delete(row);
                     TrainView.doClick(); 
                     
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
               TrainBean t = new TrainBean();
               t.setDepart(tfDepart.getText());
               t.setArrival(tfArrival.getText());
               t.setPerson(tfPerson.getText());
               t.setTraintype(tfTraintype.getText());
               dba.BookUpdate(t);
               
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