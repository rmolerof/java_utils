package com.fedex.sandbox.executors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorsTest {

	public static void main(String[] args) {
		
		ExecutorService pool = Executors.newFixedThreadPool(4);
		
		Set<Callable<String>> callables = new HashSet<Callable<String>>();
		
		callables.add(new Callable<String>(){
			public String call() throws Exception{
				System.out.println("in task 1");
				return "task 1";
			}
		});
		
		callables.add(new Callable<String>(){
			public String call() throws Exception{
				System.out.println("in task 2");
				return "task 2";
			}
		});
		
		callables.add(new Callable<String>(){
			public String call() throws Exception{
				System.out.println("in task 3");
				return "task 3";
			}
		});
		
		callables.add(new Callable<String>(){
			public String call() throws Exception{
				System.out.println("in task 4");
				return "task 4";
			}
		});
		
		try {
			// Invoke Any
			String anyResult = pool.invokeAny(callables);
			System.out.println("Invoke Any: " + anyResult);
			
			// Invoke all
			List<Future<String>> resultI = pool.invokeAll(callables);
			System.out.println("Invoke all");
			for(Future<String> future: resultI){
				System.out.println("Future: " + future.get());
			}
			
			// Submit one by one
			List<Future<String>> resultS = new ArrayList<Future<String>>();
			for(Callable<String> callable: callables){
				resultS.add(pool.submit(callable));
				TimeUnit.SECONDS.sleep(2);
			}
			System.out.println("Submit one by one");
			for(Future<String> future: resultS){
				System.out.println("Future: " + future.get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} 
		
		pool.shutdown(); // Makes sure that all threads are closed.
		
	}

}
