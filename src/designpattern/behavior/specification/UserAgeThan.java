package designpattern.behavior.specification;

import designpattern.behavior.specification.model.User;

public class UserAgeThan extends CompositeSpecification{
	private int age;

	public UserAgeThan(int age) {
		this.age = age;
	}

	@Override
	public boolean isSatisfiedBy(Object candidate) {
		if (candidate instanceof User) {
			User user = (User) candidate;
			return user.getAge() > age;
		}
		return false;
	}
}
