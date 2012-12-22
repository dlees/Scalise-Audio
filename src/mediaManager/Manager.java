package mediaManager;
import java.util.ArrayList;
import java.util.List;


public class Manager
{
	List<Record> library;
	List<Collection> catalog; 
	
	public Manager()
	{
		library = new ArrayList<Record>();
		catalog = new ArrayList<Collection>();
	}
	
	public void add_record(String title, String filename) throws Exception
	{
		if (library.contains(new Record(title)))
			throw new Exception("Library already has a record with that title!");
				
		library.add(new Record(title, filename));		
	}
	
	public void print_record(String title) throws Exception
	{
		find_record(title).print();	
	}
	
	public Record find_record(String title) throws Exception
	{
		if (!library.contains(new Record(title)))
			throw new Exception("Library has no record with that title!");
		
		return library.get(library.indexOf(new Record(title)));
	}
	
	public Record find_record(int ID) throws Exception 
	{
		if (!library.contains(new Record(ID)))
			throw new Exception("Library has no record with that id!");
		
		return library.get(library.indexOf(new Record(ID)));
	}

	
	public void delete_record(String title) throws Exception
	{
		if (!library.contains(new Record(title)))
			throw new Exception("Library has no record with that title!");
	
		// Need to check through collections!
		// look for stl like functions in JAVA
		
		library.remove(new Record(title));		
	}

	public void print_library() throws Exception
	{
		if (library.size() == 0)
			throw new Exception("Library is Empty");
		
		System.out.println("Library contains:");
		
		for (Record r : library)
			r.print();
	}

	public void add_collection(String name) throws Exception
	{
		if (catalog.contains(new Collection(name)))
			throw new Exception("Catalog already has a collection with that name!");
		
		catalog.add(new Collection(name));		
	}
	
	public void print_collection(String name) throws Exception
	{
		find_collection(name).print();	
	}
	
	public Collection find_collection(String name) throws Exception
	{
		if (!catalog.contains(new Collection(name)))
			throw new Exception("Catalog has no collection with that name!");
		
		return catalog.get(library.indexOf(new Collection(name)));
	}

}
