package com.sirma.javacourse.collections.pagebean;

import java.util.ArrayList;
import java.util.List;

/**
 * Runner class for PageBean.
 */
public class RunnerPageBean {
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(3);
		list.add(-5);
		list.add(20);
		list.add(1);
		list.add(7);
		list.add(2);
		list.add(33);
		list.add(47);
		list.add(-1);
		list.add(55);
		list.add(55);

		PageBean pageBean = new PageBean<>(list, 2);
		pageBean.startPageBean();
	}
}
