public class Demonstration_106
{
 public static void main(String args[])
{
 int i=args.length;
//System.out.println(i);
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
}}