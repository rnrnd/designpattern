package designpattern.behavior.specification;

public class AndSpecification extends CompositeSpecification{
	private Specification left;
	private Specification right;

	public AndSpecification(Specification left, Specification right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean isSatisfiedBy(Object candidate) {
		return left.isSatisfiedBy(candidate) && right.isSatisfiedBy(candidate);
	}
}
