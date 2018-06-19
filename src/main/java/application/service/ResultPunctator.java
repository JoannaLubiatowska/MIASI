package application.service;

import java.util.Arrays;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import application.entity.StudentDegrees;

public class ResultPunctator implements JavaDelegate {

	private ExamService examService = new ExamService();
	
	private Integer getDegree(Integer maxScore, Integer resultPunctation) {
		double percent = (double) resultPunctation / maxScore;
		
		return Arrays.stream(Degree.values()).filter(degree -> degree.isInInterval(percent)).findFirst()
				.map(Degree::getDegreeValue).orElse(0);
	}

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		StudentDegrees studentDegrees = (StudentDegrees) execution.getVariable("studentDegree");
		Integer score = studentDegrees.getResultPunctation();
		Integer maxScore = examService.getExamById(studentDegrees.getExamID()).getMaxPunctation();
		execution.setVariable("degree", getDegree(maxScore, score));
	}

	private enum Degree {
		TWO(.0, .5, 2), THREE(.5, .7, 3), FOUR(.7, .9, 4), FIVE(.9, 1.0, 5);

		private double min;
		private double max;
		private int degreeValue;

		Degree(double min, double max, int degreeValue) {
			this.min = min;
			this.max = max;
			this.degreeValue = degreeValue;
		}

		public boolean isInInterval(double percent) {
			return min < percent && max >= percent;
		}

		public Integer getDegreeValue() {
			return degreeValue;
		}
	}

}
