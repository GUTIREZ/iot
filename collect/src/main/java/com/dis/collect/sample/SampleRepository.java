package com.dis.collect.sample;

import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository 
public class SampleRepository {
 
	    @Autowired  
	    private JdbcTemplate jdbcTemplate;  
	  
	    @Transactional(readOnly = true)  
	    public List<SampleDomain> findAll() {  
	        return jdbcTemplate.query("select * from sample", new SampleRowMapper());  
	    }  
	  
	    @Transactional(readOnly = true)  
	    public SampleDomain findSampleById(int id) {  
	        return jdbcTemplate.queryForObject("select * from sample where id=?", new Object[] { id }, new SampleRowMapper());  
	    }  
	  
	    public SampleDomain create(final SampleDomain sample) {  
	        final String sql = "insert into sample(name,email) values(?,?)";  
	  
	        KeyHolder holder = new GeneratedKeyHolder();  
	  
	        jdbcTemplate.update(new PreparedStatementCreator() {  
	  
	            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {  
	                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);  
	                ps.setString(1, sample.getName());  
	                ps.setString(2, sample.getEmail());  
	                return ps;  
	            }  
	        }, holder);  
	  
	        int newId = holder.getKey().intValue();  
	        sample.setId(newId);  
	        return sample;  
	    }  
	  
	    public void delete(final Integer id) {  
	        final String sql = "delete from sample where id=?";  
	        jdbcTemplate.update(sql, new Object[] { id }, new int[] { java.sql.Types.INTEGER });  
	    }  
	  
	    public void update(final SampleDomain sample) {  
	        jdbcTemplate.update("update sample set name=?,email=? where id=?",  
	                new Object[] { sample.getName(), sample.getEmail(), sample.getId() });  
	    } 
	} 
	  
	class SampleRowMapper implements RowMapper<SampleDomain> {  
	  
	    public SampleDomain mapRow(ResultSet rs, int rowNum) throws SQLException {  
	        SampleDomain sample = new SampleDomain();  
	        sample.setId(rs.getInt("id"));  
	        sample.setName(rs.getString("name"));  
	        sample.setEmail(rs.getString("email"));  
	        sample.setBirthDate(rs.getDate("birth_date"));
	        return sample;  
	    }  
}
