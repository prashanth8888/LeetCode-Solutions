package SampleTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LoudAndRich {

	static class Person {
		int id;
		int quietnessFactor;
		List<Integer> richerPersons = new ArrayList<>();

		public List<Integer> getRicherPersons() {
			return this.richerPersons;
		}

		public void addRicherPerson(int personId) {
			this.richerPersons.add(personId);
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getQuietnessFactor() {
			return this.quietnessFactor;
		}

		public void setQuietnessFactor(int quietnessFactor) {
			this.quietnessFactor = quietnessFactor;
		}

	}

	public int[] loudAndRich(int[][] richer, int[] quiet) {

		int[] result = new int[quiet.length];
		Person[] persons = new Person[quiet.length];

		for (int i = 0; i < persons.length; i++) {
			persons[i] = new Person();
			persons[i].setQuietnessFactor(quiet[i]);
		}

		for (int[] richnessInfo : richer) {

			int personId = richnessInfo[1];
			int richerPerson = richnessInfo[0];

			Person currPerson = persons[personId];

			currPerson.setId(personId);
			currPerson.addRicherPerson(richerPerson);
		}

		int idx = 0;
		for (Person person : persons) {

			result[idx] = Integer.MAX_VALUE;

			Set<Integer> richerPersons = new HashSet<Integer>(person.getRicherPersons());
			List<Integer> richerPersonsTempList = person.getRicherPersons();
			Queue<Integer> richerPersonsQueue = new LinkedList<>(richerPersonsTempList);

			while (!richerPersonsQueue.isEmpty()) {
				int currRichPerson = (int) richerPersonsQueue.poll();
				List<Integer> nextLevelRicherPersons = persons[currRichPerson].getRicherPersons();
				for (int nextLevelRicherPerson : nextLevelRicherPersons) {
					if (richerPersons.add(nextLevelRicherPerson)) {
						richerPersonsQueue.add(nextLevelRicherPerson);
					}
				}
			}

			int currQuitenessFactor = Integer.MAX_VALUE;

			for (int richPerson : richerPersons) {
				if (persons[richPerson].getQuietnessFactor() < currQuitenessFactor
						&& persons[richPerson].getQuietnessFactor() < persons[idx].getQuietnessFactor()) {
					currQuitenessFactor = persons[richPerson].getQuietnessFactor();
					result[idx] = richPerson;
				}
			}

			if (result[idx] == Integer.MAX_VALUE)
				result[idx] = idx;
			idx++;
		}

		return result;
		// [5,5,2,5,4,5,6,7]
	}

	public static void main(String[] args) {
		LoudAndRich lar = new LoudAndRich();
		int[][] richInfo = { { 1, 0 }, { 2, 1 }, { 3, 1 }, { 3, 7 }, { 4, 3 }, { 5, 3 }, { 6, 3 } };
		int[] quiteNessinfo = { 3, 2, 5, 4, 6, 1, 7, 0 };

		int[] result = lar.loudAndRich(richInfo, quiteNessinfo);

		for (int r : result) {
			System.out.print(r + " ");
		}

	};
}
