package co.grandcircus.springlab;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GradeDao {

	@Autowired
	private JdbcTemplate jdbc;

	public List<Grade> findAll(){
		String sql = "SELECT * FROM grade";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(Grade.class));
	}

	public Grade findById(Long id) {

		String sql ="SELECT FROM grade WHERE id = ?";         //this final slot enable us to add the missing (parameter)
		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Grade.class), id);  //single object of result
	}

	public void create(Grade grade) {
		String sql = "INSERT INTO grade (name, type, score, total) VALUES (?, ?, ?, ?)";
		jdbc.update(sql, grade.getName(), grade.getType(), grade.getScore(), grade.getTotal());
	}

	public void update(Grade grade) {

		String sql= "UPDATE Grade name = ?, type = ?, score = ?, total = ? WHERE id = ?";
		jdbc.update(sql, grade.getName(), grade.getType(), grade.getScore(), grade.getTotal(), grade.getId());
	}
	public void delete(Long id) {
		String sql = "DELETE FROM grade WHERE id = ?";
		jdbc.update(sql, id);
	}
	
//	public Grade findByPercent(Long id) {
//		String sql = "SELECT(score / total) FROM grade WHERE id = ?";
//		jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Grade.class), id); 	
//	}
	
}

