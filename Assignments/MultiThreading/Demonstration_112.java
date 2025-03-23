class ThreadX implements Runnable
{
 public void run()
{
 for(int i=1;i<=5;++i)
{
 System.out.println("From thread X "+-1*i);
}
System.out.println("Exiting from thread X");
}}
class ThreadY implements Runnable
{
 public void run()
{
 for(int i=1;i<=5;++i)
{
 System.out.println("From thread Y "+2*i);
}
System.out.println("Exiting from threadY");
}}
class ThreadZ implements Runnable
{
 public void run()
{
 for(int i=1;i<=5;++i)
{
 System.out.println("From thread Z "+((2*i)-1));
}
System.out.println("Exiting from thread Z");
}}
public class Demonstration_112
{
 public static  void main(String args[])
{
 ThreadX x=new ThreadX();
Thread t1=new Thread(x); 
ThreadY y=new ThreadY();
Thread t2=new Thread(y); 
Thread t3=new Thread(new ThreadZ());
t1.start();//output is come in unorder because cpu can schedule the run of the thread
t2.start();
t3.start();
System.out.println("Multithreading is over");
}}