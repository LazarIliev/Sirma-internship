package com.sirma.javacourse.designpatterns.objectpool;

import java.util.Stack;

/**
 * Class for acquiring a specific object.
 */
class ObjectPool {
	private Stack<PooledClass> objects;
	private int maxNumberOfObjects;

	/**
	 * Creates an object pool with a given number of objects.
	 *
	 * @param maxNumberOfObjects how many objects the pool will hold.
	 */
	ObjectPool(int maxNumberOfObjects) {
		objects = new Stack<>();
		this.maxNumberOfObjects = maxNumberOfObjects;

	}

	/**
	 * Acquires an object from the pool.
	 *
	 * @return the next unused object from the pool.
	 */
	PooledClass acquire() {
		if (objects.isEmpty()) {
			throw new IndexOutOfBoundsException("Out of resources");
		}
		return objects.pop();
	}

	/**
	 * Releases the given resource.
	 *
	 * @param reusable the resource to be released.
	 * @return true if resources were freed.
	 */
	boolean release(PooledClass reusable) {
		if (objects.size() < maxNumberOfObjects) {
			objects.push(reusable);
			return true;
		}
		return false;
	}
}
