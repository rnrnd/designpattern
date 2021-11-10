package designpattern.behavior.specification;

public class BizSpecification extends CompositeSpecification{
	//基准对象
	private Object obj;

	public BizSpecification(Object obj) {
		this.obj = obj;
	}

	//根据obj和candidate进行业务判断
	@Override
	public boolean isSatisfiedBy(Object candidate) {

		return false;
	}
}
