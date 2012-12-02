package com.supinfo.philosophers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.supinfo.philosophers.exception.UnknowForkException;

public class DinningTable {

	private List<Philosopher> philosophers;
	private static Map<Integer,Fork> forks;
	
	public DinningTable() {
		philosophers = new ArrayList<>(5);
		forks = new HashMap<>();
	}
	
	
	// PHILOSOPHERS //
	
	/**
	 * Add the philosopher to the list and start his activity
	 * @param phi : the philosopher
	 * @throws Exception if the philosopher in parameter is null
	 */
	public void addPhilosopher(Philosopher phi) {
		philosophers.add(phi);
		Thread th = new Thread(phi);
		th.start();
	}

	// FORKS //
	
	public void putFork(Integer key, Fork fork) {
		forks.put(key, fork);
	}
	
	public static Fork getPreviousFork(int philosopherNum) {
		Fork previousFork;
		
		if(philosopherNum-1>0)
			previousFork = forks.get(philosopherNum-1);
		else previousFork = forks.get(5);
		
		if(previousFork!=null)
			return previousFork;
		else throw new UnknowForkException("Previous fork doesn't exist.");
	}
	
	public static Fork getMyFork(int philosopherNum)  {
		Fork myFork = forks.get(philosopherNum);
		
		if(myFork!=null)
			return myFork;
		else throw new UnknowForkException("My fork doesn't exist.");
	}

	
}
