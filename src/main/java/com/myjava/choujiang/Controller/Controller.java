package com.myjava.choujiang.Controller;

import com.myjava.choujiang.Bean.Sheet1;
import com.myjava.choujiang.mapper.StudentsMapper;
import com.myjava.choujiang.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;


@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    StudentsMapper studentsMapper;
    @Autowired
    private ImportService importService;
    @Autowired
    private  Sheet1 sheet1;


    @RequestMapping("/choujiang")
    public String getStu(Model model){
        Sheet1 a = studentsMapper.getStudent();
        model.addAttribute("sid",a.getSid());
        model.addAttribute("sname",a.getSname());
        return "choujiang";
    }

    @RequestMapping("/insert")
    public String insert(){
        return "insert";
    }

    @RequestMapping(value="/success",method= RequestMethod.POST)
    public   String  uploadExcel(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        InputStream inputStream =null;
        List<List<Object>> list = null;
        MultipartFile file = multipartRequest.getFile("filename");
        if(file.isEmpty()){
            return "文件不能为空";
        }
        inputStream = file.getInputStream();
        list = importService.getBankListByExcel(inputStream,file.getOriginalFilename());
        inputStream.close();
        //连接数据库部分
        for (int i = 0; i < list.size(); i++) {
            List<Object> lo = list.get(i);
            studentsMapper.insert((String.valueOf(lo.get(0))),String.valueOf(lo.get(1)));
            //调用mapper中的insert方法
        }
        return "success";
    }

}
