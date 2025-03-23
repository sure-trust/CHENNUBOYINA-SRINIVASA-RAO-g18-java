class ClassA extends Thread
{
 public void run()
{
 System.out.println("Start Thread A...");
for(int i=1;i<=5;i++)
{
 if(i==1) 
Thread.yield();
System.out.println("From thread A: i= "+i);
}
System.out.println("    exit Thread A  ");
}}
class ClassB extends Thread 
{
 public void run()
{
 System.out.println("Start Thread B...");
for(int j=1;j<=5;j++)
{
 System.out.println("From Thread B: j= "+j);
if(j==2) 
stop();
}
System.out.println("....Exit Thread  B");
}}
class ClassC extends Thread
{
 public void run()
{
 System.out.println("Start Thread C...");
for(int k=1;k<=5;k++)
{
 System.out.println("From Thread : k= "+k);
if(k==3)
{
 try
{ 
Thread.sleep(10000);
}
catch(Exception e)
{
System.out.println("exception is there");
}
}}
System.out.println("....Exit Thread  C");
}}
class Demonstration_115
{
 public static void main(String args[])
{
        ClassA t1 = new ClassA();
        ClassB t2 = new ClassB();
        ClassC t3 = new ClassC();
t1.start();
t2.start();
t3.start();
System.out.println("   end the executonf");
}}

