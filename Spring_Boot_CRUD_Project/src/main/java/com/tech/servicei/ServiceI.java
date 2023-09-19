package com.tech.servicei;

import java.util.List;
import java.util.Optional;

import com.tech.entity.College;

public interface ServiceI {
	
	//to save the college records in database
	public String saveCollege(College c);
	
	//to insert multiple college records in database
	public String saveColleges(List<College> c );
	
	
	public Optional<College> getCollege(String cid);
	
	public String deleteCollege(String cid);
	
	public List<College> getColleges();
	
	public Optional<College> updateCollege(College c);
	
	public String deleteColleges();

}
