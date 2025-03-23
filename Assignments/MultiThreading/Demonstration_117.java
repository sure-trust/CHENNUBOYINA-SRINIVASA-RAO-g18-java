//import java.lang.*;
class ThreadA extends Thread
{
 public void run()
{
 for(int i=1;i<=5;++i)
{
 System.out.println("From thread A  i= "+i);
}
System.out.println("Exiting from thread A");
}}
class ThreadB extends Thread
{
 public void run()
{
 for(int i=1;i<=5;++i)
{
 System.out.println("From thread B   j= "+i);
}
System.out.println("Exiting from thread B");
}}
class ThreadC extends Thread
{
 public void run()
{
 for(int i=1;i<=5;++i)
{
 System.out.println("From thread C   k= "+i);
}
System.out.println("Exiting from thread C");
}}
class Demonstration_117
{
 public static void main(String args[])
{
 ThreadA a=new ThreadA();
ThreadB b=new ThreadB(); //give the praority to the thread 
ThreadC c=new ThreadC();
c.setPriority(Thread.MAX_PRIORITY);  //it is maxamimum priority
b.setPriority(Thread.MIN_PRIORITY);//minimum priority
a.setPriority(b.getPriority()+1);//middle priority
a.start();
b.start();
c.start();
System.out.println("    Multithreading is over");
}}