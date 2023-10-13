package com.ddm.cbic.model;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class Reply {

	 String hdn1;
	 String hdnDEP_FROM;
	 String hdnCODE_FROM;
	 String namefrom;
	 String txtReportId;
	 String txtSubject;
	 String txtbody;
	 String txtFileNo;
	 int hd_File_Transfer_Count;
	 String mailType="";
	 
	 String fwdReportId="";
	 String fwdSUBJECT="";
	 String fwdFILE_NO="";
	 String fwdBODY="";
	 String fwdDOC="";
	 String fwdDOC2="";
	 String fwdDOC3="";
	 String fwdDOC4="";
	 String fwdDOC5="";
	 String fwdDOC6="";
	 String fwdDOC7="";
	 String fwdDOC8="";
	 String fwdDOC9="";
	 String fwdDOC10="";
	 
	 
		
	 String conversationReportId="";
	 String conversationDEP_NAME_FROM="";
	 String conversationDEP_CODE_FROM="";
	 
	 
	 String Get_Transfer_FileName;
	 List<MultipartFile> txtUploadFile0;
	 List<MultipartFile> txtUploadFile1;
	 List<MultipartFile> txtUploadFile2;
	 List<MultipartFile> txtUploadFile3;
	 List<MultipartFile> txtUploadFile4;
	 List<MultipartFile> txtUploadFile5;
	 List<MultipartFile> txtUploadFile6;
	 List<MultipartFile> txtUploadFile7;
	 List<MultipartFile> txtUploadFile8;
	 List<MultipartFile> txtUploadFile9;
	public String getHdn1() {
		return hdn1;
	}
	public void setHdn1(String hdn1) {
		this.hdn1 = hdn1;
	}
	public String getHdnDEP_FROM() {
		return hdnDEP_FROM;
	}
	public void setHdnDEP_FROM(String hdnDEP_FROM) {
		this.hdnDEP_FROM = hdnDEP_FROM;
	}
	public String getHdnCODE_FROM() {
		return hdnCODE_FROM;
	}
	public void setHdnCODE_FROM(String hdnCODE_FROM) {
		this.hdnCODE_FROM = hdnCODE_FROM;
	}
	public String getNamefrom() {
		return namefrom;
	}
	public void setNamefrom(String namefrom) {
		this.namefrom = namefrom;
	}
	public String getTxtReportId() {
		return txtReportId;
	}
	public void setTxtReportId(String txtReportId) {
		this.txtReportId = txtReportId;
	}
	public String getTxtSubject() {
		return txtSubject;
	}
	public void setTxtSubject(String txtSubject) {
		this.txtSubject = txtSubject;
	}
	public String getTxtbody() {
		return txtbody;
	}
	public void setTxtbody(String txtbody) {
		this.txtbody = txtbody;
	}
	public String getTxtFileNo() {
		return txtFileNo;
	}
	public void setTxtFileNo(String txtFileNo) {
		this.txtFileNo = txtFileNo;
	}
	public int getHd_File_Transfer_Count() {
		return hd_File_Transfer_Count;
	}
	public void setHd_File_Transfer_Count(int hd_File_Transfer_Count) {
		this.hd_File_Transfer_Count = hd_File_Transfer_Count;
	}
	public String getMailType() {
		return mailType;
	}
	public void setMailType(String mailType) {
		this.mailType = mailType;
	}
	public String getFwdReportId() {
		return fwdReportId;
	}
	public void setFwdReportId(String fwdReportId) {
		this.fwdReportId = fwdReportId;
	}
	public String getFwdSUBJECT() {
		return fwdSUBJECT;
	}
	public void setFwdSUBJECT(String fwdSUBJECT) {
		this.fwdSUBJECT = fwdSUBJECT;
	}
	public String getFwdFILE_NO() {
		return fwdFILE_NO;
	}
	public void setFwdFILE_NO(String fwdFILE_NO) {
		this.fwdFILE_NO = fwdFILE_NO;
	}
	public String getFwdBODY() {
		return fwdBODY;
	}
	public void setFwdBODY(String fwdBODY) {
		this.fwdBODY = fwdBODY;
	}
	public String getFwdDOC() {
		return fwdDOC;
	}
	public void setFwdDOC(String fwdDOC) {
		this.fwdDOC = fwdDOC;
	}
	public String getFwdDOC2() {
		return fwdDOC2;
	}
	public void setFwdDOC2(String fwdDOC2) {
		this.fwdDOC2 = fwdDOC2;
	}
	public String getFwdDOC3() {
		return fwdDOC3;
	}
	public void setFwdDOC3(String fwdDOC3) {
		this.fwdDOC3 = fwdDOC3;
	}
	public String getFwdDOC4() {
		return fwdDOC4;
	}
	public void setFwdDOC4(String fwdDOC4) {
		this.fwdDOC4 = fwdDOC4;
	}
	public String getFwdDOC5() {
		return fwdDOC5;
	}
	public void setFwdDOC5(String fwdDOC5) {
		this.fwdDOC5 = fwdDOC5;
	}
	public String getFwdDOC6() {
		return fwdDOC6;
	}
	public void setFwdDOC6(String fwdDOC6) {
		this.fwdDOC6 = fwdDOC6;
	}
	public String getFwdDOC7() {
		return fwdDOC7;
	}
	public void setFwdDOC7(String fwdDOC7) {
		this.fwdDOC7 = fwdDOC7;
	}
	public String getFwdDOC8() {
		return fwdDOC8;
	}
	public void setFwdDOC8(String fwdDOC8) {
		this.fwdDOC8 = fwdDOC8;
	}
	public String getFwdDOC9() {
		return fwdDOC9;
	}
	public void setFwdDOC9(String fwdDOC9) {
		this.fwdDOC9 = fwdDOC9;
	}
	public String getFwdDOC10() {
		return fwdDOC10;
	}
	public void setFwdDOC10(String fwdDOC10) {
		this.fwdDOC10 = fwdDOC10;
	}
	public String getGet_Transfer_FileName() {
		return Get_Transfer_FileName;
	}
	public void setGet_Transfer_FileName(String get_Transfer_FileName) {
		Get_Transfer_FileName = get_Transfer_FileName;
	}
	public List<MultipartFile> getTxtUploadFile0() {
		return txtUploadFile0;
	}
	public void setTxtUploadFile0(List<MultipartFile> txtUploadFile0) {
		this.txtUploadFile0 = txtUploadFile0;
	}
	public List<MultipartFile> getTxtUploadFile1() {
		return txtUploadFile1;
	}
	public void setTxtUploadFile1(List<MultipartFile> txtUploadFile1) {
		this.txtUploadFile1 = txtUploadFile1;
	}
	public List<MultipartFile> getTxtUploadFile2() {
		return txtUploadFile2;
	}
	public void setTxtUploadFile2(List<MultipartFile> txtUploadFile2) {
		this.txtUploadFile2 = txtUploadFile2;
	}
	public List<MultipartFile> getTxtUploadFile3() {
		return txtUploadFile3;
	}
	public void setTxtUploadFile3(List<MultipartFile> txtUploadFile3) {
		this.txtUploadFile3 = txtUploadFile3;
	}
	public List<MultipartFile> getTxtUploadFile4() {
		return txtUploadFile4;
	}
	public void setTxtUploadFile4(List<MultipartFile> txtUploadFile4) {
		this.txtUploadFile4 = txtUploadFile4;
	}
	public List<MultipartFile> getTxtUploadFile5() {
		return txtUploadFile5;
	}
	public void setTxtUploadFile5(List<MultipartFile> txtUploadFile5) {
		this.txtUploadFile5 = txtUploadFile5;
	}
	public List<MultipartFile> getTxtUploadFile6() {
		return txtUploadFile6;
	}
	public void setTxtUploadFile6(List<MultipartFile> txtUploadFile6) {
		this.txtUploadFile6 = txtUploadFile6;
	}
	public List<MultipartFile> getTxtUploadFile7() {
		return txtUploadFile7;
	}
	public void setTxtUploadFile7(List<MultipartFile> txtUploadFile7) {
		this.txtUploadFile7 = txtUploadFile7;
	}
	public List<MultipartFile> getTxtUploadFile8() {
		return txtUploadFile8;
	}
	public void setTxtUploadFile8(List<MultipartFile> txtUploadFile8) {
		this.txtUploadFile8 = txtUploadFile8;
	}
	public List<MultipartFile> getTxtUploadFile9() {
		return txtUploadFile9;
	}
	public void setTxtUploadFile9(List<MultipartFile> txtUploadFile9) {
		this.txtUploadFile9 = txtUploadFile9;
	}
	
	
	
	public String getConversationReportId() {
		return conversationReportId;
	}
	public void setConversationReportId(String conversationReportId) {
		this.conversationReportId = conversationReportId;
	}
	public String getConversationDEP_NAME_FROM() {
		return conversationDEP_NAME_FROM;
	}
	public void setConversationDEP_NAME_FROM(String conversationDEP_NAME_FROM) {
		this.conversationDEP_NAME_FROM = conversationDEP_NAME_FROM;
	}
	public String getConversationDEP_CODE_FROM() {
		return conversationDEP_CODE_FROM;
	}
	public void setConversationDEP_CODE_FROM(String conversationDEP_CODE_FROM) {
		this.conversationDEP_CODE_FROM = conversationDEP_CODE_FROM;
	}
	@Override
	public String toString() {
		return "Reply [hdn1=" + hdn1 + ", hdnDEP_FROM=" + hdnDEP_FROM + ", hdnCODE_FROM=" + hdnCODE_FROM + ", namefrom="
				+ namefrom + ", txtReportId=" + txtReportId + ", txtSubject=" + txtSubject + ", txtbody=" + txtbody
				+ ", txtFileNo=" + txtFileNo + ", hd_File_Transfer_Count=" + hd_File_Transfer_Count + ", mailType="
				+ mailType + ", fwdReportId=" + fwdReportId + ", fwdSUBJECT=" + fwdSUBJECT + ", fwdFILE_NO="
				+ fwdFILE_NO + ", fwdBODY=" + fwdBODY + ", fwdDOC=" + fwdDOC + ", fwdDOC2=" + fwdDOC2 + ", fwdDOC3="
				+ fwdDOC3 + ", fwdDOC4=" + fwdDOC4 + ", fwdDOC5=" + fwdDOC5 + ", fwdDOC6=" + fwdDOC6 + ", fwdDOC7="
				+ fwdDOC7 + ", fwdDOC8=" + fwdDOC8 + ", fwdDOC9=" + fwdDOC9 + ", fwdDOC10=" + fwdDOC10
				+ ", Get_Transfer_FileName=" + Get_Transfer_FileName + ", txtUploadFile0=" + txtUploadFile0
				+ ", txtUploadFile1=" + txtUploadFile1 + ", txtUploadFile2=" + txtUploadFile2 + ", txtUploadFile3="
				+ txtUploadFile3 + ", txtUploadFile4=" + txtUploadFile4 + ", txtUploadFile5=" + txtUploadFile5
				+ ", txtUploadFile6=" + txtUploadFile6 + ", txtUploadFile7=" + txtUploadFile7 + ", txtUploadFile8="
				+ txtUploadFile8 + ", txtUploadFile9=" + txtUploadFile9 + "]";
	}
	
	 
	 
	 
	 
	 
	
	 
}
