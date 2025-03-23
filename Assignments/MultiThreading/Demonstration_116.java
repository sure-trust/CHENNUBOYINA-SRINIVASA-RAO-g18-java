class Thread1 extends Thread
{
 public void run()
{
 try
{
 System.out.println("First thread starts running");
sleep(10000);//wait in ms
System.out.println("First thread finishes running");
}
catch(Exception e)
{
	System.out.println("an exceptin is there");
}
}}
class Thread2 extends Thread
{
 public void run()
{
 try
{
 System.out.println("Second thread starts running");
System.out.println("First thread suspended running");
suspend();//suspend the threadbut it is not available
System.out.println("Second thread runs again");
}
catch(Exception e)
{}
}} 
class Demonstration_116
{
 public static void main(String args[])
{
 try
{
Thread1 first=new Thread1();
Thread2 second=new Thread2();
first.start();
second.start();
System.out.println("Revive the second thread");
/*second.sleep(10000);
System.out.println("wakeup second thread and finishes the thread");
first.sleep(10000);
System.out.println("wakeup second thread and finishes the 333thread");*/
}
catch(Exception e)
{}
}}