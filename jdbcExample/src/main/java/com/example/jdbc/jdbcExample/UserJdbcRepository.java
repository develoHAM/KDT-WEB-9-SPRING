package com.example.jdbc.jdbcExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRepository {
    @Autowired
    private JdbcTemplate jdbc;

    private static String INSERT_USER =
            """
                INSERT INTO users (id, name, address) VALUES (? ,? ,?);
            """ ;
    private static String DELETE_USER =
            """
                DELETE FROM users WHERE id = ?;
            """;
    private static String SELECT_USER =
            """
                SELECT * FROM users WHERE id = ?;
            """;

    public void insert(Users user) {
        jdbc.update(INSERT_USER, user.getId(), user.getName(), user.getAddress());
    }
    public void deleteId(long id) { jdbc.update(DELETE_USER, id);}
    public Users findId(long id) {
        //queryForObject: 주어진 쿼리에 따라 데이터베이스에서 한 행만 반환될때 사용
        //Users클래스의 인스턴스로 매핑하기 위해서 new BeanPropertyRowMapper<>(param) : param 에는 어떤 클래스를 매핑할지 넣어준다
        //BeanPropertyRowMapper: 데이터베이스 데이블의 칼럼 이름과 Java Bean의 프로퍼티 이름을 자동으로 매핑
        return jdbc.queryForObject(SELECT_USER, new BeanPropertyRowMapper<>(Users.class), id);
    }

    //JDBC 주요 메서드
    //update() : INSERT, UPDATE, DELETE 와 같은 SQL문 실행
    //query(): 여러행을 반환하는 쿼리 결과 처리할때 사용
    //execute(): 반환값이 없는 SQL 명령을 실행
    //queryForMap(): 단 하나의 행만 반환, 해당 데이터를 Map형태로 반환
    //queryForInt(): 단일 값 반환. 반환값으로 int 형태 데이터(예로 select count(*) from ---)

}
