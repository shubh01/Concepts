package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;


public class Test {

		public static void main(String[] args) {
			
			String[] substrings=new String[] {"a","bc","ac","ad"};
			
			Arrays.sort(substrings);
			System.out.println(Arrays.toString(substrings));
			System.out.println(String.join("",substrings));
		}

	}
	
