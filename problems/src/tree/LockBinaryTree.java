package tree;

/**
 * #24 : This problem was asked by Google.

Implement locking in a binary tree. A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.

Design a binary tree node class with the following methods:

   - is_locked, which returns whether the node is locked
   - lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, 
    	it should lock it and return true.
   - unlock, which unlocks the node. If it cannot be unlocked, then it should return false. 
     Otherwise, it should unlock it and return true.

You may augment the node to add parent pointers or any other property you would like. 
You may assume the class is used in a single-threaded program, so there is no need for actual locks or mutexes. 
Each method should run in O(h), where h is the height of the tree.
 *
 */
public class LockBinaryTree {

	private LockBinaryTree left;
	private LockBinaryTree right;
	private LockBinaryTree parent;
	private boolean locked = false; // to stores the lock state.
	private int numLockedDescendants = 0;  // > 0 shows -> locked

	/*
	 * is_locked
	 */
	public boolean is_Locked() {
		return locked;
	}

	/*
	 * unlock, only of ancestors and descendants are locked
	 */
	public boolean unlock() {
		if (locked) {
			locked = false;  // update flag to false
			for (LockBinaryTree itr = parent; itr != null; itr = itr.parent) {
				--itr.numLockedDescendants; // decrement the numLockedDescendants
			}
			return true;
		}
		return false;
	}

	public boolean lock() {
		
		// we cannot lock if any of the descendants are locked.
		
		if (numLockedDescendants > 0 || locked) {
			return false;
		}
		
		// we cannot lock if any of the parents are locked.

		for (LockBinaryTree itr = parent; itr != null; itr = itr.parent) {
			if (itr.locked) { // check if parent is locked
				return false;
			}
		}
		// lock
		locked = true; // update the locked flag to "true"
		for (LockBinaryTree itr = parent; itr != null; itr = itr.parent) {
			++itr.numLockedDescendants; // increment the numLockedDescendants
		}
		return true;
	}
}