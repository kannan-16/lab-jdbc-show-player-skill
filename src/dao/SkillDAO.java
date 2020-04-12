package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO {
	
	static List<Skill> skillList=new ArrayList<Skill>();
	
	public List<Skill> listAllSkills() throws ClassNotFoundException, SQLException, IOException {
				
		PreparedStatement st = ConnectionManager.getConnection().prepareStatement("SELECT * FROM SKILL2 ORDER BY NAME");
		ResultSet result = st.executeQuery();
		
		while(result.next()) {
			
			long id=result.getLong(1);
			String name=result.getString(2);
			Skill skill=new Skill(id,name);
			
			skillList.add(skill);
			
		}
		
		return skillList;
	}
	
	public void insertPlayerSkills(Skill skill) throws SQLException, ClassNotFoundException, IOException {
		
		PreparedStatement st = ConnectionManager.getConnection().prepareStatement("INSERT INTO SKILL2(ID, NAME) VALUES (?,?)");
		
		st.setLong(1, skill.getSkillId());
		st.setString(2, skill.getSkillName());
		st.executeUpdate();
	}
}
