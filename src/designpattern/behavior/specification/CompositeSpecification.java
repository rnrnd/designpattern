package designpattern.behavior.specification;

public abstract class CompositeSpecification implements Specification{

	public abstract boolean isSatisfiedBy(Object candidate);

	@Override
	public Specification and(Specification spec) {
		return new AndSpecification(this, spec);
	}

	@Override
	public Specification or(Specification spec) {
		return new OrSpecification(this, spec);
	}

	@Override
	public Specification not() {
		return new NotSpecification(this);
	}
}
