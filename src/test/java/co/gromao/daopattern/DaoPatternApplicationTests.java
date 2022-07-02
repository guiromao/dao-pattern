package co.gromao.daopattern;

import co.gromao.daopattern.data.dao.StudentDao;
import co.gromao.daopattern.data.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DaoPatternApplicationTests {

	@Autowired
	StudentDao studentDao;

	@Test
	void testCreate() {
		studentDao.create(new Student(1, "GR", 18.0f));
	}

	@Test
	void testDelete() {
		studentDao.delete(1);
	}

	@Test
	void testRead() {
		Student student = studentDao.get(1);
		System.out.println(student);
	}

}
