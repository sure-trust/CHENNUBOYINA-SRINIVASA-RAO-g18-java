import java.awt.*;
class Scroll
{
 public static void main(String args[])
{
 Frame f=new Frame("this is scroll");
 Scrollbar s1=new Scrollbar(Scrollbar.HORIZONTAL,0,20,0,100);
s1.setBounds(100,50,300,50);
 Scrollbar s2=new Scrollbar(Scrollbar.VERTICAL,0,20,0,100);
s2.setBounds(100,200,50,300);
f.add(s1);
f.add(s2);
f.setVisible(true);
f.setSize(600,600);
f.setLayout(null);
}}