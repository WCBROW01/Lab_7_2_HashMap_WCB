import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * Dictionary implementation using a HashMap.
 * Both key and value are strings.
 * @author Will Brown
 * @version 2.0
 * Fall 2021
 */
public class Dictionary implements DictionaryInterface<String, String> {
	
	private HashMap<String,String> dictionaryMap = new HashMap<String,String>();

	@Override
	public String add(String key, String value) {
		return dictionaryMap.put(key, value);
	}

	@Override
	public String remove(String key) {
		return dictionaryMap.remove(key);
	}

	@Override
	public String getValue(String key) {
		return dictionaryMap.get(key);
	}

	@Override
	public boolean contains(String key) {
		return dictionaryMap.containsKey(key);
	}

	@Override
	public Iterator<String> getKeyIterator() {
		return new KeyIterator();
	}

	@Override
	public Iterator<String> getValueIterator() {
		return new ValueIterator();
	}
	
	/**
	 * Iterates through dictionary keys
	 */
	private class KeyIterator implements Iterator<String> {
		
		private Iterator<String> dictIterator = dictionaryMap.keySet().iterator();

		@Override
		public boolean hasNext() {
			return dictIterator.hasNext();
		}

		@Override
		public String next() {
			return dictIterator.next();
		}
		
	}
	
	/**
	 * Iterates through dictionary values
	 */
	private class ValueIterator implements Iterator<String> {
		
		private Iterator<String> dictIterator = dictionaryMap.values().iterator();

		@Override
		public boolean hasNext() {
			return dictIterator.hasNext();
		}

		@Override
		public String next() {
			return dictIterator.next();
		}
		
	}

	@Override
	public boolean isEmpty() {
		return dictionaryMap.isEmpty();
	}

	@Override
	public int getSize() {
		return dictionaryMap.size();
	}

	@Override
	public void clear() {
		dictionaryMap.clear();
	}
	
	/**
	 * Returns the contents of the dictionary as a string.
	 * This output is usable as the contents of a CSV file with zero alterations.
	 * @return the contents of the dictionary
	 */
	public String toString() {
		String dictionaryString = "";
		for (Entry<String, String> anEntry : dictionaryMap.entrySet())
			dictionaryString += "\"" + anEntry.getKey() + "\",\"" + anEntry.getValue() + "\"\n";
		
		return dictionaryString;
	}
	
}
