package provaTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class TemplateBacktracking {
	List<Integer> val = new ArrayList<>();

	boolean solve(Stack<Integer> sol) {
		int x = val.iterator().next();
		while (x <= val.get(val.size() - 1)) {
			if (canAdd(x, sol)) {
				sol.push(x);
				if (isComplete(sol))
					return true;
				else if (solve(sol)) {
					return true;
				} else {
					sol.pop();
					x = next(x);
				}
			} else
				x = next(x);
		}

		return false;

	}

	protected abstract int next(int x);

	protected abstract boolean isComplete(Stack<Integer> sol);

	protected abstract boolean canAdd(int x, Stack<Integer> sol);
}
