package mediaManager;

import java.util.ArrayList;
import java.util.List;


public class Collection implements Composite
{
	private List<Composite> members;
	private String name;
	
	Collection(String name_)
	{
		name = name_;
		members = new ArrayList<Composite>();
	}
	
	public void add(Composite e) throws Exception
	{
		if (is_present(e))
			throw new Exception(name + " already has a record with that title!");

		members.add(e);
	}
	
	public boolean is_present(Composite e)
	{
		return members.contains(e);
	}
	
	public void remove(Composite e) throws Exception
	{
		if (!is_present(e))
			throw new Exception(name + " does not contain a record with that title!");

		members.remove(e);
	}
	
	public boolean empty()
	{
		return members.size() > 0;
	}
	
	public void clear()
	{
		members.clear();
	}
	
	public String get_name()
	{
		return name;		
	}
	
	public void print()
	{
		System.out.println("Collection " + name + " contains"
				+ ((members.size()==0) ? " nothing" : ":") );
		
		// print members inside collection
		for (Composite member : members)
			member.print();
		
	}
	
	@Override
	public boolean equals(Object e)
	{
		if (e instanceof Collection)
			return equals((Collection)e);
		
		return false;
	}

	public boolean equals(Collection that)
	{
		return name == that.name;
	}
}
