package other;

import java.util.NoSuchElementException;

/**
 * The Queue class represents an immutable first-in-first-out (FIFO) queue of
 * objects.
 * 
 * @author If
 *
 * @param <E>
 */
public class ImmutableQueue<E>
{
	private ImmutableStack<E> enqueueStack;
	private ImmutableStack<E> dequeueStack;

	/**
	 * requires default constructor.
	 */
	public ImmutableQueue()
	{
		// modify this constructor if necessary, but do not remove default
		// constructor
		enqueueStack = new ImmutableStack<>();
		dequeueStack = new ImmutableStack<>();
	}

	// add other constructors if necessary
	private ImmutableQueue(ImmutableStack<E> enqueueStack,
			ImmutableStack<E> dequeueStack)
	{
		this.enqueueStack = enqueueStack;
		this.dequeueStack = dequeueStack;
	}

	/**
	 * Returns the queue that adds an item into the tail of this queue without
	 * modifying this queue.
	 * 
	 * <pre>
	 * e.g.
	 * When this queue represents the queue (2, 1, 2, 2, 6) and we enqueue the value 4 into this queue,
	 * this method returns a new queue (2, 1, 2, 2, 6, 4)
	 * and this object still represents the queue (2, 1, 2, 2, 6) .
	 * </pre>
	 * 
	 * If the element e is null, throws IllegalArgumentException.
	 * 
	 * @param e
	 * @return
	 * @throws IllegalArgumentException
	 */
	public ImmutableQueue<E> enqueue(E e)
	{
		if (e == null)
			throw new IllegalArgumentException();
		return new ImmutableQueue<>(enqueueStack.push(e), dequeueStack);
	}

	/**
	 * Returns the queue that removes the object at the head of this queue
	 * without modifying this queue.
	 * 
	 * <pre>
	 * e.g.
	 * When this queue represents the queue (7, 1, 3, 3, 5, 1) ,
	 * this method returns a new queue (1, 3, 3, 5, 1)
	 * and this object still represents the queue (7, 1, 3, 3, 5, 1) .
	 * </pre>
	 * 
	 * If this queue is empty, throws java.util.NoSuchElementException.
	 * 
	 * @return
	 * @throws java.util.NoSuchElementException
	 */
	public ImmutableQueue<E> dequeue()
	{
		if (size() == 0)
			throw new NoSuchElementException();
		if (dequeueStack.size() == 0)
		{
			dequeueStack = enqueueStack.reverseStack();
			enqueueStack = new ImmutableStack<>();
		}
		return new ImmutableQueue<>(enqueueStack, dequeueStack.pop());
	}

	/**
	 * Looks at the object which is the head of this queue without removing it
	 * from the queue.
	 * 
	 * <pre>
	 * e.g.
	 * When this queue represents the queue (7, 1, 3, 3, 5, 1),
	 * this method returns 7 and this object still represents the queue (7, 1, 3, 3, 5, 1)
	 * </pre>
	 * 
	 * If the queue is empty, throws java.util.NoSuchElementException.
	 * 
	 * @return
	 * @throws java.util.NoSuchElementException
	 */
	public E peek()
	{
		if (size() == 0)
			throw new NoSuchElementException();
		if (dequeueStack.size() == 0)
		{
			dequeueStack = enqueueStack.reverseStack();
			enqueueStack = new ImmutableStack<>();
		}
		return dequeueStack.peek();
	}

	/**
	 * Returns the number of objects in this queue.
	 * 
	 * @return
	 */
	public int size()
	{
		return enqueueStack.size() + dequeueStack.size();
	}
}

/**
 * Immutable stack for fast ImmutableQueue
 * 
 * @author If
 *
 * @param <E>
 */
class ImmutableStack<E>
{
	private final ImmutableList<E> top;
	private final int size;

	public ImmutableStack()
	{
		top = new ImmutableList<>();
		size = 0;
	}

	private ImmutableStack(ImmutableList<E> top, int size)
	{
		this.top = top;
		this.size = size;
	}

	public ImmutableStack<E> pop()
	{
		if (size == 0)
			throw new NoSuchElementException();
		return new ImmutableStack<>(top.getNext(), size - 1);
	}

	public ImmutableStack<E> push(E element)
	{
		if (element == null)
			throw new IllegalArgumentException();
		ImmutableList<E> list = new ImmutableList<>(element, top);
		return new ImmutableStack<>(list, size + 1);
	}

	public E peek()
	{
		if (size == 0)
			throw new NoSuchElementException();
		return top.getElement();
	}

	public ImmutableStack<E> reverseStack()
	{
		ImmutableStack<E> stack = new ImmutableStack<>();
		ImmutableList<E> list = top;
		while (list.getElement() != null)
		{
			stack = stack.push(list.getElement());
			list = list.getNext();
		}
		return stack;
	}

	public int size()
	{
		return size;
	}
}

/**
 * Immutable linked list for ImmutableStack
 * 
 * @author If
 *
 * @param <E>
 */
class ImmutableList<E>
{
	private final E element;
	private final ImmutableList<E> next;

	public ImmutableList()
	{
		element = null;
		next = null;
	}

	public ImmutableList(E element, ImmutableList<E> next)
	{
		this.element = element;
		this.next = next;
	}

	public E getElement()
	{
		return element;
	}

	public ImmutableList<E> getNext()
	{
		return next;
	}
}