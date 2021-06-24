//package de.telekom.sea3.webserver.repo;
//
//import de.telekom.sea3.webserver.model.Person;
//import jdk.internal.jline.WindowsTerminal;
//import net.bytebuddy.dynamic.DynamicType;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class PersonRepository_OLD implements IPersonRepository {
//    private List<Person> persons = new ArrayList<Person>();
//
//    public PersonRepository_OLD() {
//        System.out.println("A person repository is created: " + this.toString());
//    }
//
//
//    @Override
//    public <S extends Person> S save(S s) {
//        if (s.getId() == -1) {
//            persons.add(s);
//        }
//        else {
//            persons.get(s.getId()-1).setFirstname(s.getFirstname());
//            persons.get(s.getId()-1).setLastname(s.getLastname());
//            persons.get(s.getId()-1).setSalutation(s.getSalutation());
//        };
//        return s;
//    }
//
//    @Override
//    public boolean existsById(Long aLong) {
//        if (aLong == null) {
//            throw new IllegalArgumentException();
//        }
//        try {
//            persons.get((int) (aLong-1));
//            return true;
//        }
//        catch (NullPointerException npe) {
//            return false;
//        }
//    }
//
//    @Override
//    public Optional<Person> findById(Long aLong) {
//        if (aLong == null) {
//            throw new IllegalArgumentException();
//        }
//
//        for (Person p : persons) {
//            if (p.getId() == aLong) {
////TOBEDONE
//            }
//        }
//        return Optional.empty();
//    }
//
//
//    @Override
//    public long count() {
//        return persons.size();
//    }
//
//
//    @Override
//    public Iterable<Person> findAll() {
//        return persons;
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//        persons.remove(aLong-1);
//        for (Person p : persons) {
//            if (p.getId() == (int) aLong) {
//                persons.remove(p.getId());
//            }
//        }
//    }
//
////    public void remove(String id) {
////        persons.remove(Integer.parseInt(id)-1);
//////        for (Person p : persons) {
//////            if (p.getId().equals(id)) {
//////                persons.remove(id);
//////                return true;
//////            }
//////        }
//////        return false;
////    }
//
//
//
//    @Override
//    public <S extends Person> Iterable<S> saveAll(Iterable<S> iterable) {
//        return null;
//    }
//
//
//
//    @Override
//    public Iterable<Person> findAllById(Iterable<Long> iterable) {
//        return null;
//    }
//
//
//
//
//
//    @Override
//    public void delete(Person person) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Long> iterable) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends Person> iterable) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//}
