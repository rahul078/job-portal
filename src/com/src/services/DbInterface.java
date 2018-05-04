package com.src.services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.src.model.*;




public interface DbInterface {
	public User loginVerify(User u);
	public User getInfo(String email);
	public void register(HashMap<String,String> details) throws SQLException;
	public List getWorkExperience(String email);
	public List getCertificates(String email);
	public int addCertificates(Certificates c,String email) throws SQLException;
	public void deleteCertificate(String c_no) throws SQLException;
	public void deleteExperience(String desc,String email)  throws SQLException;
	public void addExperience(Work_Experience w, String email) throws SQLException ;
	public void changeInfo(User u) throws SQLException;
	public List getQuestions(int level) throws SQLException;
	public Hr hrLoginVerify(Hr u) throws SQLException;
	public int hr_register(HashMap<String, String> details);
	public int adminLogin(String id, String password) throws SQLException;
	public List getPendingHr();
	public void updateHr(String email);
	public List<Vacancy> getVacancy();
	public List<Vacancy> getVacancy(String email);
	public void validate_job(String job_id);
	public List<Vacancy> getJobs(String qualification,String email);
	public void applyJob(String email, String job_id);
	public void deleteJob(int job_id);
	public void addVacancy(Vacancy v);
	public List getApplications(String email);
	public void appoint(Appointment a);
	public List getAppointments(String email);
	public void levelUp(String email,int level);
}