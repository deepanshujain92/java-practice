import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

/**
 * @author deepanshu
 *
 */
public class SortHashMapByValue {
	public static void main(String args[]) {
		HashMap<String, Integer> scores = new HashMap<>();
		scores.put("Sachin", 55);
		scores.put("Rahul", 46);
		scores.put("Sehwag", 22);
		HashMap<String, Integer> sortedScores = sortByValue(scores);
        printSortedMap(sortedScores);        
	}
	
	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
		// Create a list from elements of HashMap
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// put data from sorted list to LinkedHashMap
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}
  
  public static void printSortedMap(HashMap<String, Integer> sortedScores){
  for (Map.Entry<String, Integer> en : sortedScores.entrySet()) { 
            System.out.println("Key = " + en.getKey() +  
                          ", Value = " + en.getValue()); 
        }
  }
}
