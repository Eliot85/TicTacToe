import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;
/**
 * Write a description of class Test here.
 * 
 * @author Babi 
 * @version 
 * Alpha build 13.02.2015
 * Beta build 14.02.2015 (added Exit option in Menu and Enter screen and new Fonts(Bradley Hand ITC))
 * Gamma build 18.02.2015 (Player v/s Computer version)
 * Delta build 20.03.2015 (Added disabled buttons and undo option after win or draw and stopped a bug of computer winning after user wins)
 */
public class T
{ 
 public static void main(String[]args)
 {
  Test obj=new Test();
  obj.setDefaultCloseOperation(Test.EXIT_ON_CLOSE);
  obj.setBounds(500,150,400,400);
  obj.setResizable(false);
  obj.setVisible(true);
 }
}
class Test extends JFrame implements ActionListener
{
 GridBagLayout gbl,cgbl;
 GridBagConstraints cgb,gbc,gbcb,gbcc;
 JPanel panel,cpanel,panelc,wpanel;
 JMenuBar mb;
 JMenu m1,m2;
 JMenuItem i1,i2,i3,i4,i5,i6;
 JRadioButton rb1,rb2;
 JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,bc1,bc2,temp1,wb,cb1,cb2;
 JLabel lab1,lab2,lab3,lab4,lab5,lab6,lab7,lab8,lab9,lab10,lab11,lab12,lab13,lab14,lab15,lab16,lab17,lab18;
 JLabel lab19,lab20,lab21,lab22,lab,labd,labc1,labc2,temp2,labp,plab1,plab2;
 JTextField t1,t2,tp;
 Font f1,f2,f3;
 Border line;
 Container contentPane;
 int k,kk;
 String M[][]=new String[3][3],player,player1,player2,ss;int r=3,c=3,tempr,tempc,cm,cn;
 public Test()
 {
  super("Tic Tac Toe"+"\u00A9");
  k=1;kk=0;cm=0;cn=0;
  
  contentPane=getContentPane();
  
  cpanel=new JPanel();
  cpanel.setLayout(new GridLayout(3,2));
  
  wpanel=new JPanel();
  wpanel.setLayout(new BorderLayout());
  
  panelc=new JPanel();
  cgbl=new GridBagLayout();
  panelc.setLayout(cgbl);
  gbcc=new GridBagConstraints();
  gbcc.fill=GridBagConstraints.HORIZONTAL;
  
  line=BorderFactory.createLineBorder(Color.BLACK);
  
  mb=new JMenuBar();
  setJMenuBar(mb);
  
  m1=new JMenu("Options");
  mb.add(m1);
  
  m2=new JMenu("Help");
  mb.add(m2);
  
  i1=new JMenuItem("New Game");
  i1.addActionListener(this);
  m1.add(i1);
  
  i2=new JMenuItem("Reset Current Game");
  i2.addActionListener(this);
  m1.add(i2);
  
  i3=new JMenuItem("Undo Last Move");
  i3.addActionListener(this);
  m1.add(i3);
  
  i4=new JMenuItem("Instructions");
  i4.addActionListener(this);
  m2.add(i4);
  
  i5=new JMenuItem("About");
  i5.addActionListener(this);
  m2.add(i5);
  
  i6=new JMenuItem("Exit");
  i6.addActionListener(this);
  m1.add(i6);
  
  ButtonGroup bg=new ButtonGroup();
  
  rb1=new JRadioButton("Play with Computer");
  rb1.addActionListener(this);
  wpanel.add(rb1,BorderLayout.CENTER);
  
  rb2=new JRadioButton("Play with another Player");
  rb2.addActionListener(this);
  wpanel.add(rb2,BorderLayout.EAST);
  
  bg.add(rb1);
  bg.add(rb2);
  
  wb=new JButton("Start");
  wb.addActionListener(this);
  wpanel.add(wb,BorderLayout.SOUTH);
  
  f1=new Font("Bradley Hand ITC",Font.BOLD,20);
  f2=new Font("Segoe UI",Font.BOLD,25);
  f3=new Font("Bradley Hand ITC",Font.BOLD,25);
  
  labp=new JLabel("Player",SwingConstants.CENTER);
  gbcc.weightx=2.0;
  gbcc.weighty=2.0;
  gbcc.ipady=200;
  gbcc.gridx=1;
  gbcc.gridy=0;
  labp.setFont(f2);
  labp.setBorder(line);
  panelc.add(labp,gbcc);
  
  tp=new JTextField(5);
  gbcc.ipadx=150;
  gbcc.gridx=2;
  gbcc.gridy=0;
  tp.setFont(f3);
  tp.setBorder(line);
  panelc.add(tp,gbcc);
  
  plab1=new JLabel("Your turn...",SwingConstants.CENTER);
  plab1.setFont(f3);
  plab1.setBorder(line);
  
  plab2=new JLabel("Please wait ...",SwingConstants.CENTER);
  plab2.setFont(f1);
  plab2.setBorder(line);
  
  labc1=new JLabel("Player 1",SwingConstants.CENTER);
  labc1.setFont(f2);
  labc1.setBorder(line);
  cpanel.add(labc1);
  
  t1=new JTextField(5);
  t1.setFont(f3);
  t1.setBorder(line);
  cpanel.add(t1);
  
  labc2=new JLabel("Player 2",SwingConstants.CENTER);
  labc2.setFont(f2);
  labc2.setBorder(line);
  cpanel.add(labc2);
  
  t2=new JTextField(5);
  t2.setFont(f3);
  t2.setBorder(line);
  cpanel.add(t2);
  
  cb1=new JButton("Begin");
  gbcc.ipadx=50;
  gbcc.ipady=200;
  gbcc.weightx=0.0;
  gbcc.gridx=1;
  gbcc.gridy=1;
  cb1.setFont(f3);
  cb1.addActionListener(this);
  panelc.add(cb1,gbcc);
  
  cb2=new JButton("Quit");
  gbcc.gridx=2;
  gbcc.gridy=1;
  cb2.setFont(f3);
  cb2.addActionListener(this);
  panelc.add(cb2,gbcc);
  
  bc1=new JButton("Enter");
  bc1.setFont(f3);
  bc1.addActionListener(this);
  cpanel.add(bc1);
  
  bc2=new JButton("Quit");
  bc2.setFont(f3);
  bc2.addActionListener(this);
  cpanel.add(bc2);
  
  temp1=new JButton();
  temp2=new JLabel();
    
  lab1=new JLabel("X",SwingConstants.CENTER);
  lab1.setFont(f1);
  lab1.setBorder(line);
  
  lab2=new JLabel("O",SwingConstants.CENTER);
  lab2.setFont(f1);
  lab2.setBorder(line);
  
  lab3=new JLabel("X",SwingConstants.CENTER);
  lab3.setFont(f1);
  lab3.setBorder(line);
  
  lab4=new JLabel("O",SwingConstants.CENTER);
  lab4.setFont(f1);
  lab4.setBorder(line);
  
  lab5=new JLabel("X",SwingConstants.CENTER);
  lab5.setFont(f1);
  lab5.setBorder(line);
  
  lab6=new JLabel("O",SwingConstants.CENTER);
  lab6.setFont(f1);
  lab6.setBorder(line);
  
  lab7=new JLabel("X",SwingConstants.CENTER);
  lab7.setFont(f1);
  lab7.setBorder(line);
  
  lab8=new JLabel("O",SwingConstants.CENTER);
  lab8.setFont(f1);
  lab8.setBorder(line);
  
  lab9=new JLabel("X",SwingConstants.CENTER);
  lab9.setFont(f1);
  lab9.setBorder(line);
  
  lab10=new JLabel("O",SwingConstants.CENTER);
  lab10.setFont(f1);
  lab10.setBorder(line);
  
  lab11=new JLabel("X",SwingConstants.CENTER);
  lab11.setFont(f1);
  lab11.setBorder(line);
  
  lab12=new JLabel("O",SwingConstants.CENTER);
  lab12.setFont(f1);
  lab12.setBorder(line);
  
  lab13=new JLabel("X",SwingConstants.CENTER);
  lab13.setFont(f1);
  lab13.setBorder(line);
  
  lab14=new JLabel("O",SwingConstants.CENTER);
  lab14.setFont(f1);
  lab14.setBorder(line);
  
  lab15=new JLabel("X",SwingConstants.CENTER);
  lab15.setFont(f1);
  lab15.setBorder(line);
  
  lab16=new JLabel("O",SwingConstants.CENTER);
  lab16.setFont(f1);
  lab16.setBorder(line);
  
  lab17=new JLabel("X",SwingConstants.CENTER);
  lab17.setFont(f1);
  lab17.setBorder(line);
  
  lab18=new JLabel("O",SwingConstants.CENTER);
  lab18.setFont(f1);
  lab18.setBorder(line);
      
  labd=new JLabel("Draw !!",SwingConstants.CENTER);
  labd.setFont(f3);
  labd.setBorder(line);
  
  contentPane.add(wpanel);
  i2.setEnabled(false);
  i3.setEnabled(false);
 }
 public JPanel newPanel()
 {
  panel=new JPanel();
  gbl=new GridBagLayout();
  panel.setLayout(gbl);
  cgb=new GridBagConstraints();
  cgb.fill=GridBagConstraints.HORIZONTAL;
  
  b1=new JButton("0 0");
  cgb.weightx=2.0;
  cgb.weighty=2.0;
  cgb.ipady=100;
  cgb.gridx=0;
  cgb.gridy=0;
  panel.add(b1,cgb);
  b1.addActionListener(this);
  
  b2=new JButton("0 1");
  cgb.gridx=1;
  cgb.gridy=0;
  panel.add(b2,cgb);
  b2.addActionListener(this);

  b3=new JButton("0 2");
  cgb.gridx=2;
  cgb.gridy=0;
  panel.add(b3,cgb);
  b3.addActionListener(this);
  
  b4=new JButton("1 0");
  cgb.gridx=0;
  cgb.gridy=1;
  panel.add(b4,cgb);
  b4.addActionListener(this);
  
  b5=new JButton("1 1");
  cgb.gridx=1;
  cgb.gridy=1;
  panel.add(b5,cgb);
  b5.addActionListener(this);

  b6=new JButton("1 2");
  cgb.gridx=2;
  cgb.gridy=1;
  panel.add(b6,cgb);
  b6.addActionListener(this);
  
  b7=new JButton("2 0");
  cgb.gridx=0;
  cgb.gridy=2;
  panel.add(b7,cgb);
  b7.addActionListener(this);
  
  b8=new JButton("2 1");
  cgb.gridx=1;
  cgb.gridy=2;
  panel.add(b8,cgb);
  b8.addActionListener(this);

  b9=new JButton("2 2");
  cgb.gridx=2;
  cgb.gridy=2;
  panel.add(b9,cgb);
  b9.addActionListener(this);
  
  lab=new JLabel("");
  lab.setBorder(line);
  cgb.ipadx=200;
  cgb.weightx=0.0;
  cgb.gridwidth=3;
  cgb.gridx=0;
  cgb.gridy=3;
  panel.add(lab,cgb);
  
  return panel;
 }
 void UservsUser(int mm,int nn)
 {
  if(mm==0&&nn==0)
  {
   if(k%2!=0)
   {
    M[0][0]="X";
    temp2=lab1;
    panel.add(lab1,gbc);
    panel.revalidate();
    panel.repaint();
    k++;
   }
   else
   {
    M[0][0]="O";
    temp2=lab2;
    panel.add(lab2,gbc);
    panel.revalidate();
    panel.repaint();
    k++;
   }
   if(bingo(0,0)==true)
   {
    b2.setEnabled(false);
    b3.setEnabled(false);
    b4.setEnabled(false);
    b5.setEnabled(false);
    b6.setEnabled(false);
    b7.setEnabled(false);
    b8.setEnabled(false);
    b9.setEnabled(false);
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);kk++;
    if(k%2==0)
    {
     panel.add(lab19,gbcb);
     panel.revalidate();
     panel.repaint();
    }
    else
    {
     panel.add(lab20,gbcb);
     panel.revalidate();
     panel.repaint();
    }
    i3.setEnabled(false);
   }
   if(k==10&&kk==0)
   {
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);
    panel.add(labd,gbcb);
    panel.revalidate();
    panel.repaint();
   }
  }
  else if(mm==0&&nn==1)
  {
   if(k%2!=0)
   {
    M[0][1]="X";
    temp2=lab3;
    panel.add(lab3,gbc);
    panel.revalidate();
    panel.repaint();
    k++;
   }
   else
   {
    M[0][1]="O";
    temp2=lab4;
    panel.add(lab4,gbc);
    panel.revalidate();
    panel.repaint();
    k++;
   }
   if(bingo(0,1)==true)
   {
    b1.setEnabled(false);
    b3.setEnabled(false);
    b4.setEnabled(false);
    b5.setEnabled(false);
    b6.setEnabled(false);
    b7.setEnabled(false);
    b8.setEnabled(false);
    b9.setEnabled(false);
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);kk++;
    if(k%2==0)
    {
     panel.add(lab19,gbcb);
     panel.revalidate();
     panel.repaint();
    }
    else
    {
     panel.add(lab20,gbcb);
     panel.revalidate();
     panel.repaint();
    }  
    i3.setEnabled(false);
   }
   if(k==10&&kk==0)
   {
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);
    panel.add(labd,gbcb);
    panel.revalidate();
    panel.repaint();
   }
  }
  else if(mm==0&&nn==2)
  {
   if(k%2!=0)
   {
    M[0][2]="X";
    temp2=lab5;
    panel.add(lab5,gbc);
    panel.revalidate();
    panel.repaint();
    k++;
   }
   else
   {
    M[0][2]="O";
    temp2=lab6;
    panel.add(lab6,gbc);
    panel.revalidate();
    panel.repaint();
    k++;
   }
   if(bingo(0,2)==true)
   {
    b1.setEnabled(false);
    b2.setEnabled(false);
    b4.setEnabled(false);
    b5.setEnabled(false);
    b6.setEnabled(false);
    b7.setEnabled(false);
    b8.setEnabled(false);
    b9.setEnabled(false);
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);kk++;   
    if(k%2==0)
    {
     panel.add(lab19,gbcb);
     panel.revalidate();
     panel.repaint();
    }
    else
    {
     panel.add(lab20,gbcb);
     panel.revalidate();
     panel.repaint();
    }   
    i3.setEnabled(false);
   }
   if(k==10&&kk==0)
   {
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);
    panel.add(labd,gbcb);
    panel.revalidate();
    panel.repaint();
   }
  }
  else if(mm==1&&nn==0)
  {
   if(k%2!=0)
   {
    M[1][0]="X";
    temp2=lab7;
    panel.add(lab7,gbc);
    panel.revalidate();
    panel.repaint();
    k++;
   }
   else
   {
    M[1][0]="O";
    temp2=lab8;
    panel.add(lab8,gbc);
    panel.revalidate();
    panel.repaint();
    k++;
   }
   if(bingo(1,0)==true)
   {
    b1.setEnabled(false);
    b2.setEnabled(false);
    b3.setEnabled(false);
    b5.setEnabled(false);
    b6.setEnabled(false);
    b7.setEnabled(false);
    b8.setEnabled(false);
    b9.setEnabled(false);
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);kk++;    
    if(k%2==0)
    {
     panel.add(lab19,gbcb);
     panel.revalidate();
     panel.repaint();
    }
    else
    {
     panel.add(lab20,gbcb);
     panel.revalidate();
     panel.repaint();
    }
    i3.setEnabled(false);
   }
   if(k==10&&kk==0)
   {
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);
    panel.add(labd,gbcb);
    panel.revalidate();
    panel.repaint();
   }
  }
  else if(mm==1&&nn==1)
  {
   if(k%2!=0)
   {
    M[1][1]="X";
    temp2=lab9;
    panel.add(lab9,gbc);
    panel.revalidate();
    panel.repaint();
    k++;
   }
   else
   {
    M[1][1]="O";
    temp2=lab10;
    panel.add(lab10,gbc);
    panel.revalidate();
    panel.repaint();
    k++;
   }
   if(bingo(1,1)==true)
   {
    b1.setEnabled(false);
    b2.setEnabled(false);
    b3.setEnabled(false);
    b4.setEnabled(false);
    b6.setEnabled(false);
    b7.setEnabled(false);
    b8.setEnabled(false);
    b9.setEnabled(false);
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);kk++;      
    if(k%2==0)
    {
     panel.add(lab19,gbcb);
     panel.revalidate();
     panel.repaint();
    }
    else
    {
     panel.add(lab20,gbcb);
     panel.revalidate();
     panel.repaint();
    }
    i3.setEnabled(false);
   }
   if(k==10&&kk==0)
   {
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);
    panel.add(labd,gbcb);
    panel.revalidate();
    panel.repaint();
   }
  }
  else if(mm==1&&nn==2)
  {
   if(k%2!=0)
   {
    M[1][2]="X";
    temp2=lab11;
    panel.add(lab11,gbc);
    panel.revalidate();
    panel.repaint();
    k++;
   }
   else
   {
    M[1][2]="O";
    temp2=lab12;
    panel.add(lab12,gbc);
    panel.revalidate();
    panel.repaint();
    k++;
   }
   if(bingo(1,2)==true)
   {
    b1.setEnabled(false);
    b2.setEnabled(false);
    b3.setEnabled(false);
    b4.setEnabled(false);
    b5.setEnabled(false);
    b7.setEnabled(false);
    b8.setEnabled(false);
    b9.setEnabled(false);
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);kk++;     
    if(k%2==0)
    {
     panel.add(lab19,gbcb);
     panel.revalidate();
     panel.repaint();
    }
    else
    {
     panel.add(lab20,gbcb);
     panel.revalidate();
     panel.repaint();
    }
    i3.setEnabled(false);
   }
   if(k==10&&kk==0)
   {
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);
    panel.add(labd,gbcb);
    panel.revalidate();
    panel.repaint();
   }
  }
  else if(mm==2&&nn==0)
  {
   if(k%2!=0)
   {
    M[2][0]="X";
    temp2=lab13;
    panel.add(lab13,gbc);
    panel.revalidate();
    panel.repaint();
    k++;
   }
   else
   {
    M[2][0]="O";
    temp2=lab14;
    panel.add(lab14,gbc);
    panel.revalidate();
    panel.repaint();
    k++;
   }
   if(bingo(2,0)==true)
   {
    b1.setEnabled(false);
    b2.setEnabled(false);
    b3.setEnabled(false);
    b4.setEnabled(false);
    b5.setEnabled(false);
    b6.setEnabled(false);
    b8.setEnabled(false);
    b9.setEnabled(false);
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);kk++;    
    if(k%2==0)
    {
     panel.add(lab19,gbcb);
     panel.revalidate();
     panel.repaint();
    }
    else
    {
     panel.add(lab20,gbcb);
     panel.revalidate();
     panel.repaint();
    }
    i3.setEnabled(false);
   }
   if(k==10&&kk==0)
   {
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);
    panel.add(labd,gbcb);
    panel.revalidate();
    panel.repaint();
   }
  }
  else if(mm==2&&nn==1)
  {
   if(k%2!=0)
   {
    M[2][1]="X";
    temp2=lab15;
    panel.add(lab15,gbc);
    panel.revalidate();
    panel.repaint();
    k++;
   }
   else
   {
    M[2][1]="O";
    temp2=lab16;
    panel.add(lab16,gbc);
    panel.revalidate();
    panel.repaint();
    k++;
   }
   if(bingo(2,1)==true)
   {
    b1.setEnabled(false);
    b2.setEnabled(false);
    b3.setEnabled(false);
    b4.setEnabled(false);
    b5.setEnabled(false);
    b6.setEnabled(false);
    b7.setEnabled(false);
    b9.setEnabled(false);
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);kk++;    
    if(k%2==0)
    {
     panel.add(lab19,gbcb);
     panel.revalidate();
     panel.repaint();
    }
    else
    {
     panel.add(lab20,gbcb);
     panel.revalidate();
     panel.repaint();
    }   
    i3.setEnabled(false);
   }
   if(k==10&&kk==0)
   {
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);
    panel.add(labd,gbcb);
    panel.revalidate();
    panel.repaint();
   }
  }
  else if(mm==2&&nn==2)
  {
   if(k%2!=0)
   {
    M[2][2]="X";
    temp2=lab17;
    panel.add(lab17,gbc);
    panel.revalidate();
    panel.repaint();
    k++;
   }
   else
   {
    M[2][2]="O";
    temp2=lab18;
    panel.add(lab18,gbc);
    panel.revalidate();
    panel.repaint();
    k++;
   }
   if(bingo(2,2)==true)
   {
    b1.setEnabled(false);
    b2.setEnabled(false);
    b3.setEnabled(false);
    b4.setEnabled(false);
    b5.setEnabled(false);
    b6.setEnabled(false);
    b7.setEnabled(false);
    b8.setEnabled(false);
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);
    kk++;
    if(k%2==0)
    {
     panel.add(lab19,gbcb);
     panel.revalidate();
     panel.repaint();
    }
    else
    {
     panel.add(lab20,gbcb);
     panel.revalidate();
     panel.repaint();
    }    
    i3.setEnabled(false);
   }
   if(k==10&&kk==0)
   {
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);
    panel.add(labd,gbcb);
    panel.revalidate();
    panel.repaint();
   }
  }
 }
 void UservsComputer(int mm,int nn)throws InterruptedException
 {
  if(mm==0&&nn==0)
  {
   M[0][0]="X";
   temp2=lab1;
   panel.add(lab1,gbc);
   panel.revalidate();
   panel.repaint();
   k++;   
   if(bingo(0,0)==true)
   {    
    b2.setEnabled(false);
    b3.setEnabled(false);
    b4.setEnabled(false);
    b5.setEnabled(false);
    b6.setEnabled(false);
    b7.setEnabled(false);
    b8.setEnabled(false);
    b9.setEnabled(false);
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);kk++;
    panel.add(lab21,gbcb);
    panel.revalidate();
    panel.repaint();   
    i3.setEnabled(false);
    return;
   } 
  }
  else if(mm==0&&nn==1)
  {
   M[0][1]="X";
   temp2=lab3;
   panel.add(lab3,gbc);
   panel.revalidate();
   panel.repaint();
   k++;   
   if(bingo(0,1)==true)
   {
    b1.setEnabled(false);
    b3.setEnabled(false);
    b4.setEnabled(false);
    b5.setEnabled(false);
    b6.setEnabled(false);
    b7.setEnabled(false);
    b8.setEnabled(false);
    b9.setEnabled(false);
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);kk++;    
    panel.add(lab21,gbcb);
    panel.revalidate();
    panel.repaint();    
    i3.setEnabled(false);
    return;
   }   
  }
  else if(mm==0&&nn==2)
  {   
   M[0][2]="X";
   temp2=lab5;
   panel.add(lab5,gbc);
   panel.revalidate();
   panel.repaint();
   k++; 
   if(bingo(0,2)==true)
   {
    b1.setEnabled(false);
    b2.setEnabled(false);
    b4.setEnabled(false);
    b5.setEnabled(false);
    b6.setEnabled(false);
    b7.setEnabled(false);
    b8.setEnabled(false);
    b9.setEnabled(false);
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);kk++;
    panel.add(lab21,gbcb);
    panel.revalidate();
    panel.repaint();   
    i3.setEnabled(false);
    return;
   }   
  }
  else if(mm==1&&nn==0)
  {
   M[1][0]="X";
   temp2=lab7;
   panel.add(lab7,gbc);
   panel.revalidate();
   panel.repaint();
   k++;   
   if(bingo(1,0)==true)
   {
    b1.setEnabled(false);
    b2.setEnabled(false);
    b3.setEnabled(false);
    b5.setEnabled(false);
    b6.setEnabled(false);
    b7.setEnabled(false);
    b8.setEnabled(false);
    b9.setEnabled(false);
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);kk++;  
    panel.add(lab21,gbcb);
    panel.revalidate();
    panel.repaint();    
    i3.setEnabled(false);
    return;
   }   
  }
  else if(mm==1&&nn==1)
  {   
   M[1][1]="X";
   temp2=lab9;
   panel.add(lab9,gbc);
   panel.revalidate();
   panel.repaint();
   k++;   
   if(bingo(1,1)==true)
   {
    b1.setEnabled(false);
    b2.setEnabled(false);
    b3.setEnabled(false);
    b4.setEnabled(false);
    b6.setEnabled(false);
    b7.setEnabled(false);
    b8.setEnabled(false);
    b9.setEnabled(false);
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);kk++;
    panel.add(lab21,gbcb);
    panel.revalidate();
    panel.repaint();     
    i3.setEnabled(false);
    return;
   }   
  }
  else if(mm==1&&nn==2)
  {   
   M[1][2]="X";
   temp2=lab11;
   panel.add(lab11,gbc);
   panel.revalidate();
   panel.repaint();
   k++;   
   if(bingo(1,2)==true)
   {
    b1.setEnabled(false);
    b2.setEnabled(false);
    b3.setEnabled(false);
    b4.setEnabled(false);
    b5.setEnabled(false);
    b7.setEnabled(false);
    b8.setEnabled(false);
    b9.setEnabled(false);
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);kk++;   
    panel.add(lab21,gbcb);
    panel.revalidate();
    panel.repaint();    
    i3.setEnabled(false);
    return;
   }   
  }
  else if(mm==2&&nn==0)
  {   
   M[2][0]="X";
   temp2=lab13;
   panel.add(lab13,gbc);
   panel.revalidate();
   panel.repaint();
   k++;   
   if(bingo(2,0)==true)
   {
    b1.setEnabled(false);
    b2.setEnabled(false);
    b3.setEnabled(false);
    b4.setEnabled(false);
    b5.setEnabled(false);
    b6.setEnabled(false);
    b8.setEnabled(false);
    b9.setEnabled(false);
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);kk++;
    panel.add(lab21,gbcb);
    panel.revalidate();
    panel.repaint();    
    i3.setEnabled(false);
    return;
   }   
  }
  else if(mm==2&&nn==1)
  {   
   M[2][1]="X";
   temp2=lab15;
   panel.add(lab15,gbc);
   panel.revalidate();
   panel.repaint();
   k++;      
   if(bingo(2,1)==true)
   {
    b1.setEnabled(false);
    b2.setEnabled(false);
    b3.setEnabled(false);
    b4.setEnabled(false);
    b5.setEnabled(false);
    b6.setEnabled(false);
    b7.setEnabled(false);
    b9.setEnabled(false);
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);kk++;
    panel.add(lab21,gbcb);
    panel.revalidate();
    panel.repaint();    
    i3.setEnabled(false);
    return;
   }   
  }
  else if(mm==2&&nn==2)
  {
   M[2][2]="X";
   temp2=lab17;
   panel.add(lab17,gbc);
   panel.revalidate();
   panel.repaint();
   k++;
   if(bingo(2,2)==true)
   {
    b1.setEnabled(false);
    b2.setEnabled(false);
    b3.setEnabled(false);
    b4.setEnabled(false);
    b5.setEnabled(false);
    b6.setEnabled(false);
    b7.setEnabled(false);
    b8.setEnabled(false);
    gbcb=gbl.getConstraints(lab);
    panel.remove(lab);
    kk++;    
    panel.add(lab21,gbcb);
    panel.revalidate();
    panel.repaint();    
    i3.setEnabled(false);
    return;
   }   
  }
  if(isFull()==true&&kk==0)
  {
   gbcb=gbl.getConstraints(lab);
   i3.setEnabled(false);
   panel.remove(lab);
   panel.add(labd,gbcb);
   panel.revalidate();
   panel.repaint();
  }
  else if(isFull()==true&&kk!=0)
  {}
  else  
   winPosition();
 }
 boolean rows(int rr)
 {
  int i,j=1;String row[]=new String[c];
  for(i=0;i<c;i++)
   row[i]=M[rr][i];
  for(i=0;i<(c-1);i++)
  {
   if(row[i]==row[i+1])
    j++;
  }
  if(j==c)
   return true;
  else
   return false;
 }
 int checkRow1()
 {
  int k1=0,k2=0,s=0;
  int i,c=0;
  for(i=0;i<3;i++)
  {
   if(M[c][i]=="X")
    k1++;
   else if(M[c][i]=="O")
    k2++;
   else
    s++;
  }
  if(k1==2&&s==1)
   return 0;
  else if(k2==2&&s==1)
   return 1;
  else
   return -1;
 }
 void row1Move()
 {
  int i,j,c=0;
  for(i=0;i<3;i++)
  {
   if(M[c][i]=="")
   {
    M[c][i]="O";
    cn=i;
    break;
   }
  }
  cm=c;
  if(cm==0&&cn==0)  
   b1.doClick();  
  else if(cm==0&&cn==1)  
   b2.doClick();
  else if(cm==0&&cn==2)  
   b3.doClick();  
 }
 int checkRow2()
 {
  int k1=0,k2=0,s=0;
  int i,c=1;
  for(i=0;i<3;i++)
  {
   if(M[c][i]=="X")
    k1++;
   else if(M[c][i]=="O")
    k2++;
   else
    s++;
  }
  if(k1==2&&s==1)
   return 0;
  else if(k2==2&&s==1)
   return 1;
  else
   return -1;
 }
 void row2Move()
 {
  int i,j,c=1;
  for(i=0;i<3;i++)
  {
   if(M[c][i]=="")
   {
    M[c][i]="O";
    cn=i;
    break;
   }
  }
  cm=c;
  if(cm==1&&cn==0)  
   b4.doClick();  
  else if(cm==1&&cn==1)  
   b5.doClick();  
  else if(cm==1&&cn==2)  
   b6.doClick();  
 }
 int checkRow3()
 {
  int k1=0,k2=0,s=0;
  int i,c=2;
  for(i=0;i<3;i++)
  {
   if(M[c][i]=="X")
    k1++;
   else if(M[c][i]=="O")
    k2++;
   else
    s++;
  }
  if(k1==2&&s==1)
   return 0;
  else if(k2==2&&s==1)
   return 1;
  else
   return -1;
 }
 void row3Move()
 {
  int i,j,c=2;
  for(i=0;i<3;i++)
  {
   if(M[c][i]=="")
   {
    M[c][i]="O";
    cn=i;
    break;
   }
  }
  cm=c;
  if(cm==2&&cn==0)  
   b7.doClick();  
  else if(cm==2&&cn==1)  
   b8.doClick();  
  else if(cm==2&&cn==2)  
   b9.doClick();  
 }
 boolean columns(int cc)
 {
  int i,j=1;String column[]=new String[r];
  for(i=0;i<r;i++)
   column[i]=M[i][cc];
  for(i=0;i<(c-1);i++)
  {
   if(column[i]==column[i+1])
    j++;
  }
  if(j==r)
   return true;
  else
   return false;
 }
 int checkColumn1()
 {
  int k1=0,k2=0,s=0;
  int i,c=0;
  for(i=0;i<3;i++)
  {
   if(M[i][c]=="X")
    k1++;
   else if(M[i][c]=="O")
    k2++;
   else
    s++;
  }
  if(k1==2&&s==1)
   return 0;
  else if(k2==2&&s==1)
   return 1;
  else
   return -1;
 }
 void column1Move()
 {
  int i,j,c=0;
  for(i=0;i<3;i++)
  {
   if(M[i][c]=="")
   {
    M[i][c]="O";
    cm=i;
    break;
   }
  }
  cn=c;
  if(cm==0&&cn==0)  
   b1.doClick();  
  else if(cm==1&&cn==0)
   b4.doClick();
  else if(cm==2&&cn==0)  
   b7.doClick();  
 }
 int checkColumn2()
 {
  int k1=0,k2=0,s=0;
  int i,c=1;
  for(i=0;i<3;i++)
  {
   if(M[i][c]=="X")
    k1++;
   else if(M[i][c]=="O")
    k2++;
   else
    s++;
  }
  if(k1==2&&s==1)
   return 0;
  else if(k2==2&&s==1)
   return 1;
  else
   return -1;
 }
 void column2Move()
 {
  int i,j,c=1;
  for(i=0;i<3;i++)
  {
   if(M[i][c]=="")
   {
    M[i][c]="O";
    cm=i;
    break;
   }
  }
  cn=c;
  if(cm==0&&cn==1)  
   b2.doClick();  
  else if(cm==1&&cn==1)  
   b5.doClick();  
  else if(cm==2&&cn==1)  
   b8.doClick();  
 }
 int checkColumn3()
 {
  int k1=0,k2=0,s=0;
  int i,c=2;
  for(i=0;i<3;i++)
  {
   if(M[i][c]=="X")
    k1++;
   else if(M[i][c]=="O")
    k2++;
   else
    s++;
  }
  if(k1==2&&s==1)
   return 0;
  else if(k2==2&&s==1)
   return 1;
  else
   return -1;
 }
 void column3Move()
 {
  int i,j,c=2;
  for(i=0;i<3;i++)
  {
   if(M[i][c]=="")
   {
    M[i][c]="O";
    cm=i;
    break;
   }
  }
  cn=c;
  if(cm==0&&cn==2)  
   b3.doClick();  
  else if(cm==1&&cn==2)  
   b6.doClick();  
  else if(cm==2&&cn==2)  
   b9.doClick();  
 }
 boolean diagonals(int rr,int cc)
 {
  String d[]=new String[r];int i,j=1,k=-1;
  if((rr==cc)||((rr==0)&&(cc==2))||((rr==2)&&(cc==0)))
  {
   if((rr==1)&&(cc==1))
   {
    for(i=0;i<r;i++)
     d[i]=M[i][i];
    for(i=0;i<(r-1);i++)
    {
     if(d[i]==d[i+1])
      j++;
    }
    if(j==r)
     return true;
    j=1;
    for(i=r-1;i>=0;i--)
    {
     k++;
     d[k]=M[k][i];
    }
    for(i=0;i<(r-1);i++)
    {
     if(d[i]==d[i+1])
      j++;
    }
    if(j==r)
     return true;
    else
     return false;
   }
   else if(rr==cc)
   {
    for(i=0;i<r;i++)
     d[i]=M[i][i];
    for(i=0;i<(r-1);i++)
    {
     if(d[i]==d[i+1])
      j++;
    }
    if(j==r)
     return true;
    else
     return false;
   }
   else
   {
    for(i=r-1;i>=0;i--)
    {
     k++;
     d[k]=M[k][i];
    }
    for(i=0;i<(r-1);i++)
    {
     if(d[i]==d[i+1])
      j++;
    }
    if(j==r)
     return true;
    else
     return false;
   }
  }
  else
   return false;
 }
 int checkDiagonal1()
 {
  int k1=0,k2=0,s=0;
  int i;
  for(i=0;i<3;i++)
  {
   if(M[i][i]=="X")
    k1++;
   else if(M[i][i]=="O")
    k2++;
   else
    s++;
  }
  if(k1==2&&s==1)
   return 0;
  else if(k2==2&&s==1)
   return 1;
  else
   return -1;
 }
 void diagonal1Move()
 {
  int i,j;
  for(i=0;i<3;i++)
  {
   if(M[i][i]=="")
   {
    M[i][i]="O";
    cm=i;cn=i;
    break;
   }
  }
  if(cm==0&&cn==0)  
   b1.doClick();  
  else if(cm==1&&cn==1)  
   b5.doClick();  
  else if(cm==2&&cn==2)  
   b9.doClick();  
 }
 int checkDiagonal2()
 {
  int k1=0,k2=0,s=0;
  int i,c=2;
  for(i=0;i<3;i++,c--)
  {
   if(M[i][c]=="X")
    k1++;
   else if(M[i][c]=="O")
    k2++;
   else
    s++;
  }
  if(k1==2&&s==1)
   return 0;
  else if(k2==2&&s==1)
   return 1;
  else
   return -1;
 }
 void diagonal2Move()
 {
  int i,j,c=2;
  for(i=0;i<3;i++,c--)
  {
   if(M[i][c]=="")
   {
    M[i][c]="O";
    cm=i;cn=c;
    break;
   }
  }
  if(cm==0&&cn==2)  
   b3.doClick();  
  else if(cm==1&&cn==1)  
   b5.doClick();  
  else if(cm==2&&cn==0)  
   b7.doClick();  
 }
 void randomMove()
 {
  Random r=new Random();
  int row=0,column=0,i;
  for(i=0;;i++)
  {
   row=r.nextInt(3);
   column=r.nextInt(3);
   if((M[row][column]).equals(""))
   {
    M[row][column]="O";
    break;
   }
  }
  cm=row;cn=column;
  if(row==0&&column==0)  
   b1.doClick();  
  else if(row==0&&column==1)  
   b2.doClick();  
  else if(row==0&&column==2)  
   b3.doClick();  
  else if(row==1&&column==0)  
   b4.doClick();  
  else if(row==1&&column==1)  
   b5.doClick();  
  else if(row==1&&column==2)
   b6.doClick();  
  else if(row==2&&column==0)  
   b7.doClick();  
  else if(row==2&&column==1)  
   b8.doClick();  
  else if(row==2&&column==2)  
   b9.doClick();  
 }
 boolean midTrick()
 {
  int i,j,c=0;
  for(i=0;i<3;i++)
   for(j=0;j<3;j++)
    if(M[i][j]=="X")
     c++;
  if(c==1)
   return true;
  else
   return false;
 }
 void winPosition()throws InterruptedException
 {  
  Random ran=new Random();
  Random m=new Random();
  int r1=checkRow1(),r2=checkRow2(),r3=checkRow3();
  int c1=checkColumn1(),c2=checkColumn2(),c3=checkColumn3();
  int d1=checkDiagonal1(),d2=checkDiagonal2();
  int a[]={r1,r2,r3,c1,c2,c3,d1,d2},n,i,mr,mc;
  if(M[1][1]=="")
  {
   M[1][1]="O";
   b5.doClick();
   return;
  }
  if(midTrick()==true)
  {
   for(i=0;;i++)
   {
    mr=m.nextInt(3);
    mc=m.nextInt(3);
    if(M[mr][mc]==""&&mr!=1&&mc!=1)
    {
     M[mr][mc]="O";
     cm=mr;
     cn=mc;
     break;
    }
   }
   if(cm==0&&cn==0)   
    b1.doClick();   
   else if(cm==0&&cn==2)   
    b3.doClick();   
   else if(cm==2&&cn==0)   
    b7.doClick();   
   else if(cm==2&&cn==2)   
    b9.doClick();   
   return;
  }
  if(r1==1||r2==1||r3==1||c1==1||c2==1||c3==1||d1==1||d2==1)
  {
   for(i=0;;i++)
   {
    n=ran.nextInt(8);
    if(a[n]==1)
    {
     if(n==0)
      row1Move();
     else if(n==1)
      row2Move();
     else if(n==2)
      row3Move();
     else if(n==3)
      column1Move();
     else if(n==4)
      column2Move();
     else if(n==5)
      column3Move();
     else if(n==6)
      diagonal1Move();
     else if(n==7)
      diagonal2Move();
     break;
    }
   }
  }
  else if(r1==0||r2==0||r3==0||c1==0||c2==0||c3==0||d1==0||d2==0)
  {
   for(i=0;;i++)
   {
    n=ran.nextInt(8);
    if(a[n]==0)
    {
     if(n==0)
      row1Move();
     else if(n==1)
      row2Move();
     else if(n==2)
      row3Move();
     else if(n==3)
      column1Move();
     else if(n==4)
      column2Move();
     else if(n==5)
      column3Move();
     else if(n==6)
      diagonal1Move();
     else if(n==7)
      diagonal2Move();
     break;
    }
   }
  }
  else  
   randomMove();
  if(bingo(cm,cn)==true)
  {
   b1.setEnabled(false);
   b2.setEnabled(false);
   b3.setEnabled(false);
   b4.setEnabled(false);
   b5.setEnabled(false);
   b6.setEnabled(false);
   b7.setEnabled(false);
   b8.setEnabled(false);
   b9.setEnabled(false);
   gbcb=gbl.getConstraints(lab);
   panel.remove(lab);
   kk++;
   panel.add(lab22,gbcb);
   panel.revalidate();
   panel.repaint();
  }
 }
 boolean bingo(int row,int column)
 {
  if((rows(row)==true)||(columns(column)==true)||(diagonals(row,column)==true))
   return true;
  else
   return false;
 }
 void makeEmpty()
 {
  int i,j;
  for(i=0;i<3;i++)
   for(j=0;j<3;j++)
    M[i][j]="";
 }
 boolean isFull()
 {
  int i,j,c=0;
  for(i=0;i<3;i++)
   for(j=0;j<3;j++)
   {
    if(M[i][j]!="")
     c++;
   }
  if(c==9)
   return true;
  else
   return false;
 }
 public void actionPerformed(ActionEvent e)
 {
  ss=e.getActionCommand();
  
  lab19=new JLabel(player1+" Wins !!",SwingConstants.CENTER);
  lab19.setFont(f3);
  lab19.setBorder(line);
  
  lab20=new JLabel(player2+" Wins !!",SwingConstants.CENTER);
  lab20.setFont(f3);
  lab20.setBorder(line);
  
  lab21=new JLabel(player+" Wins !!",SwingConstants.CENTER);
  lab21.setFont(f3);
  lab21.setBorder(line);
  
  lab22=new JLabel("Computer Wins !!",SwingConstants.CENTER);
  lab22.setFont(f3);
  lab22.setBorder(line);
  
  if(ss.equals("Start"))
  {
   if(rb1.isSelected())
   {
    contentPane.removeAll();
    contentPane.add(panelc);
    contentPane.revalidate();
    contentPane.repaint();
   }
   else if(rb2.isSelected())
   {
    contentPane.removeAll();
    contentPane.add(cpanel);
    contentPane.revalidate();
    contentPane.repaint();
   }
  }
  else if(ss.equals("Begin"))
  {
   player=tp.getText();
   i2.setEnabled(true);
   contentPane.removeAll();
   makeEmpty();ss="";
   contentPane.add(newPanel());
   contentPane.revalidate();
   contentPane.repaint();
  }
  else if(ss.equals("Enter"))
  {
   player1=t1.getText();
   player1=player1.trim();
   player2=t2.getText();
   player2=player2.trim();
   i2.setEnabled(true);
   contentPane.removeAll();
   makeEmpty();ss="";
   contentPane.add(newPanel());
   contentPane.revalidate();
   contentPane.repaint();
  }
  else if(ss.equals("Quit"))
  {
   JFrame j=new JFrame();
   int exit=JOptionPane.showConfirmDialog(j,"Are you sure ?","Tic Tac Toe"+"\u00A9",JOptionPane.YES_NO_OPTION);
   if(exit==JOptionPane.YES_OPTION)
    System.exit(0);
  }  
  else if(ss.equals("0 0"))
  {
   if(k%2!=0)
   {
    tempr=0;tempc=0;
    i3.setEnabled(true);
    temp1=b1;
    gbc=gbl.getConstraints(b1);
    panel.remove(b1);
    try
    {
     if(rb1.isSelected())
      UservsComputer(0,0);
     else if(rb2.isSelected())
      UservsUser(0,0);
    }
    catch(Exception ex)
    {}
   }
   else
   {
    if(rb2.isSelected())
    {
     tempr=0;tempc=0;ss="";
     i3.setEnabled(true);
     temp1=b1;
     gbc=gbl.getConstraints(b1);
     panel.remove(b1);
     UservsUser(0,0);
    }
    else
    {
     ss="";
     i3.setEnabled(false);
     gbc=gbl.getConstraints(b1);
     panel.remove(b1);k++;
     panel.add(lab2,gbc);
     panel.revalidate();
     panel.repaint();
    }
   }   
  }
  else if(ss.equals("0 1"))
  {
   if(k%2!=0)
   {
    tempr=0;tempc=1;
    i3.setEnabled(true);
    temp1=b2;
    gbc=gbl.getConstraints(b2);
    panel.remove(b2);
    try
    {
     if(rb1.isSelected())
      UservsComputer(0,1);
     else if(rb2.isSelected())
      UservsUser(0,1);
    }
    catch(Exception ex)
    {}
   }
   else
   {
    if(rb2.isSelected())
    {
     tempr=0;tempc=1;ss="";
     i3.setEnabled(true);
     temp1=b2;
     gbc=gbl.getConstraints(b2);
     panel.remove(b2);
     UservsUser(0,1);
    }
    else
    {
     ss="";
     i3.setEnabled(false);
     gbc=gbl.getConstraints(b2);
     panel.remove(b2);k++;
     panel.add(lab4,gbc);
     panel.revalidate();
     panel.repaint();
    }
   }   
  }
  else if(ss.equals("0 2"))
  {
   if(k%2!=0)
   {
    tempr=0;tempc=2;
    i3.setEnabled(true);
    temp1=b3;
    gbc=gbl.getConstraints(b3);
    panel.remove(b3);
    try
    {
     if(rb1.isSelected())
      UservsComputer(0,2);
     else if(rb2.isSelected())
      UservsUser(0,2);
    }
    catch(Exception ex)
    {}
   }
   else
   {
    if(rb2.isSelected())
    {
     tempr=0;tempc=2;ss="";
     i3.setEnabled(true);
     temp1=b3;
     gbc=gbl.getConstraints(b3);
     panel.remove(b3);
     UservsUser(0,2);
    }
    else
    {
     ss="";
     i3.setEnabled(false);
     gbc=gbl.getConstraints(b3);
     panel.remove(b3);k++;
     panel.add(lab6,gbc);
     panel.revalidate();
     panel.repaint();
    }
   }   
  }
  else if(ss.equals("1 0"))
  {
   if(k%2!=0)
   {
    tempr=1;tempc=0;
    i3.setEnabled(true);
    temp1=b4;
    gbc=gbl.getConstraints(b4);
    panel.remove(b4);
    try
    {
     if(rb1.isSelected())
      UservsComputer(1,0);
     else if(rb2.isSelected())
      UservsUser(1,0);
    }
    catch(Exception ex)
    {}
   }
   else
   {
    if(rb2.isSelected())
    {
     tempr=1;tempc=0;ss="";
     i3.setEnabled(true);
     temp1=b4;
     gbc=gbl.getConstraints(b4);
     panel.remove(b4);
     UservsUser(1,0);
    }
    else
    {
     ss="";
     i3.setEnabled(false);
     gbc=gbl.getConstraints(b4);
     panel.remove(b4);k++;
     panel.add(lab8,gbc);
     panel.revalidate();
     panel.repaint();
    }
   }   
  }
  else if(ss.equals("1 1"))
  {
   if(k%2!=0)
   {
    tempr=1;tempc=1;
    i3.setEnabled(true);
    temp1=b5;
    gbc=gbl.getConstraints(b5);
    panel.remove(b5);
    try
    {
     if(rb1.isSelected())
      UservsComputer(1,1);
     else if(rb2.isSelected())
      UservsUser(1,1);
    }
    catch(Exception ex)
    {}
   }
   else
   {
    if(rb2.isSelected())
    {
     tempr=1;tempc=1;ss="";
     i3.setEnabled(true);
     temp1=b5;
     gbc=gbl.getConstraints(b5);
     panel.remove(b5);
     UservsUser(1,1);
    }
    else
    {
     ss="";
     i3.setEnabled(false);
     gbc=gbl.getConstraints(b5);
     panel.remove(b5);k++;
     panel.add(lab10,gbc);
     panel.revalidate();
     panel.repaint();
    }
   }   
  }
  else if(ss.equals("1 2"))
  {
   if(k%2!=0)
   {
    tempr=1;tempc=2;
    i3.setEnabled(true);
    temp1=b6;
    gbc=gbl.getConstraints(b6);
    panel.remove(b6);
    try
    {
     if(rb1.isSelected())
      UservsComputer(1,2);
     else if(rb2.isSelected())
      UservsUser(1,2);
    }
    catch(Exception ex)
    {}
   }
   else
   {
    if(rb2.isSelected())
    {
     tempr=1;tempc=2;ss="";
     i3.setEnabled(true);
     temp1=b6;
     gbc=gbl.getConstraints(b6);
     panel.remove(b6);
     UservsUser(1,2);
    }
    else
    {
     ss="";
     i3.setEnabled(false);
     gbc=gbl.getConstraints(b6);
     panel.remove(b6);k++;
     panel.add(lab12,gbc);
     panel.revalidate();
     panel.repaint();
    }
   }   
  }
  else if(ss.equals("2 0"))
  {
   if(k%2!=0)
   {
    tempr=2;tempc=0;
    i3.setEnabled(true);
    temp1=b7;
    gbc=gbl.getConstraints(b7);
    panel.remove(b7);
    try
    {
     if(rb1.isSelected())
      UservsComputer(2,0);
     else if(rb2.isSelected())
      UservsUser(2,0);
    }
    catch(Exception ex)
    {}
   }
   else
   {
    if(rb2.isSelected())
    {
     tempr=2;tempc=0;ss="";
     i3.setEnabled(true);
     temp1=b7;
     gbc=gbl.getConstraints(b7);
     panel.remove(b7);
     UservsUser(2,0);
    }
    else
    {
     ss="";
     i3.setEnabled(false);
     gbc=gbl.getConstraints(b7);
     panel.remove(b7);k++;
     panel.add(lab14,gbc);
     panel.revalidate();
     panel.repaint();
    }
   }   
  }
  else if(ss.equals("2 1"))
  {
   if(k%2!=0)
   {
    tempr=2;tempc=1;
    i3.setEnabled(true);
    temp1=b8;
    gbc=gbl.getConstraints(b8);
    panel.remove(b8);
    try
    {
     if(rb1.isSelected())
      UservsComputer(2,1);
     else if(rb2.isSelected())
      UservsUser(2,1);
    }
    catch(Exception ex)
    {}
   }
   else
   {
    if(rb2.isSelected())
    {
     tempr=2;tempc=1;ss="";
     i3.setEnabled(true);
     temp1=b8;
     gbc=gbl.getConstraints(b8);
     panel.remove(b8);
     UservsUser(2,1);
    }
    else
    {
     ss="";
     i3.setEnabled(false);
     gbc=gbl.getConstraints(b8);
     panel.remove(b8);k++;
     panel.add(lab16,gbc);
     panel.revalidate();
     panel.repaint();
    }
   }   
  }
  else if(ss.equals("2 2"))
  {
   if(k%2!=0)
   {
    tempr=2;tempc=2;
    i3.setEnabled(true);
    temp1=b9;
    gbc=gbl.getConstraints(b9);
    panel.remove(b9);
    try
    {
     if(rb1.isSelected())
      UservsComputer(2,2);
     else if(rb2.isSelected())
      UservsUser(2,2);
    }
    catch(Exception ex)
    {}
   }
   else
   {
    if(rb2.isSelected())
    {
     tempr=2;tempc=2;ss="";
     i3.setEnabled(true);
     temp1=b9;
     gbc=gbl.getConstraints(b9);
     panel.remove(b9);
     UservsUser(2,2);
    }
    else
    {
     ss="";
     i3.setEnabled(false);
     gbc=gbl.getConstraints(b9);
     panel.remove(b9);k++;
     panel.add(lab18,gbc);
     panel.revalidate();
     panel.repaint();
    }
   }   
  }
  else if(ss.equals("New Game"))
  {
   contentPane.removeAll();
   t1.setText("");
   t2.setText("");
   tp.setText("");
   k=1;kk=0;cm=0;cn=0;
   makeEmpty();ss="";
   i2.setEnabled(false);
   i3.setEnabled(false);
   contentPane.add(wpanel);
   contentPane.revalidate();
   contentPane.repaint();
  }
  else if(ss.equals("Reset Current Game"))
  {
   contentPane.removeAll();
   makeEmpty();
   k=1;kk=0;ss="";cm=0;cn=0;
   i3.setEnabled(false);
   contentPane.add(newPanel());
   contentPane.revalidate();
   contentPane.repaint();
  }
  else if(ss.equals("Undo Last Move"))
  {
   k--;
   M[tempr][tempc]="";
   gbc=gbl.getConstraints(temp2);
   panel.remove(temp2);
   panel.add(temp1,gbc);
   panel.revalidate();
   panel.repaint();
   i3.setEnabled(false);
  }
  else if(ss.equals("Instructions"))
  {
   JFrame j=new JFrame();
   JOptionPane.showMessageDialog(j,"-: Instructions :-"+"\n"+"\n"+"Click a box to place your mark.\nIf you put your mark in 3 consecutive boxes, you win !\n\"New Game\" starts the entire game from the beginning.\n\"Reset Current Game\" only resets the current gameboard.\n                  -------------------x-------------------");
  }
  else if(ss.equals("About"))
  {
   JFrame j=new JFrame();
   JOptionPane.showMessageDialog(j,"Tic Tac Toe"+"\u00A9"+" version Delta(build 20.03.2015)"+"\n"+"All Rights Reserved."+"\n"+"\n"+"Developer :  Bishal Das"+"\n"+"\n"+"Thank You for using this program."+"\n"+"\n"+"This program is still under development. If         "+"\n"+"you find bugs, you are welcome to mail it"+"\n"+"at this email id : dasbishal98@gmail.com"+"\n"+"For more info, contact the developer."+"\n"+"\n");
  }
  else if(ss.equals("Exit"))
  {
   JFrame j=new JFrame();
   int exit=JOptionPane.showConfirmDialog(j,"Are you sure ?","Tic Tac Toe"+"\u00A9",JOptionPane.YES_NO_OPTION);
   if(exit==JOptionPane.YES_OPTION)
    System.exit(0);
  }
 }
}