package designpattern.behavior.specification;

public interface Specification {
	boolean isSatisfiedBy(Object candidate);
	Specification and(Specification spec);
	Specification or(Specification spec);
	Specification not();
}
