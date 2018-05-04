package com.src.services;

import java.sql.*;
import java.time.LocalDate; 
import java.util.*;

import com.src.model.*;


public class DbImpl implements DbInterface {
	
	private static Connection con;
	static{
		try {
			Class.forName("org.h2.Driver");
		
			con=DriverManager.getConnection("jdbc:h2:~/test","sa","sa");
		} catch (Exception e) {
		e.printStackTrace();
	}	
	}
	
	public User loginVerify(User u)
	{
		try
		{
			PreparedStatement p=con.prepareStatement("select * from user where email=? and password=?");
			p.setString(1, u.getEmail());
			p.setString(2, u.getPassword());
			ResultSet r=p.executeQuery();
			if(r.next())
			{
				u.setEmail(r.getString(1));
				u.setFname(r.getString(2));
				u.setLname(r.getString(3));
				u.setPassword(r.getString(4));
				u.setDob(r.getString(5));
				u.setEdu_qualification(r.getString(6));
				u.setPhone_number(r.getString(7));
				u.setCity(r.getString(8));
				u.setState(r.getString(9));
				u.setLevel(r.getInt(10));
				return u;
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
			
					}
		return null;
		
	}
	
	public User getInfo(String email)
	{
		
		PreparedStatement p;
		try {
		p = con.prepareStatement("select * from user where email=?");
		p.setString(1, email);
		ResultSet r=p.executeQuery();
		User u=new User();
		if(r.next())
		{
			u.setEmail(r.getString(1));
			u.setFname(r.getString(2));
			u.setLname(r.getString(3));
			u.setDob(r.getString(5));
			u.setEdu_qualification(r.getString(6));
			u.setPhone_number(r.getString(7));
			u.setCity(r.getString(8));
			u.setState(r.getString(9));
			u.setLevel(r.getInt(10));
			return u;
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
		return null;
	}
	public void register(HashMap<String,String> details) throws SQLException
	{
		PreparedStatement p=con.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?,1)");
		p.setString(1, details.get("email"));
		p.setString(2, details.get("fname"));
		p.setString(3, details.get("lname"));
		p.setString(4, details.get("password"));
		p.setString(5, details.get("dob"));
		p.setString(6, details.get("edu_qualification"));
		p.setString(7, details.get("phone_number"));
		p.setString(8, details.get("city"));
		p.setString(9, details.get("state"));
		p.executeUpdate();
	
		
	}


	@Override
	public List getWorkExperience(String email) {
		List<Work_Experience> we=new ArrayList<>();
		PreparedStatement p;
		try {
			p = con.prepareStatement("select from_year,to_year,description from job_qualification where email=?");
		
		p.setString(1, email);
		ResultSet c = p.executeQuery();
		
		while(c.next())
		{
			Work_Experience w = new Work_Experience();
			w.setFrom_year(c.getString(1));
			w.setTo_year(c.getString(2));
			w.setDescription(c.getString(3));
			we.add(w);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return we;
		
	}


	@Override
	public List getCertificates(String email) {
		List<Certificates> certificates=new ArrayList<>();
		PreparedStatement p;
		try {
			p = con.prepareStatement("select c_no,description,year from certification where email=?");
		
		p.setString(1, email);
		ResultSet c = p.executeQuery();
		
		while(c.next())
		{
			Certificates cert = new Certificates();
			cert.setC_no(c.getString(1));
			cert.setDescription(c.getString(2));
			cert.setYear(c.getString(3));
			certificates.add(cert);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return certificates;
		
	}


	@Override
	public int addCertificates(Certificates c,String email) throws SQLException {
		PreparedStatement p = con.prepareStatement("insert into CERTIFICATION values(?,?,?,?)");
		p.setString(1, c.getC_no());
		p.setString(2, c.getYear());
		p.setString(3, email);
		p.setString(4, c.getDescription());
		int flag = p.executeUpdate();
		return flag;
	}


	@Override
	public void deleteCertificate(String c_no) throws SQLException {
		PreparedStatement p=con.prepareStatement("delete from Certification where c_no=?");
		p.setString(1, c_no);
		p.executeUpdate();
		
	}


	@Override
	public void deleteExperience(String desc,String email) throws SQLException {
		PreparedStatement p=con.prepareStatement("delete from job_qualification where description=? and email=?");
		p.setString(1, desc);
		p.setString(2, email);
		p.executeUpdate();
	}


	@Override
	public void addExperience(Work_Experience w, String email) throws SQLException {
		//System.out.println("Inserting Begin");
		PreparedStatement p = con.prepareStatement("insert into job_qualification values(?,?,?,?)");
		p.setString(1, w.getFrom_year());
		p.setString(2, w.getTo_year());
		p.setString(3, email);
		p.setString(4, w.getDescription());
		p.executeUpdate();
		//System.out.println("Inserting End");
	}


	@Override
	public void changeInfo(User u) throws SQLException {
		//System.out.println("Inserting Begin");
		PreparedStatement p = con.prepareStatement("update user set fname=?,lname=?,edu_qualification=?,phone_number=?,city=?,state=? where email=?");
		//System.out.println("Prepared Statement");
		p.setString(1, u.getFname());
		p.setString(2, u.getLname());
		p.setString(3, u.getEdu_qualification());
		p.setString(4, u.getPhone_number());
		p.setString(5, u.getCity());
		p.setString(6, u.getState());
		p.setString(7, u.getEmail());
		//System.out.println("Variables set");
		p.executeUpdate();
		//System.out.println("Executed correctly");
		
		
	}


	@Override
	public List getQuestions(int level) throws SQLException {
		List<Questions> q=new ArrayList<>();
		//System.out.println("Maths Section begin");
		PreparedStatement p1 = con.prepareStatement("select * from questions_numeric where level=?");
		p1.setInt(1, level);
		ResultSet set = p1.executeQuery();
		while(set.next())
		{
			Questions q1=new Questions();
			q1.setQuestion(set.getString(1));
			//System.out.println(q1.getQuestion());
			q1.setChoice_1(set.getString(2));
			q1.setChoice_2(set.getString(3));
			q1.setChoice_3(set.getString(4));
			q1.setChoice_4(set.getString(5));
			q1.setCorrect_opt(set.getInt(6));
			q.add(q1);
		}
		List<Questions> q0=new ArrayList<>();
		Collections.shuffle(q);
		for(int count=0;count<7;count++)
		{
			q0.add(q.remove(0));
		}
		q.removeAll(q);
		if(level>0)
		{
		PreparedStatement p2 = con.prepareStatement("select * from question_verbal where level=?");
		p2.setInt(1, level);
		ResultSet set1 = p2.executeQuery();
		while(set1.next())
		{
			Questions q1=new Questions();
			q1.setQuestion(set1.getString(1));
			//System.out.println(q1.getQuestion());
			q1.setChoice_1(set1.getString(2));
			q1.setChoice_2(set1.getString(3));
			q1.setChoice_3(set1.getString(4));
			q1.setChoice_4(set1.getString(5));
			q1.setCorrect_opt(set1.getInt(6));
			q.add(q1);
		}
		for(int count=0;count<7;count++)
		{
			q0.add(q.remove(0));
		}
		q.removeAll(q);
		
		/*PreparedStatement p3 = con.prepareStatement("select * from question_situation where level=?");
		p3.setInt(1, level);
		ResultSet set2 = p3.executeQuery();
		while(set2.next())
		{
			Questions q1=new Questions();
			q1.setQuestion(set2.getString(1));
			//System.out.println(q1.getQuestion());
			q1.setChoice_1(set2.getString(2));
			q1.setChoice_2(set2.getString(3));
			q1.setChoice_3(set2.getString(4));
			q1.setChoice_4(set2.getString(5));
			q1.setCorrect_opt(set2.getInt(6));
			q.add(q1);
		}
		for(int count=0;count<7;count++)
		{
			q0.add(q.remove(0));
		}
		q.removeAll(q);
		//System.out.println("Situation end");*/
		}
		
		return q0;
	}


	@Override
	public Hr hrLoginVerify(Hr u) throws SQLException {
		PreparedStatement p=con.prepareStatement("select * from HR where email=? and password=? and identity_confirm=?");
		p.setString(1, u.getEmail());
		p.setString(2, u.getPassword());
		p.setString(3, "C");
		ResultSet r=p.executeQuery();
		//System.out.println("Got result set");
		if(r.next())
		{
			//System.out.println("inside result set");
			//System.out.println(r.getString(7));
			String res=r.getString(7);
			//System.out.println("Identity confirmed");
			Hr u1=new Hr();
			u1.setEmail(r.getString(1));
			u1.setName(r.getString(2));
			u1.setPassword(r.getString(3));
			u1.setCompany(r.getString(4));
			u1.setPhone_number(r.getString(5));
			u1.setC_address(r.getString(6));
				//System.out.println("Identity confirmed");
				return u1;
		}
		return null;
	}


	@Override
	public int hr_register(HashMap<String, String> details) {
		try {
			PreparedStatement p = con.prepareStatement("insert into hr values(?,?,?,?,?,?,?)");
			p.setString(1, details.get("email"));
			p.setString(2, details.get("name"));
			p.setString(3, details.get("password"));
			p.setString(4, details.get("company"));
			p.setString(5, details.get("phone_number"));
			p.setString(6, details.get("c_address"));
			p.setString(7, "P");
			int result = p.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			return -1;
		}
		
	}


	@Override
	public int adminLogin(String id, String password) throws SQLException {
		PreparedStatement p = con.prepareStatement("select * from admin where id=? and password=?");
		p.setString(1, id);
		p.setString(2, password);
		ResultSet r = p.executeQuery();
		if(r.next())
		{
			return 0;
		}
		return 1;
	}


	@Override
	public List<Hr> getPendingHr() {
		try {
			PreparedStatement p = con.prepareStatement("select * from HR where identity_confirm=?");
			p.setString(1, "P");
			ResultSet rs = p.executeQuery();
			List<Hr> hr=new ArrayList<>();
			
			while(rs.next())
			{
				Hr temp=new Hr();
				temp.setEmail(rs.getString(1));
				temp.setName(rs.getString(2));
				temp.setCompany(rs.getString(4));
				temp.setC_address(rs.getString(6));
				temp.setPhone_number(rs.getString(5));
				//System.out.printf("%s\t%s\t%s\t%s\t%s\n",temp.getEmail(),temp.getName(),temp.getCompany(),temp.getPhone_number(),temp.getC_address());
				hr.add(temp);
			}
			//for(Hr a:hr)
			//	System.out.println(a.getEmail()+"  "+a.getName());
			return hr;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public void updateHr(String email)
	{
		try {
			//System.out.println(email);
			PreparedStatement p = con.prepareStatement("update hr set identity_confirm=? where email=?");
			p.setString(1, "C");
			p.setString(2,email);
			//System.out.println("Values set");
			p.executeUpdate();
			//System.out.println("Successfully Updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Vacancy> getVacancy()
	{
		try {
			PreparedStatement p = con.prepareStatement("select a.position,a.company,b.phone_number,a.job_id from job_available a,Hr b where a.email=b.email and a.identity_confirm=?");
			p.setString(1, "P");
			List<Vacancy> vl=new ArrayList<Vacancy>();
			ResultSet r = p.executeQuery();
			while(r.next())
			{
				Vacancy v=new Vacancy();
				v.setPosition(r.getString(1));
				v.setCompany(r.getString(2));
				v.setPhone_number(r.getString(3));
				v.setJob_id(r.getInt(4));
				vl.add(v);
			}
			return vl;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		}
		
	}


	@Override
	public void validate_job(String job_id) {
		
		try {
			PreparedStatement p = con.prepareStatement("update job_available set identity_confirm=? where job_id=?");
			p.setString(1, "C");
			p.setInt(2,Integer.parseInt(job_id));
			p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
	}


	@Override
	public List<Vacancy> getJobs(String qualification,String email) {
		try {
			PreparedStatement p = con.prepareStatement("select * from job_available a,Hr b where a.email=b.email and a.identity_confirm=? and a.job_id not in (select job_id from application where email=?)");
			p.setString(1, "C");
			p.setString(2, email);
			List<Vacancy> vl=new ArrayList<Vacancy>();
			ResultSet r = p.executeQuery();
			while(r.next())
			{
				Vacancy v=new Vacancy();
				v.setPosition(r.getString(4));
				v.setCompany(r.getString(3));
				v.setPhone_number(r.getString(13));
				v.setJob_id(r.getInt(1));
				v.setEmail(r.getString(2));
				v.setSalary(r.getString(6));
				v.setDeadline(r.getString(7));
				vl.add(v);
			}
			return vl;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public void applyJob(String email, String job_id) {
		try {
			PreparedStatement p = con.prepareStatement("insert into application values(a_id.nextval,?,?,?)");
			p.setString(1, email);
			System.out.println(LocalDate.now().toString());
			p.setInt(2, Integer.parseInt(job_id));
			p.setString(3,LocalDate.now().toString());
			p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Vacancy> getVacancy(String email)
	{
		try {
			PreparedStatement p = con.prepareStatement("select a.position,a.job_id from job_available a,Hr b where a.email=b.email and b.email=?");
			p.setString(1, email);
			
			List<Vacancy> vl=new ArrayList<Vacancy>();
			ResultSet r = p.executeQuery();
			while(r.next())
			{
				Vacancy v=new Vacancy();
				v.setPosition(r.getString(1));
				v.setJob_id(r.getInt(2));
				vl.add(v);
			}
			return vl;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		}
		
	}
	public void deleteJob(int job_id)
	{
		PreparedStatement p;
		try {
			p=con.prepareStatement("delete from appoint where app_id in (select app_id from application where job_id=?)");
			p.setInt(1, job_id);
			p.executeUpdate();
			p=con.prepareStatement("delete from application where job_id=?");
			p.setInt(1, job_id);
			p.executeUpdate();
			p = con.prepareStatement("delete from job_available where job_id=?");
			p.setInt(1, job_id);
			//System.out.println(job_id);
			p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	public void addVacancy(Vacancy v) {
		try {
			
			PreparedStatement p = con.prepareStatement("insert into job_available values(j_id.nextval,?,?,?,?,?,?,?)");
			p.setString(1, v.getEmail());
			p.setString(2, v.getCompany());
			p.setString(3, v.getPosition());
			p.setString(4, v.getMin_qualification());
			p.setString(5, v.getSalary());
			p.setString(6, v.getDeadline());
			p.setString(7, "P");
			p.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public List getApplications(String email) {
		List<Application> app=new ArrayList<Application>();
		try {
			PreparedStatement p = con.prepareStatement("select distinct b.app_id,a.position,b.date_applied,b.email,a.job_id from application b,job_available a where b.job_id=a.job_id and a.email=? and app_id not in (select app_id from appoint)");
			p.setString(1, email);
			ResultSet rs = p.executeQuery();
			while(rs.next())
			{
				Application a=new Application();
				a.setApp_id(rs.getInt(1));
				//System.out.println(rs.getInt(1));
				a.setJob_id(rs.getInt(5));
				a.setDate(rs.getString(3));
				a.setJob_position(rs.getString(2));
				a.setEmail(rs.getString(4));
				app.add(a);
			}
			
			
	
			return app;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public void appoint(Appointment a)
	{
		try {
			PreparedStatement p = con.prepareStatement("insert into appoint values(?,?,?,?)");
			p.setInt(1, a.getApp_id());
			p.setString(2, a.getEmail());
			p.setString(3, a.getApp_date());
			p.setString(4, a.getApp_time());
			p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List getAppointments(String email) {
		try {
			PreparedStatement p = con.prepareStatement("select a.app_id,a.app_date,a.app_time,d.phone_number,c.company,c.position,c.salary from appoint a,application b,job_available c,HR d where a.app_id=b.app_id and b.job_id=c.job_id and c.email=d.email and a.email=?");
			p.setString(1, email);
			ResultSet rs = p.executeQuery();
			List<Appointment> app=new ArrayList();
			while(rs.next())
			{
				Appointment a=new Appointment();
				a.setApp_id(rs.getInt(1));
				a.setApp_date(rs.getString(2));
				a.setApp_time(rs.getString(3));
				a.setContact_number(rs.getString(4));
				a.setCompany(rs.getString(5));
				a.setPosition(rs.getString(6));
				a.setSalary(rs.getString(7));
				app.add(a);
			}
			return app;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void levelUp(String email,int level) {
		try {
			PreparedStatement p = con.prepareStatement("update user set level=? where email=?");
			p.setInt(1, level);
			p.setString(2, email);
			p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
