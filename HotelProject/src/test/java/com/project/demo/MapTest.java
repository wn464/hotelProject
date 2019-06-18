package com.project.demo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class MapTest {

	@Test
	public void test() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("3", "1");
		map.put("1", "1");map.put("7", "1");map.put("6", "1");
		map.put("2", "1");
		map.put("5", "1");
		Set<Entry<String, String>> set = map.entrySet();
		for (Entry<String, String> entry : set) {
			System.out.println(entry);
		}
	}
}
