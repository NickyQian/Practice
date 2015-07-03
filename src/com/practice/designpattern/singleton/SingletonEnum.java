package com.practice.designpattern.singleton;

import java.util.List;

import com.google.common.collect.ImmutableList;

public enum SingletonEnum {
	INSTANCE;

	public String getDetail() {

		return "Detail";
	}

	public List<String> getDetailList() {
		return ImmutableList.of("Detail1", "Detail2");
	}
}
