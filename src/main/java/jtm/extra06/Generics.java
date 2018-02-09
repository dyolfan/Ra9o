package jtm.extra06;

import static jtm.extra06.GenericsTest.log;

import java.util.LinkedList;

// import statically jtm.activity16.GenericsTest.log
// StringBuilder to be able referring to it by its name only

public class Generics<E extends Number> extends LinkedList<E> {
	// TODO #2
	// Use Eclipse code generation prompter to add generated serial version ID
	// for this class to avoid warning
	
	private static final long serialVersionUID = 7708818085602746688L;

	// TODO #3
	// Select Source— Generate Constructors from Superclass... and select
	// LinkedList<E>().
	// And implement extended constructor that after new Generics object is
	// created, log has appended line "Generics instance created"
	// HINT: use lazy initialization for log StringBuilder object
	
	public Generics() {
		super();
		String message = String.format("Generics instance created%n");
		log.append(message);
	}
	
	// Select menu: Source— Override/Implement methods..., extend LinkedList<E>
	// class, and select push(E) and pop() methods to override them.
	
	// Override pop() method of the list, that besides popping element from it
	// log has appended line: "java.lang.Integer: 1 popped", where:
	// java.lang.Integer is its class name
	// 1 is its actual value
	
	@Override
	public E pop() {
		String message = String.format(this.getFirst().getClass().getName() + ": " + this.getFirst() + " popped%n");
		log.append(message);
		return super.pop();
	}
	
	// override push() method that besides pushing new element into list
	// log has appended line: "java.lang.Double: 2 pushed", where:
	// java.lang.Double is actual class name of the value
	// 2 is its actual value
	
	@Override
	public void push(E e) {
		String message = String.format(e.getClass().getName() + ": " + e + " pushed%n");
		log.append(message);
		super.push(e);
	}
	
}
