package io.egen.rentalflix;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;


/**
 * JUnit test cases for MovieService
 */
public class MovieServiceTest {
	
		@Test
	public void testCreate(){
		Movie mov = new Movie();
		mov.setYear(1991);
		mov.setTitle("PQR");
		mov.setLanguage("German");
		
		
		MovieService movService = new MovieService();
		movService.create(mov);
		
		String actual=mov.getTitle();
		Assert.assertEquals("PQR", actual);
		
		movService.delete(1);
		
		
		
	}

	@Test
	public void testUpdate(){
		Movie mov = new Movie();
		mov.setYear(1992);
		mov.setTitle("PQR");
		mov.setLanguage("German");
		
		MovieService movService = new MovieService();
		movService.create(mov);
		
		String originalLanguage = mov.getLanguage();
		String newLanguage = "French";
		
		mov.setLanguage(newLanguage);
		
		movService.update(mov);
		Assert.assertEquals("French",mov.getLanguage());
		
		movService.delete(2);
	}
	
	
	@Test
	public void testRentMovie(){
		Movie mov = new Movie();
		mov.setYear(1993);
		mov.setTitle("PQR");
		mov.setLanguage("German");
		
		MovieService movService = new MovieService();
		movService.create(mov);
		boolean actual = movService.rentMovie(6, "Queen");
		Assert.assertEquals(true, actual);
		movService.delete(3);
		
		
    }
	@Test
	public void testFindByName(){
		Movie mov = new Movie();
		mov.setYear(1994);
		mov.setTitle("PQR");
		mov.setLanguage("German");
		
		MovieService movService = new MovieService();
		movService.create(mov);
		List<Movie> actualList=movService.findByName("PQR");
		int actual = actualList.size();
		Assert.assertEquals(4, actual);
		
		movService.delete(4);
	}
	
	
	@Test
	public void testFindAll(){
		
		Movie mov = new Movie();
		mov.setYear(1995);
		mov.setTitle("PQR");
		mov.setLanguage("German");
		
		MovieService movService = new MovieService();
		
		movService.create(mov);
		List<Movie> actual=movService.findAll();
		
		
		Assert.assertEquals(5, actual.size());
		
		movService.delete(5);
	}
	
	@Test
	public void testDelete(){
		Movie mov = new Movie();
		mov.setYear(1996);
		mov.setTitle("PQR");
		mov.setLanguage("German");
		
		MovieService movService = new MovieService();
		movService.create(mov);
		
		
		movService.delete(1);
		movService.delete(2);
		movService.delete(3);
		movService.delete(4);
		movService.delete(5);
		movService.delete(6);
		
		List<Movie> actual = movService.findAll();
		Assert.assertEquals(0, actual.size());
		
		
	
		
	}
		


}
