package data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.MemberDto;
import data.mapper.MemberMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService {
	private MemberMapper memberMapper;
	
	public int getTotalCount() {
		return memberMapper.getTotalCount();
	}
	
	public List<MemberDto> getAllMembers() {
		return memberMapper.getAllMembers();
	}
	
	public void insertMember(MemberDto dto) {
		memberMapper.insertMember(dto);
	}
	
	public int getIdCheck(String myid) {
		return memberMapper.getIdCheck(myid);
	}
	
	public void deleteMember(int num) {
		memberMapper.deleteMember(num);
	}
	
	public MemberDto getMember(int num) {
		return memberMapper.getMember(num);
	}
	
	public MemberDto getLogin(String myid) {
		return memberMapper.getLogin(myid);
	}
}
