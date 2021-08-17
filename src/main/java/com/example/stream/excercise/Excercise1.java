package com.example.stream.excercise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import com.example.stream.entity.Car;
import com.example.stream.entity.Person;
import com.example.stream.entity.PersonDTO;
import com.example.stream.utility.MockData;
import com.google.common.collect.ImmutableList;

public class Excercise1 {

	List<Person> personList;

	@Test
	public void streamApproachStream() throws IOException {
		personList = MockData.getPeople();
		personList.stream().filter(p -> p.getAge() <= 18).limit(4).collect(Collectors.toList())
				.forEach(System.out::println);

	}

	@Test
	public void rangeStreamApproach() {
		IntStream.range(0, 10).forEach(System.out::println);
		System.out.println("*********");
		IntStream.rangeClosed(0, 10).forEach(System.out::println);

	}

	@Test
	public void iterateListWithRange() throws IOException {
		personList = MockData.getPeople();
		IntStream.range(0, personList.size()).forEach(index -> {
			Person p = personList.get(index);
			System.out.println(p);

		});

	}
	
	@Test
	public void intStreamiterate()  {
		IntStream.iterate(0, i->i+1)
		.filter(num -> num%2==0)
		.limit(10)
		.forEach(System.out::println);
		

	}
	
	@Test
	public void findMinAndMax()  {
		List<Integer> list = ImmutableList.of(1,3,5,9,87,10,98,1000,2);
		int min = list.stream().min(Comparator.naturalOrder()).get();
		System.out.println("min :"+ min);
		int max = list.stream().max(Comparator.naturalOrder()).get();
		System.out.println("max :"+ max);

	}
	
	@Test
	public void findDistinct()  {
		List<Integer> list = ImmutableList.of(1,1,1,12,1,2,3,2,4,5,6,12,11,12,13);
		list.stream().distinct().sorted().collect(Collectors.toList())
		.forEach(System.out::println);

	}
	@Test
	public void mapMethodUse() throws IOException
	{
		List<PersonDTO> personDto = MockData.getPeople().stream()
		.map(PersonDTO::map)
		.limit(10)
		.collect(Collectors.toList());	
		
		personDto.forEach(System.out::println);
				
	}
	
	@Test
	public void avgMethodUse() throws IOException
	{
		double avg = MockData.getCars().stream().mapToDouble(car->car.getPrice())
		.average().orElse(0);
		System.out.println(avg);

	}
	
	@Test
	public void groupingData() throws IOException
	{
		Map<String, List<Car>> makeMap = MockData.getCars().stream()
		.collect(Collectors.groupingBy(car->car.getMake()));
		
		makeMap.forEach((x,list)->{
			System.out.println(x);
			list.forEach(System.out::println);
			
		});
		
	}
	
	@Test
	public void groupingDataCount() throws IOException
	{
		List<String> list = ImmutableList.of("john","john","ram","shyam","Ram","shyam");
		Map<String, Long> map = list.stream()
		.map(str->str.toLowerCase())
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		map.forEach((x,y)->System.out.println(x + "=>"+ y ));
		
	}
	
	@Test
	public void reduceOfArray() throws IOException
	{
		
		int arr[]= {2,5,6,7,89,33,45,23,100,181};
		int sum = Arrays.stream(arr).reduce(0,Integer::sum);
		System.out.println(sum);
		
	}
	
	@Test
	public void flatMapUse() throws IOException
	{
		List <Integer> list1 = Arrays.asList(3,5,3,2,4,7);
		List <Integer> list2 = Arrays.asList(10,15,13,12,14,17);
		List <Integer> list3 = Arrays.asList(23,25,23,22,24,27);
		List<Integer> arr[] = new ArrayList[5];
		//List<Integer> arr[] = {list1,list2,list3};
		
		List<List<Integer>> bigList = new ArrayList<List<Integer>>();
		bigList.add(list1);
		bigList.add(list2);
		bigList.add(list3);
		
		List<Integer> singleList = bigList.stream().flatMap(list->list.stream()).collect(Collectors.toList());
		singleList.forEach(System.out::println);
		 
	}
	
	@Test
	public void joiningWithStream() 
	{
		//List <String> list = ImmutableList.of("A","B","C","D","E","F");
		List <Integer> list = ImmutableList.of(1,2,3,4,4,4,5);
		String str = list.stream().map(l->String.valueOf(l)).collect(Collectors.joining(","));
		int sum = list.stream().mapToInt(Integer::intValue).sum();
		
		System.out.println(sum);
		
	}
	
	
	


}
