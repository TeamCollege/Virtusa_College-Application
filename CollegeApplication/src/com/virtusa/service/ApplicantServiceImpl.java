package com.virtusa.service;

import java.util.ArrayList;
import java.util.List;

import com.virtusa.dao.ApplicantDAO;
import com.virtusa.entities.Applicant;
import com.virtusa.helper.FactoryApplicantDAO;
import com.virtusa.model.ApplicantModel;

public class ApplicantServiceImpl implements ApplicantService
{
	private ApplicantDAO applicantDAO=null;
	public ApplicantServiceImpl() {
		this.applicantDAO=FactoryApplicantDAO.createApplicantDAO();
	}

	@Override
	public boolean storeApplicantService(ApplicantModel applicantModel) {
		Applicant applicant = new Applicant();
		applicant.setApplicantNumber(applicantModel.getApplicantNumber());
		applicant.setFirstName(applicantModel.getFirstName());
		applicant.setLastName(applicantModel.getLastName());
		applicant.setEmailAddress(applicantModel.getEmail());
		applicant.setPhoneNumber(applicantModel.getPhoneNumber());
		applicant.setDateOfBirth(applicantModel.getDateOfBirth());
		applicant.setTenthPercentage(applicantModel.getTenthPercentage());
		applicant.setInterPercentage(applicantModel.getInterPercentage());
		applicant.setCourseName(applicantModel.getCourseName());
		applicant.setDepartmentName(applicantModel.getDepartmentName());
		
		return applicantDAO.persistApplicant(applicant);
	}

	@Override 
	public List<ApplicantModel> retrieveApplicantService() {
		
			List<Applicant> applicantList=applicantDAO.viewApplicants();
			
			List<ApplicantModel> applicantModelList=new ArrayList<ApplicantModel>();
			
			for(Applicant applicant:applicantList){
				
				ApplicantModel applicantModel=new ApplicantModel();
				
				applicantModel.setApplicantNumber(applicant.getApplicantNumber());
				applicantModel.setFirstName(applicant.getFirstName());
				applicantModel.setLastName(applicant.getLastName());
				applicantModel.setDateOfBirth(applicant.getDateOfBirth());
				applicantModel.setPhoneNumber(applicant.getPhoneNumber());
				applicantModel.setEmail(applicant.getEmailAddress());
				applicantModel.setTenthPercentage(applicant.getTenthPercentage());
				applicantModel.setInterPercentage(applicant.getInterPercentage());
				applicantModel.setCourseName(applicant.getCourseName());
				applicantModel.setDepartmentName(applicant.getDepartmentName());
				
				applicantModelList.add(applicantModel);
			}
			
		return applicantModelList;

	}

}