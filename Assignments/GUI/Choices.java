import java.awt.*;
class Choices
{
 public static void main(String args[])
{
 Frame f=new Frame("this is a choices");
Choice c=new Choice();
c.setBounds(100,100,75,75);
c.add("srinu");
c.add("sagar babu");
c.add("rohith");
c.add("chandu");
c.add("raju");
f.add(c);
f.setLayout(null);
f.setVisible(true);
f.setSize(400,400);
}}