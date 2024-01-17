package guest.data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "guest")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuestDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gnum;
	
	@Column(length = 100)
	private String photo;
	
	@Column(length = 1000)
	private String content;
	
	@Column(length = 20)
	private String nickname;
	
	@CreationTimestamp
	@Column(updatable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private Timestamp writeday;
}
