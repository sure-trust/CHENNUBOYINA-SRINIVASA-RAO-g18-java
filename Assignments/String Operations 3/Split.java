class Split
{
	public static void main(String args[])
	{
		String str="i am Srinivasa Rao i am studing b-tech";
		String str2="[,//.//s//;]";
		String[] result=str.split(str2);
		for(String x:result)
			System.out.println(x);
	}
}