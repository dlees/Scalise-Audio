package mediaManager;
import java.util.ArrayList;
import java.util.List;


public class Manager
{
	List<Record> library;
	List<Collection> master_catalog; 
	
	public Manager()
	{
		library = new ArrayList<Record>();
		master_catalog = new ArrayList<Collection>();
	}
	
	public void add_record(String title, String filename) throws Error
	{
		if (library.contains(new Record(title)))
			throw new Error("Library already has a record with that title!");
				
		library.add(new Record(title, filename));		
	}
	
	public void print_record(String title) throws Error
	{
		find_record(title).print();	
	}
	
	public Record find_record(String title) throws Error
	{
		if (!library.contains(new Record(title)))
			throw new Error("Library has no record with that title!");
		
		return library.get(library.indexOf(new Record(title)));
	}
	
	public Record find_record(int ID) throws Error 
	{
		if (!library.contains(new Record(ID)))
			throw new Error("Library has no record with that id!");
		
		return library.get(library.indexOf(new Record(ID)));
	}

	
	public void delete_record(String title) throws Error
	{
		if (!library.contains(new Record(title)))
			throw new Error("Library has no record with that title!");
	
		// Need to check through collections!
		// look for stl like functions in JAVA
		
		library.remove(new Record(title));		
	}

	public void print_library() throws Error
	{
		if (library.size() == 0)
			throw new Error("Library is Empty");
		
		System.out.println("Library contains:");
		
		for (Record r : library)
			r.print();
	}

	public void add_collection(String name) throws Error
	{
		if (master_catalog.contains(new Collection(name)))
			throw new Error("Catalog already has a collection with that name!");
		
		master_catalog.add(new Collection(name));		
	}
	
	public void print_collection(String name) throws Error
	{
		find_collection(name).print();	
	}
	
	public Collection find_collection(String name) throws Error
	{
		if (!master_catalog.contains(new Collection(name)))
			throw new Error("Catalog has no collection with that name!");
		
		return master_catalog.get(master_catalog.indexOf(new Collection(name)));
	}
	
	public void add_member(String collection, Composite item) throws Error
	{
		find_collection(collection).add(item);			
	}

	public void remove_member(String collection, Composite item) throws Error
	{
		find_collection(collection).remove(item);			
	}
}
