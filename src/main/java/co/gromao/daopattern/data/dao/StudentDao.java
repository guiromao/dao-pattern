package co.gromao.daopattern.data.dao;

import co.gromao.daopattern.data.model.Student;

public interface StudentDao {

    void create(Student student);

    void delete(Integer id);

    Student get(Integer id);

}
