package mycar.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/* * 
 * 은행 서비스에서 사용자(TABLE_USER)가 1개 이상의 계좌(TABLE_ACCOUNT)를 
 * 가질수 있다고 가정할경우 TABLE_USER 입장에서 보면 OneToMany이고, 
 * TABLE_ACCOUNT 입장에서 보면 ManyToOne이다.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "mycar_comment")
public class MyCarCommentDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	
	@ManyToOne  // 서브 테이블에는 ManyToOne : 하나의 등록글에 여러 개의 댓글을 달 수 있다.
	@JoinColumn(name = "num")
	@OnDelete(action = OnDeleteAction.CASCADE) // 부모 데이터를 지우면 댓글도 삭제된다.
	private MyCarDto mycar;//join table �꽑�뼵
	
	private String comment;// @Column 어노테이션 생략 시, 기본 컬럼명은 comment, 기본 length는 255가 된다.
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul") // 댓글은 출력을 ajax로 처리할 것임
	@Column(updatable = false) // 수정 시 수정 컬럼에서 제외
	@CreationTimestamp // 엔터티가 생성되는 시점의 시간이 자동 등록
	private Timestamp writeday;

}













