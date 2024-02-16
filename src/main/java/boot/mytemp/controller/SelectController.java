package boot.mytemp.controller;

import boot.mytemp.mapper.SelectMapper;
import boot.mytemp.service.SelectService;
import boot.mytemp.service.SelectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class SelectController {

    @Autowired
    SelectServiceImpl selectService;

    @GetMapping("/select")
    public String selectView(){

        List<Map> resultList = selectService.selectSeoul();
        return "views/select";
    }

}
