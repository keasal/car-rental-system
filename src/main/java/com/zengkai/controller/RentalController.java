package com.zengkai.controller;

import com.zengkai.entity.*;
import com.zengkai.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class RentalController {

    @Autowired
    CarService carService;
    //查询所有库存车
    @GetMapping("/all")
    public List<CarInfo> queryAllCars() {
        return carService.queryAllCars();
    }

    //租借车
    @RequestMapping(value = "/rental", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RspDTO rentalCar(@RequestBody ReqDTO reqDTO) {
        RspDTO rsp;
        try{
            if(!StringUtils.hasText(reqDTO.getUserName()) || !StringUtils.hasText(reqDTO.getModel()) || !StringUtils.hasText(reqDTO.getStartDate()) || !StringUtils.hasText(reqDTO.getEndDate())) {
                return new RspDTO("E001", "请求参数有误");
            }
            boolean result = carService.rentalCar(reqDTO);

            if(result) {
                rsp = new RspDTO();
            } else {
                rsp = new RspDTO("E001", "库存不足,操作失败");
            }
        } catch (Exception e) {
            rsp = new RspDTO("E001", "库存不足,操作失败");
        }
        return rsp;
    }


    //查询客户名下的租借记录
    @GetMapping("/allRecord")
    public List<RentalRecord> allRecord(String userName) {
        return carService.allRecord(userName);
    }

    //归还车
    @PostMapping("/returnCar")
    public RspDTO returnCar(@RequestBody ReqDTOReturn reqDTOReturn) {
        boolean result = carService.returnCar(reqDTOReturn.getRecordId());
        if(result) {
            return new RspDTO("A001", "操作成功");
        } else {
            return new RspDTO("E001", "操作失败");
        }
    }


}
