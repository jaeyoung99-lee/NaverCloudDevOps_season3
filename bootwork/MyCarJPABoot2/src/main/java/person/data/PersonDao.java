package person.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class PersonDao {
	private PersonRepository personRepository;
	
	// 추가
	public void insertPerson(PersonDto dto) {
		personRepository.save(dto);
	}
	
	// 전체 출력
	public List<PersonDto> getAllPersons(){
		return personRepository.findAll();
	}
	
	// 삭제
	public void deletePerson(int num) {
		personRepository.deleteById(num);
	}
}
