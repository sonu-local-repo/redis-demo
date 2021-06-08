package com.codeforfun.demo.config;


import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableCaching
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        RedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(configuration, getJedisClientConfiguration());
        return jedisConnectionFactory;

    }
    @Bean
    public JedisClientConfiguration getJedisClientConfiguration() {
        JedisClientConfiguration.JedisClientConfigurationBuilder builder = JedisClientConfiguration .builder();
        GenericObjectPoolConfig GenericObjectPoolConfig = new GenericObjectPoolConfig();
        GenericObjectPoolConfig.setMaxTotal(10);
        GenericObjectPoolConfig.setMaxIdle(5);
        GenericObjectPoolConfig.setMinIdle(2);
        return builder.usePooling().poolConfig(GenericObjectPoolConfig).build();
    }
    @Bean
    public RedisTemplate<String, Object> redisTemplate(){
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        template.setConnectionFactory(redisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new JdkSerializationRedisSerializer());
        template.setValueSerializer(new JdkSerializationRedisSerializer());

        template.setEnableTransactionSupport(true);
        template.afterPropertiesSet();
        return template;
    }
}
