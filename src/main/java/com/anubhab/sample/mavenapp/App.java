package com.anubhab.sample.mavenapp;

import java.util.concurrent.ExecutionException;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws ExecutionException {
		System.out.println("Hello World!");
		LoadingCache<String, String> cache = CacheBuilder.newBuilder()
				.maximumSize(20)
				.recordStats()
				.build(new CacheLoader<String,String>(){

			@Override
			public String load(String key) throws Exception {
				return key;
			}
			
		});
		
		for(int i=0; i<30; i++){
			cache.get(""+i);
		}
		
		CacheStats stats = cache.stats();
		System.out.println(stats.toString());
	}
}
