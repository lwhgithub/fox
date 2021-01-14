package com.fh.car.server.Impl;

import com.fh.car.mapper.CarMapper;
import com.fh.car.model.Brand;
import com.fh.car.model.Car;
import com.fh.car.model.CarParam;
import com.fh.car.server.CarServer;
import com.fh.common.ServerResponse;
import com.fh.utils.OssUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-10 16:54
 */
@Service
public class CarServerImpl implements CarServer {

    @Resource
    private CarMapper carMapper;


    @Override
    public ServerResponse queryCar(CarParam carParam) {
        List<Car> list = carMapper.queryCar(carParam);
        long count = carMapper.queryCarcount(carParam);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("list",list);
        map.put("count",count);
        return ServerResponse.success(map);
    }

    @Override
    public ServerResponse queryCarBrand() {
        List<Brand> brand = carMapper.queryCarBrand();
        return ServerResponse.success(brand);
    }

    @Override
    public ServerResponse addCar(Car car) {
        carMapper.addCar(car);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse deleteCar(Integer carid, String carimgPath) {
        if(StringUtils.isNoneBlank(carimgPath)){
            OssUtil.deleteFile(carimgPath);
        }
        carMapper.deleteCar(carid);
        return ServerResponse.success();
    }
    @Override
    public void deleteBatch(List idList, List<String> paths) {
        if (paths!=null){
            for (String path  : paths){
                if(path.length()>0){
                    OssUtil.deleteFile(path);
                }
            }
        }
        carMapper.deleteBatch(idList);

    }

    @Override
    public ServerResponse updateCar(Car car) {
        if(StringUtils.isNoneBlank(car.getNewcarimgPath())){
            OssUtil.deleteFile(car.getCarimgPath());
            car.setCarimgPath(car.getNewcarimgPath());
        }
        carMapper.updateCar(car);
        return ServerResponse.success();
    }




}
