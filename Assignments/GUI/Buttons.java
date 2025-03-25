import java.awt.*;
public class Buttons extends Component
{
 public static void main(String args[])
{
 Frame f=new Frame("button example");
 Button b=new Button("click me");
b.setBounds(150,50,100,100);
f.add(b);
f.setSize(600,600);
f.setLayout(null);
f.setVisible(true);
}}