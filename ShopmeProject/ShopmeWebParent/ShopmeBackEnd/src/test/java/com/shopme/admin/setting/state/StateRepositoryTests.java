package com.shopme.admin.setting.state;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Country;
import com.shopme.common.entity.State;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class StateRepositoryTests {

	@Autowired 
	private StateRepository repo;
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateStates() {
		Integer countryId = 1;
		Country country = entityManager.find(Country.class, countryId);
		
		State state = repo.save(new State("Taiwan",country));
		
		assertThat(state).isNotNull();
	}
	
	@Test
	public void testGetState() {
		Integer stateId = 1;
		Optional<State> findById = repo.findById(stateId);
		assertThat(findById.isPresent());
	}
	
	@Test
	public void testDeleteState() {
		Integer stateId = 1;
		repo.deleteById(stateId);
		
		Optional<State> findById = repo.findById(stateId);
		assertThat(findById.isEmpty());
	}
}
