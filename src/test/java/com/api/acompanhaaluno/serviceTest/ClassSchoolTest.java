package com.api.acompanhaaluno.serviceTest;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.api.acompanhaaluno.models.ClassSchoolModel;
import com.api.acompanhaaluno.services.ClassSchoolService;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class ClassSchoolTest {
	
	@Autowired
	ClassSchoolService cs;
	
	//@Test
	@Ignore
	public void saveClassScholl() {
	ClassSchoolModel cm01 = new ClassSchoolModel();
	cm01.setName("Infantil IV");
	cm01.setCategory("Educação Infantil");
	
	cs.save(cm01);
	System.out.println();
	System.out.println();
	System.out.println(cm01);
	System.out.println();
	System.out.println();
	
	
	}
}
