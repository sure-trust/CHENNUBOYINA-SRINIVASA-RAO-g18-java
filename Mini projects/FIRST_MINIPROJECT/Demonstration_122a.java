import java.io.FileOutputStream;
public class Demonstration_122a
{
 public static void main(String args[])
{
 try
{
FileOutputStream fout=new FileOutputStream("D:/nptel/text/Kri_122a");//create the file in this locatin
fout.write(65);//store the data in character by using the ascii code
fout.write(63);
fout.write("i am srinivasa rao".getBytes());
fout.close();
System.out.println("File is writing over");
}
catch(Exception e)
{
 System.out.println(e);
}}}