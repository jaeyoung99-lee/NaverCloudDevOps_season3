package bit701.day0919;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex3_Book828_Network {

	public static void main(String[] args) throws UnknownHostException { // 네트워크 문제 생길 때 발생하는 Exception
		// TODO Auto-generated method stub

		// InetAddress : 상대방의 IP 주소를 알아낼 때 사용
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 IP 주소 : " + local.getHostAddress());
		System.out.println("내 컴퓨터의 이름 : " + local.getHostName());
		
		// naver 서버의 ip를 알고자 할 경우
		InetAddress[] naverArr = InetAddress.getAllByName("www.naver.com");
		for(InetAddress inet : naverArr) {
			System.out.println("NAVER의 서버 IP : " + inet.getHostAddress());
		}
		
		// google 서버의 ip를 알고자 할 경우
		InetAddress[] googleArr = InetAddress.getAllByName("www.google.com");
		for(InetAddress inet : googleArr) {
			System.out.println("GOOGLE의 서버 IP : " + inet.getHostAddress());
		}
		
		// nate 서버의 ip를 알고자 할 경우
		InetAddress[] nateArr = InetAddress.getAllByName("www.nate.com");
		for(InetAddress inet : nateArr) {
			System.out.println("NATE의 서버 IP : " + inet.getHostAddress());
		}
		
		// github 서버의 ip를 알고자 할 경우
		InetAddress[] githubArr = InetAddress.getAllByName("www.github.com");
		for(InetAddress inet : githubArr) {
			System.out.println("GITHUB의 서버 IP : " + inet.getHostAddress());
		}
	}

}
