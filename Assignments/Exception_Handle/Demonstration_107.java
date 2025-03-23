public class Demonstration_107
{
 public static void main(String args[])
{
try
{
 int i=args.length;
String mystring[]=new String[i];
mystring[0]=args[0];
if(args[0].equals("java"))
{
 System.out.println("First word in java");
}
System.out.println("Number of arguments:"+i);
int x=12/i;
int y[]={155,999};
y[i]=x;
}
catch(ArithmeticException e)
{
 System.out.println("Divide by 0"+e);
}
catch(NullPointerException e)
{
 System.out.println("a null pointer exception "+e);
}
catch(ArrayIndexOutOfBoundsException e)
{
 System.out.println("array index out of bound "+e);
}
}}