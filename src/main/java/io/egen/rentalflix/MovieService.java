package io.egen.rentalflix;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.egen.utils.DBUtils;

/**
 * Service implementing IFlix interface
 * You can use any Java collection type to store movies
 */
public class MovieService implements IFlix {
	
	private static final Logger LOG = Logger.getLogger(MovieService.class.getName());

	@Override
	public List<Movie> findAll() {
  List<Movie> movies = new ArrayList<Movie>();
		
		Connection con = DBUtils.connect();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
			try {
				ps= con.prepareStatement("SELECT * FROM MOVIE");
				rs = ps.executeQuery();
				
				while(rs.next()){
					Movie mov = new Movie();
					mov.setTitle(rs.getString("title"));
					mov.setLanguage(rs.getString("language"));
					mov.setYear(rs.getInt("year"));
					
					movies.add(mov);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
					try {
						if(ps!=null){
						ps.close();							
					}if(rs!=null){
						rs.close();
					}if(con!=null){
						con.close();
					}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		System.out.println(movies);			
		return movies;

	}
	@Override
	public List<Movie> findByName(String name) {
	
		List<Movie> movies = new ArrayList<Movie>();
		Movie movie = new Movie();
		Connection con = DBUtils.connect();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
			try {
				System.out.println(name);
				ps= con.prepareStatement("SELECT * FROM MOVIE WHERE movie.title = ?");
				ps.setString(1,name);
				rs = ps.executeQuery();
				
				while(rs.next()){
					Movie mov = new Movie();
					mov.setTitle(rs.getString("title"));
					mov.setLanguage(rs.getString("language"));
					mov.setYear(rs.getInt("year"));
					
					movies.add(mov);
					System.out.println(movies);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
				LOG.log(Level.SEVERE, null, e);
			}finally{
				
					try {
						if(ps!=null){
						ps.close();							
					}if(rs!=null){
						rs.close();
					}if(con!=null){
						con.close();
					}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		System.out.println(movies);			
		return movies;
	}


	@Override
	public Movie create(Movie movie) {
		Connection con = DBUtils.connect();
		System.out.println(con);
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		try {
			System.out.println("Entered try of create");
			ps=con.prepareStatement("insert into Movie(title,year,language) values(?,?,?)");
			
			
	     	ps.setString(1,movie.getTitle());
			ps.setInt(2, movie.getYear());
			ps.setString(3,movie.getLanguage());
			
			if(ps.executeUpdate()==1){
				LOG.info("Insertion to Movie Table");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.log(Level.SEVERE, null,e);
		}
		
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		Connection con = DBUtils.connect();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		try {
			System.out.println("Entered TRy of Update");
			System.out.println(movie.getLanguage());
			ps=con.prepareStatement("update movie  SET movie.language=? WHERE movie.id = ?");
		
		ps.setString(1, movie.getLanguage());
		ps.setInt(2,3);
		
		if(ps.executeUpdate()==1){
			LOG.info("Updation to Movie Table");
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.log(Level.SEVERE, null,e);
		}
		
		
		return null;
	}

	@Override
	public Movie delete(int id) {
		
		Movie movie = new Movie();
		Connection con = DBUtils.connect();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		try {
			System.out.println("Entered try of Delete");
			System.out.println(id);
			ps=con.prepareStatement("DELETE FROM Movie WHERE movie.id= ?");
			ps.setInt(1,id);
		
			
			if(ps.executeUpdate()==1){
				LOG.info("Deletion FROM Movie Table");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.log(Level.SEVERE, null,e);
		}
		return movie;
	}

	@Override
	public boolean rentMovie(int movieId, String user) {
		HashMap<String,Integer> hmap = new HashMap<String,Integer>();
		
		hmap.put("Thanu",1);
		hmap.put("Vinu",2);
		hmap.put("King",3);
		 
		Integer id = hmap.get(user);
		System.out.println(id);
		System.out.println(movieId);
		
		if(hmap.values().contains(user)){
			return false;
		}
		else
			return true;
		
		
	
	}


	

}