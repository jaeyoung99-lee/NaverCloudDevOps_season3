package person.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import person.data.PersonDao;
import person.data.PersonDto;

@RestController
@RequiredArgsConstructor
public class PersonController {
	private final PersonDao personDao;
	
	// 추가
	@PostMapping("/person/add")
	public void insert(@RequestBody PersonDto dto)
	{
		System.out.println("add>>"+dto);
		
		//db insert
		personDao.insertPerson(dto);
	}
	
	// 출력
	@GetMapping("/person/list")
	public List<PersonDto> list()
	{
		System.out.println("list>>");
		return personDao.getAllPersons();
	}
	
	// 삭제
	@DeleteMapping("/person/delete")
	public void delete(@RequestParam("pnum") int pnum)
	{
		System.out.println("delete>>"+pnum);
		personDao.deletePerson(pnum);
	}
	
	
	// dto 반환
	@GetMapping("/person/select")
	public PersonDto select(@RequestParam("pnum") int pnum) {
		System.out.println("select >> " + pnum);
		return personDao.getSelectData(pnum);
	}
	
	// 수정 : pnum이 반드시 들어있어야 함
	@PostMapping("/person/update")
	public void update(@RequestBody PersonDto dto) {
		System.out.println("update >> " + dto);
		personDao.updatePerson(dto);
	}
}










