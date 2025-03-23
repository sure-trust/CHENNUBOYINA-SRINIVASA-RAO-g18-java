class Demonstration_1011a
{
 public static void main(String args[])
{
 int a=args.length;//give the inputs
 System.out.println(a);
int b=42/a;
System.out.println("a= "+a);
if(a==1)
{
a=a/(a-1);//if i give the one input it gives an arthematic exception
System.out.println("the result is "+a);
}
if(a==2)
{
 int c[]={1};
c[2]=99;//if i give the 2 inputs it also give an ArrayIndexOutOFBOundException
for(int i:c)
System.out.println(c);
}}}