package com.sh.que_sera_sera;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SensorOutputRepository extends CrudRepository<SensorOutput, Long> {
}
