package person.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import person.data.PersonDao;
import person.data.PersonDto;

@RestController // @ResponseBody 안 써도 됨
@RequiredArgsConstructor
public class PersonController {
	private final PersonDao personDao;
	
	// 추가
	@GetMapping("/person/add")
	public void insert(@RequestBody PersonDto dto) {
		System.out.println("add >> " + dto); // 호출되는지 확인용, 자동으로 toString 함수 호출됨
		
		// db insert
		personDao.insertPerson(dto);
	}
	
	// 출력
	@GetMapping("/person/list")
	public List<PersonDto> list(){
		System.out.println("list >> "); // 호출되는지 확인용
		return personDao.getAllPersons();
	}
}
