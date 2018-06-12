package application.service;

import java.util.Arrays;

import application.entity.Exams;

public class ResultPunctator {

	public Integer getDegree(Exams exam, int resultPunctation) {
		// TODO Auto-generated method stub
		double percent = (double) resultPunctation / exam.getMaxPunctation();
		return Arrays.stream(Degree.values()).filter(degree -> degree.isInInterval(percent)).findFirst()
				.map(Degree::getDegreeValue).orElse(0);
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

		public int getDegreeValue() {
			return degreeValue;
		}
	}

}
