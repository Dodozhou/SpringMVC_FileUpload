package com.star.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by hp on 2017/2/24.
 */
@Controller
public class UploadsController {
    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(@RequestPart("image") MultipartFile image, Model model,HttpServletRequest request) throws IOException {
        File dir=new File(request.getSession().getServletContext().getRealPath("/uploads"));
        if(!dir.exists()){
            dir.mkdirs();
        }
        image.transferTo(new File(dir.getAbsolutePath()+"/"+image.getOriginalFilename()));
        return "success";
    }
}
