package com.tech.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.engine.internal.AbstractEntityEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.entity.College;
import com.tech.servicei.ServiceI;

@RestController
public class CollegeController {

	@Autowired
	ServiceI si;

	@PostMapping("/college/save")
	public ResponseEntity<String> insertCollege(@RequestBody College c) {
		try {
			String msg = si.saveCollege(c);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<String>("You has pass null object OR You has pass null Id",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/colleges/add")
	public ResponseEntity<String> insertColleges(@RequestBody List<College> c) {
		try {
			if (c.isEmpty() == false) {

				String resp = si.saveColleges(c);
				return new ResponseEntity<String>(resp, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<String>("You are trying to insert empty college", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {

			return new ResponseEntity<String>("You has not assign id field", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/college/{cid}")
	public ResponseEntity<Object> getCollege(@PathVariable("cid") String cid) {
		try {
			System.out.println(cid);
			Optional<College> college = si.getCollege(cid);
			if (college.isPresent()) {
				College clg = college.get();
				return new ResponseEntity<Object>(clg, HttpStatus.OK);
			} else {

				return new ResponseEntity<Object>("College Id " + cid + " is Not found", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>("You has pass College Id null", HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/colleges")
	public ResponseEntity<Object> getColleges() {

		List<College> colleges = si.getColleges();

		if (colleges.isEmpty() == false) {

			return new ResponseEntity<Object>(colleges, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("No Records Found", HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/college/{cid}")
	public ResponseEntity<Object> deleteRecord(@PathVariable("cid") String cid) {

		String msg = si.deleteCollege(cid);

		return new ResponseEntity<Object>(msg, HttpStatus.OK);

	}

	@PutMapping("/college/update")
	public ResponseEntity<Object> updateRecord(@RequestBody College c) {
		try {
			Optional<College> clg = si.updateCollege(c);
			if (clg.isPresent()) {
				College college = clg.get();
				return new ResponseEntity<Object>(college, HttpStatus.OK);
			} else {
				String s = "College Id " + c.getC_Id() + " is Not Found in Database";

				return new ResponseEntity<Object>(s, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {

			return new ResponseEntity<Object>("You are trying to insert Null Id,Id should not null",
					HttpStatus.NOT_FOUND);

		}

	}

	@DeleteMapping("/college/delete")
	public ResponseEntity<Object> deleteRecords() {

		String msg = si.deleteColleges();
		return new ResponseEntity<Object>(msg, HttpStatus.OK);

	}

}
