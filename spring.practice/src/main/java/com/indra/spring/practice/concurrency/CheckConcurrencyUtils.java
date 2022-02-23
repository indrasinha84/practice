package com.indra.spring.practice.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class CheckConcurrencyUtils {

	public static void main(String[] args) {
		Semaphore s = new Semaphore(1);
//		s.acquire();
		CyclicBarrier cb = new CyclicBarrier(1);
//		cb.await(0, null)
		CountDownLatch cd = new CountDownLatch(1);
//		cd.await();
		Phaser p = new Phaser();
//		p.arrive();
		Exchanger<CheckConcurrencyUtils> e = new Exchanger<CheckConcurrencyUtils>();
//		e.exchange(null);
		ExecutorService fjp = Executors.newWorkStealingPool(10);
//		fjp.execute(null);
		ExecutorService ctp = Executors.newCachedThreadPool();
		ExecutorService ftp = Executors.newFixedThreadPool(10);
		ExecutorService schtp = Executors.newScheduledThreadPool(1);
		ExecutorService stp = Executors.newSingleThreadScheduledExecutor();
	}

}
