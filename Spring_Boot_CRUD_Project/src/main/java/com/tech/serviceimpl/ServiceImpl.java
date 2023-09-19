package com.tech.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.entity.College;
import com.tech.repository.CollegeRepository;
import com.tech.servicei.ServiceI;

@Service
public class ServiceImpl implements ServiceI {

	@Autowired
	CollegeRepository crp;

	@Override
	public String saveCollege(College c) {
		Optional<College> clg = crp.findById(c.getC_Id());
		if (clg.isPresent() == false) {
			crp.save(c);
			return "College Id " + c.getC_Id() + " is saved in databased successfully";
		} else {
			return "This College is already exist";
		}
	}

	@Override
	public String saveColleges(List<College> c) {

		crp.saveAll(c);

		return "All colleges are save successfully";
	}

	@Override
	public Optional<College> getCollege(String cid) {

		Optional<College> clg = crp.findById(cid);
		if (clg.isPresent()) {

			return clg;
		}

		return clg;
	}

	@Override
	public String deleteCollege(String cid) {

		Optional<College> clg = crp.findById(cid);
		if (clg.isPresent()) {

			crp.deleteById(cid);
			return "College id " + cid + " is deleted successfully";
		} else {
			return "College is not found by this id " + cid;
		}
	}

	@Override
	public List<College> getColleges() {

		Iterable<College> clgs = crp.findAll();

		return (List<College>) clgs;
	}

	@Override
	public Optional<College> updateCollege(College c) {
		Optional<College> college = crp.findById(c.getC_Id());
		if (college.isPresent()) {
			College clg = crp.save(c);
			return crp.findById(clg.getC_Id());
		} else {
			return college;
		}
	}

	@Override
	public String deleteColleges() {

		crp.deleteAll();
		return "All records deleted successfully";
	}

}
