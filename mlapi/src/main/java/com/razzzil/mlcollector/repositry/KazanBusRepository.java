package com.razzzil.mlcollector.repositry;

import com.razzzil.mldto.KazanApiResponseModel;
import com.razzzil.mldto.jooq.tables.KazanBusLog;
import org.jooq.DSLContext;
import org.jooq.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class KazanBusRepository {

    final KazanBusLog KAZAN_BUS_LOG_TABLE = KazanBusLog.KAZAN_BUS_LOG;

    @Autowired
    private DSLContext dslContext;


    public void saveBatch(List<KazanApiResponseModel> models) {
        List<Query> queries = new ArrayList<>();

        for (KazanApiResponseModel model : models) {
            Query query = this.dslContext
                    .insertInto(KAZAN_BUS_LOG_TABLE)
                    .set(KAZAN_BUS_LOG_TABLE.EVENT_TIME, model.getUpdatedAt())
                    .set(KAZAN_BUS_LOG_TABLE.REPORT_TIME, LocalDateTime.now())
                    .set(KAZAN_BUS_LOG_TABLE.AZIMUTH, model.getData().getAzimuth())
                    .set(KAZAN_BUS_LOG_TABLE.GARAG_NUMB, model.getData().getGaragNumb())
                    .set(KAZAN_BUS_LOG_TABLE.GRAPH, model.getData().getGraph())
                    .set(KAZAN_BUS_LOG_TABLE.LATITUTE, model.getData().getLatitude())
                    .set(KAZAN_BUS_LOG_TABLE.LONGITUDE, model.getData().getLongitude())
                    .set(KAZAN_BUS_LOG_TABLE.MARSH, model.getData().getMarsh())
                    .set(KAZAN_BUS_LOG_TABLE.SMENA, model.getData().getSmena())
                    .set(KAZAN_BUS_LOG_TABLE.SPEED, model.getData().getSpeed())
                    .set(KAZAN_BUS_LOG_TABLE.TIME_NAV, model.getData().getTimeNav());
            queries.add(query);
        }

        this.dslContext
            .batch(queries)
            .execute();
    }

}
