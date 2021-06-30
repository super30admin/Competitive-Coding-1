package heap;

import java.util.ArrayList;

public class Heap {
	
	ArrayList<Integer> data=new ArrayList<Integer>();
	
	public void add(int item)
	{
		data.add(item);
		upheapify(data.size()-1);
	}

	private void upheapify(int ci) {
		// TODO Auto-generated method stub
		
		int pi=(ci-1)/2;                                   //pi is parent index
		
		if(data.get(ci)<data.get(pi))                       // ci is child index
		{
			swap(pi,ci);
			upheapify(pi);
		}		
	}
	
	private void swap(int i,int j)
	{
		int ith=data.get(i);
		int jth=data.get(j);
		
		data.set(i, jth);
		data.set(j, ith);
	}
	
	public void display()
	{
		System.out.println(data);
	}
	
	public int size()
	{
		return this.data.size();
	}

	public boolean isEmpty()
	{
		return this.size()==0;
	}
	
	public int remove()
	{
		swap(0,data.size()-1);
		int rv=this.data.remove(this.data.size()-1);
		downheapify(0);
		return rv;
	}

	private void downheapify(int pi) {
		// TODO Auto-generated method stub
		
		
		int lci=2*pi+1;         //lci is left child
		int rci=2*pi+2;       //rci is right child
		
		int min=pi;
		
		if(lci<data.size()-1 && data.get(lci)<data.get(min))
		{
			min=lci;
		}
		if(rci<data.size()-1 && data.get(rci)<data.get(min))
		{
			min=rci;
		}
		
		if(min!=pi)
		{
			swap(min,pi);
			downheapify(min);
		}
		
	}
	
	public int get()
	{
	return this.data.get(0);
	}
}
