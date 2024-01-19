package mycar.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mycar")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyCarDto {	
	@Id // �� ����Ƽ�� ������ �� �ֵ��� �ĺ� ���̵� ������ ����
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	
	@Column(name = "carname",length = 30) // �÷����� ������� ���� ��� ���� ����
	private String carname;
	
	private int carprice;
	
	@Column(length = 20)
	private String carcolor;
	
	@Column(length = 30)  //length ���� �� 255
	private String carguip;
	
	@Column(length = 100)
	private String carphoto;
	
	@Column(updatable = false) // ���� �� �÷� ����
	@CreationTimestamp
	private Timestamp writeday;	
	
	//@Transient: ���̺��� �÷����δ� �������� �ʰ� ��ü������ ��� ������ ��� ����
	@Transient 
	private int commentcount;
	
	@Transient 
	private String message;
}














