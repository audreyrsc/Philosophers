package com.supinfo.philosophers;

import java.util.Random;


public class Philosopher implements Runnable {

	private int num;
	
	public Philosopher(int num) {
		this.num = num;
	}
	
	@Override
	public void run() {
		final int max = 5;
		
		for(int i=0; i<max; i++) {
			try {
				
				think();
				eat();
				
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void think() throws InterruptedException {
		System.out.println(num+" is thinking...");
		Thread.sleep(getRandomTimeout());
	}
	
	private void eat() throws InterruptedException {
		Fork previousFork = DinningTable.getPreviousFork(num);
		Fork myFork = DinningTable.getMyFork(num);
		
		if(!previousFork.getLock().isLocked() && !myFork.getLock().isLocked()) {
			
			previousFork.getLock().lock();
			myFork.getLock().lock();
			
			System.out.println(num+" is eating with forks "+previousFork.getNum()+","+myFork.getNum());
			Thread.sleep(getRandomTimeout());
			
			previousFork.getLock().unlock();
			myFork.getLock().unlock();
			
			System.out.println(num+" has finished to eat.");
		} else {
			System.out.println(num+" wants to eat!!");
		}
	}
	
	private int getRandomTimeout() {
		Random r = new Random();
		int timeout = r.nextInt(3001);
		
		while(timeout<1000)
			timeout = r.nextInt(4001);
		
		return timeout;
	}
}
