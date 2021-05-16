package com.zengkai.dao;

import com.zengkai.entity.CarInfo;
import com.zengkai.entity.RentalRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CarDao {

    List<CarInfo> selectAllCars();

    CarInfo selectOneCarByModel(String model);

    void updateCarIncrease(String model);

    void updateCarReduce(String model);


    List<RentalRecord> selectAllRecordsByUserName(String userName);

    RentalRecord selectRecordByRecordId(Long recordId);

    int updateRentalRecord(RentalRecord record);

    int insertRentalRecord(RentalRecord record);

}
