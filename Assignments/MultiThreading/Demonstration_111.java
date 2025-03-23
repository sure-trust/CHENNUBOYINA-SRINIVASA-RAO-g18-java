//import java.lang.*;
class threadA extends Thread
{
 public void run()
{
 for(int i=1;i<=5;++i)
{
 System.out.println("From thread A "+-1*i);
}
System.out.println("Exiting from thread A");
}}
class threadB extends Thread
{
 public void run()
{
 for(int i=1;i<=5;++i)
{
 System.out.println("From thread B "+2*i);
}
System.out.println("Exiting from thread B");
}}
class threadC extends Thread
{
 public void run()
{
 for(int i=1;i<=5;++i)
{
 System.out.println("From thread C "+((2*i)-1));
}
System.out.println("Exiting from thread C");
}}
class Demonstration_111
{
 public static void main(String args[])
{
 threadA a=new threadA();
threadB b=new threadB();
threadC c=new threadC();
a.start();
b.start();
c.start();
System.out.println("    Multithreading is over");
}}