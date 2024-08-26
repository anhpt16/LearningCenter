package com.nhatanh.centerlearn.admin.converter;


import com.nhatanh.centerlearn.admin.controller.service.TermServiceController;
import com.nhatanh.centerlearn.admin.model.SaveRoomModel;
import com.nhatanh.centerlearn.admin.model.SaveTermModel;
import com.nhatanh.centerlearn.admin.model.SaveTimeslotModel;
import com.nhatanh.centerlearn.admin.request.*;
import com.nhatanh.centerlearn.admin.validator.FormValidator;
import com.nhatanh.centerlearn.common.enums.RoomStatus;
import com.nhatanh.centerlearn.common.enums.TimeslotStatus;
import com.nhatanh.centerlearn.common.utils.SlugGenerate;
import com.tvd12.ezyfox.bean.annotation.EzySingleton;
import lombok.AllArgsConstructor;

@EzySingleton
@AllArgsConstructor
public class AdminRequestToModelConverter {
    private final FormValidator formValidator;
    private final TermServiceController termServiceController;

    public SaveTermModel toSaveTermModelConverter(SaveTermRequest request) {
        long idParent = 0;
        // Decorate
        if (!formValidator.validateBlank(request.getParentName()) && !formValidator.validateBlank(request.getParentType())) {
            idParent = termServiceController.getIdByTermNameAndType(request.getParentName(), request.getParentType());
        }
        // Generate Slug
        String slug = SlugGenerate.createSlug(request.getName());
        // Converter
        return SaveTermModel.builder()
            .name(request.getName())
            .slug(slug)
            .termType(request.getTermType())
            .parentId(idParent)
            .description(request.getDescription())
            .build();
    }

    public SaveRoomModel toSaveRoomModelConverter(UpdateRoomResquest resquest) {
        return SaveRoomModel.builder()
            .name(resquest.getName())
            .slot(resquest.getSlot())
            .termId(resquest.getBase())
            .status(resquest.getStatus())
            .description(resquest.getDescription())
            .build();
    }

    public SaveRoomModel toSaveRoomModelConverter(SaveRoomRequest request) {
        return SaveRoomModel.builder()
            .name(request.getName())
            .description(request.getDescription())
            .slot(request.getSlot())
            .termId(request.getBase())
            .status(RoomStatus.ACTIVE.name())
            .build();
    }

    public SaveTimeslotModel toSaveTimeslotModelConverter(SaveTimeslotRequest request) {
        return SaveTimeslotModel.builder()
            .period(request.getPeriod())
            .timeStart(request.getTimeStart())
            .timeEnd(request.getTimeEnd())
            .description(request.getDescription())
            .status(TimeslotStatus.ACTIVE.name())
            .build();
    }

    public SaveTimeslotModel toSaveTimeslotModelConverter(UpdateTimeslotRequest request) {
        return SaveTimeslotModel.builder()
            .period(request.getPeriod())
            .timeStart(request.getTimeStart())
            .timeEnd(request.getTimeEnd())
            .description(request.getDescription())
            .status(request.getStatus())
            .build();
    }
}
