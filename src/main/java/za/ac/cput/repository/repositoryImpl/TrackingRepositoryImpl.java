package za.ac.cput.repository.repositoryImpl;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import za.ac.cput.domain.Tracking;
import za.ac.cput.repository.TrackingRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

public class TrackingRepositoryImpl implements TrackingRepository {
    private static TrackingRepositoryImpl repository = null; // nothing in Tracking repo
    private Set<Tracking> TrackingDB = null;

    private TrackingRepositoryImpl() {
        TrackingDB = new HashSet<Tracking>();
    }

    public static TrackingRepositoryImpl getRepository() {
        if (repository == null) { // will return null if empty
            repository = new TrackingRepositoryImpl(); // will return an object if not
        }
        return repository;
    }

    @Override
    public Tracking create(Tracking tracking) {
        boolean success = TrackingDB.add(tracking);
        if (!success)
            return null;
        return tracking;
    }
    @Override
    public Tracking read(String tripId) {
        for (Tracking t : TrackingDB) {
            if (t.getTripId().equals(tripId)) // this will return null if trip id does not match
                return t;
        }
        return null;
    }
    @Override
    public Tracking update(Tracking tracking) {
        Tracking oldTracking= read(tracking.getTripId());
        if (oldTracking != null) {
            TrackingDB.remove(oldTracking); // getting the existing Tracking and comparing it , will update if needed and new Tracking is returned
            TrackingDB.add(tracking);
            return tracking;
        }
        return null;
    }

    @Override
    public boolean delete(String tripId) { // read locationId, is found will return true, else will return false
        Tracking trackingToDelete = read(tripId);
        if (trackingToDelete == null) {
            return false;
        }
        TrackingDB.remove(trackingToDelete);
        return true;
    }

    @Override
    public Set<Tracking> getAll () {

        return TrackingDB;
    }

    @Override
    public void flush() {


    }

    @Override
    public <S extends Tracking> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Tracking> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Tracking> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Tracking getOne(String s) {
        return null;
    }

    @Override
    public Tracking getById(String s) {
        return null;
    }

    @Override
    public Tracking getReferenceById(String s) {
        return null;
    }

    @Override
    public <S extends Tracking> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Tracking> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Tracking> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Tracking> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Tracking> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Tracking> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Tracking, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Tracking> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Tracking> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Tracking> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<Tracking> findAll() {
        return null;
    }

    @Override
    public List<Tracking> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Tracking entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Tracking> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Tracking> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Tracking> findAll(Pageable pageable) {
        return null;
    }
}
