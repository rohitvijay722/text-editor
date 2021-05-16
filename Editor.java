import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.regex.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;

class Editor extends WindowAdapter implements ActionListener
{
JFrame f,f5;
JLabel l5,l6,l7;
JTextField t5,t6,t7;
JPanel p5,p6;
JButton b5,b6,b7,b8,b9,b10;
JMenuBar mb;
JMenu m1,m2;
JMenuItem nw,opn,sve,sveas,exit,cu,cpy,pst;
JTextArea ta;
String str;
FileInputStream fis;
FileDialog fd;
File fi,fi2,fi3;
FileOutputStream fos,fos2;
Thread t1;
public Editor()
{
f=new JFrame();f.addWindowListener(this);
f.setVisible(true);
f.setSize(400,400);
ta=new JTextArea();
mb=new JMenuBar();
m1=new JMenu("File");
m2=new JMenu("Edit");
nw=new JMenuItem("New"); nw.addActionListener(this);
opn=new JMenuItem("Open..."); opn.addActionListener(this);
sve=new JMenuItem("Save");  sve.addActionListener(this);
sveas=new JMenuItem("Save As...");  sveas.addActionListener(this);
exit=new JMenuItem("Exit"); exit.addActionListener(this);
cu=new JMenuItem("Cut");cu.addActionListener(this);
cpy=new JMenuItem("Copy");cpy.addActionListener(this);
pst=new JMenuItem("Paste");pst.addActionListener(this);

m1.add(nw); m1.add(opn); m1.add(sve); m1.add(sveas); m1.addSeparator(); m1.add(exit);
m2.add(cu);m2.add(cpy);m2.add(pst);
mb.add(m1); mb.add(m2);
f.setJMenuBar(mb);  f.add(ta);
}
public void actionPerformed(ActionEvent e)
{
 str=e.getActionCommand();
 switch(str)
 {
 case "New":
  {ta.setText("");
  break;}
 case "Exit":
  {
   System.exit(0);
   break;}
  case "Open...":
  {
   ta.setText("");
  fd=new FileDialog(f,"SELECT",FileDialog.LOAD);
  fd.setVisible(true);
  String path,name;
  name=fd.getFile();
  path=fd.getDirectory();
  try{
  fi=new File(path,name);
  if(!fi.exists())
  {System.out.print("File does not exist");}
  fis=new FileInputStream(fi);
  BufferedInputStream bis=new BufferedInputStream(fis);
  int ch;  
  while((ch=bis.read())!=-1)
  {
    char ch1=(char)ch;
    String ch2=""+ch1; 
    ta.setText(ta.getText()+ch2);                     
  }
  bis.close(); 
  }
  catch(IOException e1)
  {
   String s=e1.getMessage();
   System.out.print(s);
  }
  catch(Exception e11){}
  break;}
 
   case "Save":
    {
     fd=new FileDialog(f,"SELECT",FileDialog.SAVE);
     fd.setVisible(true);
     String n,p;
     n=fd.getFile();
     p=fd.getDirectory();
     try{
     fi2=new File(p,n);
     String str9=ta.getText();
     char arr[]=str9.toCharArray();
     fos=new FileOutputStream(fi2);
      for(int i=0;i<arr.length;i++)
      {  
       fos.write(arr[i]);
      }
     }
     catch(IOException er)
     {  System.out.print(er.getMessage());}
     catch(Exception e11){}
      break;
    }
    case "Save As...":
    {
     fd=new FileDialog(f,"SELECT",FileDialog.SAVE);
     fd.setVisible(true);
       String na,di;
       na=fd.getFile();
       di=fd.getDirectory();
       try{
       fi3=new File(di,na);
       String str8=ta.getText();
       char arr2[]=str8.toCharArray();
       fos2=new FileOutputStream(fi3);
        for(int i=0;i<arr2.length;i++)
        { 
         fos2.write(arr2[i]);
        }
      }
     catch(IOException e9)
     {
      System.out.print(e9.getMessage());
     }
     catch(Exception e10)
     {}
     break;
    }
  
    case "Close":
    {
     f5.setVisible(false);
     break;
    }
 
    case "Cut":
    {
     ta.cut();break;
    }
    case "Copy":
    {
     ta.copy();break; 
    } 
    case "Paste":
    {
     ta.paste();break; 
    }
 }
}
public void windowClosing(WindowEvent w)
{
Window we=w.getWindow();
we.dispose();
we.setVisible(true);
System.exit(0);
}
public static void main(String args[]) throws IOException
{
new Editor();

}
}
 








