package org.openmrs.module.basicexample.web.resource;

import org.openmrs.api.context.Context;
import org.openmrs.module.basicexample.Department;
import org.openmrs.module.basicexample.api.DepartmentService;
import org.openmrs.module.webservices.rest.web.v1_0.controller.MainResourceController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;

@Controller
@RequestMapping("/rest/v1/basicexample")
public class RestController extends MainResourceController {
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController#getNamespace()
	 */
	@Override
	public String getNamespace() {
		return "v1/basicexample";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Map<String, String>> getDigipath() {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("date", String.valueOf(new Date()));
		hm.put("action", "Hello World");
		Map<String, String> hm2 = new HashMap<String, String>();
		hm2.put("date", String.valueOf(new Date()));
		hm2.put("action", "Second action");
		list.add(hm);
		list.add(hm2);
		return list;
		//		return "HELLO WORLD";
	}
	
	@RequestMapping(value = "/departments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Department> getDepartments() {
		DepartmentService departmentService = Context.getService(DepartmentService.class);
		return departmentService.getAllDepartments();
	}
	
	@RequestMapping(value = "/department", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String createDepartment() {
		DepartmentService departmentService = Context.getService(DepartmentService.class);
		Department department = new Department();
		department.setDepartmentId(1);
		department.setName("ABC");
		department.setId(1);
		department.setUuid("123");
		department.setDescription("test");
		departmentService.saveDepartment(department);
		return "Success";
	}
	
}
