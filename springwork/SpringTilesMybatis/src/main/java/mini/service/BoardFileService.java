package mini.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import mini.dao.BoardFileDao;
import mini.dto.BoardFileDto;

@Service
@AllArgsConstructor
public class BoardFileService {
	private BoardFileDao boardFileDao;
	
	public void insertPhoto(BoardFileDto dto) {
		boardFileDao.insertPhoto(dto);
	}
	
	public List<String> getPhotoByNum(int num) {
		return boardFileDao.getPhotoByNum(num);
	}
}
