package chap08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {

   public static void main(String[] args) {
      FileInputStream fis = null;
      FileWriter fos = null;
      try {
         fis = new FileInputStream(new File("ha.txt"));
         try {
         fos = new FileWriter("ho.txt");
         } catch (IOException e1) {
            e1.printStackTrace();
         }
         int cnt=1;
         int c;
      try {
         while((c=fis.read())!=-1) {
            if(c==13) {
               fos.write("\n"+cnt+":");
            }else {   
                fos.write((char)c);
                cnt++;
            }
         }
         fis.close();
         fos.close();
      } catch (IOException e) {         
         e.printStackTrace();
      }
         
      } catch (FileNotFoundException e) {         
         e.printStackTrace();
      } 

   }
}