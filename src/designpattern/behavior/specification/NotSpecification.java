package designpattern.behavior.specification;

import designpattern.behavior.specification.model.User;

public class NotSpecification extends CompositeSpecification{
	private Specification spec;

	public NotSpecification(Specification spec) {
		this.spec = spec;
	}

	@Override
	public boolean isSatisfiedBy(Object candidate) {
		return !spec.isSatisfiedBy(candidate);
	}

}
