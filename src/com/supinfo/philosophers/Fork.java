package com.supinfo.philosophers;

import java.util.concurrent.locks.ReentrantLock;

public class Fork {

	private int num;
	private ReentrantLock lock;
	
	public Fork(int num) {
		this.num = num;
		lock = new ReentrantLock();
	}
	
	public int getNum() {
		return num;
	}

	public ReentrantLock getLock() {
		return lock;
	}
}
