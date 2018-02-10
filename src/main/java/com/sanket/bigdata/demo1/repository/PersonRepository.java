package com.sanket.bigdata.demo1.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.CrudRepository;

import com.sanket.bigdata.demo1.domain.Plan;

public class PersonRepository implements CrudRepository<Plan, String>{

	public static final String PERSONS_KEY = "persons";

	private final HashOperations<String, String, Plan> hashOps;

	public PersonRepository(RedisTemplate<String, Plan> redisTemplate) {
		this.hashOps = redisTemplate.opsForHash();
	}

	@Override
	public long count() {
		return hashOps.keys(PERSONS_KEY).size();
	}

	@Override
	public void delete(String emailAddress) {
		hashOps.delete(PERSONS_KEY, emailAddress);
	}

	@Override
	public void delete(Plan person) {
		hashOps.delete(PERSONS_KEY,  person.getEmailAddress());
	}

	@Override
	public void delete(Iterable<? extends Plan> persons) {
		for (Plan p : persons) {
			delete(p);
		}
	}

	@Override
	public void deleteAll() {
		Set<String> emails = hashOps.keys(PERSONS_KEY);
		for (String email : emails) {
			delete(email);
		}

	}

	@Override
	public boolean exists(String emailAddress) {
		return hashOps.hasKey(PERSONS_KEY,  emailAddress);
	}

	@Override
	public Iterable<Plan> findAll() {
		return hashOps.values(PERSONS_KEY);
	}

	@Override
	public Iterable<Plan> findAll(Iterable<String> emailAddresses) {
		return hashOps.multiGet(PERSONS_KEY, convertIterableToList(emailAddresses));
	}

	@Override
	public Plan findOne(String emailAddress) {
		return hashOps.get(PERSONS_KEY, emailAddress);
	}

	@Override
	public <S extends Plan> S save(S person) {
		hashOps.put(PERSONS_KEY, person.getEmailAddress(), person);

		return person;
	}

	@Override
	public <S extends Plan> Iterable<S> save(Iterable<S> persons) {
		List<S> result = new ArrayList();

		for(S entity : persons) {
			save(entity);
			result.add(entity);
		}

		return result;
	}

	private <T> List<T> convertIterableToList(Iterable<T> iterable) {
        List<T> list = new ArrayList<>();
        for (T object : iterable) {
            list.add(object);
        }
        return list;
    }
}
