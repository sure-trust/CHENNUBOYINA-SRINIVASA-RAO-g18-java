import java.awt.*;
class MyBorder
{
 public static void main(String args[])
{
 Frame f=new Frame("this is a Border");
Button b1=new Button("North");
Button b2=new Button("South");
Button b3=new Button("east");
Button b4=new Button("west");
Button b5=new Button("center");
f.add(b1,BorderLayout.NORTH);
f.add(b2,BorderLayout.SOUTH);
f.add(b3,BorderLayout.EAST);
f.add(b4,BorderLayout.WEST);
f.add(b5,BorderLayout.CENTER);
f.setVisible(true);
f.setSize(300,300);
}}