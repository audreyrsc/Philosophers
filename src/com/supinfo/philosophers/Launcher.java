package com.supinfo.philosophers;


public class Launcher {

	public static void main(String[] args) throws Exception {
		DinningTable table = new DinningTable();
		
		for(int i=1; i<=5; i++) {
			table.addPhilosopher(new Philosopher(i));
			table.putFork(i, new Fork(i));
		}
		
	}

}
