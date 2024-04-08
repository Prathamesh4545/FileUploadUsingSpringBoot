package org.prathamesh.dev.projectfileupload.Repository;

import org.prathamesh.dev.projectfileupload.Entity.DataBlackCoffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<DataBlackCoffee, Integer> {
}
