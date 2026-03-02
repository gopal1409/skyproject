package com.lnd.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lnd.model.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {
}
