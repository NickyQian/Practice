package com.nicky.practice.worksapplications;

/**
* The Queue class represents an immutable first-in-first-out (FIFO) queue of objects.
*/
public interface ExamImmutableQueue<E> {
/**
* Returns the queue that adds an item into the tail of this queue without modifying this queue.
* <pre>
* e.g.
* When this queue represents the queue (2, 1, 2, 2, 6) and we enqueue the value 4 into this queue,
* this method returns a new queue (2, 1, 2, 2, 6, 4)
* and this object still represents the queue (2, 1, 2, 2, 6) .
* </pre>
* If the element e is null, throws IllegalArgumentException.
* @param e
* @return
* @throws IllegalArgumentException
*/
public ExamImmutableQueue<E> enqueue(E e);
/**
* Returns the queue that removes the object at the head of this queue without modifying this queue.
* <pre>
* e.g.
* When this queue represents the queue (7, 1, 3, 3, 5, 1) ,
* this method returns a new queue (1, 3, 3, 5, 1)
* and this object still represents the queue (7, 1, 3, 3, 5, 1) .
* </pre>
* If this queue is empty, throws java.util.NoSuchElementException.
* @return
* @throws java.util.NoSuchElementException
*/
public ExamImmutableQueue<E> dequeue();
/**
* Looks at the object which is the head of this queue without removing it from the queue.
* <pre>
* e.g.
* When this queue represents the queue (7, 1, 3, 3, 5, 1),
* this method returns 7 and this object still represents the queue (7, 1, 3, 3, 5, 1)
* </pre>
* If the queue is empty, throws java.util.NoSuchElementException.
* @return
* @throws java.util.NoSuchElementException
*/
public E peek();
/**
* Returns the number of objects in this queue.
* @return
*/
public int size();
}
