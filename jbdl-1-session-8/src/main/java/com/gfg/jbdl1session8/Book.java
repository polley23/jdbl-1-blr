package com.gfg.jbdl1session8;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    private String bname;
    private String author;
    private JdbcTemplate jdbcTemplate;

    public void persist(){
        jdbcTemplate.update(
                "insert into books (bname, author) values (?,?)",
                this.bname,this.author
        );
    }

    public void GetAuthor(String bname){
        List<Map<String, Object>>  authors = jdbcTemplate.queryForList(
                "select author from books where bname = ?", bname

        );
    }

}
