package com.practice.collections;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class MapRemoveTest {
	@Test
	public void test() {
		Map<Integer, String> employeeRelations = Maps.newHashMap();
		employeeRelations.put(1, "department1");
		employeeRelations.put(2, "department2");
		employeeRelations.put(3, "department3");
		employeeRelations.put(4, "department1");
		employeeRelations.put(5, "department2");
		employeeRelations.put(6, "department3");
		employeeRelations.put(7, "department2");
		employeeRelations.put(8, "department3");

		// remove all employees in department2
		String departToBeDeleted = "department2";
		List<String> departsToBeDeleted = Lists.newArrayList(departToBeDeleted);
		employeeRelations.values().removeAll(departsToBeDeleted);

		iteratorMap(employeeRelations);

		String depart3 = "department3";
		Iterator<Integer> it = employeeRelations.keySet().iterator();
		while(it.hasNext()) {
			Integer employeeId = it.next();
			if(depart3.equals(employeeRelations.get(employeeId))) {
				it.remove();
			}
		}
		iteratorMap(employeeRelations);

	}

	private void iteratorMap(Map<Integer, String> employeeRelations) {
		System.out.println("=============");
		for (Entry<Integer, String> entry : employeeRelations.entrySet()) {
			System.out.println(String.format("%d : %s", entry.getKey(), entry.getValue()));
		}
	}
}
