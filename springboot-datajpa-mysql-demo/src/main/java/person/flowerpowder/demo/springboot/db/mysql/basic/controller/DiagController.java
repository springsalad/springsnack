package person.flowerpowder.demo.springboot.db.mysql.basic.controller;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import person.flowerpowder.demo.springboot.db.mysql.basic.service.UserMgmtService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
public class DiagController {



    private UserMgmtService userMgmtService;

    @Autowired
    public DiagController(UserMgmtService userMgmtService) {
        this.userMgmtService = userMgmtService;
    }


    @RequestMapping(path = "/demo/user/list")
    public Map<String, Object> listUser() throws Exception {

        List<String> userNames = userMgmtService.listAllNames();

        Map<String, Object> resp = new HashMap<>();



        resp.put("users", userNames);



        return resp;

    }


}
