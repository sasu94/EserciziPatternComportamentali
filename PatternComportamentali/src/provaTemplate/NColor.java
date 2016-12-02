package provaTemplate;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class NColor extends TemplateBacktracking {
	Map<Integer, List<Integer>> stati;

	NColor(Map<Integer, List<Integer>> l) {
		stati = l;
		val.add(1);
		val.add(2);
		val.add(3);
	}

	public NColor() {
		val.add(1);
		val.add(2);
		val.add(3);

	}

	@Override
	protected int next(int x) {
		return x + 1;
	}

	@Override
	protected boolean isComplete(Stack<Integer> sol) {
		return sol.size() == stati.keySet().size();
	}

	@Override
	protected boolean canAdd(int x, Stack<Integer> sol) {
		for (int i = 1; i <= sol.size(); i++)
			if (stati.get(i).contains(sol.size() + 1) && x == sol.get(i - 1))
				return false;
		return true;
	}

}
