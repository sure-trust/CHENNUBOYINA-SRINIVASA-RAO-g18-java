class ReplaceAll
{
	public static void main(String args[])
	{
		String str1="i was srinu i was studing b tech";
		String str2="(?i) was";
		System.out.println(str1.replaceAll(str2," am"));
	}
}