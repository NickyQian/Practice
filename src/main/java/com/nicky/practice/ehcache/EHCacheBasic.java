package com.nicky.practice.ehcache;

import java.io.FileNotFoundException;
import java.io.IOException;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration.Strategy;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

import org.junit.Assert;
import org.junit.Test;

public class EHCacheBasic {
	@SuppressWarnings("unused")
	@Test
	public void testEHCache() throws FileNotFoundException, IOException {

//		try (InputStream fis = new FileInputStream(new File("src/config/ehcache.xml").getAbsolutePath());) {
//			CacheManager manager = CacheManager.newInstance(fis);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		CacheManager cacheManager = CacheManager.create();
		String[] cacheNames = cacheManager.getCacheNames();

		// A new cache based on the default configuration
		cacheManager.addCache("cacheWithDefaultConfig");
		Cache cacheWithDefaultConfig = cacheManager.getCache("cacheWithDefaultConfig");

		// a new cache with specified configuration
		Cache memoryOnlyCache = new Cache("memoryOnlyCache", 5000, false, false, 5, 2);
		cacheManager.addCache(memoryOnlyCache);
		Cache cacheToGet = cacheManager.getCache("memoryOnlyCache");

		int maxEntriesLocalHeap = 1000;
		Cache cacheWithSpecifiedConfig = new Cache(new CacheConfiguration("cacheWithSpecifiedConfig",
				maxEntriesLocalHeap).memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LFU).eternal(false)
				.timeToLiveSeconds(60).timeToIdleSeconds(30).diskExpiryThreadIntervalSeconds(0)
				.persistence(new PersistenceConfiguration().strategy(Strategy.LOCALTEMPSWAP)));
		cacheManager.addCache(cacheWithSpecifiedConfig);
		cacheManager.removeCache("cacheWithSpecifiedConfig");

		Element element = new Element("key1", "value1");
		cacheWithDefaultConfig.put(element);
		// This updates the entry for "key1"
		cacheWithDefaultConfig.put(new Element("key1", "value2"));
		Element e = cacheWithDefaultConfig.get("key1");
		Object value = e.getObjectValue();
		Assert.assertEquals("value2", value.toString());

		// The following gets the number of elements currently in the cache.
		Cache cache = cacheManager.getCache("cacheWithDefaultConfig");
		int cacheSize = cache.getSize();
		System.out.println(cacheSize);
		// The following gets the number of elements currently in the
		// MemoryStore.
		long elementsInMemory = cache.getMemoryStoreSize();
		System.out.println(elementsInMemory);
		// The following gets the number of elements currently in the DiskStore.
		long elementsInDisk = cache.getDiskStoreSize();
		System.out.println(elementsInDisk);

	}
}
