package de.quirmbach.jp.mapstructdemo.mapper;

import de.quirmbach.jp.mapstructdemo.dto.PersonDto;
import de.quirmbach.jp.mapstructdemo.entity.PersonEntity;
import de.quirmbach.jp.mapstructdemo.mapper.IPersonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.UUID;

@SpringBootTest
class PersonMapperTest {

	@Autowired
	private IPersonMapper mapper;

	@Test
	void should_convert_entity_to_dto() {
		PersonEntity entity = new PersonEntity();
		entity.setId(UUID.randomUUID().toString());
		entity.setFirstName("JP");
		entity.setLastName("Quirmbach");

		PersonDto dto = mapper.convertToPersonDto(entity);

		assertEquals(entity.getId(), dto.getPersonId());
		assertEquals(entity.getFirstName(), dto.getFirstName());
		assertEquals(entity.getLastName(), dto.getSurName());
	}

	@Test
	void should_convert_null_entity_to_null_dto() {
		PersonDto dto = mapper.convertToPersonDto(null);
		assertNull(dto);
	}

	@Test
	void should_convert_dto_to_entity() {
		PersonDto dto = new PersonDto();
		dto.setPersonId(UUID.randomUUID().toString());
		dto.setFirstName("JP");
		dto.setSurName("Quirmbach");

		PersonEntity entity = mapper.convertToPersonEntity(dto);

		assertEquals(dto.getPersonId(), entity.getId());
		assertEquals(dto.getFirstName(), entity.getFirstName());
		assertEquals(dto.getSurName(), entity.getLastName());

	}

	@Test
	void should_convert_null_dto_to_null_entity() {
		PersonEntity entity = mapper.convertToPersonEntity(null);
		assertNull(entity);
	}

}
