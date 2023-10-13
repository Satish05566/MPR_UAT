package com.ddm.cbic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;

import com.ddm.cbic.dao.implementation.SP_MPR_GST_LIST_USER_DaoImpl;
import com.ddm.cbic.model.SP_MPR_GST_LIST_USER_Result;
import com.google.gson.Gson;


public class MprListUser {
	
	@Autowired 
	private SP_MPR_GST_LIST_USER_DaoImpl sP_MPR_GST_LIST_USER_DaoImpl;
	
	
	
}
