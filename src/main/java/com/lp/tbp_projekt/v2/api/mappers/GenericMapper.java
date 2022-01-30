package com.lp.tbp_projekt.v2.api.mappers;

public interface GenericMapper<D, E>
{
    D mapDto(E entity);

    E map(D dto) throws Exception;
}
