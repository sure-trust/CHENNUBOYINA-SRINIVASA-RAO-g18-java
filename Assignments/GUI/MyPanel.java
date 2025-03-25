import java.awt.*;
public class MyPanel
{
 public static void main(String args[])
{
 Frame frame=new Frame("Frame with Panal");
Panel panel=new Panel();
frame.resize(200,200);
frame.setBackground(Color.blue);
frame.setLayout(null);
panel.resize(100,100);
panel.setBackground(Color.yellow);
frame.add(panel);//add panel into the Frame
frame.show();
}}