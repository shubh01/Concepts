package lru.cache.java.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class LRUMain {

	private static LinkedList<Integer> CACHE = new LinkedList<>();
	private static HashMap<Integer, Integer> DICTONARY = new HashMap<>();
	private static Integer INITIAL_CAPACITY = 5;
	
	public static Integer getElement(Integer pageNo) {
		if(DICTONARY.containsKey(pageNo)) {
			Integer entry = DICTONARY.get(pageNo);
			Integer result = reorderCacheAndGetData(entry);
			reorderDictonary();
			return result;
		}else {
			if(DICTONARY.size() < INITIAL_CAPACITY) {
				return addElementInCacheAndDictonary(pageNo);
			}else {
				Integer value = removeElement();
				removeEntryFromDictonary(value);
				return addElementInCacheAndDictonary(pageNo);
			}
		}
	}

	private static Integer addElementInCacheAndDictonary(Integer pageNo) {
		Integer dataFromDb =  getDataFromDb(pageNo);
		addElement(dataFromDb);
		reorderDictonary();
		DICTONARY.put(pageNo, 0);
		return dataFromDb;
	}
	
	public static void main(String[] args) {
		getElement(11);		
		getElement(12);		
		getElement(13);		
		getElement(13);
		getElement(14);
		getElement(15);
		getElement(16);
   	   CACHE.stream().forEach(data -> System.out.println("element in cache : "+data));
		System.out.println("cache size: "+CACHE.size()+" dictonay size: "+DICTONARY.size());
	}
	
	private static void removeEntryFromDictonary(Integer index) {
		Integer key  = DICTONARY.entrySet().stream().filter(entry -> entry.getValue().equals(index)).findFirst().get().getKey();
		DICTONARY.remove(key);		
	}
	
	private static Integer reorderCacheAndGetData(Integer entry) {
		Integer result = CACHE.get(entry);
		CACHE.remove(result);
		CACHE.add(0, result);
		return result;
	}
	
	private static void reorderDictonary() {
		Iterator<Map.Entry<Integer, Integer>> iterator = DICTONARY.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<Integer, Integer> entry = iterator.next();
			DICTONARY.put(entry.getKey(),CACHE.indexOf(entry.getKey()));
		}
	}
	
	private static void addElement(Integer data) {
		CACHE.add(0,data);
	}
	
	private static Integer removeElement() {
		Integer data = CACHE.getLast();
		Integer index = CACHE.indexOf(data);
		System.out.println("data "+data+" index "+index);
		Iterator<Integer> iterator = CACHE.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().equals(data))
				iterator.remove();
		}
		return index;
	}
	
	private static Integer getDataFromDb(Integer pageNo) {
		return  pageNo;		
	}
}
