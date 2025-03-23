class ThreadId implements Runnable
{
 public void run()
{
 try
{
 long threadId = Thread.currentThread().getId();
 //System.out.println("Thread "+Thread.currentThread().getId() +" is running");
System.out.println("Thread "+threadId+" is running");
}
catch(Exception e)
{
 System.out.println("Exception is caught");
}}}
public class Demonstration_113 
{
 public static void main(String args[])
{
 int n=8;
for(int i=0;i<8;i++)
{
	ThreadId a=new ThreadId();
	Thread b=new Thread(a);
 //Thread obj=new Thread(new ThreadId());
 b.start();
 //obj.start();
}}}