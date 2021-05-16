package com.zengkai.service;

import com.zengkai.dao.CarDao;
import com.zengkai.entity.CarInfo;
import com.zengkai.entity.RentalRecord;
import com.zengkai.entity.ReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class CarService {

    @Autowired
    CarDao carDao;

    //查看库存
    public List<CarInfo> queryAllCars() {
        return carDao.selectAllCars();
    }

    //租借车辆
    public boolean rentalCar(ReqDTO reqDTO) throws Exception {
        //1.检查库存
        CarInfo carInfo = carDao.selectOneCarByModel(reqDTO.getModel());

        if(carInfo == null || carInfo.getInStock() <= 0) {
            return false;
        }

        //2.更新库存 TODO：超卖？
        carDao.updateCarReduce(reqDTO.getModel());

        //3.创建用户名下已经租借的车信息
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = format.parse(reqDTO.getStartDate());
        Date endDate = format.parse(reqDTO.getEndDate());
        RentalRecord record = new RentalRecord();
        record.setUserName("zeng");
        record.setModel(reqDTO.getModel());
        record.setStartDate(startDate);
        record.setEndDate(endDate);
        record.setStatus("Y");
        carDao.insertRentalRecord(record);
        return true;
    }

    //查看租借记录
    public List<RentalRecord> allRecord(String userName) {
        return carDao.selectAllRecordsByUserName(userName);
    }

    //归还车辆
    public boolean returnCar(Long recordId) {
        System.out.println("recordId--"+ recordId);
        RentalRecord record = carDao.selectRecordByRecordId(recordId);
        if(record == null || !"Y".equalsIgnoreCase(record.getStatus())) {
            return false;
        }

        carDao.updateCarIncrease(record.getModel());
        record.setStatus("N");
        carDao.updateRentalRecord(record);
        return true;
    }
}
