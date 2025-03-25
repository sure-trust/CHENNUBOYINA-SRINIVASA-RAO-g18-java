import java.awt.*;
class Text
{
 public static void main(String args[])
{
 Frame f=new Frame("text field");
 TextField t1,t2;
t1=new TextField("Krishna university");
t1.setBounds(50,100,200,30);
t2=new TextField("iit khargpur");
t2.setBounds(50,150,200,30);
f.add(t1);
f.add(t2);
f.setSize(400,400);
f.setLayout(null);
f.setVisible(true);
}}