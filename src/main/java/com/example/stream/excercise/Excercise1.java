package com.example.stream.excercise;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import com.example.stream.entity.Person;
import com.example.stream.utility.MockData;

public class Excercise1 {
	
	@Test
	public void streamApproachStream() throws IOException
	{
		List<Person> personList = MockData.getPeople();
		personList.stream().filter(p -> p.getAge()<=18).limit(4)
		.collect(Collectors.toList()).forEach(System.out::println);
		
		
	}
	
	@Test
	public void intStreamApproach()
	{
		IntStream.range(0, 10).forEach(System.out::println);
		System.out.println("*********");
		IntStream.rangeClosed(0, 10).forEach(System.out::println);
		
		
	}

}
