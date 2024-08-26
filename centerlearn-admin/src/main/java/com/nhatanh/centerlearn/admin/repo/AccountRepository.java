package com.nhatanh.centerlearn.admin.repo;

import com.nhatanh.centerlearn.common.entity.Account;
import com.tvd12.ezydata.database.EzyDatabaseRepository;
import com.tvd12.ezyfox.database.annotation.EzyRepository;

@EzyRepository
public interface AccountRepository extends EzyDatabaseRepository<Long, Account> {
    
}
