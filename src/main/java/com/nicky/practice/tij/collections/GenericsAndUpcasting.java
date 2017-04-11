package com.nicky.practice.tij.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class GenericsAndUpcasting {

	@Test
	public void test() {
		ArrayList<Apple> apples = Lists.newArrayList();
		apples.add(new Gala());
		apples.add(new Fuji());
		apples.forEach(System.out::println);
	}

	@Test
	@SuppressWarnings("unused")
	public void testAsList() {
		List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder());
		List<Snow> snow2 = Lists.newArrayList();
		Collections.addAll(snow2, new Light(), new Heavy());
		List<Snow> snow3 = Arrays.<Snow> asList(new Light(), new Heavy());
		List<Snow> snow4 = Arrays.asList(new Light(), new Heavy());
	}
}

class Apple {
}

class Gala extends Apple {
}

class Fuji extends Apple {
}

class Snow {
}

class Powder extends Snow {
}

class Light extends Powder {
}

class Heavy extends Powder {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}
