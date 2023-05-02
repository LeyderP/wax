package com.wax.wax.Infraestructura.adapters.output.persistence.mapper;

import com.wax.wax.Dominio.modelos.correspondenciaModel;
import com.wax.wax.Infraestructura.adapters.output.persistence.entidades.correspondenciaEntidad;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

//@Mapper(componentModel = "spring")//
public interface correspondenciaPersistenciaMapper {

    correspondenciaPersistenciaMapper INSTANCE = Mappers.getMapper(correspondenciaPersistenciaMapper.class);

    correspondenciaEntidad tocorrespondenciaEntidad(correspondenciaModel correspondenciaModel);
    correspondenciaModel tocorrespondenciaModel(correspondenciaEntidad correspondenciaEntidad);

    List<correspondenciaModel> EntitiesTocorrespondenciaModels(List<correspondenciaEntidad> productEntities);

}
