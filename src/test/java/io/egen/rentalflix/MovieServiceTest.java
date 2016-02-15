package io.egen.rentalflix;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;


/**
 * JUnit test cases for MovieService
 */
public class MovieServiceTest {

	@Test
	public void testFindAll(){
		Movie mov = new Movie();
		mov.setYear(1993);
		mov.setTitle("PQR");
		mov.setLanguage("German");
		
		MovieService movService = new MovieService();
		movService.create(mov);
		int actual=movService.findAll().size();
		Assert.assertEquals(1, actual);
		
		movService.delete(1);
	}
	
	@Test
	public void testFindByName(){
		Movie mov = new Movie();
		mov.setYear(1993);
		mov.setTitle("PQR");
		mov.setLanguage("German");
		
		MovieService movService = new MovieService();
		movService.create(mov);
		List<Movie> actualList=movService.findByName("PQR");
		int actual = actualList.size();
		Assert.assertEquals(1, actual);
		
		movService.delete(2);
	}

	
	@Test
	public void testCreate(){
		Movie mov = new Movie();
		mov.setYear(1993);
		mov.setTitle("PQR");
		mov.setLanguage("German");
		
		
		MovieService movService = new MovieService();
		movService.create(mov);
		
		String actual=mov.getTitle();
		Assert.assertEquals("PQR", actual);
		
		movService.delete(3);
		
	}
	
	@Test
	public void testUpdate(){
		Movie mov = new Movie();
		mov.setYear(1993);
		mov.setTitle("PQR");
		mov.setLanguage("German");
		
		MovieService movService = new MovieService();
		movService.create(mov);
		
		String originalLanguage = mov.getLanguage();
		String newLanguage = "French";
		
		mov.setLanguage(newLanguage);
		
		movService.update(mov);
		Assert.assertEquals("French",mov.getLanguage());
		
		movService.delete(4);
		
	}
	
	@Test
	public void testDelete(){
		Movie mov = new Movie();
		mov.setYear(1993);
		mov.setTitle("PQR");
		mov.setLanguage("German");
		
		MovieService movService = new MovieService();
		movService.create(mov);
		
		movService.delete(1);
		
	}
	
	public void testRentMovie(){
		
		
    }

	
}
