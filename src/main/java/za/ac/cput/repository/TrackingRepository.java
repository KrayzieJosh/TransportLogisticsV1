package za.ac.cput.repository;

import za.ac.cput.domain.Tracking;

import java.util.Set;

public interface TrackingRepository extends IRepository <Tracking,String>{
    public Set<Tracking> getAll();
}
