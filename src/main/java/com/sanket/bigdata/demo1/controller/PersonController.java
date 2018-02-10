package com.sanket.bigdata.demo1.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.common.reflect.TypeToken;
import com.sanket.bigdata.demo1.domain.Plan;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {
	
	private CrudRepository<Plan, String> repository;

	@Autowired
	public PersonController(CrudRepository<Plan, String> repository)
	{
		this.repository = repository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Plan> persons()
	{
		return repository.findAll();
	}

	@RequestMapping(method = RequestMethod.PUT)
    public Plan add(@RequestBody JSONObject plan, @PathVariable String resource,HttpServletRequest request,HttpServletResponse response) {
		
		Map<String, Object> mapOfJSON = new Gson().fromJson(plan.toJSONString(),
				new TypeToken<Map<String, Object>>() {
				}.getType());
		
        return repository.save(plan);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Plan update(@RequestBody @Valid Plan person) {
        return repository.save(person);
    }

    @RequestMapping(value = "/{emailAddress:.+}", method = RequestMethod.GET)
    public Plan getById(@PathVariable String emailAddress) {
        return repository.findOne(emailAddress);
    }

    @RequestMapping(value = "/{emailAddress:.+}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable String emailAddress) {
        repository.delete(emailAddress);
    }

}
