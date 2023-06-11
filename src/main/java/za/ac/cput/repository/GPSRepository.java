package za.ac.cput.repository;

import za.ac.cput.domain.GPS;

import java.util.Set;

public interface GPSRepository extends IRepository <GPS,String>{
    public Set<GPS> getAll();
}
