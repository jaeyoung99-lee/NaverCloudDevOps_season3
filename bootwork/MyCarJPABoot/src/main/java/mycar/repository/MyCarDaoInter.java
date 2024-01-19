package mycar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import mycar.data.MyCarDto;

public interface MyCarDaoInter extends JpaRepository<MyCarDto,Long>{

	// ���� �������� �̿��ؼ� �����ϴ� �޼��带 �߰��غ���
	// �ڵ�����, ����, ���� �����ϴ� �޼��带 ������

	// @Query : repository�� ���ϴ� ������ �ۼ��ϰ� ���ִ� ������̼�
	// value �Ӽ� : ���� �ۼ���
	// nativeQuery : JPA���� ������ ��Ģ�� ��� ������ �� �ִ� �Ӽ�
	@Query(value = 
			"""
			update mycar set carname=:carname,carprice=:carprice,carcolor=:carcolor
			 where num=:num
			""",nativeQuery = true)
	@Modifying // @Modifying�� insert, update, delete �Ӹ� �ƴ϶� DDL ������ ����� ���� ǥ�⸦ ����� �Ѵ�.
	@Transactional // @Transactional�� update, delete�� �� �� ǥ�⸦ ����� ���� ������ �ȴ�.
	public void updateMycarNoPhoto(@Param("num") Long num,@Param("carname") String carname,
			@Param("carprice") int carprice,@Param("carcolor") String carcolor);


	@Query(value = 
			"""
			update mycar set carname=:#{#dto.carname},carprice=:#{#dto.carprice},
			carcolor=:#{#dto.carcolor},carguip=:#{#dto.carguip}
			 where num=:#{#dto.num}
			""",nativeQuery = true)
	@Modifying // @Modifying�� insert, update, delete �Ӹ� �ƴ϶� DDL ������ ����� ���� ǥ�⸦ ����� �Ѵ�.
	@Transactional // @Transactional�� update, delete�� �� �� ǥ�⸦ ����� ���� ������ �ȴ�.
	public void updateMycarDTONoPhoto(@Param("dto") MyCarDto dto);

	// ���� count()�� �ص� ������ �׽�Ʈ�� ������.
	@Query(value = "select count(*) from mycar",nativeQuery = true)
	public Long getTotalMyCount();
}










