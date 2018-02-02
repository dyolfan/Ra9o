package jtm.extra16;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jtm.activity03.RandomPerson;

public interface PersonMatcher {

	void addPerson(RandomPerson person);

	List<RandomPerson> getPersonList();


}
