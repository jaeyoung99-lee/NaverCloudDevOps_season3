package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex2_FileReader {
	static final String FILENAME = "D:\\naver0829\\memo1.txt";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(FILENAME); // 줄 단위로 읽는 멤버 메서드가 없음. 그래서 2차 생성을 해야 함
			br = new BufferedReader(fr);
			
			// br.readLine()이 한 줄 씩 읽음. 더 이상 읽을 내용 없을 경우 null 값 반환
			// 대부분 두 줄 이상이고 몇 줄이 저장되어 있는지 모르므로 while문으로 처리
			while(true) {
				// 파일의 내용을 한 줄 씩 읽음
				String line = br.readLine();
				// 더 이상 읽을 내용 없을 경우 while 문 종료
				if(line == null) {
					break;
				}
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// 해당 파일이 없을 경우 예외가 발생하며 catch 영역이 실행된다
			System.out.println("해당 파일을 찾을 수 없어요 : " + e.getMessage());
		}
		
		// 열려있는 자원들을 닫는다(열려진 역순으로 닫는다)
		br.close();
		fr.close();
		
	}

}
