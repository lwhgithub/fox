package com.fh.car.controller;

import com.fh.book.model.Book;
import com.fh.book.model.BookParam;
import com.fh.car.model.Car;
import com.fh.car.model.CarParam;
import com.fh.car.server.CarServer;
import com.fh.common.ServerResponse;
import com.fh.utils.OssUtil;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * 生产地址: FLYFOX第五号BUG工厂第二分厂三十三号生产员
 * 生产日期: 2021-01-10 16:53
 */
@RestController
@RequestMapping("CarController")
public class CarController {
    @Resource
    private CarServer carServer;


//   接口功能:
//   请求路径：      http://localhost:8111/aa/CarController/queryCar
//   请求类型：      get
//   接收参数：      com.fh.car.model.CarParam
//   接收数据类型：  com.fh.car.model.CarParam
//   必须参数:       无 默认提供pagingSize=10 pagingStart=0
//   返回值:         {"code":1111,"data":{"count":条数,"list":[{数据1},{数据2},...]},"message":"成功"}
//   返回值类型：    json
    @GetMapping("queryCar")
    public ServerResponse queryCar(CarParam carParam){
        return carServer.queryCar(carParam);
    }

//   接口功能:
//   请求路径：      http://localhost:8111/aa/CarController/queryCarBrand
//   请求类型：      get
//   接收参数：      com.fh.car.model.Brand
//   接收数据类型：  com.fh.car.model.Brand
//   必须参数:       无 默认提供pagingSize=10 pagingStart=0
    //   返回值:     {"code":1111,"data":[{数据1},{数据2},...],"message":"成功"}
//   返回值类型：    json
    @GetMapping("queryCarBrand")
    public ServerResponse queryCarBrand(){
        return carServer.queryCarBrand();
    }

//   接口功能:
//   请求路径：      http://localhost:8111/aa/CarController/addCar
//   请求类型：      post
//   接收参数：      com.fh.car.model.Car
//   接收数据类型：  com.fh.car.model.Car
//   必须参数:       无
//   返回值:         {"code":1111,"data":null,"message":"成功"}
//   返回值类型：    json
    @PostMapping("addCar")
    public ServerResponse addCar(Car car){
        return carServer.addCar(car);
    }

//   接口功能:
//   请求路径：      http://localhost:8111/aa/CarController/deleteCar
//   请求类型：      delete
//   接收参数：      carid  carimgPath
//   接收数据类型：  Integer  String
//   必须参数:       carid
//   返回值:         {"code":1111,"data":null,"message":"成功"}
//   返回值类型：    json
    @DeleteMapping("deleteCar")
    public ServerResponse deleteCar(Integer carid,String carimgPath){
        return carServer.deleteCar(carid,carimgPath);
    }

//   接口功能:
//   请求路径：      http://localhost:8111/aa/CarController/deleteBatch
//   请求类型：      delete
//   接收参数：      idList  paths
//   接收数据类型：  List   List<String>
//   必须参数:       idList  paths
//   返回值:         {"code":1111,"data":null,"message":"成功"}
//   返回值类型：    json
    @DeleteMapping("deleteBatch")
    public ServerResponse deleteBatch(@RequestParam("idList") List idList, @RequestParam("paths") List<String> paths){
        carServer.deleteBatch(idList,paths);
        return ServerResponse.success();
    }

//   接口功能:
//   请求路径：      http://localhost:8111/aa/CarController/updateCar
//   请求类型：      put
//   接收参数：      com.fh.book.model.Book  newcarimgPath
//   接收数据类型：  com.fh.book.model.Book  String
//   必须参数:       Integer类型:bookId;   newcarimgPath
//   返回值:         {"code":1111,"data":null,"message":"成功"}
//   返回值类型：    json
    @PutMapping("updateCar")
    public ServerResponse updateCar(Car car){
        return carServer.updateCar(car);
    }

//   接口功能:       上传图片OSS阿里云
//   请求路径：      http://localhost:8111/aa/CarController/uploadFilea
//   请求类型：      任意
//   接收参数：      file
//   接收数据类型：  MultipartFile
//   必须参数:       file
//   返回值:         {"code":1111,"data":null,"message":"成功"}
//   返回值类型：    json
    @RequestMapping("uploadFilea")
    @CrossOrigin
    public ServerResponse importPhoto(MultipartFile file){
        return OssUtil.uploadFile(file);
    }




}
