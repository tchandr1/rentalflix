package io.egen.rentalflix;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;


/**
 * JUnit test cases for MovieService
 */
public class MovieServiceTest {


	public void testFindAll(){
		Movie mov = new Movie();
		mov.setYear(1993);
		mov.setTitle("PQR");
		mov.setLanguage("German");
		
		MovieService movService = new MovieService();
		movService.create(mov);
		int actual=movService.findAll().size();
		Assert.assertEquals(6, actual);
		
		movService.delete(mov.getId());
	}
	
			public void testFindByName(){
		Movie mov = new Movie();
		mov.setYear(1993);
		mov.setTitle("PQR");
		mov.setLanguage("German");
		
		MovieService movService = new MovieService();
		movService.create(mov);
		boolean actual=movService.findByName("PQR").contains(mov);
		Assert.assertEquals(6, actual);
		
		movService.delete(mov.getId());
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
		
		movService.delete(mov.getId());
		
	}
	
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
		
		movService.delete(mov.getId());
		
	}
	
	
	public void testDelete(){
		Movie mov = new Movie();
		mov.setYear(1993);
		mov.setTitle("PQR");
		mov.setLanguage("German");
		
		MovieService movService = new MovieService();
		movService.create(mov);
		
		int count = movService.delete(mov.getId()).getId();
		
		Assert.assertEquals(6, count);
	}
	
/*	public void testRentMovie(){
		
		
    }
*/
	
}
