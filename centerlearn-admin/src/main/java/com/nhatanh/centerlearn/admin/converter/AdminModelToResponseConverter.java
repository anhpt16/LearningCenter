package com.nhatanh.centerlearn.admin.converter;


import com.nhatanh.centerlearn.admin.model.RoomModel;
import com.nhatanh.centerlearn.admin.model.TermModel;
import com.nhatanh.centerlearn.admin.model.TimeslotModel;
import com.nhatanh.centerlearn.admin.response.AdminRoomBaseResponse;
import com.nhatanh.centerlearn.admin.response.AdminRoomResponse;
import com.nhatanh.centerlearn.admin.response.AdminTermResponse;
import com.nhatanh.centerlearn.admin.response.AdminTimeslotResponse;
import com.nhatanh.centerlearn.common.enums.RoomStatus;
import com.nhatanh.centerlearn.common.enums.TimeslotStatus;
import com.tvd12.ezyfox.bean.annotation.EzySingleton;
import lombok.AllArgsConstructor;

@EzySingleton
@AllArgsConstructor
public class AdminModelToResponseConverter {

    public AdminTermResponse toTermItemResponse(TermModel termModel, String name) {
        return AdminTermResponse.builder()
            .id(termModel.getId())
            .name(termModel.getName())
            .slug(termModel.getSlug())
            .termType(termModel.getTermType())
            .parentName(name)
            .description(termModel.getDescription())
            .build();
    }

    public AdminRoomResponse toRoomItemResponse(RoomModel roomModel, String name) {
        return AdminRoomResponse.builder()
            .id(roomModel.getId())
            .name(roomModel.getName())
            .slot(roomModel.getSlot())
            .description(roomModel.getDescription())
            .termName(name)
            .status(RoomStatus.fromString(roomModel.getStatus()))
            .createdAt(roomModel.getCreatedAt())
            .updatedAt(roomModel.getUpdatedAt())
            .build();
    }

    public AdminRoomBaseResponse toRoomBaseResponse(TermModel model) {
        return AdminRoomBaseResponse.builder()
            .id(model.getId())
            .name(model.getName())
            .build();
    }

    public AdminTimeslotResponse toTimeslotResponse(TimeslotModel model) {
        return AdminTimeslotResponse.builder()
            .id(model.getId())
            .period(model.getPeriod())
            .timeStart(model.getTimeStart())
            .timeEnd(model.getTimeEnd())
            .status(TimeslotStatus.fromString(model.getStatus()))
            .createdAt(model.getCreatedAt())
            .updatedAt(model.getUpdatedAt())
            .description(model.getDescription())
            .build();
    }
}
