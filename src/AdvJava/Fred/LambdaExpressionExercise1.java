package AdvJava.Fred;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressionExercise1
{
	public static void main(String[] args)
	{
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("John", "Doe", 51),
				new Person("Jane", "Doe", 45),
				new Person("Michael", "Cain", 68),
				new Person("Dominic", "Cummings", 49),
				new Person("Mary", "Groves", 35),
				new Person("Matthew", "Arnold", 39)
				);
		
		// Step 1: Sort list by last name
		people.sort(Comparator.comparing(Person::getLastName));
		// Step 2: Create a method that prints all elements in the list
		System.out.println();
		people.forEach(System.out::println);
		// Step 3: Create a method that prints all people that have last name beginning with C
		System.out.println();
		people.stream().filter(p -> p.getLastName().startsWith("C")).forEach(System.out::println);
	}
}
