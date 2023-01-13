package com.statistics.api;

import com.statistics.api.dto.InputDataDTO;
import com.statistics.domain.usercase.IDeleteAllStatistics;
import com.statistics.domain.usercase.IFindStatistics;
import com.statistics.domain.usercase.IInputStatistic;
import com.statistics.domain.usercase.impl.FindStatistics;
import com.statistics.domain.usercase.impl.InputStatistic;
import com.statistics.mappers.StatisticMapper;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Qualifier;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class StatisticsRestAPI {

    private final IFindStatistics findStatistics;
    private final IInputStatistic inputStatistic;

    private final IDeleteAllStatistics deleteAllStatistics;

    private final StatisticMapper mapper;

    @Inject
    public StatisticsRestAPI(@Named("findStatistics") IFindStatistics findStatistics,
                             @Named("inputStatistic") IInputStatistic inputStatistic,
                             @Named("deleteAllStatistics") IDeleteAllStatistics deleteAllStatistics,
                             StatisticMapper mapper){
        this.findStatistics = findStatistics;
        this.inputStatistic = inputStatistic;
        this.deleteAllStatistics = deleteAllStatistics;
        this.mapper = mapper;
    }

    @POST
    @Path("transactions")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStatistic(InputDataDTO newStatistic) {
        inputStatistic.inputStatistic(newStatistic.getTimestamp(), newStatistic.getAmount());
        return Response.status(Response.Status.CREATED).build();
    }


    @GET
    @Path("statistics")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAllLastMinut() {
        var response = mapper.convertToResponse(findStatistics.findLastMinutStatistics());
        return Response.ok(response).build();
    }

    @DELETE
    @Path("transactions")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAll() {
        deleteAllStatistics.deleteAll();
        return Response.noContent().build();
    }
}