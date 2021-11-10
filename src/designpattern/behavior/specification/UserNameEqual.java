package designpattern.behavior.specification;

import designpattern.behavior.specification.model.User;

public class UserNameEqual extends CompositeSpecification{
	private String name;

	public UserNameEqual(String name) {
		this.name = name;
	}

	@Override
	public boolean isSatisfiedBy(Object candidate) {
		if (candidate instanceof User) {
			User user = (User) candidate;
			return user.getName().equals(name);
		}
		return false;
	}
}
