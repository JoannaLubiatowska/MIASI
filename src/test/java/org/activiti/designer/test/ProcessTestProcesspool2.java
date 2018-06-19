package org.activiti.designer.test;

import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.junit.Test;

import application.entity.StudentDegrees;

public class ProcessTestProcesspool2 {

	

	private String filename = "C:\\Users\\Asia\\eclipse-workspace\\MIASI_Project\\src\\main\\resources\\diagrams\\studentsAssigment.bpmn";

	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();

	@Test
	public void startProcess() throws Exception {
		RepositoryService repositoryService = activitiRule.getRepositoryService();
		repositoryService.createDeployment().addInputStream("process_pool2.bpmn20.xml",
				new FileInputStream(filename)).deploy();
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("showDegreeCommand", new DoNothing());
		variableMap.put("studentDegree", new StudentDegrees(null, 1, null, null, 5, null));
		variableMap.put("saveStudentDegreeCommand", new DoNothing());
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("process_pool2", variableMap);
		assertNotNull(processInstance.getId());
		System.out.println("id " + processInstance.getId() + " "
				+ processInstance.getProcessDefinitionId());
	}
}

class DoNothing implements JavaDelegate, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7902961538116973826L;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
	}

}