package boot.mytemp.controller;


import boot.mytemp.service.SelectServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class SelectController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    SelectServiceImpl selectService;

//    @ResponseBody
//    @GetMapping("/select")
//    public String selectView(){
//        long startTime = System.currentTimeMillis();
//        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
//
//        List<Map<String, String>> dataList = new ArrayList<>();
//
//        for (int i = 0; i < resultList.size(); i++) {
//            String idx = Integer.toString(i);
//            Map<String, String> data = hashOps.entries(idx);
//            dataList.add(data);
//        }
//
//
////        List<Map<String, String>> dataList = new ArrayList<>();
////        boolean listExists = hashOps.hasKey("list", "1");
////
////        if( listExists ){
////            // Redis에 데이터가 있는지 확인
////            for (int i = 1; ; i++) {
////                String redisKey = Integer.toString(i); // 데이터가 저장된 해시 키
////                if (!hashOps.hasKey(redisKey, "large_name")) {
////                    return dataList.toString();
////                }
////                // Redis에서 데이터 가져오기
////                Map<String, String> data = hashOps.entries(redisKey);
////                dataList.add(data);
////            }
//
////            long endTime = System.currentTimeMillis();
////            long duration = endTime - startTime;
////            System.out.println("Redis Select took " + duration + " milliseconds");
//
//        } else {
//            List<Map> resultList = selectService.selectJoinTest();
//            long endTime = System.currentTimeMillis();
//            long duration = endTime - startTime;
//            System.out.println("No Redis Use Select took " + duration + " milliseconds");
//            return resultList.toString();
//        }
//
//        //return "views/select";
//    }

    /* no sorted redis data */
    @ResponseBody
    @GetMapping("/select")
    public String selectView(){
        long startTime = System.currentTimeMillis();
        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();

        List<Map<String, String>> dataList = new ArrayList<>();

        if(hashOps.hasKey("1", "large_name")) {
            // Redis에서 데이터를 읽어옴
            for (int i = 0; ; i++) {
                String idx = Integer.toString(i); // 데이터의 키
                if (!hashOps.hasKey(idx, "large_name")) {
                    break;
                }
                // 데이터 가져오기
                Map<String, String> data = hashOps.entries(idx);
                dataList.add(data);
            }
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            System.out.println("Redis Use Select took " + duration + " milliseconds");
            return dataList.toString();
        } else {
            List<Map> resultList = selectService.selectJoinTest();
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            System.out.println("No Redis Use Select took " + duration + " milliseconds");
            return resultList.toString();
    }

    //return "views/select";
}


    @GetMapping("/cache/select")
    public String cachingSelectView(){

        List<Map> resultList = selectService.selectJoinTest();

        return "views/select";

    }

    @PostMapping("/redisInsert")
    public ResponseEntity<?> redisInsert() {
        long startTime = System.currentTimeMillis();

        //ValueOperations<String, String> vop = redisTemplate.opsForValue();

        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();

        String idx;
        String large_name;
        String legal_name;
        String shop_name;

        List<Map> resultList = selectService.selectJoinTest();

        for (int i = 0; i < resultList.size(); i++) {
            idx = Integer.toString(i);
            large_name = resultList.get(i).get("large_name").toString();
            legal_name = resultList.get(i).get("legal_name").toString();
            shop_name = resultList.get(i).get("shop_name").toString();

            Map<String, String> data = new HashMap<>();
            data.put("large_name",large_name);
            data.put("legal_name",legal_name);
            data.put("shop_name",shop_name);
            hashOps.putAll(idx,data);
        }

        // 리스트 전체를 하나의 해시로 저장
//        Map<String, String> data = new HashMap<>();
//        for (int i = 0; i < resultList.size(); i++) {
//            Map<String, String> item = resultList.get(i);
//            data.put(Integer.toString(i), item.toString());
//        }
//        hashOps.putAll("list", data);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Redis Insertion took " + duration + " milliseconds");

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
