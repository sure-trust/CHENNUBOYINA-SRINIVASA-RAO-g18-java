import java.awt.*;
public class Checkboxs
{
public static void main(String args[]){
 Frame f=new Frame("checkbox exampled");
 Checkbox c1=new Checkbox("c++");
c1.setBounds(100,100,50,50);
Checkbox c2=new Checkbox("java");
 //Checkbox c2=new Checkbox("java",true);//it is automatically tick mark for java check box;
c2.setBounds(100,150,50,50);
f.add(c1);
f.add(c2);
f.setSize(400,400);
f.setLayout(null);
f.setVisible(true);
}
}
