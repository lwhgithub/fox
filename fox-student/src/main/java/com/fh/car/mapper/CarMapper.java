package com.fh.car.mapper;

import com.fh.car.model.Brand;
import com.fh.car.model.Car;
import com.fh.car.model.CarParam;

import java.util.List;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-10 16:53
 */
public interface CarMapper {
    List<Car> queryCar(CarParam carParam);

    long queryCarcount(CarParam carParam);

    void addCar(Car car);

    List<Brand> queryCarBrand();

    void deleteCar(Integer carid);

    void updateCar(Car car);

    void deleteBatch(List idList);
}
