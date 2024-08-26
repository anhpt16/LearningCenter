package com.nhatanh.centerlearn.admin.converter;

import com.nhatanh.centerlearn.admin.model.RoomModel;
import com.nhatanh.centerlearn.admin.model.TermModel;
import com.nhatanh.centerlearn.admin.model.TimeslotModel;
import com.nhatanh.centerlearn.common.entity.Room;
import com.nhatanh.centerlearn.common.entity.Term;
import com.nhatanh.centerlearn.common.entity.Timeslot;
import com.tvd12.ezyfox.bean.annotation.EzySingleton;
import lombok.AllArgsConstructor;

@EzySingleton
@AllArgsConstructor
public class AdminEntityToModelConverter {

    public TermModel toModel(Term term) {
        if (term == null) {
            return null;
        }
        return TermModel.builder()
            .id(term.getId())
            .name(term.getName())
            .slug(term.getSlug())
            .termType(term.getTermType())
            .parentId(term.getParentId())
            .description(term.getDescription())
            .build();
    }

    public RoomModel toModel(Room room) {
        if (room == null) {
            return null;
        }
        return RoomModel.builder()
            .id(room.getId())
            .name(room.getName())
            .slot(room.getSlot())
            .termId(room.getTermId())
            .description(room.getDescription())
            .status(room.getStatus())
            .createdAt(room.getCreatedAt())
            .updatedAt(room.getUpdatedAt())
            .build();
    }

    public TimeslotModel toModel(Timeslot timeslot) {
        if (timeslot == null) {
            return null;
        }
        return TimeslotModel.builder()
            .id(timeslot.getId())
            .period(timeslot.getPeriod())
            .timeStart(timeslot.getTimeStart())
            .timeEnd(timeslot.getTimeEnd())
            .description(timeslot.getDescription())
            .status(timeslot.getStatus())
            .createdAt(timeslot.getCreatedAt())
            .updatedAt(timeslot.getUpdatedAt())
            .build();
    }
}
