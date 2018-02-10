package com.sanket.bigdata.demo1.config;

import redis.clients.jedis.Jedis;

public class JedisConnection {

	private static Jedis jedis;

	public static Jedis getConnection() {

		if (jedis == null) {
			Jedis jedis = new Jedis("localhost");
			System.out.println("Connection to server sucessfully");
			return jedis;
		}

		return jedis;

	}
}
