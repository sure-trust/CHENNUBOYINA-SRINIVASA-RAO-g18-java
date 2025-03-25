import javax.swing.*;
class Progress extends JFrame
{
 int i=0;
int num=0;
JProgressBar jb;
public Progress()
{
 jb=new JProgressBar(0,2000);
jb.setBounds(40,40,160,30);
jb.setValue(0);
jb.setStringPainted(true);
add(jb);
setSize(250,150);
setLayout(null);
}
public void iterate()
{
 while(i<=2000)
{
 jb.setValue(i);
i=i+20;
try{Thread.sleep(150);}catch(Exception e)
{}
}}
public static void main(String args[])
{
 Progress m=new Progress();
m.setVisible(true);
m.iterate();
}}
