import java.util.Vector;
import java.util.Collections;
class VectorOperations
{
	public static void main(String args[]){
		Vector<Integer>v=new Vector<>();
		v.add(1);
		v.add(2);
		v.add(3);
		v.add(4);
		v.add(5);
		v.add(6);
		v.add(7);
		v.add(8);
		v.add(9);
		v.add(10);
		System.out.println(v);
		v.add(2,4);
		
		System.out.println(v);//add at particular index 
		System.out.println("the size of the vactor "+v.size());//return the size of the vector
		System.out.println("To check is it empty or not "+v.isEmpty());
		System.out.println("to remove the element at parivular index "+v.remove(3));
		System.out.println("after removeing the element in the vector "+v);
		System.out.println("the capacity of the vector is "+v.capacity());
		v.trimToSize();
		System.out.println("after the trimming vector "+v.capacity());
		Collections.sort(v);
		System.out.println("the sorting the element in vector "+v);
		v.clear();
		System.out.println("after the remove the all elements in the vector "+v);
	}
		
}