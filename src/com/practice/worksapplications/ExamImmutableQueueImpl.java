package com.practice.worksapplications;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ExamImmutableQueueImpl<E> implements ExamImmutableQueue<E> {
	private List<E> queue;
	public ExamImmutableQueueImpl() {
		queue = new ArrayList<E>();
	}
	private ExamImmutableQueueImpl(List<E> queue) {
		this.queue = queue;
	}
	
	@Override
	public ExamImmutableQueue<E> enqueue(E e) {
		if (e == null) {
		throw new IllegalArgumentException();
		}
		queue.add(e);
		ExamImmutableQueueImpl<E> result = new ExamImmutableQueueImpl<E>(queue);
		queue.remove(queue.size()-1);
		return result;
	}

	@Override
	public ExamImmutableQueue<E> dequeue() {
		if (queue.isEmpty()) {
			throw new NoSuchElementException();
		}
		List<E> clone = new ArrayList<E>(queue);
		clone.remove(0);
		return new ExamImmutableQueueImpl<E>(clone);
	}

	@Override
	public E peek() {
		if (queue.isEmpty()) {
			throw new NoSuchElementException();
		}
		return queue.get(0);
	}

	@Override
	public int size() {
		return queue.size();
	}

}
