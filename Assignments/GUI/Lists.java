import java.awt.*;
class Lists
{
 public static void main(String args[])
{ 
  Frame f=new Frame("this is a list");
 List l1=new List(5);
l1.setBounds(100,100,75,75);
l1.add("srinu");
l1.add("sagar babu");
l1.add("rohith");
l1.add("chandu");
l1.add("raju");
f.add(l1);
f.setSize(400,400);
f.setVisible(true);
f.setLayout(null);
}}