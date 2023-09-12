package bit701.day0912;

import java.io.FileWriter;
import java.io.IOException;

public class Ex1_FileWriter {
	static final String FILENAME = "D:\\naver0829\\memo1.txt";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// 파일에 개인 정보 저장하기
		FileWriter fw = null;
		
		// 생성
//		fw = new FileWriter(FILENAME); // 파일이 없으면 새로 생성하고 있으면 덮어쓴다
		fw = new FileWriter(FILENAME, true); // 실행 시마다 기존 파일에 내용을 추가함
		
		// 파일에 내용 저장하기
		fw.write("이름 : 유재석\n");
		fw.write("핸드폰 : 010-5454-7789\n");
		fw.write("--------------------\n");
		
		// 파일 닫기
		fw.close();
		System.out.println("탐색기를 열고 memo1.txt 파일을 확인하세요");
	}

}
