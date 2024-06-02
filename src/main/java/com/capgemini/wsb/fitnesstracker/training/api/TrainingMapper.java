package com.capgemini.wsb.fitnesstracker.training.api;

@Mapper(componentModel = "spring")
public interface TrainingMapper {
    TrainingDto toDto(Training training);
    Training toEntity(TrainingDto trainingDto);
    void updateEntityFromDto(TrainingDto trainingDto, @MappingTarget Training training);
}

