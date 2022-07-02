package co.gromao.daopattern.data.dao;

import co.gromao.daopattern.data.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Student student) {
        String createSql = "insert into student values(?, ?, ?)";
        jdbcTemplate.update(createSql, student.getId(), student.getName(), student.getScore());
    }

    @Override
    public void delete(Integer id) {
        String deleteSql = "delete from student where id = ?";
        jdbcTemplate.update(deleteSql, id);
    }

    @Override
    public Student get(Integer id) {
        String getSql = "select * from student where id = ?";
        Student student = jdbcTemplate.queryForObject(getSql, new Object[]{id}, (rs, rowNum) -> {
            return new Student(rs.getInt("id"), rs.getString("name"),
                    rs.getFloat("score"));
        });

        return student;
    }

}
