package designpattern.behavior.chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链
 */
public class ResponsibilityChain {
	public static void main(String[] args) {
		FilterChain chain = new FilterChain();
		chain.add(new Filter1())
				.add(new Filter2())
				.add(new Filter3());
		chain.doFilter();
	}
}
interface Filter {
	void doFilter(FilterChain chain);
}
class FilterChain {
	int index = 0;
	List<Filter> filters = new ArrayList<>();

	FilterChain add(Filter filter) {
		filters.add(filter);
		return this;
	}

	public void doFilter() {
		if (index == filters.size()) {
			return;
		}
		filters.get(this.index++).doFilter(this);
	}
}
class Filter1 implements Filter {

	@Override
	public void doFilter(FilterChain chain) {
		System.out.println("filter1");
		chain.doFilter();
	}
}
class Filter2 implements Filter {

	@Override
	public void doFilter(FilterChain chain) {
		System.out.println("filter2");
		chain.doFilter();
	}
}
class Filter3 implements Filter {

	@Override
	public void doFilter(FilterChain chain) {
		System.out.println("filter3");
		chain.doFilter();
	}
}