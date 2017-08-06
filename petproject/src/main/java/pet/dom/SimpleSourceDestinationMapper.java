package pet.dom;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SimpleSourceDestinationMapper {
    TourDTO sourceToDestination(Tour source);
   // Tour destinationToSource(TourDTO destination);
}