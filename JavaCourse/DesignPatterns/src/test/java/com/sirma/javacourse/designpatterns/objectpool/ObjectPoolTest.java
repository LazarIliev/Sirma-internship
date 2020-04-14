package com.sirma.javacourse.designpatterns.objectpool;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ObjectPoolTest {

	@Test
	void acquire_moreTimeThanIsSet_shouldThrowIndexOutOfBoundsException() {
		ObjectPool objectPool = new ObjectPool(2);
		objectPool.release(new PooledClass());
		objectPool.release(new PooledClass());
		objectPool.acquire();
		objectPool.acquire();

		assertThrows(IndexOutOfBoundsException.class, () -> { objectPool.acquire();});
	}

	@Test
	void release_whenFullCase_shouldReturnFalse() {
		ObjectPool objectPool = new ObjectPool(2);
		objectPool.release(new PooledClass());
		objectPool.release(new PooledClass());

		assertFalse(objectPool.release(new PooledClass()));
	}

	@Test
	void release_inNormalCase_shouldReturnTrue() {
		ObjectPool objectPool = new ObjectPool(5);

		assertTrue(objectPool.release(new PooledClass()));
	}
}