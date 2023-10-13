package com.ddm.cbic.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
 
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class DownloadController {
	
	@Value("${spring.DGADMIN.FILE_UPLOAD_PATH}")
    private String DGADMIN_FILE_UPLOAD_PATH;
	
    @Autowired
    ServletContext context;
 
   
}