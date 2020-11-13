//package com.razzzil.mlsaver;
//
//import com.razzzil.mldto.KazanApiResponseDataModel;
//import com.razzzil.mldto.KazanApiResponseModel;
//import com.razzzil.mlsaver.repositry.KazanBusRepository;
//import jdk.nashorn.internal.ir.annotations.Ignore;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Collections;
//
//@SpringBootTest
//class MLSaverApplicationTests {
//
//    @Autowired
//    private KazanBusRepository repository;
//
//    @Test
//    @Ignore
//    void contextLoads() {
//        KazanApiResponseModel model = KazanApiResponseModel.builder()
//                .updatedAt("test")
//                .data(KazanApiResponseDataModel.builder()
//                        .azimuth("csdc")
//                        .garagNumb("cms;lc")
//                        .graph("lcmdl")
//                        .latitude("kmcskdc")
//                        .longitude("cknlkds")
//                        .marsh("kcsmd")
//                        .smena("klcsdk")
//                        .speed("ksmkc")
//                        .timeNav("ksdlkcsd")
//                        .build())
//                .build();
//        repository.saveBatch(Collections.singletonList(model));
//
//    }
//
//}
