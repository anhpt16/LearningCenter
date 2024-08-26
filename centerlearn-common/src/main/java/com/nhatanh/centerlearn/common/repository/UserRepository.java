package com.nhatanh.centerlearn.common.repository;

import com.nhatanh.centerlearn.common.entity.User;
import com.tvd12.ezydata.database.EzyDatabaseRepository;
import com.tvd12.ezyfox.database.annotation.EzyRepository;

@EzyRepository
public interface UserRepository extends EzyDatabaseRepository<Long, User> {}