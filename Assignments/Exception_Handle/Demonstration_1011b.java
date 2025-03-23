class Demonstration_1011b
{
 public static void main(String args[])
{
try
{
 int a=args.length;
int b=42/a;
System.out.println("a= "+a);
if(a==1)
a=a/(a-1);
try
{
if(a==2)
{
 int c[]={1};
c[2]=99;
}
}
catch(ArrayIndexOutOfBoundsException e)//if i give two inputs it can execute
{
 System.out.println("array is out of range");
}}
catch(ArithmeticException e)//if i give one input it can execute
{
 System.out.println("Diveded by zero");
}
}}