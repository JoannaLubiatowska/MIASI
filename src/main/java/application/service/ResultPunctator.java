package application.service;

import java.util.Arrays;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import application.entity.StudentDegrees;

public class ResultPunctator implements JavaDelegate {

	private ExamService examService = new ExamService();
	
	private Float getDegree(Integer maxScore, Integer resultPunctation) {
		double percent = (double) resultPunctation / maxScore;
		
		return Arrays.stream(Degree.values()).filter(degree -> degree.isInInterval(percent)).findFirst()
				.map(Degree::getDegreeValue).orElse(0.0F);
	}

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		StudentDegrees studentDegrees = (StudentDegrees) execution.getVariable("studentDegree");
		Integer score = studentDegrees.getResultPunctation();
		Integer maxScore = examService.getExamById(studentDegrees.getExamID()).getMaxPunctation();
		studentDegrees.setDegree(getDegree(maxScore, score));
	}

	private enum Degree {
		TWO(.0, .5, 2.0F), 
		THREE(.5, .6, 3.0F),
		THREE_AND_HALF(.6, .7, 3.5F),
		FOUR(.7, .8, 4.0F),
		FOUR_AND_HALF(.8, .9, 4.5F),
		FIVE(.9, 1.0, 5.0F);

		private double min;
		private double max;
		private Float degreeValue;

		Degree(double min, double max, float degreeValue) {
			this.min = min;
			this.max = max;
			this.degreeValue = degreeValue;
		}

		public boolean isInInterval(double percent) {
			return min <= percent && max >= percent;
		}

		public Float getDegreeValue() {
			return degreeValue;
		}
	}

}
