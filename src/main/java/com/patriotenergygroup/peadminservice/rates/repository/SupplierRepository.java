package com.patriotenergygroup.peadminservice.rates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patriotenergygroup.peadminservice.rates.domain.Supplier;

@Repository("supplierRepository")
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
