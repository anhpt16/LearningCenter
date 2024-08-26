package com.nhatanh.centerlearn.admin.converter;

import com.nhatanh.centerlearn.admin.model.SaveRoomModel;
import com.nhatanh.centerlearn.admin.model.SaveTermModel;
import com.nhatanh.centerlearn.admin.model.SaveTimeslotModel;
import com.nhatanh.centerlearn.admin.model.TermModel;
import com.nhatanh.centerlearn.common.entity.Room;
import com.nhatanh.centerlearn.common.entity.Term;
import com.nhatanh.centerlearn.common.entity.Timeslot;
import com.nhatanh.centerlearn.common.utils.ClockProxy;
import com.tvd12.ezyfox.bean.annotation.EzySingleton;
import lombok.AllArgsConstructor;

@EzySingleton
@AllArgsConstructor
public class AdminModelToEntityConverter {
    protected final ClockProxy clock;

    public Term toTermEntityConverter(SaveTermModel model) {
        Term entity = new Term();
        this.mergeToEntity(model, entity);
        return entity;
    }
    public Room toRoomEntityConverter(SaveRoomModel model) {
        Room entity = new Room();
        this.mergeToEntity(model, entity);
        return entity;
    }
    public Timeslot toTimeslotEntityConverter(SaveTimeslotModel model) {
        Timeslot entity = new Timeslot();
        this.mergeToEntity(model, entity);
        return entity;
    }

    public void mergeToEntity(SaveTimeslotModel model, Timeslot entity) {
        entity.setPeriod(model.getPeriod());
        entity.setTimeStart(model.getTimeStart());
        entity.setTimeEnd(model.getTimeEnd());
        entity.setDescription(model.getDescription());
        entity.setStatus(model.getStatus());
        entity.setCreatedAt(this.clock.nowDateTime());
        entity.setUpdatedAt(this.clock.nowDateTime());
    }

    public void mergeToSaveEntity(SaveRoomModel model, Room entity) {
        entity.setName(model.getName().toUpperCase());
        entity.setSlot(model.getSlot());
        entity.setTermId(model.getTermId());
        entity.setStatus(model.getStatus());
        entity.setDescription(model.getDescription());
        entity.setUpdatedAt(this.clock.nowDate());
    }

    public void mergeToEntity(SaveTermModel model, Term entity) {
        entity.setName(model.getName().toUpperCase());
        entity.setSlug(model.getSlug());
        entity.setTermType(model.getTermType());
        entity.setParentId(model.getParentId());
        entity.setDescription(model.getDescription());
    }

    public void mergeToEntity(SaveRoomModel model, Room entity) {
        entity.setName(model.getName().toUpperCase());
        entity.setSlot(model.getSlot());
        entity.setTermId(model.getTermId());
        entity.setDescription(model.getDescription());
        entity.setStatus(model.getStatus());
        entity.setCreatedAt(this.clock.nowDate());
        entity.setUpdatedAt(this.clock.nowDate());
    }

    public void mergeToSaveEntity(SaveTimeslotModel model, Timeslot entity) {
        entity.setPeriod(model.getPeriod());
        entity.setTimeStart(model.getTimeStart());
        entity.setTimeEnd(model.getTimeEnd());
        entity.setStatus(model.getStatus());
        entity.setDescription(model.getDescription());
        entity.setUpdatedAt(this.clock.nowDateTime());
    }
}
