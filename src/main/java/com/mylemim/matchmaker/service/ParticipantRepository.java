package com.mylemim.matchmaker.service;

import com.mylemim.matchmaker.domain.Participant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mile on 7.3.2017..
 */
@Repository
public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long> {
}
