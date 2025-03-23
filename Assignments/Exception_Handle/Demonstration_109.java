class Demonstration_109
{
 public static void main(String args[])
{
 int i=0;
String greeting[]={"Hello Twinckle","Hello java","Hello World"};
while(i<4)
{
 try
{
  System.out.println(greeting[i]);
i++;
}
catch(Exception e)
{
 System.out.println(e.toString());
}
finally
{
 System.out.println("Hi");
if(i<3);
else
{
System.out.println("you should quit and reset index value");
break;
}
}}}}

