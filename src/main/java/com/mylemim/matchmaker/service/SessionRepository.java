package com.mylemim.matchmaker.service;

import com.mylemim.matchmaker.domain.Session;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mile on 26.2.2017..
 */
@Repository
public interface SessionRepository extends PagingAndSortingRepository<Session, Long> {
}
