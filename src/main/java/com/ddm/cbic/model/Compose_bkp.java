package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Compose_bkp {
	String user_type="";
	
	String hdCheck_val="";
	String hdcount="";
	String hdReportIDNo="";
	String ddl_Group="";
	String ddl_brd="";
	String ddl_fo="";
	String ddl_dep="";
	String ddlzone="";
	String ddlcomm="";
	String ddldiv="";
	String reportID="";
	String txtFileno="";
	String txtSubject="";
	String txtbody="";
	List<MultipartFile> txtUploadFile;
	int hd_File_Transfer_Count=0;
	String hdMailType="";
	String zzList="";
	String ccList="";
	String ddList="";
	String _dep_to="";
	String _code_to="";
	String _name_to="";
	String code="";
	List<String> fileNames = new ArrayList<String>();
	List<String> fwdFileNames = new ArrayList<String>();
	List<String > validationMessage = new ArrayList<String>();
	
	
	
	public String getTxtbody() {
		return txtbody;
	}
	public void setTxtbody(String txtbody) {
		this.txtbody = txtbody;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getHdCheck_val() {
		return hdCheck_val;
	}
	public void setHdCheck_val(String hdCheck_val) {
		this.hdCheck_val = hdCheck_val;
	}
	public String getHdcount() {
		return hdcount;
	}
	public void setHdcount(String hdcount) {
		this.hdcount = hdcount;
	}
	public String getHdReportIDNo() {
		return hdReportIDNo;
	}
	public void setHdReportIDNo(String hdReportIDNo) {
		this.hdReportIDNo = hdReportIDNo;
	}
	public String getDdl_Group() {
		return ddl_Group;
	}
	public void setDdl_Group(String ddl_Group) {
		this.ddl_Group = ddl_Group;
	}
	public String getDdl_brd() {
		return ddl_brd;
	}
	public void setDdl_brd(String ddl_brd) {
		this.ddl_brd = ddl_brd;
	}
	public String getDdl_fo() {
		return ddl_fo;
	}
	public void setDdl_fo(String ddl_fo) {
		this.ddl_fo = ddl_fo;
	}
	public String getDdl_dep() {
		return ddl_dep;
	}
	public void setDdl_dep(String ddl_dep) {
		this.ddl_dep = ddl_dep;
	}
	public String getDdlzone() {
		return ddlzone;
	}
	public void setDdlzone(String ddlzone) {
		this.ddlzone = ddlzone;
	}
	public String getDdlcomm() {
		return ddlcomm;
	}
	public void setDdlcomm(String ddlcomm) {
		this.ddlcomm = ddlcomm;
	}
	public String getDdldiv() {
		return ddldiv;
	}
	public void setDdldiv(String ddldiv) {
		this.ddldiv = ddldiv;
	}
	public String getReportID() {
		return reportID;
	}
	public void setReportID(String reportID) {
		this.reportID = reportID;
	}
	public String getTxtFileno() {
		return txtFileno;
	}
	public void setTxtFileno(String txtFilrno) {
		this.txtFileno = txtFilrno;
	}
	public String getTxtSubject() {
		return txtSubject;
	}
	public void setTxtSubject(String txtSubject) {
		this.txtSubject = txtSubject;
	}
	
	
	public int getHd_File_Transfer_Count() {
		return hd_File_Transfer_Count;
	}
	public void setHd_File_Transfer_Count(int hd_File_Transfer_Count) {
		this.hd_File_Transfer_Count = hd_File_Transfer_Count;
	}
	public String getHdMailType() {
		return hdMailType;
	}
	public void setHdMailType(String hdMailType) {
		this.hdMailType = hdMailType;
	}
	public List<MultipartFile> getTxtUploadFile() {
		return txtUploadFile;
	}
	public void setTxtUploadFile(List<MultipartFile> txtUploadFile) {
		this.txtUploadFile = txtUploadFile;
	}
	
	
	
	
	public List<String> getFileNames() {
		return fileNames;
	}
	public void setFileNames(List<String> fileNames) {
		this.fileNames = fileNames;
	}
	public List<String> getValidationMessage() {
		return validationMessage;
	}
	public void setValidationMessage(List<String> validationMessage) {
		this.validationMessage = validationMessage;
	}
	
	
	public String getZzList() {
		return zzList;
	}
	public void setZzList(String zzList) {
		this.zzList = zzList;
	}
	public String getCcList() {
		return ccList;
	}
	public void setCcList(String ccList) {
		this.ccList = ccList;
	}
	public String getDdList() {
		return ddList;
	}
	public void setDdList(String ddList) {
		this.ddList = ddList;
	}
	
	
	
	public String get_dep_to() {
		return _dep_to;
	}
	public void set_dep_to(String _dep_to) {
		this._dep_to = _dep_to;
	}
	public String get_code_to() {
		return _code_to;
	}
	public void set_code_to(String _code_to) {
		this._code_to = _code_to;
	}
	public String get_name_to() {
		return _name_to;
	}
	public void set_name_to(String _name_to) {
		this._name_to = _name_to;
	}
	
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
	public List<String> getFwdFileNames() {
		return fwdFileNames;
	}
	public void setFwdFileNames(List<String> fwdFileNames) {
		this.fwdFileNames = fwdFileNames;
	}
	@Override
	public String toString() {
		return "Compose [user_type=" + user_type + ", hdCheck_val=" + hdCheck_val + ", hdcount=" + hdcount
				+ ", hdReportIDNo=" + hdReportIDNo + ", ddl_Group=" + ddl_Group + ", ddl_brd=" + ddl_brd + ", ddl_fo="
				+ ddl_fo + ", ddl_dep=" + ddl_dep + ", ddlzone=" + ddlzone + ", ddlcomm=" + ddlcomm + ", ddldiv="
				+ ddldiv + ", reportID=" + reportID + ", txtFileno=" + txtFileno + ", txtSubject=" + txtSubject
				+ ", txtbody=" + txtbody + ", txtUploadFile=" + txtUploadFile + ", hd_File_Transfer_Count="
				+ hd_File_Transfer_Count + ", hdMailType=" + hdMailType + ", zzList=" + zzList + ", ccList=" + ccList
				+ ", ddList=" + ddList + ", _dep_to=" + _dep_to + ", _code_to=" + _code_to + ", _name_to=" + _name_to
				+ ", code=" + code + ", fileNames=" + fileNames + ", fwdFileNames=" + fwdFileNames
				+ ", validationMessage=" + validationMessage + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
