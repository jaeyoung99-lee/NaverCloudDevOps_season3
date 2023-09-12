package bit701.day0912;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex5_FileReader {
	static final String SCORE_FILE = "D:\\naver0829\\score.txt"; 
	String[] line_split;
	Score[] score = new Score[20];
	int count = 0;
	
	public Ex5_FileReader() throws IOException {
		// 파일 읽어서 score 배열에 담기(줄 단위로 읽은 후 콤마(,)로 분리해서 넣기)
		FileReader fr = null;
		BufferedReader br = null;
		
		fr = new FileReader(SCORE_FILE);
		br = new BufferedReader(fr);
		
		while(true) {
			String line = br.readLine();
			if(line == null)
				break;
			line_split = line.split(",");
			String name = line_split[0];
			int kor = Integer.parseInt(line_split[1]);
			int eng = Integer.parseInt(line_split[2]);
			
			score[count] = new Score(name, kor, eng);
			count++;
		}
		br.close();
		fr.close();
	}
	
	// 출력
	// 이름  국어  영어  총점  평균
	public void dataList() {
		System.out.println("이름\t국어\t영어\t총점\t평균");
		for(int i = 0; i < count; i++) {
			System.out.println(score[i].getName() + "\t" + score[i].getKor() + "\t" + score[i].getEng() + "\t" + (score[i].getKor() + score[i].getEng()) + "\t" + (score[i].getKor() + score[i].getEng()) / 2.0);
		}
	}
			
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Ex5_FileReader ex = new Ex5_FileReader();
		ex.dataList();
	}

}
