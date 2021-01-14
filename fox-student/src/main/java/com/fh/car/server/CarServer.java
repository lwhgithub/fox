package com.fh.car.server;

import com.fh.car.model.Car;
import com.fh.car.model.CarParam;
import com.fh.common.ServerResponse;

import java.util.List;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-10 16:53
 */
public interface CarServer {
    ServerResponse queryCar(CarParam carParam);

    ServerResponse addCar(Car car);

    ServerResponse queryCarBrand();

    ServerResponse deleteCar(Integer carid, String carimgPath);

    ServerResponse updateCar(Car car);

    void deleteBatch(List idList, List<String> paths);
}
