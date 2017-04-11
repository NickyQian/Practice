package com.nicky.practice.worksapplications;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class ExamPeekableQueueImpl<E extends Comparable<E>> implements
		ExamPeekableQueue<E> {
	private List<E> queue;

	public ExamPeekableQueueImpl() {
		queue = new ArrayList<E>();
	}

	@Override
	public void enqueue(E e) {
		if (e == null) {
			throw new IllegalArgumentException();
		}
		queue.add(e);
	}

	@Override
	public E dequeue() {
		if (queue.isEmpty()) {
			throw new NoSuchElementException();
		}
		return queue.remove(0);
	}

	@Override
	public E peekMedian() {
		if (queue.isEmpty()) {
			throw new NoSuchElementException();
		}
		Collections.sort(queue);
		return queue.get((queue.size()/2));
	}

	@Override
	public E peekMaximum() {
		if (queue.isEmpty()) {
			throw new NoSuchElementException();
		}
		Collections.sort(queue);
		return queue.get(queue.size()-1);
	}

	@Override
	public E peekMinimum() {
		if (queue.isEmpty()) {
			throw new NoSuchElementException();
		}
		Collections.sort(queue);
		return queue.get(0);
	}

	@Override
	public int size() {
		return queue.size();
	}
	
	//for testing
	public static void main(String[] args){
		ExamPeekableQueueImpl<Integer> queueImpl = new ExamPeekableQueueImpl<Integer>();
		queueImpl.enqueue(6);
		queueImpl.enqueue(1);
		queueImpl.enqueue(5);
		queueImpl.enqueue(4);
		queueImpl.enqueue(3);
		queueImpl.enqueue(2);
		queueImpl.dequeue();
		System.out.println(queueImpl.peekMaximum());
		System.out.println(queueImpl.peekMinimum());
		System.out.println(queueImpl.peekMedian());
		
	}
}
