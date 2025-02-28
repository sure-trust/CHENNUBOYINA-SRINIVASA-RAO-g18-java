class Dogs
{
	String name;//instance variables
	float price;
	int age;
	Dogs(String name,float price,int age)
	{
		this.name=name;
		this.price=price;
		this.age=age;
	}
	void display()
	{
		System.out.println("the neme of the dog is "+name);
		System.out.println("the price of the dog is "+price);
		System.out.println("the age of the dog is "+age);
	}
	
}